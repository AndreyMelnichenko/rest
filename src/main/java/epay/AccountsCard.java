package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsCard {
    @JsonProperty("Pan")
    private String pan;
    @JsonProperty("ExpireDate")
    private String expireDate;
    @JsonProperty("ExpireDateStr")
    private String expireDateStr;
    @JsonProperty("CardUid")
    private String cardUid;
    @JsonProperty("PhoneSms")
    private String phoneSms;
    @JsonProperty("Alias")
    private String alias;
}
