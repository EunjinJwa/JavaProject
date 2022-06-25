package jinny.study.tdd;

import jinny.study.tdd.domain.DuplicatedIdException;
import jinny.study.tdd.domain.User;
import jinny.study.tdd.domain.UserRegister;
import jinny.study.tdd.domain.UserRepository;
import jinny.study.tdd.doubletest.MemoryUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 대역 테스트코드 작성하기
 * Fake : MemoryUserRepository
 */
public class UserRegisterTest {
    private UserRegister userRegister;
    //    private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository memoryUserRepository = new MemoryUserRepository();

    @BeforeEach
    void setUp () {
        userRegister = new UserRegister(memoryUserRepository);
    }

    @DisplayName("이미 같은 ID가 존재하면 가입 실패")
    @Test
    void dupIdExists() {
        // Fake Repository로 이미 같은 ID가 존재하는 상황 만들기
        memoryUserRepository.save(User.builder().id("11100").name("jinny").email("jinny@mail.com").build());

        Assertions.assertThatThrownBy(
                        () -> userRegister.register(User.builder().id("11100").name("kassy").email("kassy@mail.com").build()))
                .isInstanceOf(DuplicatedIdException.class);
    }
}
