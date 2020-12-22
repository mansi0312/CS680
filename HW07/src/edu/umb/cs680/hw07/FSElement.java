package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected Directory parent;
    private String name;
    private int size;
    private LocalDateTime creationTime;


    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
    this.parent = parent;
    this.name = name;
    this.size = size;
    this.creationTime = creationTime;
    }

    public Directory getParent() {

        return this.parent;
    }
    public void setParent(Directory parent) {

        this.parent = parent;
    }
    public String getName() {

        return this.name;
    }
    public int getSize() {

        return this.size;
    }
    public LocalDateTime getCreationTime() {

        return this.creationTime;
    }
    public abstract boolean isDirectory();

}
