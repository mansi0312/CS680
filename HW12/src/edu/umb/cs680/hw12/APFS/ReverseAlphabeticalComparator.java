package edu.umb.cs680.hw12.APFS;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<ApfsElement> {
    public int compare(ApfsElement e1, ApfsElement e2) {
        return e2.getName().compareTo(e1.getName());
    }
}
