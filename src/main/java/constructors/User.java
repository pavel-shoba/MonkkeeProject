package constructors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {
    /**
     * Constructor for User object
     */
    String password;
    String username;

    public User() {
    }
}
