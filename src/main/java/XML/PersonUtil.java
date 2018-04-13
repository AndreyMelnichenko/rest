package XML;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {
    public static UserXml getUser (String first_name, String last_name, String id, String email_field){
        return new UserXml(first_name, last_name, id, email_field);
    }

    public List<UserXml> getUsers (UserXml... userXmls){
        List<UserXml> dataList = new ArrayList<>();
        for(UserXml userXml:userXmls){
            dataList.add(userXml);
        }
        return dataList;
    }
}
