package com.back.example.springboot.jpa.dongexample.Inheritance;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GrandChildId implements Serializable {

    @Column(name = "GRANDCHILD_ID")
    private String id;

    private ChildId childId;

    public GrandChildId() {
    }

    public GrandChildId(String id, ChildId childId) {
        this.id = id;
        this.childId = childId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChildId getChildId() {
        return childId;
    }

    public void setChildId(ChildId childId) {
        this.childId = childId;
    }
}
