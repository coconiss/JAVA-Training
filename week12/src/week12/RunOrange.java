package week12;

public class RunOrange {

	public static void main(String[] args) {
		
		wThread t1 = new wThread("���ϳ�");
		wThread t2 = new wThread("�ڵθ�");
		wThread t3 = new wThread("�ڼ���");

		t1.start();
		t2.start();
		t3.start();
	}

}
