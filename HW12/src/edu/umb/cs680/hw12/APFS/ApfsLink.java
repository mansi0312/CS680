package edu.umb.cs680.hw12.APFS;


import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement{
    private ApfsElement target = null;
    public ApfsLink(ApfsDirectory parent, String name, int size,
                LocalDateTime createTime, ApfsElement target) {
        super(parent, name, size, createTime);
        this.target = target;
    }
    public void setTarget(ApfsElement target) {
        this.target = target;
    }

    public ApfsElement getTarget() {

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
