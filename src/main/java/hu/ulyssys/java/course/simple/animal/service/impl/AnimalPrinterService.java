package hu.ulyssys.java.course.simple.animal.service.impl;

import hu.ulyssys.java.course.simple.animal.entity.AbstractAnimal;

public class AnimalPrinterService {
    public void printAnimal(AbstractAnimal animal) {
        System.out.println("Name: " + animal.getName() + " ,id: " + animal.getId()
                + " ,number of legs: " + animal.getLegsNumber()
                + " type:" + animal.getType());
    }
}
