package ex2_itenrface;

public class Reptile implements IAnimal{
    @Override
    public void run() {
        System.out.println("Reptile run");
    }

    @Override
    public void sleep() {
        System.out.println("Reptile sleep");
    }

    @Override
    public void eat() {
        System.out.println("Reptile eat");
    }
}
