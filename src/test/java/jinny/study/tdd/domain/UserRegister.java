package jinny.study.tdd.domain;

public class UserRegister {

    private WeakPasswordChecker weakPasswordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;
    public UserRegister (WeakPasswordChecker weakPasswordChecker, UserRepository userRepository, EmailNotifier emailNotifier) {
        this.weakPasswordChecker = weakPasswordChecker;
        this.userRepository = userRepository;
        this.emailNotifier = emailNotifier;
    }

    public void register (User user) {
        if (weakPasswordChecker.checkPasswordWeak(user.password)) {
            throw new WeakPasswordException();
        }
        User savedUser = userRepository.findById(user.id);
        if (savedUser != null) {
            throw new DuplicatedIdException();
        }
        userRepository.save(user);

        emailNotifier.sendRegisterEmail(user.email);
    }
}
