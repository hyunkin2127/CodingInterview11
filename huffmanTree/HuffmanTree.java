package huffmanTree;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;


public class HuffmanTree {

	public static void main(String args[]){

		ChainNode c1 = new ChainNode("a");
		ChainNode c2 = c1;
		System.out.println(c1.alpha + " // " + c2.alpha);
		c2.alpha = "b";
		System.out.println(c1.alpha + " // " + c2.alpha);
		c1.alpha = "c";
		System.out.println(c1.alpha + " // " + c2.alpha);

		String a = "A";
		String b = a;
		System.out.println(a + " // " + b);
		b = "B";
		System.out.println(a + " // " + b);

		HashMap<String, ChainNode> map = new HashMap<String, ChainNode>();

		try {
			File fl = new File("d:/test.txt") ;
			Scanner scan = new Scanner(fl);
			scan.useDelimiter("");
			String key;
			while(scan.hasNext()){
				key = scan.next();
				if(!map.containsKey(key))	map.put(key, new ChainNode(key));
				else{
					System.out.println(map.get(key));
					map.get(key).frequency++; // hashmap.get(key)는 key값에 해당하는 value의 주소를 가져온다.
//					ChainNode temp = map.get(key).frequency;
//					temp.frequency++;
//					map.put(key, temp);
				}
			}//end of while(scan.hasnext());
		}

		catch (Exception e){
			System.out.println("Exception: " + e);
		}

		MinHeap heap = new MinHeap(map.size());
		Iterator<Entry<String, ChainNode>> it = map.entrySet().iterator();
		while(it.hasNext()){
			heap.put(it.next().getValue());
		}

		for(int k=1; k<map.size();k++){
			ChainNode huffnode=new ChainNode();
			huffnode.right=heap.removeMin();
			System.out.println("right : "+ huffnode.right.alpha+ " // " + huffnode.right.frequency + " // k :" + k);
			huffnode.left=heap.removeMin();
			System.out.println("left : " + huffnode.left.alpha+ " // " + huffnode.left.frequency  + " // k : " + k);
			huffnode.frequency=huffnode.right.frequency + huffnode.left.frequency;
			heap.put(huffnode);
		}
		System.out.println(heap.getMin().alpha);
		PrintHuffnode(heap.getMin(), "");
	}

	public static void PrintHuffnode(ChainNode huff, String s){
		if(huff!=null){
			PrintHuffnode(huff.left, s+"0");
			if(huff.alpha != null){
				System.out.println("Alphbet : "+huff.alpha);
				System.out.println("Code : "+s);
			}
			PrintHuffnode(huff.right, s+"1");
		}
	}
}
