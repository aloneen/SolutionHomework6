package kz.seisen.Command;

import java.util.Scanner;

// AdvancedRemoteControl supports undo/redo functionality
class AdvancedRemoteControl {
    private Command lastCommand;
    private Command undoneCommand; // stores the last undone command for redo

    public void setCommand(Command command) {
        this.lastCommand = command;
        // Clear the undone command when a new command is set.
        this.undoneCommand = null;
    }

    public void pressExecute() {
        if (lastCommand != null) {
            lastCommand.execute();
        }
    }

    public void pressUndo() {
        if (lastCommand != null) {
            System.out.println("Undoing last command");
            lastCommand.undo();
            undoneCommand = lastCommand;
            lastCommand = null;
        }
    }

    public void pressRedo() {
        if (undoneCommand != null) {
            System.out.println("Redoing last command");
            undoneCommand.execute();
            lastCommand = undoneCommand;
            undoneCommand = null;
        }
    }
}
