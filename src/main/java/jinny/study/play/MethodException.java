package jinny.study.play;

import com.sun.istack.internal.NotNull;

public class MethodException {

	public static void main(String[] args) {
		Integer plusResult = calcPlus2(3, null);
		System.out.println(plusResult);
	}

	public static Integer calcPlus1(Integer a, Integer b) {
		assert b != null : "b cannot be null";
		return a + b;
	}

	public static Integer calcPlus2(Integer a, @NotNull Integer b) {
		return a + b;
	}




}
