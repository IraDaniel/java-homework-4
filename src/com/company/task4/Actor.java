package com.company.task4;

import java.io.Serializable;

/**
 * Created by Ira on 09.01.2016.
 */
public class Actor implements Serializable {

    private String name;

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
