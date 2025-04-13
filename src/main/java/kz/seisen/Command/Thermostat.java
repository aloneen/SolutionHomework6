package kz.seisen.Command;

class Thermostat {
    private int temperature = 20;

    public void setTemperature(int temp) {
        System.out.println("[Thermostat] Setting temperature to " + temp + "°C");
        temperature = temp;
    }

    public int getTemperature() {
        return temperature;
    }
}