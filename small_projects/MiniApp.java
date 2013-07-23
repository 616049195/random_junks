import javax.sound.midi.*;
public class MiniApp {
	public static void main(String[] args) {
		System.out.println("Hello!");
		MiniApp _mplayer = new MiniApp();
		_mplayer.play();
	}

	public void play () {

		try{
			Sequencer _sequencer = MidiSystem.getSequencer();
			_sequencer.open();

			Sequence _seq = new Sequence(Sequence.PPQ, 4);

			Track _track = _seq.createTrack();

			ShortMessage _m1 = new ShortMessage();
			_m1.setMessage(144, 1, 44, 100);
			MidiEvent pitchOn = new MidiEvent(_m1, 1);
			_track.add(pitchOn);

			ShortMessage _m2 = new ShortMessage();
			_m2.setMessage(128, 1, 44, 100);
			MidiEvent pitchOff = new MidiEvent(_m2, 16);
			_track.add(pitchOff);

			_sequencer.setSequence(_seq);

			_sequencer.start();
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
		}
	}
}