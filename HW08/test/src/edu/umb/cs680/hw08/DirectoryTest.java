package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class DirectoryTest {
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




	    private String[] dirToStringArray(Directory d) {
	        String parentName = null;
	        Directory parent = d.getParent();
	        if (parent != null) {
	            parentName = parent.getName();
	        }
	        String[] dirInfo = {
	                d.getName(),
	                String.valueOf(d.getSize()),
	                String.valueOf (d.getCreationTime()),
	                parentName,
	                String.valueOf(d.countChildren()),
	                String.valueOf(d.getTotalSize()),
	                String.valueOf(d.isDirectory()),
	                String.valueOf(d.isFile()),
	                String.valueOf(d.isLink())
	        };
	        return dirInfo;
	        }
	   @Test
	    public void verifyDirectoryEqualityRoot(){
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

	       String[] expected = {"Root", "0", localdatetime1.toString(), null, "2", "60", "true", "false", "false"};
	       Directory directory = root;
	       String[] actual = dirToStringArray(directory);
	       assertArrayEquals(actual, expected);
	   }
	    @Test
	    public void verifyDirectoryEqualityHome() {
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

	       String[] expected = {"Home", "0", localdatetime2.toString(), "Root", "4", "40", "true", "false", "false" };
	        Directory directory = home;
	        String[] actual = dirToStringArray(directory);
	        assertArrayEquals(actual, expected);
	    }

	    @Test
	    public void verifyDirectoryEqualityCode() {
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
	        String[] expected = {"Code", "0", localdatetime3.toString(), "Home",  "3", "20", "true", "false", "false" };
	        Directory directory = code;
	        String[] actual = dirToStringArray(directory);
	        assertArrayEquals(actual, expected);
	    }
}
