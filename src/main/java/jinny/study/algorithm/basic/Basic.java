package jinny.study.algorithm.basic;

public class Basic {

	public static void main(String[] args) {
		System.out.println(max4(4,9,3,7));
		System.out.println(min3(45,6,34));
	}

	/** 최대값 구하기 */
	public static int max4(int a, int b, int c, int d) {
		int max = getMax(a, b);
		max = getMax(max, c);
		max = getMax(max, d);
		return max;
	}

	/**
	 * 최솟값 구하기
	 */
	public static int min3(int a, int b, int c) {
		int min = a;
		if (b < min) {
			min = b;
		}
		if (c < min) {
			min = c;
		}
		return min;
	}

	private static int getMax(int a, int b) {
		return Math.max(a, b);
	}

}
