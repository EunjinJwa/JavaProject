package jinny.study.tdd.doubletest;

import jinny.study.tdd.domain.User;
import jinny.study.tdd.domain.UserRepository;

import java.util.HashMap;

public class MemoryUserRepository implements UserRepository {
    private HashMap<String, User> userMap = new HashMap<>();

    @Override
    public void save (User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User findById (String id) {
        return userMap.get(id);
    }
}
