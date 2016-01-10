package com.company.task4;

import java.io.Serializable;

/**
 * Created by Ira on 09.01.2016.
 */
public class Movie implements Serializable {

    private String name;
    private Actor actor;

    public Movie(String name, Actor actor) {
        this.name = name;
        this.actor = actor;
    }

    public void replaceName(String newName){
        name = newName;
    }
    public void replaceActor(String mainActor){
        actor.setName(mainActor);
    }

    public String getName() {
        return name;
    }

    public Actor getActor() {
        return actor;
    }
}
