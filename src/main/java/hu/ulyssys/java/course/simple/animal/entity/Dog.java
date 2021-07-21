package hu.ulyssys.java.course.simple.animal.entity;

public class Dog extends AbstractAnimal{
    @Override
    public AnimalType getType() {
        return AnimalType.DOG;
    }

    public Dog() {
    }

    public Dog(Long id, String name, int legsNumber) {
        super(id, name, legsNumber);
    }
}
