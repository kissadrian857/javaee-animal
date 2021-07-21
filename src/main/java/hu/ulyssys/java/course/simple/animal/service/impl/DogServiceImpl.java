package hu.ulyssys.java.course.simple.animal.service.impl;

import hu.ulyssys.java.course.simple.animal.entity.Cat;
import hu.ulyssys.java.course.simple.animal.entity.Dog;
import hu.ulyssys.java.course.simple.animal.service.DogService;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DogServiceImpl extends AbstractServiceImpl<Dog> implements DogService {
    List<Cat> list = new ArrayList<>();
}
