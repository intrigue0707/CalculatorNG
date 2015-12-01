import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maryia on 12/1/2015.
 */
public class Runner {
    public static void main(String[] args){
        XmlSuite suite= new XmlSuite();
        suite.setName("TemporarySuite");
        List<String> files= new ArrayList<>();
files.addAll(new ArrayList<String>() {
    {
        add("src/main/resources/parallel.xml");
        add("src/main/resources/suits.xml");
    }
});
suite.setSuiteFiles(files);
        List<XmlSuite> suits=new ArrayList<>();
        suits.add(suite);

    }
}
