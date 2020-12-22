package edu.umb.cs680.hw10.APFS;

import edu.umb.cs680.hw10.FSFoundation.FSElement;
import edu.umb.cs680.hw10.FSFoundation.FileSystem;

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

    public FSElement createDefaultRoot() {


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

        ApfsFile a1 = new ApfsFile(null, "a", 10,dateTime1);
        home.appendChild(a1);
        ApfsFile b = new ApfsFile(null, "b", 10,dateTime1);
        home.appendChild(b);
        ApfsLink x = new ApfsLink(null,"x",0, dateTime1, a1);
        home.appendChild(x);
        ApfsFile a2 = new ApfsFile(null, "a", 10,dateTime1);
        root.appendChild(a2);



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



        ApfsCountingVisitor visitor1 = new ApfsCountingVisitor();
        root.accept( visitor1 );
        System.out.println("Visitor1: the number of Directories is "+ visitor1.getDirNum() + ".");
        System.out.println("Visitor1: the number of Files is "+ visitor1.getFileNum() + ".");
        System.out.println("Visitor1: the number of Links is "+  visitor1.getLinkNum() + ".");


        ApfsFileCrawlingVisitor visitor2 = new ApfsFileCrawlingVisitor();
        root.accept( visitor2 );
        System.out.println("Visitor2: Out put file name:");
        for(ApfsFile f: visitor2.getFiles())
            System.out.println(f.getName());
        System.out.println("Complete.");


        FileSearchVisitor visitor3 = new FileSearchVisitor("a");
        root.accept( visitor3 );
        System.out.println("Visitor3: the number of the file by searching: " + visitor3.getFoundFiles().size());

    }

}
