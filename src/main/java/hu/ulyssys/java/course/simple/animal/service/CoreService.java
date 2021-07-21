package hu.ulyssys.java.course.simple.animal.service;

import hu.ulyssys.java.course.simple.animal.entity.AbstractAnimal;

import java.util.List;

public interface CoreService<T extends AbstractAnimal> {
    List<T> getALl();

    void add(T animal);

    void remove(T animal);
}
