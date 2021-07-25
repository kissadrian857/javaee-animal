package hu.ulyssys.java.course.simple.animal.mbean;


import hu.ulyssys.java.course.simple.animal.entity.Dog;
import hu.ulyssys.java.course.simple.animal.service.DogService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class DogCRUDMBean implements Serializable {

    private List<Dog> list;

    @Inject
    private DogService dogService;

    @PostConstruct
    private void init(){
        list = dogService.getALl();
    }

    public List<Dog> getList() {
        return list;
    }

    public void setList(List<Dog> list) {
        this.list = list;
    }
}
