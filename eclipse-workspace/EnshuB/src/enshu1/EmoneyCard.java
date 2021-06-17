//B9TB2174
//西川凜

package enshu1;

public class EmoneyCard {
	private int balance = 0;
	private String name = "";
	public EmoneyCard(String n) {
		name = n;
	}
	public void charge(int b) {
		balance += b;
	}
	public boolean pay(int b) {
		if(b>balance) {
			return false;
		}
		else {
			balance -= b;
			return true;
		}
	}
	public void print() {
		System.out.println(name+":"+balance);
	}
	public boolean transferFrom(EmoneyCard ec, int b) {
		if(ec.pay(b)) {
			balance += b;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		EmoneyCard ec1 = new EmoneyCard("Card1");
		EmoneyCard ec2 = new EmoneyCard("Card2");
		ec1.charge(100);
		ec2.charge(100);
		ec1.print();
		ec2.print();
		if (ec1.transferFrom(ec2, 300)) {
		System.out.println("transfer OK");
		} else {
		System.out.println("transfer NG");
		}
		ec2.charge(1000);
		ec1.print();
		ec2.print();
		if (ec1.transferFrom(ec2, 300)) {
		System.out.println("transfer OK");
		} else {
		System.out.println("transfer NG");
		}
		ec1.print();
		ec2.print();
		}
	}

