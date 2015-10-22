import dynamicProblems.FindMaxAsc;
import dynamicProblems.FindMaxSum;
import graph.Graph;
import graph.MST_Kruskal;
import graph.ShortestPathFinder;
import graph.GraphSearch;
import heap.ArrayHeap2;
import linkedList.LinkedList;
import queue.ArrayQueue;
import sort.MergeSort;
import sort.QuickSort;
import sort.quick;
import stack.FindMaxRect;
import stringAlgorithm.Trie;
import stringAlgorithm.stringExamples;
import trees.AVL;
import trees.BST;
import trees.Node;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class main {

	public static void main(String[] args) {
		//		testArrayQueue();
		testSort();
//		testquick();

//		testBST2();

//		testAVL();
//		testGraph();
//		testGraph2();
//		testMST_Kruskal();


		class A{
			public int one = 1;
			public int two = 2;
		};

		class B extends A{
			public int three = 3;
			public int four = 4;
		};

		A aa1 = new A();
		B bb2 = new B();
		A aa2 = new B();

//		System.out.println(aa1.one + " " + aa2.one);

//	testSort();

//		testTrie();
//		testStringExamples();

//		Integer[] a = {8, 9, 51, 122, 36, 4, 65, 15, 12, 13, 24, 26, 27, 48, 19, 20, 44, 88, 29, 8, 64, 2, 8};
//		Integer[] d={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20};
//		int[] c = {20, 22, 23, 24,10,11,12,13,14,15,16,17,18,19};
//		int[] b={1,14,4,5,2,6,9,3,12,10,7,8,20,15,13,11,17,19,16}; //18

//		SpliteArrayOddEven sa = new SpliteArrayOddEven(c);
//		sa.spliteByQuick();
//		for(int q : sa.arr){
//			System.out.println(q);
//		}

//		testGraph();
//		testTree();
//			testHeap();

//		FindSumNumb fs = new FindSumNumb(c);
//		System.out.println(fs.FindByBF(43));
//		System.out.println(fs.FindByHash(1));

//		FindMissingNumb fNum = new FindMissingNumb(b);
//		System.out.println("BF : "+fNum.findNumbByBF());
//		System.out.println("HASH : "+fNum.findNumbByHash());
//		System.out.println("SORT : "+fNum.findNumbBySort());

//		TestHashMap tm = new TestHashMap();
//		tm.makeHashMap(a);
	}

	public static void testLL(){

		LinkedList ll = new LinkedList();

		ll.insert(0);
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(5);
		ll.insert(6);
		ll.insert(7);
		ll.insert(8);
		ll.insert(9);

		ll.deleteNode(5);
		ll.deleteNode(3);
		//
		ll.printList();
	}

	public static void testArrayQueue(){
		ArrayQueue<Integer> aq = new ArrayQueue(5);

		aq.enQueue(10);
		aq.enQueue(11);
		aq.enQueue(12);
		aq.enQueue(13);
		aq.enQueue(14);
		aq.enQueue(15);
		aq.enQueue(16);

		aq.printQueue();

		aq.enQueue(17);
		aq.enQueue(18);
		aq.enQueue(19);
		aq.enQueue(9);


		//		aq.enQueue(20);

		System.out.println("deQ : " +aq.deQueue());
		System.out.println("deQ : " +aq.deQueue());

		aq.printQueue();

		aq.enQueue(20);
		aq.enQueue(21);
		aq.printQueue();
		aq.enQueue(23);
		aq.enQueue(24);
		aq.enQueue(25);

	}

	public static void testSort(){

		int[] a = {8, 9, 51, 122, 36, 4, 65, 15, 12, 13, 24, 26, 27, 48, 19, 20, 44, 88, 29, 64, 2};
		MergeSort ms = new MergeSort(a);
		QuickSort qs = new QuickSort(a);

//		BaseSort2 bs = new BaseSort2(a);
//		bs.selectionSort();
		//		bs.insertionSort();
		//		bs.shellSort();
//
//		ms.sort(0, a.length-1); //merge는 잘됨
//		ms.showRepository();
		qs.sort(0, a.length-1); //안됨
		qs.showRepository();

	}

	public static void testquick(){

		int[] list = {10,5,3,8,4,9,1,6,2,7};
		quick quick = new quick();

		System.out.println("before quick : " + Arrays.toString(list));
		quick.quickSort(list, 0, list.length - 1);
		System.out.println("after quick : " + Arrays.toString(list));


	}


//	public static void testBST(){
//
//		BinarySearchTree bst = new BinarySearchTree(new Node(10));
//		bst.insertData(bst.root, 8);
//		bst.insertData(bst.root, 15);
//		bst.insertData(bst.root, 5);
//		bst.insertData(bst.root, 8);
//		bst.insertData(bst.root, 4);
//		bst.insertData(bst.root, 9);
//		bst.insertData(bst.root, 5);
//		bst.insertData(bst.root, 7);
//		bst.insertData(bst.root, 1);
//		bst.insertData(bst.root, 11);
//
//
//		bst.inOrder(bst.root);
//
//		System.out.println("\n"+bst.searchDataByRecur(bst.root, 11).data);
//		System.out.println(bst.deleteData(bst.root, 5).data);
//		System.out.println(bst.searchDataByRecur(bst.root, 11).data);
//
//		bst.inOrder(bst.root);
//	}

	public static void testBST2(){

//		Node root = new Node(50);
//		BST bb = new BST(root);
//		bb.insert(root, null, 40);
//		bb.insert(root, null, 20);
//		bb.insert(root, null, 60);
//		bb.insert(root, null, 30);
//		bb.insert(root, null, 48);
//		bb.insert(root, null, 70);
//		bb.insert(root, null, 15);
//		bb.insert(root, null, 10);
//		bb.insert(root, null, 13);
//		bb.insert(root, null, 52);
//		bb.insert(root, null, 51);
//		bb.insert(root, null, 55);
//		bb.insert(root, null, 64);
//		bb.insert(root, null, 72);
//		bb.insert(root, null, 8);

		Node root = new Node(50);
		BST bb = new BST(root);
		bb.insert(root, null, 40);
		bb.insert(root, null, 20);

//		System.out.println("BTS2 : " + bb.search(root, 60).getParent().getData());
		bb.traverseTree(root);
//		bb.delete(root, 60);
//		bb.traverseTree(root);

	}

	public static void testAVL(){

		Node root = new Node(50);
		AVL aa = new AVL(root);
		root = aa.insert(root , 40);
		aa.insert(root , 60);
		aa.insert(root , 70);
		aa.insert(root , 80);
		aa.insert(root , 45);
		aa.insert(root , 48);
		aa.insert(root , 47);
		aa.insert(root , 43);
		aa.insert(root , 30);
		aa.insert(root , 25);
		aa.insert(root , 27);
		aa.insert(root , 35);
		aa.insert(root , 94);
		aa.insert(root , 90);
		aa.insert(root , 16);
		aa.insert(root , 21);

//		LL 회전 -- 50만 나옴
//		Node root = new Node(50);
//		AVL aa = new AVL(root);
//		root = aa.insert(root, 49);
//		root = aa.insert(root, 48);



//		//RR 회전 -- 50만 나옴
//		Node root = new Node(50);
//		AVL aa = new AVL(root);
//		root = aa.insert(root, 51);
//		root = aa.insert(root, 52);

		System.out.println("root.data :  " + root.getData());
		System.out.println("root.left : " + root.getChild("left").getData());
		System.out.println("root.right : " + root.getChild("right").getData());



		aa.traverseTree(root);

	}


/*	public static  void testTree(){
		Tree t = new Tree(new Node(0, null));

		t.addByLevel(1);
		t.addByLevel(2);
		t.addByLevel(3);
		t.addByLevel(4);
		t.addByLevel(5);
		t.addByLevel(6);
		t.addByLevel(7);
		t.addByLevel(8);
		t.addByLevel(9);

		//		System.out.println(t.search(t.root, 10));
		//		System.out.println(t.findHeight(t.root));
		//		t.levelOrder();
		t.inOrder(t.root);
		System.out.println(t.findSizeByRecur(t.root));
		System.out.println(t.findSizeByRepeat(t.root));
		t.remove(t.root, 3);
		System.out.println("========================================");
		t.inOrder(t.root);
		System.out.println(t.findSizeByRecur(t.root));
		System.out.println(t.findSizeByRepeat(t.root));
		//		t.levelOrder();

	}*/

	public static void testHeap(){
		ArrayHeap2 ah = new ArrayHeap2(20);
		ah.insert(1);
		ah.insert(2);
		ah.insert(3);
		ah.insert(4);
		ah.insert(5);
		ah.insert(6);
		ah.insert(7);
		ah.insert(8);
		ah.insert(9);
		ah.insert(10);

		ah.printHeap();
		System.out.println(ah.removeTop());
		ah.printHeap();

		System.out.println(ah.removeTop());
		ah.printHeap();

		System.out.println(ah.removeTop());
		ah.printHeap();

		System.out.println(ah.removeTop());
		ah.printHeap();

		System.out.println(ah.removeTop());
		System.out.println(ah.removeTop());
	}

	public static void testPC(){

		BlockingQueue queue = new ArrayBlockingQueue(50);
		//BlockingQueue queue = new LinkedBlockingQueue();

		ProdNCons2 pc2 = new ProdNCons2(queue);
		Thread p = new Thread(pc2.p);
		Thread c = new Thread(pc2.c);

		p.start();
		c.start();

		//		ProdNCons pc = new ProdNCons(4, 3);
		//		try {
		//			Thread.sleep(1000);
		//		} catch (InterruptedException e) {
		//			e.printStackTrace();

		//		}
		//		synchronized (pc.list) {
		//			pc.done = true;
		//			pc.list.notifyAll();
		//		}
	}

	public static void testGraph(){

		Graph g = new Graph(new boolean[6][6]);

		g.insertEdge(0, 1);
		g.insertEdge(0, 2);
		g.insertEdge(1, 3);
		g.insertEdge(1, 4);
		g.insertEdge(2, 3);
		g.insertEdge(4, 5);
		g.insertEdge(3, 5);
		g.point = 6;
		GraphSearch tv = new GraphSearch(g);

		tv.DSF(0);
		//			tv.BFS(0);


	}

	public  static void testGraph2(){
//		ShortestPathFinder sf = new ShortestPathFinder(4);
//		sf.insertEdges(1, 2, 1);
//		sf.insertEdges(1, 3, 4);
//		sf.insertEdges(2, 3, 2);
//		sf.insertEdges(3, 4, 2);


		ShortestPathFinder sf = new ShortestPathFinder(7);
		sf.insertEdges(1, 2, 1);
		sf.insertEdges(1, 3, 4);
		sf.insertEdges(2, 4, 5);
		sf.insertEdges(3, 4, 3);
		sf.insertEdges(4, 5, 2);
		sf.insertEdges(4, 6, 5);
		sf.insertEdges(5, 6, 1);
//		sf.insertEdges(5, 7, 4);
		sf.insertEdges(6, 7, 3);

		sf.findShortestPath(1);
		sf.showWay();


	}

	public static void testMST_Kruskal(){
//		MST_Kruskal mk = new MST_Kruskal(4);
//		mk.insertEdge(0, 1, 1);
//		mk.insertEdge(0, 2, 4);
//		mk.insertEdge(1, 2, 2);
//		mk.insertEdge(2, 3, 5);

		MST_Kruskal mk = new MST_Kruskal(7);
		mk.insertEdge(0, 1, 1);
		mk.insertEdge(0, 2, 4);
		mk.insertEdge(1, 3, 5);
		mk.insertEdge(2, 3, 3);
		mk.insertEdge(3, 4, 2);
		mk.insertEdge(3, 5, 5);
		mk.insertEdge(4, 5, 1);
		mk.insertEdge(5, 6, 3);
		mk.insertEdge(4, 6, 4);
		mk.showGraph(0, mk.originAdj);
		System.out.println("=================================================");
		mk.makeMST();
		for(int i=0; i<mk.newAdj.length; i++){
			for(int j=0; j<mk.newAdj[i].length; j++){
				if(mk.newAdj[i][j] == Integer.MAX_VALUE) System.out.print("M  ");
				else System.out.print(mk.newAdj[i][j]+ "  ");
			}
			System.out.println();
		}

//		mk.showGraph(0, mk.newAdj);
//
//		for(int i=0; i<mk.newAdj.length; i++){
//			for(int j=0; j<mk.newAdj[i].length; j++){
//				System.out.print(mk.newAdj[i][j]+ "  ");
//			}
//			System.out.println();
//		}


	}

	public static void testDP_Q4(){
		int [] a ={-10,-14,-5,-2,-7,-1,-15,-9,-25};
		FindMaxSum fms = new FindMaxSum(a);
		fms.findSection();
		fms.findSection2();
		fms.findSection3();

	}

	public static void testDP_Q20(){
		int [] a ={-10, 1, 2, 3, 4, -14, -15, 2, 7, 10, 15, 24, 25, -1, -15, -9, -25, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		FindMaxAsc fma = new FindMaxAsc(a);
		fma.findAsc();
	}

	public static void testStack_Q24(){

		int[] arr= {1, 2, 4, 3, 2, 1, 5, 9, 7, 1, 4, 8};
		FindMaxRect fmr = new FindMaxRect(arr);

		fmr.calRect();

	}

	public static void testTrie(){
		Trie t = new Trie();
		t.add("APPLE");
		t.add("APPLESAUCE");
		t.add("APPLICATION");
		System.out.println(t.contains("FOO")    + " " + false);
		System.out.println(t.contains("APPL")   + " " + false);
		System.out.println(t.contains("APPLES") + " " + false);
		System.out.println(t.contains("APPLE")  + " " + true);
	}

	public static void testStringExamples(){
		stringExamples rs = new stringExamples("This is a apple");
		rs.parseString();
	}
}
