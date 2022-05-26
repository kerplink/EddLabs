public class TestLista {

    public static void main(String [] args) {
        Lista l = new Lista();
        System.out.println("Vacía?: " + l.EstaVacia());
        System.out.println("\nSize: " + l.Size());
        l.InsertaInicio(12);
        System.out.println("Vacía?: " + l.EstaVacia());
        System.out.println("\nSize: " + l.Size());
        l.Print();
        l.InsertaInicio(32);
        System.out.println("\nSize: " + l.Size());
        l.Print();
        l.InsertaFinal(51);
        System.out.println("\nSize: " + l.Size());
        System.out.println("Elementos mayores al promedio: "+l.promed()+" Size "+l.getMayoresProm(l.promed()).Size());
        l.getMayoresProm(l.promed()).Print();
        System.out.println("\n");
        l.Print();
        l.Eliminar(12);
        System.out.println("\nSize: " + l.Size());
        l.Print();
        l.Eliminar(32);
        System.out.println("\nSize: " + l.Size());
        l.Print();
        l.Eliminar(51);
        System.out.println("\nSize: " + l.Size());
        System.out.println("Vacía: " + l.EstaVacia());
    }
}
