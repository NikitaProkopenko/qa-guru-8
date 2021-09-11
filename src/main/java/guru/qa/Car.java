package guru.qa;

public class Car {
    String color;
    int wheelsCount;
    boolean manualTransmission;
    int passengersCount;
    int fuelVolume;

    public Car(String color, int wheelsCount, boolean manualTransmission, int passengersCount, int fuelVolume) {
        this.color = color;
        this.wheelsCount = wheelsCount;
        this.manualTransmission = manualTransmission;
        this.passengersCount = passengersCount;
        this.fuelVolume = fuelVolume;
    }

    void beepSound() {
        System.out.println("BEEP");
    }

    void fuelCheck() {
        if (fuelVolume <= 0) {
            System.out.println("Your can need a fuel");
        } else {
            System.out.println(fuelVolume);
        }
    }

    void starEngine() {
        if (manualTransmission) {
            fuelVolume = fuelVolume - 1;
        } else {
            fuelVolume = fuelVolume - 2;
        }
    }
}
