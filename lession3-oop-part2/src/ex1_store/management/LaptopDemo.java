package ex1_store.management;

import ex1_store.devices.Laptop;

public class LaptopDemo {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Acer", "2019", 80);
        laptop.showDetail();
    }
}
