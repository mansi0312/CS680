package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class Link extends FSElement {
    private FSElement target = null;
    public Link(Directory parent, String name, int size,
                LocalDateTime createTime, FSElement target) {
        super(parent, name, size, createTime);
        this.target = target;
    }
    public void setTarget(FSElement target) {
        this.target = target;
    }

    public FSElement getTarget() {
        return this.target;
    }
    public boolean isDirectory() {

        return false;
    }
    public boolean isFile() {

        return false;
    }
    public boolean isLink() {

        return true;
    }
}
