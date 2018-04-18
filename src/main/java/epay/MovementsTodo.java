package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementsTodo {
    @JsonProperty("MovementUid")
    private String movementUid;
    @JsonProperty("Rrn")
    private String rrn;
    @JsonProperty("MovementDate")
    private String movementDate;
    @JsonProperty("SignAmount")
    private String signAmount;
    @JsonProperty("Amount")
    private String amount;
    @JsonProperty("Description")
    private String description;


}
