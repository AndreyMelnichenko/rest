package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenRK {
    @JsonProperty("AppKey")
    private String appKey;
    @JsonProperty("Pin")
    private String pin;
}
