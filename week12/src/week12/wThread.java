package week12;

import java.util.Random;

public class wThread extends Thread {

	public wThread(String name) {
		super(name);
	}
	
	public void run() {
		Random r = new Random();		//�������� ������ �����ϰ� �����´�.
		for (int i = 0; i < 10; i++) {
			try {
				sleep(500);		//0.5�� ������ ��
			} catch (InterruptedException e) {
				return;			//�����߻��� Ż����
			}		
			
			if(Orange.orangeCount == 0) {
				System.out.println("�����ִ� �������� �����ϴ�.");
				return;	//�����ִ� �������� 0�ΰ�� ������ϰ� Ż��
			}
			Orange.takeOut(getName(), Math.abs(r.nextInt()%7));	//math.abs�� ������ �������Ѵ�.
		}
	}
}
