package edu.umb.cs680.hw12.APFS;

import java.util.Comparator;

public class TimestampBasedComparator implements Comparator<ApfsElement> {
    public int compare(ApfsElement e1, ApfsElement e2) {
        return e2.getLastModified().compareTo(e1.getLastModified());
    }
}
