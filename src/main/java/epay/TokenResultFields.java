package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResultFields {
    @JsonProperty("AccessToken")
    private String accessToken;
    @JsonProperty("TokenType")
    private String tokenType;
    @JsonProperty("ExpiresIn")
    private String expiresIn;
}
