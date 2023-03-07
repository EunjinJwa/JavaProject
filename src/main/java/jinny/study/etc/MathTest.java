package jinny.study.etc;


import java.math.BigDecimal;

public class MathTest {




    public static void main(String[] args) {

        // 소숫점 n번째 반올림
//        mathFunction();

//        testRake();
        calcMath();
    }



    /**
     * Math 객체를 사용한 소숫점 처리
     */
    public static void mathFunction() {

        double doubleValue01 = 0.5478234;

        // 소수점 2째자리
        double result1 = Math.ceil((double)doubleValue01 * 10000)/100.0;
        double result2 = Math.round(doubleValue01*100)/100.0;

        System.out.println(result1);
        System.out.println(result2);

    }

    public static void testRake() {
        long buyIn = 34523L;
        long rake = (long) (buyIn*0.07);
        System.out.println(rake);



        BigDecimal a = BigDecimal.valueOf(((double)rake)/1000);
        System.out.println(a);
    }

    public static void calcMath() {
        long val1 = 100;
        float value = 1.5f;
        long result = (long)Math.ceil(val1 * value);
        System.out.println(val1 * value);
        System.out.println(result);
        System.out.println(Math.round(value));
        System.out.println(Math.floor(value));

        System.out.println((long)Math.ceil(val1 * value));

    }
}
