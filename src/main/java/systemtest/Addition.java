package systemtest;

public class Addition {

	private int addend1 = 0;
	private int addend2 = 0;
	private int sum = 0;

	public static void main(String args[]) {
		// Filler.
	}
	
	public void add() {
		sum = addend1 + addend2;
	}
	
	public int getAddend1() {
		return addend1;
	}
	public void setAddend1(String addend1) {
		this.addend1 = Integer.parseInt(addend1);
	}
	public int getAddend2() {
		return addend2;
	}
	
	public void setAddend2(String addend2) {
		this.addend2 = Integer.parseInt(addend2);
	}
	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}
