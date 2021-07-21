package hu.ulyssys.java.course.simple.animal.entity;

public abstract class AbstractAnimal implements AnimalTypeAware{
    private Long id;
    private String name;
    private int legsNumber;

    public AbstractAnimal() {
    }

    public AbstractAnimal(Long id, String name, int legsNumber) {
        this.id = id;
        this.name = name;
        this.legsNumber = legsNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegsNumber() {
        return legsNumber;
    }

    public void setLegsNumber(int legsNumber) {
        this.legsNumber = legsNumber;
    }
}
