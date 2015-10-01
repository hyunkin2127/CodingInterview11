package huffmanTree;

public class ChainNode {
	// package visible data members
	String alpha;
	int frequency;
	ChainNode right;
	ChainNode left;

	ChainNode(){
		alpha = null;
		frequency = 0;
		right =null;
		left =null;
	}

	// package visible constructors
	ChainNode(String alpha) {
		this.alpha=alpha;
		frequency=1;
		right=null;
		left=null;
	}
}