package MapObj;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class MyPairDeserialaser extends KeyDeserializer {
    @Override
    public Object deserializeKey(String key, DeserializationContext deserializationContext) {
        String[] pairs = key.split("and");
        String firstName = pairs[0].trim();
        String secondName = pairs[1].trim();
        return new MyPair(firstName, secondName);
    }
}
