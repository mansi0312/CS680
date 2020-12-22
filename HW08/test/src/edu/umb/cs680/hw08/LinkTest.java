package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class LinkTest {

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

    private String[] linkToStringArray(Link link) {
        String[] linkInfo = {

                link.getName(),
                Integer.toString(link.getSize()),
                link.getCreationTime().toString(),
                link.getParent().getName(),
                String.valueOf(link.getTarget().getName()),
                String.valueOf(link.isDirectory()),
                String.valueOf(link.isFile()),
                String.valueOf(link.isLink())
        };
        return linkInfo;
    }

    @Test
    public void verifyLinkEqualityX() {
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

        String[] expected = {"x", "0", localdatetime3.toString(), "Home", "Applications", "false", "false", "true" };
        Link link = this.x;
        String[] actual = linkToStringArray(x);
        assertArrayEquals(actual, expected);
    }
    @Test
    public void verifyLinkEqualityY() {
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

        String[] expected = {"y", "0", localdatetime4.toString(), "Code", "b", "false", "false", "true" };
        Link link = this.y;
        String[] actual = linkToStringArray(y);
        assertArrayEquals(actual, expected);
    }

}
