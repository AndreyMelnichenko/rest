package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivateUserRK {
    @JsonProperty("ActivationId")
    private String activationId;
    @JsonProperty("SmsCode")
    private String smsCode;
}
