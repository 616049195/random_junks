import javax.swing.*;

public class FirstGUI {
	public static void main(String[] args) {
		JFrame _frame = new JFrame();
		
		JButton _button = new JButton("Click here!");

		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		_frame.getContentPane().add(_button);
		_frame.setSize(300, 300);
		_frame.setVisible(true);
	}

	public void changeText() {
		_button.setText("CLICKED!");
	}
}