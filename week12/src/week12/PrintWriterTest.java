package week12;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PrintWriterTest {

	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		pw.write("자바프로그래밍 응용");
		pw.flush();
		pw.close();
				
	}

}
