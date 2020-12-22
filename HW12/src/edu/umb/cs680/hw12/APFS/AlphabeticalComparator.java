package edu.umb.cs680.hw12.APFS;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsElement> {
    public int compare(ApfsElement e1, ApfsElement e2) {
        return e1.getName().compareTo(e2.getName());
    }

}
