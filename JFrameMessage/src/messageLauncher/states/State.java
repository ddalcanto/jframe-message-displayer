package messageLauncher.states;

import javax.swing.JPanel;

public abstract class State {

	protected JPanel panel;

	private static State currentState = null;

	public abstract void setPanel(JPanel panel);

	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

	public abstract void tick();

	public abstract void run(JPanel panel);

}
