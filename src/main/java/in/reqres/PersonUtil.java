package in.reqres;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {
    public static Data getData (String id, String firstName, String lastName, String email){
        return new Data(id, firstName, lastName, email);
    }

    public List<Data> getDatas (Data... datas){
        List<Data> dataList = new ArrayList<>();
        for(Data data:datas){
            dataList.add(data);
        }
        return dataList;
    }
}
