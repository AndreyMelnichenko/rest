package in.reqres;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = {"name", "job"})
@NoArgsConstructor
public class User {
    private String name;
    private String job;
    private String id;
    private String createdAt;
    private String updatedAt;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
