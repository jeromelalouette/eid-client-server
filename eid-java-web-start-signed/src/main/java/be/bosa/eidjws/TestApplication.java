package be.bosa.eidjws;

import javax.swing.*;
import java.awt.*;

public class TestApplication {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.getContentPane().add(
				new JLabel("Hello, World!"),
				BorderLayout.CENTER
		);

		frame.pack();
		frame.setVisible(true);
	}

}
