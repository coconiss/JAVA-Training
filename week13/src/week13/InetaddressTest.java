package week13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InetaddressTest extends JFrame implements ActionListener {
	JTextField tf;
	JTextArea ta;
		
	public InetaddressTest() {
		setTitle("Inetaddress 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tf = new JTextField(25);
		ta = new JTextArea();
		
		JLabel lbl1 = new JLabel("호스트 이름 : ");	//North
		JLabel lbl2 = new JLabel("검사할 호스트 이름을 입력해 주세요.");	//South
		
		JButton btn = new JButton("검사 실행");
		
		JPanel p1 = new JPanel();
		p1.add(lbl1); p1.add(tf); p1.add(btn);
		
		add(p1, "North");
		add(ta, "Center");
		add(lbl2, "South");
		
		btn.addActionListener(this);
		
		setBounds(1000, 200, 500, 400);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		InetAddress ip = null;
		InetAddress[] ipArr = null;	//ip주소가 들어갈 배열
		String host = "";
		
		ta.setText("");		//textarea의 글자를 없앤다(초기화)
		host = tf.getText();	//textfield내용을 url로 넣어줌(url 값)
		try {
			ip = InetAddress.getByName(host);
			ta.append("getHostName() : " + ip.getHostName() + "\n");
			ta.append("getHostAddress() : " + ip.getHostAddress() + "\n");
			ta.append("toString() : " + ip.toString() + "\n");
			
			byte[] ipAddr = ip.getAddress();
			ta.append("getAddress() : " + Arrays.toString(ipAddr) + "\n");
			
			String result = "";
			for (int i = 0; i < ipAddr.length; i++) {
				result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
				result += ".";
			}
			
			ta.append("getAddress()(음수일 때 256을 더한 값) : " + result + "\n\n");
			
			ip = InetAddress.getLocalHost();
			ta.append("getHostName() : " + ip + "\n");
			ta.append("getHostAddress() : " + ip.getHostAddress() + "\n");
		} catch (UnknownHostException e1) {
			System.out.println("알지 못하는 호스트입니다.");
		}
		
	}

	public static void main(String[] args) {
		new InetaddressTest();
	}

}
