package threads;

import java.util.concurrent.Executor;

public class Exec implements Executor {

	@Override
	public void execute(Runnable command) {
		command.run();
	}
}
