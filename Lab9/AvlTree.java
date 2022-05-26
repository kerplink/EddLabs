
public class AvlTree{
	
	private class AvlNode{
		
		public int value;
		public int height;
		public AvlNode right;
		public AvlNode left;
		
		public AvlNode(int value) {
			this.value = value;
			height = 1;
			right = null;
			left = null;
		}
		
	}
	
	private AvlNode root;
	
	public AvlTree() {
		root = null;
	}
	
	public boolean search(int value) {
		return search(value, root);
	}
	
	private boolean search(int value, AvlNode node) {
		if(node == null) return false;
		if(node.value == value) return true;
		if(value < node.value) return search(value, node.left);
		return search(value, node.right);
	}
	
	public void insert(int value) {
		if(root == null) {
			root = new AvlNode(value);
		}else{
			root = insert(value, root);
		}
		root = balance(root);
		
	}
	
	private AvlNode insert(int value, AvlNode node) {
		
		if(value < node.value){
			if(node.left == null) {
				node.left = new AvlNode(value);
			}else {
				node.left = insert(value, node.left);
			}
		}else if(node.value < value) {
			if(node.right == null) {
				node.right = new AvlNode(value);
			}else {
				node.right = insert(value, node.right);
			}
		}
		
		node = balance(node);
		return node;
	}
	
	private AvlNode balance(AvlNode root) {
		int balanceIndex = getHeight(root.left) - getHeight(root.right);
		AvlNode result = root;
		if(balanceIndex > 1) {
			int heightLeftLeft = getHeight(root.left.left);
			int heightLeftRight = getHeight(root.left.right);
			if(heightLeftLeft > heightLeftRight) {
				result = leftLeft(root);
			}else {
				result = leftRight(root);
			}
		}else if(balanceIndex < -1) {
			int heightRightLeft = getHeight(root.right.left);
			int heightRightRight = getHeight(root.right.right);
			if(heightRightLeft > heightRightRight) {
				result = rightLeft(root);
			}else {
				result = rightRight(root);
			}
		}else {
			result.height = getHeight(result); // Actualización de la altura
		}
		return result;
	}
	
	/* Left Left case */
	private AvlNode leftLeft(AvlNode root) {
		return rightRotate(root);
	}
	
	/* Left Right Case */
	private AvlNode leftRight(AvlNode root) {
		root.left = leftRotate(root.left);
		return rightRotate(root);
	}
	
	/* Right Left Case */
	private AvlNode rightLeft(AvlNode root) {
		root.right = rightRotate(root.right);
		return leftRotate(root);
	}
	
	/* Right Right Case */
	private AvlNode rightRight(AvlNode root) {
		AvlNode result = leftRotate(root);
		return result;
	}
	
	private AvlNode rightRotate(AvlNode root) {
		AvlNode left = root.left;
		root.left = left.right;
		left.right = root;
		
		// Actualizacion de las alturas
		root.height = getHeight(root);
		left.height = getHeight(left);
		return left;
	}
	
	private AvlNode leftRotate(AvlNode root) {
		AvlNode right = root.right;
		root.right = right.left;
		right.left = root;
		
		// Actualizacion de las alturas
		root.height = getHeight(root);
		right.height = getHeight(right);
		return right;
	}
	
	private int getHeight(AvlNode node) {
		if(node == null) return 0;
		return Math.max(node.left != null ? node.left.height : 0, node.right != null ? node.right.height : 0)+1;
	}
	
	public void print() {
		print(root, "");
	}
	
	private void print(AvlNode node, String space) {
		if(node == null) {
			System.out.println(space + "NULL");
		}else {
			System.out.println(space + "[" + node.value + ", " + node.height + "]");
			print(node.left, space+"--");
			print(node.right, space+"--");
		}
		
	}
	
}