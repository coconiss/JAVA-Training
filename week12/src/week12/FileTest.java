package week12;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("temp/test.txt");	//상대경로
		System.out.println(file.exists());		//존재여부 확인
		if(file.exists()) {	//파일이 존재한다면..
			System.out.println("파일 이름 : " + file.getName());
			System.out.println("상대 경로 : " + file.getPath());
			System.out.println("절대 경로 : " + file.getAbsolutePath());
			System.out.println("쓰기 가능 : " + file.canWrite());
			System.out.println("읽기 가능 : " + file.canRead());
			System.out.println("파일 여부 : " + file.isFile());
			System.out.println("폴더 여부 : " + file.isDirectory());
			System.out.println("파일 크기 : " + file.length() + " byte");		//byte단위
		}else {
			System.out.println("파일이 존재하지 않음");
		}
	}

}
