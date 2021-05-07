package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSocketThread extends Thread {
	 ChatServer cs;
	 Socket s;
	 String threadName = "thread";
	 String name;
	 PrintWriter pw;
	 BufferedReader br;
	 
	 public ServerSocketThread(ChatServer cs, Socket s) {
		this.cs = cs;
		this.s = s;
		threadName = getName();
		System.out.println(s.getInetAddress() +"주소로 접속하였습니다.");
		System.out.println("Thread Name : "+threadName);
		
	}
	
	 
	public void sendMessage(String str) {
		pw.println(str);
	}
	
	
	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(), true);
			sendMessage("대화명을 입력하세요.");
			name = br.readLine();
			cs.broadCasting("["+name + "]" +"님 입장");
			while(true) {
				String in = br.readLine();
				cs.broadCasting("[" + name + "]" + in);
				cs.removeClient(this        );
			}
		} catch (IOException e) {
			System.out.println(threadName + "님이 퇴장");
			
		}finally {
			try {
				s.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
	
}
