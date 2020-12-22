package edu.umb.cs680.hw10.APFS;

import java.util.LinkedList;

public class FileSearchVisitor implements ApfsVisitor{
    private String fileName;
    private LinkedList<ApfsFile> foundFiles = new LinkedList<ApfsFile>();
    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
    }
    public void visit(ApfsLink link) {
        return;
    }
    public void visit(ApfsDirectory dir) {
        return;
    }
    public void visit(ApfsFile file) {
        if(file.getName().equals(fileName)){
            foundFiles.add(file);
        }
    }
    public LinkedList<ApfsFile> getFoundFiles() {

        return foundFiles;
    }
}
