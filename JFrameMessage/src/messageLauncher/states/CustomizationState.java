package messageLauncher.states;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CustomizationState extends State implements Menu {

	ActionListener buttonListener = new ButtonListener();

	FontState fontState = new FontState();
	BackgroundState backgroundState = new BackgroundState();
	TextState textState = new TextState();

	boolean textInputStateActive = false;
	boolean textInputStateHasRun = false;

	boolean backgroundStateActive = false;
	boolean backgroundStateHasRun = false;

	boolean textStateActive = false;
	boolean textStateHasRun = false;

	boolean fontStateActive = false;
	boolean fontStateHasRun = false;

	boolean backgroundHasRemoved = false;

	boolean fontHasRemoved = false;

	private int thisButtonAmount;
	private int lastSpacing;

	@Override
	public void setPanel(JPanel panel) {
		this.panel = panel;

	}

	public void tick() {
		fontStateRun();
		backgroundStateRun();
		textStateRun();
		panel.setBackground(Color.WHITE);
		panel.setBackground(BackgroundState.color);

		for (int i = originalButtonAmount - originalButtonAmount; i < thisButtonAmount; i++) {
			buttons[i].setFont(FontState.font);
		}
	}

	public void run(JPanel panel) {
		setPanel(panel);
		createButtons();

	}

	public void createButtons() {
		thisButtonAmount = originalButtonAmount;
		for (int i = originalButtonAmount - originalButtonAmount; i < thisButtonAmount; i++) {
			buttons[i] = new JButton(String.valueOf(i));
			buttons[i].setFont(FontState.font);
			buttons[i].setBounds(100, i * 60 + (40 + lastSpacing), 120, 50);
			buttons[i].addActionListener(buttonListener);
			panel.add(buttons[i]);
			if (i == thisButtonAmount - 2) {
				lastSpacing = 10;
			}
		}
		buttons[0].setText("Edit Text");
		buttons[1].setText("Change Font");
		buttons[2].setText("Background");
		buttons[3].setText("Run Text");

	}

	public void removeButtons() {
		for (int i = originalButtonAmount - originalButtonAmount; i < thisButtonAmount; i++) {
			panel.remove(buttons[i]);
			this.tick();
		}
	}

	public void removeAllButtons() {
		fontState.removeButtons();
		backgroundState.removeButtons();
		this.removeButtons();
	}

	public void textInputStateRun() {

	}

	public void fontStateRun() {
		if (fontStateActive == true) {

			if (backgroundStateActive == true) { // Wipes the backgroundState buttons if fontState button is clicked on
													// while the backgroundState buttons haven't been deactivated

				backgroundState.removeButtons();

			}
			if (backgroundHasRemoved == false) { // Makes sure the code resetting backgroundStateActive won't be run
													// multiple times
				backgroundStateActive = false;
				backgroundStateHasRun = false;
				backgroundHasRemoved = true;
			}

			if (fontStateHasRun == false) { // if fontStateRun has NOT been called before, run the fontState's
											// run(Panel) method
				fontState.run(panel);
				fontStateHasRun = true;
			}

			if (fontStateHasRun == true) { // if fontStateRun HAS been called before, run the fontState's tick() method
				fontState.tick();
			}

		} else if (fontStateActive == false && fontStateHasRun == true && backgroundStateActive == false) {
			fontState.removeButtons();
			fontStateHasRun = false;

		}

	}

	public void backgroundStateRun() {
		if (backgroundStateActive == true) {
			backgroundHasRemoved = false;
			if (fontStateActive == true) { // Wipes the backgroundState buttons if fontState button is clicked on while
											// the backgroundState buttons haven't been deactivated
				fontStateActive = false;
				fontStateHasRun = false;
				fontState.removeButtons();

			}
			if (backgroundStateHasRun == false) { // if backgroundStateRun has NOT been called before, run the
													// backgroundStateRun's run(Panel) method
				backgroundState.run(panel);
				backgroundStateHasRun = true;
			}

			if (fontHasRemoved == false) {
				fontStateActive = false;
				fontStateHasRun = false;
				fontHasRemoved = true;
			}

			if (backgroundStateHasRun == true) { // if backgroundStateRun HAS been called before, run the
													// backgroundStateRun's tick() method
				backgroundState.tick();
			}

		} else if (backgroundStateActive == false && backgroundStateHasRun == true && fontStateActive == false) {
			backgroundState.removeButtons();
			backgroundStateHasRun = false;
		}
	}

	public void textStateRun() {
		if (textStateActive == true) {

			if (textStateHasRun == false) { // if textStateRun has NOT been called before, run the textState's
											// run(Panel) method
				textState.run(panel);
				textStateHasRun = true;
				removeAllButtons();
			}

			if (textStateHasRun == true) { // if textStateRun HAS been called before, run the textState's tick() method
				textState.tick();

			}

		}
	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {
			}

			if (e.getSource() == buttons[1]) {

				if (fontStateActive == false) {
					fontStateActive = true;
				} else if (fontStateActive == true) {
					fontStateActive = false;
					panel.setBackground(Color.WHITE);
				}

			}

			if (e.getSource() == buttons[2]) {
				if (backgroundStateActive == false) {
					backgroundStateActive = true;
				} else if (backgroundStateActive == true) {
					backgroundStateActive = false;
					panel.setBackground(Color.WHITE);
				}
			}

			if (e.getSource() == buttons[3]) {
				if (textStateActive == false) {
					textStateActive = true;
				} else if (textStateActive == true) {
					textStateActive = false;
				}
			}
		}

	}

}
