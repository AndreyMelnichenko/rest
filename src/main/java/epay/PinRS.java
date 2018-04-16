package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PinRS {
    @JsonProperty("Result")
    private String result;
    @JsonProperty("Uid")
    private String uid;
    @JsonProperty("Errors")
    private String errors;
}
