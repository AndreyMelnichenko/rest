package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class PinRK {
    @JsonProperty("AppKey")
    private String appKey;
    @JsonProperty("OldPin")
    private String oldPin;
    @JsonProperty("NewPin")
    private String newPin;
}
