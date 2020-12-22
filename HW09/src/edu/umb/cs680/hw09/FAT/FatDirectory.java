package edu.umb.cs680.hw09.FAT;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FatDirectory extends FatFSElement{
    private LinkedList<FatFSElement> children = new LinkedList<FatFSElement>();
    private LinkedList<FatFSElement> allchildren = new LinkedList<FatFSElement>();;
    private LinkedList<FatFile> files = new LinkedList<FatFile>();
    private FAT fileSystem;

    public FatDirectory(FatDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);

    }

    public LinkedList<FatFSElement> getChildren() {

        return this.children;
    }
    public void appendChild(FatFSElement child) {

        this.children.add(child);
        child.setParent(this);

    }
    public int countChildren() {

        return this.children.size();
    }
    public LinkedList<FatDirectory> getSubDirectories() {
        LinkedList<FatDirectory> subdirectories = new LinkedList<FatDirectory>();
        for(FatFSElement e : children) {
            if (e.isDirectory()) {
                subdirectories.add((FatDirectory) e);
            }
        }
        return subdirectories;
    }
    public LinkedList<FatFile> getFiles() {
        for(FatFSElement e : children) {
            if(!e.isDirectory()) {
                files.add((FatFile) e);
            }
        }
        return this.files;
    }
    public int getTotalSize() {
        int totalsize = 0;

        for(FatFSElement e : children) {
            if (e.isDirectory())
                totalsize += ((FatDirectory) e).getTotalSize();

            else
                totalsize += e.getSize();

        }

        return totalsize;
    }
    public LinkedList<FatFSElement> getAllChildren() {


        for(FatFSElement e : children) {
            if (e.isDirectory()) {
                allchildren.add(e);
                for (FatFSElement f : ((FatDirectory) e).getAllChildren())
                    allchildren.add(f);
            }
            else
                allchildren.add(e);

        }
        return allchildren;

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
