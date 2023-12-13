package jinny.study.play;

import lombok.Builder;

public class Meal {

	public long id;

	public int price;
	public int count;
	public double discount;

	@Builder
	public Meal(long id, int price, int count, double discount) {
		this.id = id;
		this.price = price;
		this.count = count;
		this.discount = discount;
	}
}
