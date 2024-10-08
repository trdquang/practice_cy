package ex3_zoo.animal;

public class Lion extends Animal {
    public Lion(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " roar");
    }

    public void hunt(){
        System.out.println(getName() + " hunt");
    }
}
