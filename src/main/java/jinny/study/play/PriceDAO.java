package jinny.study.play;


public class PriceDAO {

	public MealExpense getMeals(long id) {
		if (id <= 10) {
			return new TypeAMealExpense(getBasicMeal());
		}
		return new DefaultMealExpense();
	}

	private Meal getBasicMeal() {
		return Meal.builder()
				.price(400)
				.count(1)
				.discount(5)
				.build();
	}

}
