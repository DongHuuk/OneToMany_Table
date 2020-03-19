package com.back.example.springboot.jpa.dongexample;

import com.back.example.springboot.jpa.dongexample.Inheritance.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class AppRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        save();
        find();

    }

    private void find() {
        System.out.println("git test");
    }

    private void save() {
        Child child = new Child();
        child.setName("child");

        Parent parent = new Parent();
        parent.setName("parent");
        parent.addChild(child);
        entityManager.persist(parent);
        child.addParent(parent);
        entityManager.persist(child);
    }
}
