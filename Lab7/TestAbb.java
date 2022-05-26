/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carola
 */
public class TestAbb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Abb a = new Abb();
        a.Insertar(10);
        a.Insertar(8);
        a.Insertar(12);
        a.Insertar(4);
        a.Insertar(-8);

        a.Imprimir();

        System.out.println(" EL complemento es : " + a.Complemento());	// True
        a.Eliminar(-8);
        System.out.println(" EL complemento es : " + a.Complemento());	// False

    }

}
