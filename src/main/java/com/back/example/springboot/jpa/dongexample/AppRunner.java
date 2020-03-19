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
        parent.setId("Parent_1");
        parent.setName("parent");
        entityManager.persist(parent);
//
        Child child = new Child();
        ChildId childId = new ChildId(parent.getId(), "child_1");
        child.setId(childId);
        child.setParent(parent);
        entityManager.persist(child);
//
        GrandChild grandChild = new GrandChild();
        grandChild.setId(new GrandChildId("grand_id", childId));
        grandChild.setChild(child);
        entityManager.persist(grandChild);
    }
}
