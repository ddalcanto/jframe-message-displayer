package messageLauncher.states;

import java.awt.Font;

import javax.swing.JButton;

public interface Menu {

	JButton[] buttons = new JButton[20];

	int originalButtonAmount = 4; // Amount of buttons the starting screen will contain

	Font defaultFont = new Font(Font.SERIF, Font.PLAIN, 14);

}
