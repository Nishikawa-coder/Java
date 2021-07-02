//B9TB2174
//西川凜
package enshu2;

public class FuncCalc extends Calc {
	private int Unit;// Unitが2の時Radianで1の時Degreeである
	private double logbase = Math.exp(1);

	public FuncCalc() {
		super();
	}

	public void pow(double d) {
		val = Math.pow(val, d);
	}

	public void setLogBase(double d) {
		if (d <= 0 || d == 1) {
			System.out.println("Error");
		} else {
			logbase = d;
		}

	}

	public void div(double d) {
		if (d == 0) {
			System.out.println("Error");
		} else {
			super.div(d);
		}

	}

	public void log() {
		if (val <= 0) {
			System.out.println("Error");
		} else {
			val = Math.log(val);
			div(Math.log(logbase));
		}

	}

	public void setRadianMode() {
		Unit = 2;
	}

	public void setDegreeMode() {
		Unit = 1;
	}

	public void sin() {
		if (Unit == 1) {
			mul(Math.PI);
			div(180);
		}
		val = Math.sin(val);
	}

	public void cos() {
		if (Unit == 1) {
			mul(Math.PI);
			div(180);
		}
		val = Math.cos(val);
	}

	public static void main(String[] args) {
		FuncCalc fc = new FuncCalc();
		// sin(40 度)
		fc.setDegreeMode();
		fc.set(40);
		fc.sin();
		fc.print();
		// cos(PI)
		fc.setRadianMode();
		fc.set(Math.PI);
		fc.cos();
		fc.print();
		// 2^10
		fc.set(2);
		fc.pow(10);
		fc.print();
		// log2(2^10)
		fc.setLogBase(2);
		fc.log();
		fc.print();
		// log10(log2(2^10))
		fc.setLogBase(10);
		fc.log();
		fc.print();
		// Error check
		fc.div(0);
		fc.set(0);
		fc.log();
		fc.setLogBase(-1);
		fc.setLogBase(1);
	}
}
