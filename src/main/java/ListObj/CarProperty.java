package ListObj;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class CarProperty {

    @JsonProperty("car_speed")
    private String speed;
    @JsonProperty("car_name")
    private String brand;
}
