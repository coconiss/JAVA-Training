package week13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class URLTest extends JFrame implements ActionListener {
	JTextField tf;
	JTextArea ta;
		
	public URLTest() {
		setTitle("Inetaddress 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tf = new JTextField(25);
		ta = new JTextArea();
		ta.setLineWrap(true);
		JScrollPane scrollpane = new JScrollPane(ta);
		
		JLabel lbl1 = new JLabel("호스트 이름 : ");	//North
		JLabel lbl2 = new JLabel("검사할 호스트 이름을 입력해 주세요.");	//South
		
		JButton btn = new JButton("검사 실행");
		
		JPanel p1 = new JPanel();
		p1.add(lbl1); p1.add(tf); p1.add(btn);
		
		add(p1, "North");
		add(scrollpane, "Center");
		add(lbl2, "South");
		
		btn.addActionListener(this);
		
		setBounds(1000, 200, 500, 400);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String host = "";
		ta.setText("");
		host = tf.getText();
		try {
			URL url = new URL(host);
			URLConnection con = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = "";
			while((line = br.readLine()) != null) {
				ta.append(line + "\n");
			}
			
			br.close();
		} catch (MalformedURLException e1) {
			System.out.println("형식에 맞지 않는 url입니다.");
		} catch (IOException e1) {
			System.out.println("연결객체가 생성되지 않았습니다.");
		}
		
	}

	public static void main(String[] args) {
		new URLTest();
	}

}
