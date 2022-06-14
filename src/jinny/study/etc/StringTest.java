package jinny.study.etc;

public class StringTest {

    public static void main (String[] args) {
        replaceRegex();
    }

    /**
     * 정규 표현식 문자열 치환
     */
    public static void replaceRegex() {
        String str = "TEST_\\123/and:{colo<>ne}!".concat("\\");
        System.out.println(str);
        String regex = "[$¥*{:<}>|/?\\W\"!]";  // 역슬러시 변환은 \\W 뒤에 작성해야함.
        System.out.println(str.replaceAll(regex, " "));
        System.out.println(str.replaceAll(regex, " ")
                .replace("\\", ""));

    }
}
