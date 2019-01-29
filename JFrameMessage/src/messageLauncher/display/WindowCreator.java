package messageLauncher.display;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowCreator {

	public JFrame frame;
	public JPanel panel;

	public static int frameW = 650;
	public static int frameH = 650;


	private String title;
	private int width;
	private int height;

	protected WindowCreator(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	protected void DisplayWindow() {
		frame = new JFrame();
		panel = new JPanel();

		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		frame.setSize(frameW, frameH);
		frame.setVisible(true);

		panel.setLayout(null);

	}

}
