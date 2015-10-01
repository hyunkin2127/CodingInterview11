package stringAlgorithm;
//CodingInterView p.496 Trie Algorithm
//15-09-30

import java.util.*;
public class Trie {

	HashMap<Character, HashMap> root; // char Wrapper클래스 Character, hashmap

	/**
	 *  Default contructor
	 */
	public Trie() {
		root = new HashMap<Character, HashMap>();
	}

	/**
	 *  Contructor that takes a String[] of words to add
	 *  @param sa a String[] of words to be added
	 */
	public Trie(String[] sa) {
		this(); // 기본생성자 실행
		addAll(sa);
	}

	/**
	 *  Constructor that takes a Collection<String> of words to add
	 *  @param sc a Collection<String> of words to be added
	 */
	public Trie(Collection<String> sc) {
		this();  // 기본생성자 실행
		addAll(sc);
	}

	/**
	 *  Adds a string to the trie
	 *  @param s String to add to the trie
	 */
	public void add(String s) {

		HashMap<Character, HashMap> curr_node = root;
		for (int i = 0, n = s.length(); i < n; i++) {
			Character c = s.charAt(i);		//입력된 문자열을 한글자씩씩 읽어서
			if (curr_node.containsKey(c))		//현재 가리키고 있는 Hashmap내부에 존재하는지 확인하고
				curr_node = curr_node.get(c);		//있으면 그 노드를 얻어옴(map 내부에 저장된 노드의 주소값을 받아옴) --> 해당 노드에 추가하려고

			else {		//없으면
				curr_node.put(c, new HashMap<Character, HashMap>());		//새로운 HashMap을 만들어서 삽입
				curr_node = curr_node.get(c);		//그리고 방금삽입한 Map속의 노드의 주소값을 갖고 있음
			}
		}		//이러한 작업을 반복하여 매 글자마다 map에 담고 그 map에 연결시키는 방식
				//편향트리를 만드는것과 같은 개념
		//모든 문자를 map에 추가하고 나면 마지막으로 문자열의 끝을 알릴 널문자를 추가함
		curr_node.put('\0', new HashMap<Character, HashMap>(0)); //  종단문자를 키값으로하여 새로운 노드를 삽입
	}

	/**
	 *  Adds a String[] of words to the trie
	 *  @param sa String[] to add to the trie
	 */
	public void addAll(String[] sa) {
		for (String s: sa)
			add(s);
	}

	/**
	 *  Adds a Collection<String> of words to the trie
	 *  @param sc Collection<String> to add to the trie
	 */
	public void addAll(Collection<String> sc) {
		for (String s: sc)
			add(s);
	}

	/**
	 *  Returns true iff the String is in the trie
	 *  @param s query
	 *  @return true if the query is in the trie
	 */
	public boolean contains(String s) {  // 전달받은 문자열 s가 Trie구조 안에 존재하는지를 확인하는 메서드
		HashMap<Character, HashMap> curr_node = root;
		for (int i = 0, n = s.length(); i < n; i++) { 		//전달받은 문자열을 하나씩 확인해서
			Character c = s.charAt(i);
			if (curr_node.containsKey(c)) curr_node = curr_node.get(c);		//만약 존재하면	탐색 기준이 되는 map을 하위map으로 교체시킨다.
			else return false;
		}
		//String s의 마지막 글자까지 탐색이 끝났을때, 현재 가리키고 있는 노드에 문자열의 끝을 알리는 널문자가 포함되어있는지 확인하고
		if (curr_node.containsKey('\0')) return true; 		//포함되어있으면 있는걸로 판단
		else return false;		//아니면 없는걸로 판단
	}

//	public static void main(String[] args) {
//		Trie t = new Trie();
//		t.add("APPLE");
//		t.add("APPLESAUCE");
//		t.add("APPLICATION");
//		System.out.println(t.contains("FOO")    + " " + false);
//		System.out.println(t.contains("APPL")   + " " + false);
//		System.out.println(t.contains("APPLES") + " " + false);
//		System.out.println(t.contains("APPLE")  + " " + true);
//	}
}