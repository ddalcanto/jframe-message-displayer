package messageLauncher.states;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import messageLauncher.display.WindowCreator;

public class TextState extends State {

	ActionListener moveText = new TimerListener();

	private int labelY = -250;
	private int frameH = WindowCreator.frameH;
	private int frameW = WindowCreator.frameW;

	int x = frameW / 2;
	int y = frameH / 2;

	private String text = "Welcome to my text creator! You can modify the \"text\" variable inside TextState to change the displayed text";

	Timer t = new Timer(10, moveText);

	JLabel label = new JLabel("");

	public void setPanel(JPanel panel) {
		this.panel = panel;

	}

	@Override
	public void tick() {

		label.setFont(FontState.font);
		label.setLocation(0, labelY);
		if (labelY > frameH - 50) {
			labelY = -250;
		}
	}

	@Override
	public void run(JPanel panel) {
		t.start();
		setPanel(panel);
		createText();

		panel.setLayout(new GridLayout());
		label.setHorizontalAlignment(JLabel.CENTER);

	}

	public void createText() {

		label.setSize(text.length() * 6, 100);
		label.setText(text);
		panel.add(label);
		labelY = -250;

	}

	class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			labelY++;
		}

	}

}
