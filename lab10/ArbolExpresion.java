
/**
 * 
 * @author Martita
 * 
 */

public class ArbolExpresion {
	
	public ArbolExpresion left;
	public ArbolExpresion right;
	public char symbol;
	
	public ArbolExpresion(char symbol) {
		this.symbol = symbol;
	}
	
	public void print(int number) {
		String line = "";
		for(int i = 0; i < number; i++) {
			line += "--";
		}
		line += "> " + this.symbol;
		System.out.println(line);
		if(left != null) left.print(number+1);
		if(right != null) right.print(number+1);
	}
}
