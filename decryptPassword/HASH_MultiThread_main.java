package decryptPassword;

import java.io.File;
import java.util.Scanner;

public class HASH_MultiThread_main {

	
	public static void main(String[] args) {
		
		Scanner scanedpw = new Scanner(System.in);
		String[] password=new String[4]; // pass파일에서 읽어온 문자열을 나누어 저장하기 위한 문자열 배열 선언
		HASH_MultiThread_thread[] HashThread=new  HASH_MultiThread_thread[4];  // 각 스레드마다 각각 암호와 순서를 전달하기 위해 스레드 객체를 배열화
			
		try {
			File pw = new File("C:/Users/Heon/Desktop/password/pass2.txt"); // pass2 파일 오픈
	    	scanedpw = new Scanner(pw); // 오픈된 파일을 scanner 객체에 담음
		    scanedpw.useDelimiter(""); // scanner 객체에서 문자열을 끊어서 읽어오기 위해 토큰 설정
		    
		    for(int i=0;i<4;i++){
		    	password[i]=""; // 읽어온 암호 저장용 배열 초기화
				for(int j=0;j<32;j++)
					password[i]+=scanedpw.next(); // scanner객체에 저장된 암호를 8바이트 단위로 끊어 배열에 순차적으로 저장함
				HashThread[i] = new HASH_MultiThread_thread(password[i], i); // 암호가 저장된 배열과 각 스레드 순서를 인자로 스레드를 객체를 생성함
				HashThread[i].start(); //스레드 실행
			} 	    		    

		    try{
		    	HashThread[0].join();
		    	HashThread[1].join();
		    	HashThread[2].join();
		    	HashThread[3].join();}
		    catch(InterruptedException e){e.printStackTrace();}
		    
		}		
		catch (Exception e){System.out.println("Exception: " + e);}		
	}	
}
