package XML;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@XmlRootElement(name="person_root")
public class UserXml {

    private String first_name;
    private String last_name;
    private String id;
    private String email_field;

}
