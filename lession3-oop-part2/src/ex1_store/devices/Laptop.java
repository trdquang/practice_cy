package ex1_store.devices;

public class Laptop extends Device {
    private double battery;

    public Laptop(String brand, String model, double battery) {
        super(brand, model);
        this.battery = battery;
    }

    public Laptop() {
    }

    @Override
    public void showDetail() {
        System.out.printf("%10s %10s %.2f", brand, model, battery);
    }
}
