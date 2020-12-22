package edu.umb.cs680.hw12.APFS;


import edu.umb.cs680.hw12.FSFoundation.FSElement;
import edu.umb.cs680.hw12.FSFoundation.FileSystem;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFS extends FileSystem {
    private static APFS instance = null;
    private static ApfsDirectory root;
    private LocalDateTime dateTime = LocalDateTime.now();
    private LinkedList<ApfsDirectory> rootDirs = new LinkedList<ApfsDirectory>();

    private APFS() {

    }

    public static APFS getInstance() {
        if (instance == null) {
            instance = new APFS();
        }
        return instance;
    }

    protected FSElement createDefaultRoot() {


        return new ApfsDirectory(null, "root", 0, dateTime);
    }

    public void addRootDir(ApfsDirectory rootDir) {

        this.rootDirs.add(rootDir);
    }
    public static void main(String args[]) {
        LocalDateTime dateTime1 = LocalDateTime.now();
        APFS apfs = APFS.getInstance();
        apfs.initFileSystem("FFileSys", 2000);
        ApfsDirectory root = (ApfsDirectory) apfs.createDefaultRoot();
        ApfsDirectory home = new ApfsDirectory(null, "home", 0,dateTime1);
        root.appendChild(home);

        ApfsFile a = new ApfsFile(null, "a", 10,dateTime1);
        home.appendChild(a);
        ApfsLink x = new ApfsLink(null,"x",0, dateTime1, a);
        home.appendChild(x);



        LinkedList<ApfsElement> tree = root.getAllChildren();




        for(ApfsElement f : tree) {
            System.out.print("Name: " + f.getName());
            if(f.isDirectory())

                System.out.println(" is a Directory. ");
            if(f.isFile())

                System.out.println(" is a File. ");

            if(f.isLink()) {

                System.out.print(" is a Link. ");
                System.out.println(" Target to  " + ((ApfsLink)f).getTarget().getName());
            }
        }

    }
}
