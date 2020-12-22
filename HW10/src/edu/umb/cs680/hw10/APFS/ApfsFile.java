package edu.umb.cs680.hw10.APFS;



import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {
    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }
    public boolean isDirectory() {

        return false;
    }
    public boolean isFile() {

        return true;
    }
    public boolean isLink() {

        return false;
    }
    public void accept(ApfsVisitor v) {
        v.visit(this);

    }
}
