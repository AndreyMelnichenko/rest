package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRS {
    @JsonProperty("Result")
    private ResultFields result;
    @JsonProperty("Uid")
    private String uid;
    @JsonProperty("Errors")
    private String errors;
}
