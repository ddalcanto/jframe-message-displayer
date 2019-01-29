package messageLauncher.display;

import messageLauncher.states.BackgroundState;
import messageLauncher.states.CustomizationState;
import messageLauncher.states.FontState;
import messageLauncher.states.State;
import messageLauncher.states.TextState;

public class Customizer extends WindowCreator {

	private CustomizationState customizationState;
	private BackgroundState backgroundState;
	private FontState fontState;
	private TextState textState;
	private int state;

	public Customizer(String title, int width, int height) {
		super(title, width, height);
		width = 200;
		height = 200;

		customizationState = new CustomizationState();
		backgroundState = new BackgroundState();
		fontState = new FontState();
		textState = new TextState();

	}

	public void DisplayWindow() {
		super.DisplayWindow();

		state = 1;
		switch (state) { // Changes the starting State. Only for debug purposes
		case 1:
			State.setState(customizationState);
			break;
		case 2:
			State.setState(backgroundState);
			break;
		case 3:
			State.setState(fontState);
			break;
		case 4:
			State.setState(textState);
			break;
		default:
			State.setState(customizationState);
			break;
		}

		State.getState().run(panel);

	}

	public void tick() {
		State.getState().tick();

	}

}
