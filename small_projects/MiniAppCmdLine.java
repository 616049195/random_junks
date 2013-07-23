import javax.sound.midi.*;

public class MiniAppCmdLine {
	public static void main (String[] args) {

		MiniAppCmdLine _cmdline = new MiniAppCmdLine();

		if (args.length < 2) {
			System.out.println("Select your instrument and pitch, please.");
		} 
		else {
			int inst = Integer.parseInt(args[0]);
			int pitch = Integer.parseInt(args[1]);
			_cmdline.play(inst, pitch);
		}


	}

	public void play (int inst, int pitch) {
		try {
			Sequencer _player = MidiSystem.getSequencer();
			_player.open();
			Sequence _seq = new Sequence(Sequence.PPQ, 4);
			Track _track = _seq.createTrack();

			MidiEvent _event = null;

			ShortMessage _m1= new ShortMessage();
			_m1.setMessage(192, 1, inst, 100);
			MidiEvent changeInst = new MidiEvent(_m1, 1);
			_track.add(changeInst);

			ShortMessage _m2 = new ShortMessage();
			_m2.setMessage(144, 1, pitch, 100);
			MidiEvent _pitchOn = new MidiEvent(_m2, 1);
			_track.add(_pitchOn);

			ShortMessage _m3 = new ShortMessage();
			_m1.setMessage(128, 1, pitch, 100);
			MidiEvent _pitchOff = new MidiEvent(_m3, 1);
			_track.add(_pitchOff);

			_player.setSequence(_seq);
			_player.start();
		}
		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}