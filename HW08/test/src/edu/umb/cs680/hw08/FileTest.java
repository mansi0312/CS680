package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class FileTest {

    private LocalDateTime localdatetime1 = LocalDateTime.now();
    private LocalDateTime localdatetime2 = LocalDateTime.now();
    private LocalDateTime localdatetime3 = LocalDateTime.now();
    private LocalDateTime localdatetime4 = LocalDateTime.now();
    Directory root = new Directory(null, "Root",0, localdatetime1);
    Directory home = new Directory(null, "Home", 0, localdatetime2);
    Directory applications = new Directory(null, "Applications", 0, localdatetime2);
    Directory code = new Directory(null, "Code", 0, localdatetime3);
    File a = new File(null, "a", 10, localdatetime3);
    File b = new File(null, "b", 10, localdatetime3);
    File c = new File(null, "c", 10, localdatetime3);
    File d = new File(null, "d", 10, localdatetime3);
    File e = new File(null, "e", 10, localdatetime4);
    File f = new File(null, "f", 10, localdatetime4);
    Link x = new Link(null, "x", 0, localdatetime3, applications);
    Link y = new Link(null, "y", 0, localdatetime4, b);

    private String[] fileToStringArray(File file) {
        String[] fileInfo = {

                file.getName(),
                Integer.toString(file.getSize()),
                file.getCreationTime().toString(),
                file.getParent().getName(),
                String.valueOf(file.isDirectory()),
                String.valueOf(file.isFile()),
                String.valueOf(file.isLink())
                 };
        return fileInfo;
    }

    @Test
    public void verifyFileEqualityA() {
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

        String[] expected = {"a", "10", localdatetime3.toString(), "Applications", "false", "true", "false" };
        File file = this.a;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyFileEqualityB() {
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
        String[] expected = { "b", "10", localdatetime3.toString(), "Applications", "false", "true", "false" };
        File file = this.b;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyFileEqualityC() {
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
        String[] expected = { "c", "10", localdatetime3.toString(), "Home", "false", "true", "false" };
        File file = this.c;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyFileEqualityD() {
        root.appendChild(home);
        root.appendChild(applications);
        home.appendChild(code);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(c);
        home.appendChild(d);
        code.appendChild(e);
        code.appendChild(f);
        String[] expected = {"d", "10", localdatetime3.toString(), "Home", "false", "true", "false"};
        File file = this.d;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyFileEqualityE() {
        root.appendChild(home);
        root.appendChild(applications);
        home.appendChild(code);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(c);
        home.appendChild(d);
        code.appendChild(e);
        code.appendChild(f);
        String[] expected = {"e", "10", localdatetime4.toString(), "Code", "false", "true", "false"};
        File file = this.e;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyFileEqualityF() {
        root.appendChild(home);
        root.appendChild(applications);
        home.appendChild(code);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(c);
        home.appendChild(d);
        code.appendChild(e);
        code.appendChild(f);
        String[] expected = {  "f", "10", localdatetime4.toString(), "Code", "false", "true", "false"};
        File file = this.f;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }

}
