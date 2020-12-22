package edu.umb.cs680.hw12.APFS;

import java.util.Comparator;

public class ElementKindBasedComparator implements Comparator<ApfsElement> {
    public int compare(ApfsElement e1, ApfsElement e2) {
        if (e1.isDirectory() && !e2.isDirectory()) {
            return -1;
        }
        if (!e1.isDirectory() && e2.isDirectory()) {
            return 1;
        }
        if (e1.isLink() && !e2.isLink()) {
            return 1;
        }
        if (!e1.isLink() && e2.isLink()) {
            return -1;
        }
        return e1.getName().compareTo(e2.getName());
    }
}
