package enshu3;

public class Item {

	protected String name;
	protected int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	// Object クラスの equals(Object o) メソッドをオーバーライド
	public boolean equals(Object o) {
		Item i = (Item) o;
		return this.name.equals(i.name) && this.price == i.price;
	}

	// Object クラスの equals(Object o) メソッドをオーバーライド
	public String toString() {
		return name + ": " + price + "JPY";
	}

	public void print() {
		System.out.println(toString());
	}

	
}