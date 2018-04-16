package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserRK {
    @JsonProperty("PhoneNumber")
    private String phoneNumber;
}
