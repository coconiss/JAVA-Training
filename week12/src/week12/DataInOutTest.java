package week12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInOutTest {

	public static void main(String[] args) {

		char c = 'Y';
		byte b = 20;
		boolean bool = true;
		
		try {
			DataOutputStream dOut = new DataOutputStream(new FileOutputStream("data.txt"));
			dOut.writeChar(c);
			dOut.writeByte(b);
			dOut.writeBoolean(bool);
			dOut.flush();
			dOut.close();
			
			DataInputStream dIn = new DataInputStream(new FileInputStream("data.txt"));
			char c2 = dIn.readChar();
			System.out.println("char형 : "+c2);
			byte b2 = dIn.readByte();
			System.out.println("byte형 : "+b2);
			boolean bool2 = dIn.readBoolean();
			System.out.println("boolean형 : "+bool2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
