package week12;

import java.io.File;

public class FileDirListTest {

	public static void main(String[] args) {
		File fCur = new File(".");
		String[] fList = fCur.list();
		for (int i = 0; i < fList.length; i++) {
			System.out.println(fList[i]);
		}
	}

}
