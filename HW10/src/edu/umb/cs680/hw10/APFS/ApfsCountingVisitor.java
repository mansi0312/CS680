package edu.umb.cs680.hw10.APFS;

public class ApfsCountingVisitor implements ApfsVisitor {
    private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;
    public void visit(ApfsLink link) {
        linkNum++;
    }
    public void visit(ApfsDirectory dir) {
      dirNum++;
    }
    public void visit(ApfsFile file) {
      fileNum++;
    }

    public int getDirNum() {
        return dirNum;
    }

    public int getLinkNum() {
        return linkNum;
    }

    public int getFileNum() {
        return fileNum;
    }
}
