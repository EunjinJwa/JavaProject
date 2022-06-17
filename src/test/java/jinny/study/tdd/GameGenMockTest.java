package jinny.study.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;

import java.util.List;

public class GameGenMockTest {
    @Test
    void mockTest () {
        // 모의 객체 생성
        GameNumGen genMock = Mockito.mock(GameNumGen.class);
        // genMock.generate(GameLevel.High) 메서드가 불리면 "123"을 리턴하라.
        BDDMockito.given(genMock.generate(GameLevel.HIGH)).willReturn("123");

        String num = genMock.generate(GameLevel.HIGH);
        Assertions.assertThat("123").isEqualTo(num);
    }

    @Test
    @DisplayName("리턴타입이 void인 메서드에 대해 익셉션 발생")
    void voidMethodWillThrowTest () {
        List<String> mockList = Mockito.mock(List.class);
        BDDMockito.willThrow(UnsupportedOperationException.class)    // 발생시킬 Exception 타입
                .given(mockList)    // given : 모의 객체를 전달. 리턴 타입은 모의 객체가 됨.
                .clear();           // exception을 발생할 메서드 호출

        org.junit.jupiter.api.Assertions.assertThrows(
                UnsupportedOperationException.class,
                () -> mockList.clear()
        );
    }

    @Test
    @DisplayName("ArgumentMatchers.any() : 임의의 인자를 전달하여 모든 값에 일치하도록 스텁 설정")
    void anyMatcherTest () {
        GameNumGen genMock = Mockito.mock(GameNumGen.class);
        BDDMockito.given(genMock.generate(ArgumentMatchers.any())).willReturn("123");

        String num = genMock.generate(GameLevel.HIGH);
        Assertions.assertThat("123").isEqualTo(num);

        String num2 = genMock.generate(GameLevel.EASY);
        Assertions.assertThat("123").isEqualTo(num2);
    }

    @Test
    @DisplayName("ArgumentMatchers.any() : n개의 인자값에 any를 사용할 경우 모든 인자값이 any여야 함.")
    void anyMatcherException () {
        List<String> tempList = Mockito.mock(List.class);
        try {
            BDDMockito.given(tempList.set(ArgumentMatchers.anyInt(), "banana")).willReturn("banana");
            tempList.set(3, "apple");
            org.junit.jupiter.api.Assertions.fail();
        } catch (InvalidUseOfMatchersException e) {
            System.out.println("실패함 : " + e.getMessage());
        }
    }

    @Test
    @DisplayName("ArgumentMatchers.any() + eq(): 임의의 값 일치와 정확한 값 일치가 필요한 경우 eq() 사용")
    void mixAnyAndEq () {
        List<String> mockList = Mockito.mock(List.class);

        BDDMockito.given(mockList.set(ArgumentMatchers.anyInt(), ArgumentMatchers.eq("banana"))).willReturn("banana");

        Assertions.assertThat(mockList.set(3, "apple")).isNull();
        Assertions.assertThat(mockList.set(4, "banana")).isEqualTo("banana");
    }

    @Test
    void init() {
        GameNumGen gameNumGen = Mockito.mock(GameNumGen.class);
        Game game = new Game(gameNumGen);
        game.init(GameLevel.EASY);

        BDDMockito
                .then(gameNumGen)       // 메서드 호출부를 검증할 모의 객체
                .should().generate(GameLevel.EASY);     // 실제로 불려야 할 메서드 지정
    }





}
