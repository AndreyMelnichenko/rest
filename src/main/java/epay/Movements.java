package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movements {
    @JsonProperty("Result")
    private List<MovementsTodo> result;
    @JsonProperty("Uid")
    private String uid;
    @JsonProperty("Errors")
    private String errors;
}
