package hu.ulyssys.java.course.simple.animal.entity;

public class Slug extends AbstractAnimal {
    @Override
    public AnimalType getType() {
        return AnimalType.SLUG;
    }

    public Slug() {
    }

    public Slug(Long id, String name, int legsNumber) {
        super(id, name, legsNumber);
    }
}
