package week15;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.*;

import java.util.Vector;

import javax.xml.ws.Response;


public class ChatGUIServer {
	ArrayList<Thread> aList;
    ServerSocket ss;
    Socket s;
    Vector v;
    ServerThread st;
    public ChatGUIServer() {
        v = new Vector();
        aList = new ArrayList<Thread>();
        try {
            ss = new ServerSocket(7777);
            System.out.println("ss>>>" + ss);
            System.out.println("채팅 서버 가동중...");
            
            while (true) {
                s = ss.accept();
                System.out.println("Accepted from" + s);
                st = new ServerThread(this, s);
                this.addThread(st);
                st.start();
            }

        } catch (Exception e) {
            System.out.println("서버 접속 실패>>>" + e);
        }
    }
    public void addThread(ServerThread st) {
    	aList.add(st);
		System.out.println("클라이언트 1명 입장, 총 " + aList.size() + "명 입니다.");
        v.add(st);
    }
    public void removeThread(ServerThread st) {
    	aList.remove(st);
		System.out.println("클라이언트 1명 퇴장, 총" + aList.size() + "명 입니다.");
        v.remove(st);
    }
    public void broadCast(String str) {
        for (int i = 0; i < v.size(); i++) {
            ServerThread st = (ServerThread) v.elementAt(i);
            st.send(str);
        }
    }

    public static void main(String[] args) {
        new ChatGUIServer();

    }

}

class ServerThread extends Thread {
	int count;
    Socket s;
    ChatGUIServer cg;
    BufferedReader br;
    PrintWriter pw;
    String str;
    String name;

    public ServerThread(ChatGUIServer cg, Socket s) {
        this.cg = cg;
        this.s = s;

        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw = new PrintWriter(s.getOutputStream(), true);
        } catch (Exception e) {
            System.out.println("에러 발생>>>>>" + e);
        }
    }

    public void send(String str) {
        pw.println(str);
        pw.flush();
    }

    // run()_ServerThread -> broadCast(str)_ChatGUIServer -> send(str)_ServerThread
    public void run(){

    	Calendar calendar = Calendar.getInstance();
    	Date date = calendar.getTime();
    	String today = (new SimpleDateFormat("a:hh:mm").format(date));
        try {
        	count++;
            pw.println("대화명을 입력하세요");
            name = br.readLine();
            cg.broadCast("[" + name + "]" + "님이 입장했습니다.");

            while ((str = br.readLine()) != null) {
                cg.broadCast("[" + name + "]: " + str + "          [" + today + "]");
            }
        } catch (Exception e) {
            cg.removeThread(this);
            count--;
            cg.broadCast("[" + name + "]" + "님이 퇴장했습니다.");
            System.out.println(s.getInetAddress() + "의 연결이 종료됨!");
        }
    }
	

}