package jinny.study.tdd.domain;

import org.junit.jupiter.api.function.Executable;

public class UserRegister {

    private UserRepository userRepository;
    public UserRegister (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register (User user) {
        User savedUser = userRepository.findById(user.id);
        if (savedUser != null) {
            throw new DuplicatedIdException();
        }
        userRepository.save(user);
    }
}
