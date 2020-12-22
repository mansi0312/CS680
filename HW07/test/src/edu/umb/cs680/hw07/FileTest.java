package edu.umb.cs680.hw07;

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

    private String[] fileToStringArray(File file) {
        String[] fileInfo = {
                String.valueOf(file.isDirectory()),
                file.getName(),
                Integer.toString(file.getSize()),
                file.getCreationTime().toString(),
                file.getParent().getName(),
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
        code.appendChild(e);
        code.appendChild(f);

        String[] expected = { "false", "a", "10", localdatetime3.toString(), "Applications" };
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
        code.appendChild(e);
        code.appendChild(f);
        String[] expected = { "false", "b", "10", localdatetime3.toString(), "Applications" };
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
        code.appendChild(e);
        code.appendChild(f);
        String[] expected = { "false", "c", "10", localdatetime3.toString(), "Home" };
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
        String[] expected = { "false", "d", "10", localdatetime3.toString(), "Home"};
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
        String[] expected = { "false", "e", "10", localdatetime4.toString(), "Code" };
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
        String[] expected = { "false", "f", "10", localdatetime4.toString(), "Code"};
        File file = this.f;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }
}
