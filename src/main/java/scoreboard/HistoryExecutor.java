package scoreboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import scoreboard.api.Command;
import scoreboard.api.CommandExecutor;

public class HistoryExecutor implements CommandExecutor {
	protected Stack<Command> history;
	private Map<Command, Command> reverse;
	private CommandExecutor executor;

	public HistoryExecutor(CommandExecutor executor) {
		this.history = new Stack<>();
		initReverseMap();
		this.executor = executor;
	}
	
	private void initReverseMap() {
		this.reverse = new HashMap<>();
		this.reverse.put(Command.IncreaseA, Command.DecreaseA);
		this.reverse.put(Command.IncreaseB, Command.DecreaseB);
		this.reverse.put(Command.DecreaseA, Command.IncreaseA);
		this.reverse.put(Command.DecreaseB, Command.IncreaseB);
	}

	@Override
	public void execute(Command command) {
		executor.execute(command);
		if (command == Command.Reset) {
			history.clear();
		} else if (command == Command.Rewind) {
			if (!this.history.empty()) {
				executor.execute(reverse.get(this.history.pop()));
			}
		} else {
			this.history.add(command);
		}
	}
	
	public void replay(File historyFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(historyFile));
		reader.lines().forEach((line) -> execute(Command.valueOf(line)));
		reader.close();
	}

	public void write(File historyFile) throws FileNotFoundException {
		PrintStream out = new PrintStream(historyFile);
		history.forEach(command -> out.println(command));
		out.close();
	}
}
