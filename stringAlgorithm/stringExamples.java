package stringAlgorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Heon on 2015-10-01.
 *
 *
 * 1. 주어진 문자열을 단어별로 파싱
 * 2. 순서대로 배열에 넣던지 아무튼 순서를 부여해서
 * 3. 역순으로 출력
 */
public class stringExamples {

	String str;

	//1. answk
	public stringExamples(String s){
		str = s;
	}
	/*****************************************************************
	 * Codinginterview p.512 Q9
	 * 주어진 문자열의 단어 순서를 반전 시키는 알고리즘

	 * 문자열에 포함된 단어의 갯수를 미리 알수 없기 때문에
	 * 배열의 길이를 미리 결정할 수 없고 이로 인해 초기화가 불가능 하기때문에 배열을 이용하기에는 문제가 있음
	 * 그럼 문자열을 임시로 저장해둘 장소로 어디를 사용할것인가.
	 * --> 역순접근이 가능한 가변배열 :  ArrayList???, Queue?????
	 * Stack !!!!! --> 먼저 입력한 단어가 가장 마지막에 나오면 되니까 아니면 양방향 큐도 괜찮고
	 * 스택처럼 LIFO 기능을 갖고 있는 자료구조면 뭐든 상관없을듯
	 ****************************************************************/
	public void parseString(){
		Scanner sc = new Scanner(str);
		Stack<String> st = new Stack<String>();
		while(sc.hasNext()) st.push(sc.next());
		while(!st.isEmpty()) System.out.print(st.pop().toString() + "  ");
	}
}
