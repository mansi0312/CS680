package edu.umb.cs680.hw12;


import edu.umb.cs680.hw12.APFS.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FourComparatorTest {
    private LocalDateTime localdatetime1 = LocalDateTime.now();
    private LocalDateTime localdatetime2 = LocalDateTime.now();
    private LocalDateTime localdatetime3 = LocalDateTime.now();
    private LocalDateTime localdatetime4 = LocalDateTime.now();
    ApfsDirectory root = new ApfsDirectory(null, "Root",0, localdatetime1);
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



        @Test
        public void getChildrenAlphabeticalTest() {
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
            String[] expected = {"Code","c", "d", "x"};
            LinkedList<ApfsElement> children = home.getChildren(new AlphabeticalComparator());
            String[] actual = new String[children.size()];
            for(int i =0; i < children.size(); i++)
                actual[i] = children.get(i).getName();
            assertArrayEquals(expected, actual);
        }
        @Test
        public void getChildrenReverseAlphabeticalTest() {
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
            String[] expected = {"x", "d", "c", "Code"};
            LinkedList<ApfsElement> children = home.getChildren(new ReverseAlphabeticalComparator());
            String[] actual = new String[children.size()];
            for(int i =0; i < children.size(); i++)
                actual[i] = children.get(i).getName();
            assertArrayEquals(expected, actual);
        }
        @Test
    public void getChildrenElementKindBasedTest() {
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
            String[] expected = {"Code", "c", "d", "x"};
            LinkedList<ApfsElement> children = home.getChildren(new ElementKindBasedComparator());
            String[] actual = new String[children.size()];
            for(int i =0; i < children.size(); i++)
                actual[i] = children.get(i).getName();
            assertArrayEquals(expected, actual);
        }
     @Test
    public void getChildrenTimestampBasedTest() {
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
         code.setLastModified(LocalDateTime.of(2012, 5, 2, 6, 0));
         c.setLastModified(LocalDateTime.of(2013, 7, 12, 6, 30));
         d.setLastModified(LocalDateTime.of(2013, 5, 3, 6, 0));
         x.setLastModified(LocalDateTime.of(2013, 7, 12, 6, 0));
         String[] expected = {"c", "x", "d", "Code"};
         LinkedList<ApfsElement> children = home.getChildren(new TimestampBasedComparator());
         String[] actual = new String[children.size()];
         for(int i =0; i < children.size(); i++)
             actual[i] = children.get(i).getName();
         assertArrayEquals(expected, actual);
        }
}
