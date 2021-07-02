//B9TB2174
//西川凜

package enshu3;

import java.util.Vector;

public class Cart {
	private Vector<Item> items;
	private int[] count = new int[10];
	private String[] name = new String[10];
	private int[] price = new int[10];
	private int budget;
	private int sum = 0;
	private int c = 0;
	private int i = 0;
	private int k;
	private boolean match;

	public Cart(int budget) {
		this.budget = budget;
		items = new Vector<Item>();
	}

	public void add(String name, int price) {
		if (sum + price <= budget) {
			Item i = new Item(name, price);
			items.add(i);
			sum += price;
			System.out.println("[ADD] " + name + ": " + price + "JPY OK");
		} else {
			System.out.println("[ADD] " + name + " " + price + "JPY Failed");
		}

	}

	public void remove(String name, int price) {
		Item i = new Item(name, price);
		items.remove(i);
		sum -= price;
		System.out.println("[REMOVE] " + name + ": " + price + "JPY OK");
	}

	public void print() {
		for (k = 0; k < 10; k++) {
			name[k] = "";
			count[k] = 0;
		}
		c = 0;
		k = 0;
		match = false;
		for (Item n : items) {

			for (Item m : items) {
				if (n.equals(m)) {
					count[c] += 1;
				}
			}
			for (i = 0; i < 10; i++) {
				if (n.name == name[i]) {
					match = true;

				}

			}
			if (!match) {
				name[k] = n.name;
				price[k] = n.price;
				System.out.println(name[k] + "(" + price[k] + "JPY)" + " x" + count[k]);
				k += 1;
			}
			c += 1;
		}

		System.out.println("Sum=" + sum + "JPY");
	}

	public static void main(String[] argv) {
		// 予算 300 円でプランを作成
		Cart sc = new Cart(300);
		// おやつを追加
		sc.add("Chocolate", 120);
		sc.add("Chips", 100);
		sc.add("PopCorn", 110); // ←予算オーバー
		// Chips を Candy に変更
		sc.remove("Chips", 100);
		sc.add("Candy", 20);
		// 再び PopCorn を追加
		sc.add("PopCorn", 110);
		// 買い物プランを表示
		System.out.println("---- Items ----");
		sc.print();
		// チョコレートを削除
		sc.remove("Chocolate", 120);
		// Candy を 3 個追加
		sc.add("Candy", 20);
		sc.add("Candy", 20);
		sc.add("Candy", 20);
		// PopCorn を追加
		sc.add("PopCorn", 110);
		// 買い物プランを表示
		System.out.println("---- Items ----");
		sc.print();
	}
}
