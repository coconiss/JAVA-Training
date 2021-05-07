package week15;

//Socket 클래스
import java.net.*;
import java.util.ArrayList;
//입출력 클래스
import java.io.*;

//그래픽 관련 클래스
import java.awt.*; // GUI
import javax.swing.*; // JFrame, JTextField, JTextArea, JScrollPane

//Event 처리
import java.awt.event.*; // ActionListener

public class ChatGUIClient extends JFrame implements ActionListener, Runnable {

 JTextField tf; 
 JTextArea ta; 
 JTextArea list;
 JScrollPane js, ls;
 Socket s;
 BufferedReader br;
 PrintWriter pw;
 String str, str1;
 public ChatGUIClient() {
     tf = new JTextField();
     ta = new JTextArea();
     js = new JScrollPane(ta);
     add(js, "Center");
     add(tf, BorderLayout.SOUTH);
     tf.addActionListener(this);
     setBounds(200, 200, 500, 350);
     setVisible(true);
     tf.requestFocus();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     try {
         s = new Socket("127.0.0.1", 7777);
         br = new BufferedReader(new InputStreamReader(s.getInputStream()));
         pw = new PrintWriter(s.getOutputStream(), true);

     } catch (Exception e) {
         System.out.println("접속 오류>>>" + e);
     }

     Thread ct = new Thread(this);

     ct.start();
 }

 public void run() {
     try {
         while ((str1 = br.readLine()) != null) {
             ta.append(str1 + "\n");
         }
     } catch (Exception e) {
         e.printStackTrace();
         ;
     }
 }


 public void actionPerformed(ActionEvent e) {
    
     str = tf.getText();
     tf.setText("");
     pw.println(str);
     pw.flush();
 }

 public static void main(String[] args) {

     new ChatGUIClient();

 }

}