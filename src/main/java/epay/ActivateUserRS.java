package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivateUserRS {
    private ResultFields resultFields;
    @JsonProperty("Uid")
    private String uid;
    @JsonProperty("Errors")
    private String errors;
}
