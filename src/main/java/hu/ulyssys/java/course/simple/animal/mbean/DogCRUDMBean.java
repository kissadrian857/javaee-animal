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

    private Dog selectedDog;

    public Dog getSelectedDog() {
        return selectedDog;
    }

    public void setSelectedDog(Dog selectedDog) {
        this.selectedDog = selectedDog;
    }

    @PostConstruct
    private void init() {
        list = dogService.getALl();
    }

    public List<Dog> getList() {
        return list;
    }

    public void setList(List<Dog> list) {
        this.list = list;
    }

    public void remove(Dog dog) {
        dogService.remove(dog);
        list = dogService.getALl();
    }

    public void save() {
        if (selectedDog.getId() == null) {
            selectedDog.setId(System.currentTimeMillis());
            dogService.add(selectedDog);
        } else {
            dogService.update(selectedDog);
        }
        list = dogService.getALl();
        selectedDog = new Dog();
    }
}
