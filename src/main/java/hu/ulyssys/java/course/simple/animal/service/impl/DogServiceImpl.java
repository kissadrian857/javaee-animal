package hu.ulyssys.java.course.simple.animal.service.impl;

import hu.ulyssys.java.course.simple.animal.entity.Dog;
import hu.ulyssys.java.course.simple.animal.service.DogService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DogServiceImpl extends AbstractServiceImpl<Dog> implements DogService {

    public DogServiceImpl() {
        for (int i = 0; i < 10; i++) {
            Dog dog = new Dog(Long.parseLong(i + ""), "Kutya" + i, 4);
            add(dog);
        }
    }
}
