package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	ServerSocket ss;		//서버의 소켓
	Socket s;				//클라이언트 소켓
	ArrayList<Thread> aList;
	
	public ChatServer() {
		aList = new ArrayList<Thread>();
		System.out.println("채팅 서버가 켜졌습니다.");
	}
	
	public void giveAndTake() {
		try {
			ss = new ServerSocket(7777);
			ss.setReuseAddress(true);
			while(true) {
				s =ss.accept();	//대기(클라이언트가 연결요청 수락)
				ServerSocketThread sst = new ServerSocketThread(this, s);
				addClient(sst);
				sst.start();
			}
		} catch (IOException e) {
			
		}
		
	}
	
	public synchronized void addClient(Thread t) {
		aList.add(t);
		System.out.println("클라이언트 1명 입장, 총 " + aList.size() + "명 입니다.");
	}
	
	public synchronized void removeClient(Thread t) {
		aList.remove(t);
		System.out.println("클라이언트 1명 퇴장, 총" + aList.size() + "명 입니다.");
	}
	
	public synchronized void broadCasting(String str) {	//모든 클라이언트한테 메세지 전송
		for (int i = 0; i < aList.size(); i++) {
			ServerSocketThread sst = (ServerSocketThread)aList.get(i);
			sst.sendMessage(str);
		}
	}
}


