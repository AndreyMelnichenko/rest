package ListObj;

import MapObj.MyPairDeserialaser;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoatRS {

    @JsonDeserialize(keyUsing = MyBoatDeserialaser.class)
    private Map<String,List<CarProperty>> boatsMap;
}
