import java.util.Scanner;
public class testDate {
    public static boolean tryCode(String a) {
        return a.matches("[1-5]+") && (a.length() == 1);
    }
    public static void main(String[]args) {
        String opc = "a";
        date td = new date();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Cambiar dia"+"\n"+"2.Cambiar mes"+"\n"+"3.Cambiar año"+"\n"+
                "4.Mostrar fecha (Formato DD/MM/AA"+"\n"+"5. Salir");
        while(!opc.equals("5")) {
            System.out.println("Seleccione operación (El numero asociado)");
            opc = sc.next();
            while(!tryCode(opc)) {
                System.out.println("Oción inválida");
                opc = sc.next();
            }
            switch(Integer.parseInt(opc)) {
                case(1):
                    System.out.println("Ingrese el dia");
                    td.setDia(sc.nextInt());
                    break;
                case(2):
                    System.out.println("Ingrese el mes");
                    td.setMes(sc.nextInt());
                    break;
                case(3):
                    System.out.println("Ingrese el Año");
                    td.setAño(sc.nextInt());
                    break;
                case(4):
                    System.out.println(td.aString());
                    break;
                case(5):
                    sc.close();
                    break;
            }
        }
    }
}
