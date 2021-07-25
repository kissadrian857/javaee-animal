package hu.ulyssys.java.course.simple.animal.mbean;


import hu.ulyssys.java.course.simple.animal.entity.Slug;
import hu.ulyssys.java.course.simple.animal.service.SlugService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class SlugCRUDMBean implements Serializable {
    private List<Slug> list;

    @Inject
    SlugService slugService;

    private Slug selectedSlug;

    public List<Slug> getList() {
        return list;
    }

    @PostConstruct
    private void init(){
        list = slugService.getALl();
    }

    public void setList(List<Slug> list) {
        this.list = list;
    }

    public Slug getSelectedSlug() {
        return selectedSlug;
    }

    public void setSelectedSlug(Slug selectedSlug) {
        this.selectedSlug = selectedSlug;
    }
}
