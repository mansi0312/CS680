package edu.umb.cs680.hw10.APFS;

import edu.umb.cs680.hw10.FSFoundation.FSElement;

import java.time.LocalDateTime;

public abstract class ApfsElement extends FSElement {
    protected ApfsDirectory parent;
    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
     this.parent = parent;
    }
    public ApfsDirectory getParent() {

        return this.parent;
    }
    public void setParent(ApfsDirectory parent) {

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

    public abstract void accept(ApfsVisitor v);
}
