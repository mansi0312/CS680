package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{

    private LinkedList<FSElement> children = new LinkedList<FSElement>();
    private LinkedList<File> files = new LinkedList<File>();
    private FileSystem fileSystem;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
      super(parent, name, size, creationTime);
    }

    public LinkedList<FSElement> getChildren() {

        return this.children;
    }
    public void appendChild(FSElement child) {

        this.children.add(child);
        child.setParent(this);

    }
    public int countChildren() {

        return this.children.size();
    }
    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subdirectories = new LinkedList<Directory>();
        for(FSElement e : children) {
            if (e.isDirectory()) {
                subdirectories.add((Directory) e);
            }
        }
        return subdirectories;
    }
    public LinkedList<File> getFiles() {
             for(FSElement e : children) {
                 if(!e.isDirectory()) {
                     files.add((File) e);
                 }
             }
        return this.files;
    }
    public int getTotalSize() {
      int totalsize = 0;

        for(FSElement e : children) {
            if (e.isDirectory())
                totalsize += ((Directory) e).getTotalSize();

            else
            totalsize += e.getSize();

        }

      return totalsize;
    }

    public boolean isDirectory() {

        return true;
    }
    public boolean isFile() {

        return false;
    }
    public boolean isLink() {

        return false;
    }
}
