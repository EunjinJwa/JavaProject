package jinny.study.play;

public class MealMain {


	static PriceDAO priceDAO = new PriceDAO();

	public static void main(String[] args) {
		MealExpense meals = priceDAO.getMeals(1);
		long total = meals.getTotal();

		System.out.println("total : " + total);
	}
}
