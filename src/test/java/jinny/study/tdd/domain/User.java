package jinny.study.tdd.domain;

import lombok.*;

@EqualsAndHashCode(of = {"id", "name"})
@ToString
@Builder
@Getter @Setter
public class User {
    String id;
    String password;
    String name;
    String email;
    Integer age;
}
