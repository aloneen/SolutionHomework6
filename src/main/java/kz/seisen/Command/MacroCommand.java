package kz.seisen.Command;

import java.util.ArrayList;
import java.util.List;


class MacroCommand implements Command {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public void undo() {
        // Undo in reverse order for correct rollback
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}
