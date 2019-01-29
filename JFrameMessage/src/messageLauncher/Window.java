package messageLauncher;

import messageLauncher.display.Customizer;

public class Window implements Runnable {

	boolean isRunning = true;

	Customizer window = new Customizer("Message", 200, 200);

	public Window() {
		window.DisplayWindow();

	}

	public void tick() {
		window.tick();
	}

	// Code from RealTutsGML
	public void run() {
		double fps = 60.0;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		while (isRunning) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				// System.out.println("fps = " + ticks);
				ticks = 0;
				timer = 0;

			}

		}
	}
}