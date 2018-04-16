package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultFields {
    @JsonProperty("ActivationId")
    private String activationId;
    @JsonProperty("ExpiresIn")
    private String expiresIn;
    @JsonProperty("SmsCodeRegex")
    private String smsCodeRegex;
    @JsonProperty("AppKey")
    private String appKey;
    @JsonProperty("HasPin")
    private String hasPin; //ready for casting to boolean if it will be need
}
