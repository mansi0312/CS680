package edu.umb.cs680.hw09.FAT;

import edu.umb.cs680.hw09.FSFoundation.FSElement;

import java.time.LocalDateTime;

public abstract class FatFSElement extends FSElement {
    protected FatDirectory parent;

    public FatFSElement(FatDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        this.parent = parent;
    }
    public FatDirectory getParent() {

        return this.parent;
    }
    public void setParent(FatDirectory parent) {

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
