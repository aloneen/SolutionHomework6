package kz.seisen.Command;


import java.util.Scanner;

// CLI menu to interact with the remote
public class CommandMain {
    public static void main(String[] args) {
        // Setup devices
        Light livingRoomLight = new Light();
        Thermostat homeThermostat = new Thermostat();

        // Setup concrete commands
        Command turnOnLight = new TurnOnLightCommand(livingRoomLight);
        Command turnOffLight = new TurnOffLightCommand(livingRoomLight);
        Command setThermostat = new SetThermostatCommand(homeThermostat, 22);

        // Create a macro command for "Goodnight Mode"
        MacroCommand goodnightMode = new MacroCommand();
        goodnightMode.addCommand(turnOffLight);
        // Assume goodnight mode lowers the thermostat to 18°C
        goodnightMode.addCommand(new SetThermostatCommand(homeThermostat, 18));

        // Instantiate the advanced remote with undo/redo support
        AdvancedRemoteControl remote = new AdvancedRemoteControl();

        // Simple CLI menu
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Turn On Light");
            System.out.println("2. Turn Off Light");
            System.out.println("3. Set Thermostat to 22°C");
            System.out.println("4. Activate Goodnight Mode");
            System.out.println("5. Undo Last Command");
            System.out.println("6. Redo Last Command");
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    remote.setCommand(turnOnLight);
                    remote.pressExecute();
                    break;
                case 2:
                    remote.setCommand(turnOffLight);
                    remote.pressExecute();
                    break;
                case 3:
                    remote.setCommand(setThermostat);
                    remote.pressExecute();
                    break;
                case 4:
                    remote.setCommand(goodnightMode);
                    remote.pressExecute();
                    break;
                case 5:
                    remote.pressUndo();
                    break;
                case 6:
                    remote.pressRedo();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        scanner.close();
        System.out.println("Exiting Remote Control CLI.");
    }
}
