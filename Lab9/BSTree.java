

public class BSTree{
	
	private class BSTNode{
		
		public int value;
		public BSTNode right;
		public BSTNode left;
		
		public BSTNode(int value) {
			this.value = value;
			right = null;
			left = null;
		}
		
	}
	
	private BSTNode root;
	
	public BSTree() {
		root = null;
	}
	
	public boolean search(int value) {
		return search(value, root);
	}
	
	private boolean search(int value, BSTNode node) {
		if(node == null) return false;
		if(node.value == value) return true;
		if(value < node.value) return search(value, node.left);
		return search(value, node.right);
	}
	
	public void insert(int value) {
		if(root == null) {
			root = new BSTNode(value);
		}else{
			root = insert(value, root);
		}
		
	}
	
	private BSTNode insert(int value, BSTNode node) {
		
		if(value < node.value){
			if(node.left == null) {
				node.left = new BSTNode(value);
			}else {
				node.left = insert(value, node.left);
			}
		}else if(node.value < value) {
			if(node.right == null) {
				node.right = new BSTNode(value);
			}else {
				node.right = insert(value, node.right);
			}
		}
		
		return node;
	}
	
	public void print() {
		print(root, "");
	}
	
	private void print(BSTNode node, String space) {
		if(node == null) {
			System.out.println(space + "NULL");
		}else {
			System.out.println(space + "[" + node.value + "]");
			print(node.left, space+"--");
			print(node.right, space+"--");
		}
		
	}
	
}