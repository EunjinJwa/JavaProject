package jinny.study.javastandard.ch14;

import jinny.study.javastandard.functionalinterface.MyFunction;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lamda01 {

    public static void main(String[] args) {

        // Functional Interface를 람다식으로 호출하기
        // 가장 중요한 전제. 함수형 인터페이스는 단 하나의 추상 메서드만 정의되어있어야 한다.

        exam01();

    }

    public static void exam01() {
        // 메서드를 사용하는 방법
        MyFunction f1 = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };
        f1.max(3,5);

        // 람다식 사용
        MyFunction f2 = (a, b) -> a > b ? a : b;
        f2.max(3,5);        // 윗줄에 정의된 람다식에는 max()라는 메서드 이름이 표현되어있지 않지만, 한 개만 존재하는 추상 메서드인 max()를 정의한 것으로, max()를 호출한다.
    }

    public static void exam02() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "aaa");

        // 메서드 사용해서 List sort 구현하기
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // 람다 사용하여 List sort 구현하기
        Comparator<String> sortFunction = (o1, o2) -> o1.compareTo(o2);
        Collections.sort(list, sortFunction);

        // 한 줄로 더 줄이면?
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
    }





}
