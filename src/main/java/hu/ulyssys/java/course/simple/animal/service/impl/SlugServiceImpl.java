package hu.ulyssys.java.course.simple.animal.service.impl;

import hu.ulyssys.java.course.simple.animal.entity.Slug;
import hu.ulyssys.java.course.simple.animal.service.SlugService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SlugServiceImpl extends AbstractServiceImpl<Slug> implements SlugService {

    public SlugServiceImpl() {
        for (int i = 0; i < 10; i++) {
            Slug slug = new Slug(Long.parseLong(i + ""), "Csiga" + i, 0);
            add(slug);
        }
    }

    public void update(Slug updateable){
        for(Slug slug : getALl()){
            if(slug.getId().equals(updateable.getId())){
                slug.setName(updateable.getName());
                slug.setLegsNumber(updateable.getLegsNumber());
            }
        }
    }
}
