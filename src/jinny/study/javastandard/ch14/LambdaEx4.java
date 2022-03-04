package jinny.study.javastandard.ch14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 컬렉션 프레임웤에 추가된 함수영 인터페이스 메서드 !!!
 * 인자값으로 함수형 인터페이스를 받아서 처리한다.
 */
public class LambdaEx4 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // list의 모든 요소 출력
        list.forEach(i -> System.out.println(i + ""));  // 인자값으로 Consumer<T> 인터페이스를 받음

        // list에서 2의 배수를 제거함
        list.removeIf(i -> i%2 == 0); // 인자값으로 Predecate<T>를 받음
        System.out.println(list);

        // list의 모든 요소를 10배 한 값으로 변환
        list.replaceAll(i -> i*10); // 인자값으로 UnaryOperator<E>
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        map.forEach((k, v) -> System.out.println("key = " + k + " , value = " + v));

    }


}


