package info.thecodinglive.pattern;

import java.util.Arrays;

public enum UrlClassName {
	HOME("home", "info.thecodinglive.pattern.HomeView"),
	LIST("list", "info.thecodinglive.pattern.ListView"),
	WRITE("write", "info.thecodinglive.pattern.WriteView"),
	;

	private String command;
	private String commandClass;

	public static UrlClassName findByCommand(String command) {
		return Arrays.stream(values())
			.filter(urls -> command.equals(urls.getCommand()))
			.findAny()
			.orElse(null);
	}

	UrlClassName(String command, String commandClass) {
		this.command = command;
		this.commandClass = commandClass;
	}

	public String getCommand() {
		return command;
	}

	public String getCommandClass() {
		return commandClass;
	}
}
