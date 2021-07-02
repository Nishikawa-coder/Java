//B9TB2174
//西川凜
package enshu2;

public class Calc {
	protected double val;
	 public Calc() {
	 val = 0;
	 }
	 public void set(double d) {
	 val = d;
	 }
	 public void add(double d) {
	 val += d;
	 }
	 public void sub(double d) {
	 val -= d;
	 }
	 public void mul(double d) {
	 val *= d;
	 }
	 public void div(double d) {
	 val /= d;
	 }
	 public void print() {
	 System.out.println("Value=" + val);
	 }
}
