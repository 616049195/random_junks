import javax.sound.midi.*;

public class MusicTest1 {
	
	public void play () {
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			System.out.println("Suceed!");


			

		}
		catch (MidiUnavailableException ex) {
			
			System.out.println("FAILED...");
		}
}

	public static void main (String[] args) {
		MusicTest1 test1 = new MusicTest1();
		test1.play();

		// methods from Object class
		System.out.println(test1.getClass());
		System.out.println(test1.hashCode());
		System.out.println(test1.equals(test1));
		System.out.println(test1.toString());

		// methods from Thorwable class
		MidiUnavailableException ex = new MidiUnavailableException();
		ex.printStackTrace();
		System.out.println(ex.getMessage());

	}
} 