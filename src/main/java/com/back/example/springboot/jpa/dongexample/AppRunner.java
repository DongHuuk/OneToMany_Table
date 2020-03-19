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

    }

    private void save() {

        Parent parent = new Parent();
        parent.setName("parent_1");
        parent.setId("Parent_1");
        entityManager.persist(parent);

        Child child = new Child();
        child.setParent(parent);
        child.setName("child_1");
        entityManager.persist(child);

        GrandChild grandChild = new GrandChild();
        grandChild.setChild(child);
        grandChild.setName("grandChild_1");
        entityManager.persist(grandChild);
    }
}
