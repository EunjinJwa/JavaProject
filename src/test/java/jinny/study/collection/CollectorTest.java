package jinny.study.collection;

import jinny.study.tdd.domain.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorTest {

    @Test
    public void collectToMapTest() {
        User user1 = User.builder()
                .id("aaa1")
                .password("1234")
                .name("kassy1")
                .age(10)
                .build();

        User user2 = User.builder()
                .id("aaa1")
                .password("5555")
                .name("kassy1")
                .age(20)
                .build();

        User user3 = User.builder()
                .id("aaa3")
                .password("6666")
                .name("kassy1")
                .age(30)
                .build();

        List<User> users = Arrays.asList(user1, user2, user3);

        Map<User, User> collect = users.stream().collect(Collectors.toMap(Function.identity(), Function.identity(), this::mergeUserAge));

        System.out.println(collect);

    }

    private User mergeUserAge (User user1, User user2) {
        user1.setAge(user1.getAge() + user2.getAge());
        return user1;
    }
}
