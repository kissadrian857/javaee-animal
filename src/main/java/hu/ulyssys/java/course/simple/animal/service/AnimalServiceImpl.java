package hu.ulyssys.java.course.simple.animal.service;

import hu.ulyssys.java.course.simple.animal.entity.AbstractAnimal;

import java.util.ArrayList;
import java.util.List;

public class AnimalServiceImpl {
    List<AbstractAnimal> list = new ArrayList<>();

    public List<AbstractAnimal> getAll() {
        return list;
    }

    public void addAnimal(AbstractAnimal animal) {
        list.add(animal);
    }

    public void removeAnimal(AbstractAnimal animal) {
        list.remove(animal);
    }
}
