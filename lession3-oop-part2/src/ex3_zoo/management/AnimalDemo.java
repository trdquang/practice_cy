package ex3_zoo.management;

import ex3_zoo.animal.Animal;
import ex3_zoo.animal.Bird;
import ex3_zoo.animal.Lion;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal bird = new Bird("Starling");
        Animal lion = new Lion("African Lion");

        bird.makeSound();

        lion.makeSound();
    }
}