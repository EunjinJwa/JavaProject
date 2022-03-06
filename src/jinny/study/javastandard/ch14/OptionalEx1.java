package jinny.study.javastandard.ch14;

import java.util.Optional;
import java.util.function.Function;

public class OptionalEx1 {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("kassy");
        Optional<Integer> optInt = optStr.map(String::length);
        System.out.println("optStr = " + optStr.get());
        System.out.println("optInt = " + optInt.get());

        int result1 = Optional.of("123")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).get();  // filter 결과가 null이면 NoSuchElementException 발생

        int result2 = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).orElse(-1);


        Function<String, Integer> f = (s) -> {
            return Optional.of(s)
                    .filter(x -> x.length() > 0)
                    .map(Integer::parseInt).orElse(-1);
        };

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + f.apply("50"));

        System.out.println(Integer.min(3, 5));

    }







}
