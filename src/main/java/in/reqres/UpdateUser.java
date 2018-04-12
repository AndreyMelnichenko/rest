package in.reqres;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of={"name","job"})
@NoArgsConstructor
public class UpdateUser extends User {

    private String updatedAt;

    public UpdateUser(String name, String job) {
        super(name, job);
    }
}
