package epay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsList {
    @JsonProperty("AccountUid")
    private String accountUid;
    @JsonProperty("AccountNumber")
    private String accountNumber;
    @JsonProperty("ClientAllias")
    private String clientAllias;
    @JsonProperty("PartnerAlias")
    private String partnerAlias;
    @JsonProperty("IsMain")
    private String isMain;
    @JsonProperty("OrderNumber")
    private String orderNumber;
    @JsonProperty("IsActive")
    private String isActive;
    @JsonProperty("AvailableBalance")
    private String availableBalance;
    @JsonProperty("LockedBalance")
    private String lockedBalance;
    @JsonProperty("Card")
    private AccountsCard card;
}
