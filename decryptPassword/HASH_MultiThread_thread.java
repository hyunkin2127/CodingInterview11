package decryptPassword;

import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class HASH_MultiThread_thread extends Thread{
	
	String password="";  //전달 받을 암호를 저장할 변수
	int threadNum; // 스레드 번호를 나타내기 위한 변수
		
	public HASH_MultiThread_thread (String password, int i){
		
		this.password=password; // 읽어들인 암호로 변수 초기화
		threadNum=i;  // 입력된 스레드 번호로 초기화
	}
	
	public void run(){
						
		int a=0; // 랜덤하게 생성된 문자열을  읽어들인 암호를 비교하기 위해 사용되는 변수
		String randstr=""; // 랜덤하게 생성된 문자열을 저장할 변수
		String digestedstr=""; // 생성한 문자열을 digest하여 생성된 결과를 저장할 변수
		String decryptedresult=""; //해독 완료된 암호를 담을 변수
		FileWriter decryptedPwFile = null; //해독 완료된 암호를 저장하기 위한 FileWriter 객체 
		Random rand= new Random();		
					
		System.out.println(threadNum+"번  Thread 작업시작");
		long start=System.currentTimeMillis();  // 시간 측정 시작
		
		while(true){ //해독 전체 과정반복을 위한 while문
			
			randstr="";  //한번 반복을 마칠때마다 randstr을 빈 문자열로 초기화 
			
			for(int j=0;j<4;j++){  //임의의 4바이트 문자열 생성하여 randstr에 저장
				int w=(rand.nextInt(106)+33);
				randstr+=(char)w;
			}				
			digestedstr = testMD5(randstr); // 생성된 문자열을 digest함
			
			while(true){ // digest한 문자열과 전달받은 암호(문자열)을 비교하기 위한 while문				
				
				if(digestedstr.charAt(a)==password.charAt(a))  // digest한 문자열과 암호를 각각 한글자씩 비교함 같을경우 a를 증가시켜 다음글자를 비교 할준비를 함
					a++;
				else{ // 만약 같지 않으면 a를 0으로 초기화시켜 비교위치를 문자열의 맨앞으로 이동시키고 비교 while문 종료					
					a=0;				
					break;
				}
				
				if(a==password.length()){  // 만약 비교결과 두 문자열이 같을경우(암호를 찾은 경우)
					decryptedresult+=randstr;  // 해당 digestedstr을 만들어낸 randstr를 결과에 append 시키고 종료
					break;
				}
			}
			if(a==password.length())  // 만약 비교결과 두 문자열이 같을경우(암호를 찾은 경우) 전체과정 while문을 빠져 나가기 위한 if문
				break;
		}	
		
		try { //결과를 파일에 저장
			decryptedPwFile = new FileWriter("C:/Users/Heon/Desktop/password/HASH_MultiThread_thread_result.txt", true);
			decryptedPwFile.append(decryptedresult);
		}
		catch(IOException e){e.printStackTrace();}
		finally{
			try{decryptedPwFile.close();} 
			catch(Exception e){}
			}
				    
		long stop=System.currentTimeMillis();
						
		System.out.println(threadNum+"번 Thread 소요시간 : " + (stop-start)/1000+"s");
		System.out.println(threadNum+"번 Thread 해독결과 : "+decryptedresult);
		System.out.println(threadNum+"번 Thread 작업종료");
	}	
	
	public String testMD5(String str){  // Message Digest 함수
		String MD5 = ""; 
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(str.getBytes()); 
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			MD5 = sb.toString();
			
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			MD5 = null; 
		}
		return MD5;
	}	
}