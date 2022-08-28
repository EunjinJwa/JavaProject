package jinny.study.nextstep;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int sum(String a) {
        if (!zeroStringValidation(a)) {
            return 0;
        }
        return sumIntArr(convertStringToIntArr(a));
    }
    public int[] convertStringToIntArr(String text) {
        String[] stringArr = textSplit(text);
        int[] result = new int[stringArr.length];
        int i = 0;
        for (String stringNum : stringArr) {
            result[i] = parseStringToPositiveInt(stringNum);
            i++;
        }
        return result;
    }

    public String[] textSplit(String text) {
        final String regex = "[,:]";
        final Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        } else {
            return text.split(regex);
        }
    }

    public int parseStringToPositiveInt(String stringNum) {
        int num = Integer.parseInt(stringNum);
        if (num < 0) {
            throw new RuntimeException("number must be greater than 0 : " + num);
        }
        return num;
    }



    public int sumIntArr(int[] ints) {
        return Arrays.stream(ints).sum();
    }

    public boolean zeroStringValidation(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        return true;
    }


}
