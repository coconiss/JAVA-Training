package week12;

public class Orange {
	
	public static int orangeCount = 50;
	
	public static synchronized void takeOut(String name, int num) {		//synchronized : ����ȭ
		
		if(num <= orangeCount) {
			orangeCount -=num;
			System.out.println(name + " : " +num+ "���� �������� ��������.");
		}
		else {
			System.out.println("�������� �����մϴ�.");
		}
		System.out.println("���� ���� �������� ���� : " + orangeCount);
	}

}
