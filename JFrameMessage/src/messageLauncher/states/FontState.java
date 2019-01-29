package messageLauncher.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FontState extends State implements Menu {

	ActionListener buttonListener = new ButtonListener();

	BackgroundState backgroundState = new BackgroundState();

	private String[] differentFonts;

	public static Color color;
	public static Font font = defaultFont;
	private int thisButtonAmount;

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void tick() {
		panel.setBackground(BackgroundState.color);
		for (int i = originalButtonAmount; i < originalButtonAmount + thisButtonAmount; i++) {
			buttons[i].setFont(FontState.font);
		}
	}

	public void run(JPanel panel) {
		setPanel(panel);
		createButtons();
	}

	public void createButtons() {
		thisButtonAmount = 2;
		for (int i = originalButtonAmount; i < originalButtonAmount + thisButtonAmount; i++) {
			buttons[i] = new JButton(String.valueOf(i));
			buttons[i].setFont(FontState.font);
			buttons[i].setBounds(300, (i - originalButtonAmount) * 60 + 40, 120, 50);
			buttons[i].addActionListener(buttonListener);
			panel.add(buttons[i]);
		}
		buttons[0 + originalButtonAmount].setText("serif");
		buttons[1 + originalButtonAmount].setText("dialog");

	}

	public void removeButtons() {

		for (int i = originalButtonAmount; i < originalButtonAmount + thisButtonAmount; i++) {
			panel.remove(buttons[i]);
			this.tick();
		}
	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0 + originalButtonAmount]) {
				font = new Font(Font.SERIF, Font.PLAIN, 14);
				System.out.println("serif");
				for (int i = 0; i < 2; i++) {
					buttons[i + originalButtonAmount].setFont(font);
				}
			}

			if (e.getSource() == buttons[1 + originalButtonAmount]) {
				font = new Font(Font.DIALOG, Font.BOLD, 12);
				System.out.println("dialog");
				for (int i = 0; i < 2; i++) {
					buttons[i + originalButtonAmount].setFont(font);
				}
			}
		}
	}
}