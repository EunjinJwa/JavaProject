package jinny.study.etc;

public class StringTest {

    public static void main (String[] args) {
        replaceRegex();
    }

    /**
     * 정규 표현식 문자열 치환
     */
    public static void replaceRegex() {
        String str = "TEST_123/and:colone!";
        String regex = "[:!/]";
        System.out.println(str.replaceAll(regex, " "));
    }
}
