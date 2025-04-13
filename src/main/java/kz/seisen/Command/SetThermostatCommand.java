package kz.seisen.Command;

public class SetThermostatCommand implements Command {
    private Thermostat thermostat;
    private int temperature;
    private int previousTemperature;

    public SetThermostatCommand(Thermostat thermostat, int temperature) {
        this.thermostat = thermostat;
        this.temperature = temperature;
    }

    public void execute() {
        previousTemperature = thermostat.getTemperature();
        thermostat.setTemperature(temperature);
    }

    public void undo() {
        thermostat.setTemperature(previousTemperature);
        System.out.println("[Thermostat] Reverted temperature to " + previousTemperature + "°C");
    }
}