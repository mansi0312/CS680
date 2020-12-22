package edu.umb.cs680.hw09;
import edu.umb.cs680.hw09.FAT.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;


public class FATTest {

    @Test
    public void FatTest() {
        LocalDateTime localdatetime1 = LocalDateTime.now();
        LocalDateTime localdatetime2 = LocalDateTime.now();
        LocalDateTime localdatetime3 = LocalDateTime.now();
        LocalDateTime localdatetime4 = LocalDateTime.now();
        FatDirectory root = new FatDirectory(null, "Root", 0, localdatetime1);
        FatDirectory home = new FatDirectory(null, "Home", 0, localdatetime2);
        FatDirectory applications = new FatDirectory(null, "Applications", 0, localdatetime2);
        FatDirectory code = new FatDirectory(null, "Code", 0, localdatetime3);
        FatFile a = new FatFile(null, "a", 10, localdatetime3);
        FatFile b = new FatFile(null, "b", 10, localdatetime3);
        FatFile c = new FatFile(null, "c", 10, localdatetime3);
        FatFile d = new FatFile(null, "d", 10, localdatetime3);
        FatFile e = new FatFile(null, "e", 10, localdatetime4);
        FatFile f = new FatFile(null, "f", 10, localdatetime4);

        root.appendChild(home);
        root.appendChild(applications);
        home.appendChild(code);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(c);
        home.appendChild(d);

        code.appendChild(e);
        code.appendChild(f);

        LinkedList<FatFSElement> tree = root.getAllChildren();

        String[] exprcted = { "Home","Code", "e", "f",   "c", "d",  "Applications",  "a", "b" };

        String[] actual = new String[tree.size()];

        for(int i =0; i < tree.size(); i++)
            actual[i] = tree.get(i).getName();
        assertArrayEquals(exprcted, actual);


    }

}
