package jinny.study.play;

public class TypeAMealExpense implements MealExpense {

	private final Meal meal;

	public TypeAMealExpense(Meal meal) {
		this.meal = meal;
	}

	@Override
	public long getTotal() {
		return Math.floorDiv((int) (meal.price * meal.count * meal.discount), 100L);
	}
}
