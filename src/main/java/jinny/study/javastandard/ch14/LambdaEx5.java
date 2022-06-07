package jinny.study.javastandard.ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx5 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        /**
         * Supplier
         * 매개변수가 없고 반환값만 있는 함수
         */
        Supplier<Integer> s = () -> (int)(Math.random()*100);


        /**
         * Consumer
         * 매개변수가 있고, 반환값이 없는 함수
         */
        Consumer<Integer> c = i -> System.out.println("i = " + i);


        /**
         * Predicate
         * 매개변수가 있고, 반환값으로 Boolean을 리턴하는 함수
         */
        Predicate<Integer> p = i -> i%2 == 0;

        /**
         * Function
         * 매개변수가 있고, 반환값을 리턴하는 함수. 반환되는 타입은 매개변수와 다를 수 있다.
         */
        Function<Integer, Double> f = i -> (double)i/100;

        // 함수형 인터페이스 사용 테스트

        makeRandomList(s, list);
        System.out.println(list);

        printEvenNum(p, c, list);

        List newList = doSomthing(f, list);
        System.out.println("doSomthing = " + newList);



    }

    private static void makeRandomList(Supplier<Integer> s, List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        for (T i : list) {
            if (p.test(i))
                c.accept(i);
        }
    }

    public static <T, R> List<R> doSomthing(Function<T, R> f, List<T> list) {
        List<R> newList = new ArrayList<>(list.size());
        for (T i : list) {
            newList.add(f.apply(i));
        }
        return newList;
    }
}
