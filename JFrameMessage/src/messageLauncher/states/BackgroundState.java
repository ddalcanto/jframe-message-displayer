package messageLauncher.states;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BackgroundState extends State implements Menu {
	ActionListener buttonListener = new ButtonListener();

	public static Color color;
	private int thisButtonAmount;

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void tick() {
		panel.setBackground(color);
		for (int i = originalButtonAmount; i < originalButtonAmount + thisButtonAmount; i++) {
			buttons[i].setFont(FontState.font);
		}
	}

	public void run(JPanel panel) {
		setPanel(panel);
		createButtons();
	}

	public void createButtons() {
		thisButtonAmount = 3;
		for (int i = originalButtonAmount; i < originalButtonAmount + thisButtonAmount; i++) {
			buttons[i] = new JButton(String.valueOf(i));
			buttons[i].setFont(FontState.font);
			buttons[i].setBounds(300, (i - originalButtonAmount) * 60 + 40, 120, 50);
			buttons[i].addActionListener(buttonListener);
			panel.add(buttons[i]);
		}
		buttons[0 + originalButtonAmount].setText("Magenta");
		buttons[1 + originalButtonAmount].setText("Red");
		buttons[2 + originalButtonAmount].setText("Green");

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
				color = Color.magenta;
				System.out.println("blue clicked");

			}

			if (e.getSource() == buttons[1 + originalButtonAmount]) {
				color = Color.RED;
				System.out.println("red clicked");
			}

			if (e.getSource() == buttons[2 + originalButtonAmount]) {
				color = Color.GREEN;
				System.out.println("green clicked");
			}
		}
	}

}
