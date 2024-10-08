package ex1_store.devices;

public abstract class Device {
    protected String brand;
    protected String model;

    public Device(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Device() {
    }

    public abstract void showDetail();
}
