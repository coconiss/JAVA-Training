package week12;

import java.util.Random;

public class wThread extends Thread {

	public wThread(String name) {
		super(name);
	}
	
	public void run() {
		Random r = new Random();		//가져오는 갯수를 랜덤하게 가져온다.
		for (int i = 0; i < 10; i++) {
			try {
				sleep(500);		//0.5초 쉬었다 감
			} catch (InterruptedException e) {
				return;			//에러발생시 탈출함
			}		
			
			if(Orange.orangeCount == 0) {
				System.out.println("남아있는 오렌지가 없습니다.");
				return;	//남아있는 오렌지가 0인경우 실행안하고 탈출
			}
			Orange.takeOut(getName(), Math.abs(r.nextInt()%7));	//math.abs로 정수만 나오게한다.
		}
	}
}
