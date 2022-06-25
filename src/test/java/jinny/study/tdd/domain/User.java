package jinny.study.tdd.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    String id;
    String password;
    String name;
    String email;
}
