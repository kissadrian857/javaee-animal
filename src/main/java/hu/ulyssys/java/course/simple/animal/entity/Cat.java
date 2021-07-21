package hu.ulyssys.java.course.simple.animal.entity;

public class Cat extends AbstractAnimal{
    @Override
    public AnimalType getType() {
        return AnimalType.CAT;
    }

    public Cat() {
    }

    public Cat(Long id, String name, int legsNumber) {
        super(id, name, legsNumber);
    }
}
