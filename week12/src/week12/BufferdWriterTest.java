package week12;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BufferdWriterTest {

	public static void main(String[] args) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write("버퍼를 사용한 글자");
			bw.flush(); 	//비우기
			bw.close(); 	//닫기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
