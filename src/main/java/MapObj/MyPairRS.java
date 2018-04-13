package MapObj;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
public class MyPairRS {

    @JsonDeserialize(keyUsing = MyPairDeserialaser.class)
    private Map<MyPair,String> map;

}
