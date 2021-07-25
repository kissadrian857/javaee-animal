package hu.ulyssys.java.course.simple.animal.mbean;

import hu.ulyssys.java.course.simple.animal.entity.Cat;
import hu.ulyssys.java.course.simple.animal.service.CatService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CatCRUDMBean implements Serializable {
    private List<Cat> list;

    @Inject
    CatService catService;

    private Cat selectedCat;

    @PostConstruct
    private void init() {
        list = catService.getALl();
    }

    public List<Cat> getList() {
        return list;
    }

    public void setList(List<Cat> list) {
        this.list = list;
    }

    public Cat getSelectedCat() {
        return selectedCat;
    }

    public void setSelectedCat(Cat selectedCat) {
        this.selectedCat = selectedCat;
    }

    public void remove(Cat cat) {
        catService.remove(cat);
        list = catService.getALl();
    }

    public void save() {
        if (selectedCat.getId() == null) {
            selectedCat.setId(System.currentTimeMillis());
            catService.add(selectedCat);
        } else {
            catService.update(selectedCat);
        }
        list = catService.getALl();
        selectedCat = new Cat();
    }
}

