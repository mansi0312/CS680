package edu.umb.cs680.hw09.FAT;

import edu.umb.cs680.hw09.FSFoundation.FSElement;
import edu.umb.cs680.hw09.FSFoundation.FileSystem;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class FAT extends FileSystem {

    private static FAT instance = null;
    private static FatDirectory root;
    private LocalDateTime dateTime = LocalDateTime.now();
    private LinkedList<FatDirectory> rootDirs = new LinkedList<FatDirectory>();

    private FAT() {

    }

    public static FAT getInstance() {
        if (instance == null) {
            instance = new FAT();
        }
        return instance;
    }

    protected FSElement createDefaultRoot() {


        return new FatDirectory(null, "root", 0, dateTime);
    }

    public void addRootDir(FatDirectory rootDir) {

        this.rootDirs.add(rootDir);
    }

    public static void main(String args[]) {
        LocalDateTime dateTime1 = LocalDateTime.now();
        FAT fat = FAT.getInstance();
        fat.initFileSystem("FFileSys", 2000);
        FatDirectory root = (FatDirectory) fat.createDefaultRoot();
        FatDirectory home = new FatDirectory(null, "home", 0,dateTime1);
        root.appendChild(home);
        FatFile a = new FatFile(null, "a", 10,dateTime1);
        home.appendChild(a);

        LinkedList<FatFSElement> tree = root.getAllChildren();

        System.out.println("tree: " + tree.size());
        for(FatFSElement f : tree) {
            System.out.print("Name: " + f.getName());
            if(f.isDirectory())
                System.out.println(" is a Directory. ");
            if(f.isFile())
                System.out.println(" is a file. ");

        }

    }
}

