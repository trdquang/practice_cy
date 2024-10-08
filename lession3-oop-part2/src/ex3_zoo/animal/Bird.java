package ex3_zoo.animal;

public class Bird extends Animal{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " sings");
    }

    public void fly(){
        System.out.println(getName() + " fly");
    }
}
