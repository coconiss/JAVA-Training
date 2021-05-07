package week12;

public class RunOrange {

	public static void main(String[] args) {
		
		wThread t1 = new wThread("박하나");
		wThread t2 = new wThread("박두리");
		wThread t3 = new wThread("박서이");

		t1.start();
		t2.start();
		t3.start();
	}

}
