package ListObj;

import MapObj.Boat;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class MyBoatDeserialaser extends KeyDeserializer {

    @Override
    public Object deserializeKey(String key, DeserializationContext deserializationContext) {
        String[] pairs = key.split("and");
        String name = pairs[0].trim();
        String type = pairs[1].trim();
        return new Boat(name, type);
    }
}
