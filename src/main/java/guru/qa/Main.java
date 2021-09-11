package guru.qa;

public class Main {
    public static void main(String[] args) {
        Car oldCar = new Car("black", 4, true, 4, 50);
        Car newCar = new Car("white", 6, false, 6, 250);
        Car withoutFuelCar = new Car("orange", 4, true, 2, 0);
        oldCar.beepSound();
        newCar.beepSound();
        withoutFuelCar.beepSound();

        oldCar.fuelCheck();
        newCar.fuelCheck();
        withoutFuelCar.fuelCheck();

        oldCar.starEngine();
        newCar.starEngine();
        withoutFuelCar.starEngine();

        oldCar.fuelCheck();
        newCar.fuelCheck();
        withoutFuelCar.fuelCheck();
    }
}
