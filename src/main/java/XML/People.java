package XML;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@lombok.Data
@XmlRootElement(name="people")
public class People {
    private List<UserXml> person;
}
