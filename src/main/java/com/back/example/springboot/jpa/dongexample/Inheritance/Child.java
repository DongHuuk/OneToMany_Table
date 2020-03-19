package com.back.example.springboot.jpa.dongexample.Inheritance;

import javax.persistence.*;

@Entity
public class Child {

    @EmbeddedId
    private ChildId id;

    @MapsId("parentId")
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public ChildId getId() {
        return id;
    }

    public void setId(ChildId id) {
        this.id = id;
    }
}
