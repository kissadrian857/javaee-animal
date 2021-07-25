package hu.ulyssys.java.course.simple.animal.service.impl;

import hu.ulyssys.java.course.simple.animal.entity.Cat;
import hu.ulyssys.java.course.simple.animal.service.CatService;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CatServiceImpl extends AbstractServiceImpl<Cat> implements CatService {
    List<Cat> list = new ArrayList<>();

    public CatServiceImpl() {
        for (int i = 0; i < 10; i++) {
            Cat cat = new Cat(Long.parseLong(i + ""), "Macska" + i, 4);
            add(cat);
        }
    }

    public void update(Cat cat){

    }
}
