import java.util.Stack;

/**
 * 
 * @author Martita
 * 
 * Para m�s info, visitar https://es.stackoverflow.com/questions/26907/infijo-a-posfijo-en-java
 * Y http://informatica.uv.es/iiguia/AED/laboratorio/P6/pr_06_2005.html
 *
 */

public class Parsing {

	public static String fromInfijoToPostfijo(String infijo) {
		Stack<Character> St = new Stack<Character>();
		String salida = "";
		for (int i = 0; i < infijo.length(); i++) {
			char aux = infijo.charAt(i);
			if (isANumber(aux)) {
				salida += aux;
			} else if (prioridad(aux) == 0) {
				St.push(aux);
			} else if (aux == ')') {
				while (St.lastElement() != '(') {
					salida += St.pop();
				}
			} else if (prioridad(aux) > 0) {
				if (St.isEmpty()) {
					St.push(aux);
				} else if (prioridad(aux) > prioridad(St.peek())) {
					St.push(aux);
				} else {
					salida += St.pop();
					St.push(aux);
				}
			}
		}
		while(!St.isEmpty()){
			salida+=St.pop();
		}
		return salida;
	}
	
	private static boolean isANumber(char symbol) {
		return symbol == '0' || symbol == '1' || symbol == '2' || symbol == '3' || 
				symbol == '4' || symbol == '5' || symbol == '6' || symbol == '7' || 
				symbol == '8' || symbol == '9';
	}
	
	private static int prioridad(char symbol) {
		if(symbol == '(') return 0;
		if(symbol == '+' || symbol == '-') return 1;
		if(symbol == '*' || symbol == '/') return 2;
		return -1;
	}

	
	public static ArbolExpresion getArbol(String postfijo) {
		Stack<ArbolExpresion> St = new Stack<ArbolExpresion>();
		for (int i=0;i<postfijo.length();i++){
			ArbolExpresion A = new ArbolExpresion(postfijo.charAt(i));
			if (isANumber(postfijo.charAt(i))){
				St.push(A);
			}else{
				if(!St.isEmpty())A.left=St.pop();
				if(!St.isEmpty())A.right=St.pop();
				St.push(A);
			}
		}
		return St.pop();
	}
}
