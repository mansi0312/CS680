package edu.umb.cs680.hw15.FSFoundation;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected FSElement parent;
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;


    public FSElement(FSElement parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public FSElement getParent() {

        return this.parent;
    }
    public void setParent(FSElement parent) {

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
    public abstract boolean isFile();
    public abstract boolean isLink();

}
