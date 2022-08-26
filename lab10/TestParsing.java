import java.util.Scanner;

/**
 * 
 * @author Martita
 * 
 */

public class TestParsing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tec = new Scanner(System.in);
		System.out.print("Ingrese su expresi�n: ");
		String expresion = tec.next();
		tec.close();
		String salida = Parsing.fromInfijoToPostfijo(expresion);
		System.out.print("Su expresi�n postfija es: " + salida);
		ArbolExpresion a = Parsing.getArbol(salida);
		System.out.println("\n\nSU ARBOL DE EXPRESION: \n");
		a.print(0);
	}

}
