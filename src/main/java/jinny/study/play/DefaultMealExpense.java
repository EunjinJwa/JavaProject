package jinny.study.play;

import lombok.Builder;

public class DefaultMealExpense implements MealExpense {

	private final int price = 500;
	private final int count = 1;

	@Override
	public long getTotal() {
		return price * count;
	}
}
