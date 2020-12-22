package edu.umb.cs680.hw09;



import edu.umb.cs680.hw09.APFS.ApfsDirectory;
import edu.umb.cs680.hw09.APFS.ApfsElement;
import edu.umb.cs680.hw09.APFS.ApfsFile;
import edu.umb.cs680.hw09.APFS.ApfsLink;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;


public class APFSTest {

    @Test
    public void ApfsTest() {
        LocalDateTime localdatetime1 = LocalDateTime.now();
        LocalDateTime localdatetime2 = LocalDateTime.now();
        LocalDateTime localdatetime3 = LocalDateTime.now();
        LocalDateTime localdatetime4 = LocalDateTime.now();
        ApfsDirectory root = new ApfsDirectory(null, "Root", 0, localdatetime1);
        ApfsDirectory home = new ApfsDirectory(null, "Home", 0, localdatetime2);
        ApfsDirectory applications = new ApfsDirectory(null, "Applications", 0, localdatetime2);
        ApfsDirectory code = new ApfsDirectory(null, "Code", 0, localdatetime3);
        ApfsFile a = new ApfsFile(null, "a", 10, localdatetime3);
        ApfsFile b = new ApfsFile(null, "b", 10, localdatetime3);
        ApfsFile c = new ApfsFile(null, "c", 10, localdatetime3);
        ApfsFile d = new ApfsFile(null, "d", 10, localdatetime3);
        ApfsFile e = new ApfsFile(null, "e", 10, localdatetime4);
        ApfsFile f = new ApfsFile(null, "f", 10, localdatetime4);
        ApfsLink x = new ApfsLink(null, "x", 0, localdatetime3, applications);
        ApfsLink y = new ApfsLink(null, "y", 0, localdatetime4, b);
        root.appendChild(home);
        root.appendChild(applications);
        home.appendChild(code);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(c);
        home.appendChild(d);
        home.appendChild(x);
        code.appendChild(e);
        code.appendChild(f);
        code.appendChild(y);
        LinkedList<ApfsElement> tree = root.getAllChildren();

        String[] exprcted = { "Home","Code", "e", "f", "y",   "c", "d",   "x", "Applications",  "a", "b" };

        String[] actual = new String[tree.size()];

        for(int i =0; i < tree.size(); i++)
            actual[i] = tree.get(i).getName();
        assertArrayEquals(exprcted, actual);


    }

}
