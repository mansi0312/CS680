package edu.umb.cs680.hw10;
import edu.umb.cs680.hw10.APFS.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
public class APFSVistorTest {
   @Test
   public void ApfsVistorTest() {

       LocalDateTime dateTime1 = LocalDateTime.now();
       APFS apfs = APFS.getInstance();
       apfs.initFileSystem("FFileSys", 2000);
       ApfsDirectory root = (ApfsDirectory) apfs.createDefaultRoot();
       ApfsDirectory home = new ApfsDirectory(null, "home", 0,dateTime1);
       root.appendChild(home);

       ApfsFile a1 = new ApfsFile(null, "a", 10,dateTime1);
       home.appendChild(a1);
       ApfsFile b = new ApfsFile(null, "b", 10,dateTime1);
       home.appendChild(b);
       ApfsLink x = new ApfsLink(null,"x",0, dateTime1, a1);
       home.appendChild(x);
       ApfsFile a2 = new ApfsFile(null, "a", 10,dateTime1);
       root.appendChild(a2);



       LinkedList<ApfsElement> tree = root.getAllChildren();
       ApfsCountingVisitor visitor1 = new ApfsCountingVisitor();
       root.accept( visitor1 );
       String[] expected = {"2", "3", "1"};
       String[] actual = {String.valueOf(visitor1.getDirNum()),
               String.valueOf(visitor1.getFileNum()),
               String.valueOf(visitor1.getLinkNum())};
       assertArrayEquals(expected, actual);


   }

}
