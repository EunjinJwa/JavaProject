package jinny.study.tdd;

import jinny.study.tdd.domain.*;
import jinny.study.tdd.doubletest.MemoryUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class UserRegisterMockTest {
    UserRegister userRegister;
    private WeakPasswordChecker mockWeakPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private MemoryUserRepository memoryUserRepository = new MemoryUserRepository();
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class);

    @BeforeEach
    void setUp () {
        userRegister = new UserRegister(mockWeakPasswordChecker, memoryUserRepository, mockEmailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword () {
        /** mockWeakPasswordChecker.checkPasswordWeak 가 실행되면 true를 반환하도록 설정함. */
        BDDMockito.given(mockWeakPasswordChecker.checkPasswordWeak("pw1234"))
                .willReturn(true);

        Assertions.assertThatThrownBy(() -> userRegister.register(User.builder().id("100").name("jinny").email("jinny@email.com").build()))
                .isInstanceOf(WeakPasswordException.class);
    }

    @DisplayName("회원가입시 암호검사 수행함")
    @Test
    void checkPasswordWhenRegist () {
        userRegister.register(User.builder().id("100").password("pw1234").name("jinny").email("jinny@email.com").build());

        /** mockWeakPasswordChecker 객체의 checkPasswordWeak() 메서드가 실행되었는지 확인 */
        BDDMockito.then(mockWeakPasswordChecker)
                .should()
                .checkPasswordWeak(BDDMockito.anyString());
    }

    @DisplayName("[Captor] 가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendEmail() {
        userRegister.register(User.builder().id("100").password("pw1234").name("jinny").email("jinny@email.com").build());

        /**
         * Mockito의 ArgumentCaptor : 모의객체를 메서드를 호출할 때 전달한 객체를 담는 기능을 제공한다.
         * sendRegisterEmail(captor.capture()) : 모의객체 메서드 호출에 사용된 전달인자가 ArgumentCaptor에 함께 담긴다.
         */
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        BDDMockito.then(mockEmailNotifier)
                .should()
                .sendRegisterEmail(captor.capture());

        Assertions.assertThat("jinny@email.com").isEqualTo(captor.getValue());
    }
}
