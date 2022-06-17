package jinny.study.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoExtentionTest {

    // 모의 객체 생성
    @Mock
    GameNumGen genMock;

    @Test
    void mockTest() {

        // genMock.generate(GameLevel.High) 메서드가 불리면 "123"을 리턴하라.
        BDDMockito.given(genMock.generate(GameLevel.HIGH)).willReturn("123");

        String num = genMock.generate(GameLevel.HIGH);
        Assertions.assertThat("123").isEqualTo(num);
    }

}
