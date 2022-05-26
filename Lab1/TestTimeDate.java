import  java.util.Scanner;
public class TestTimeDate {
    public static boolean tryCode(String a) {
        return a.matches("[1-7]+") && (a.length() == 1);
    }
    public static void main(String[]args) {
        TimeDate td = new TimeDate();
        //opc es la opcion que será ingresada por teclado
        String opc = "a";
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Cambiar dia"+"\n"+"2.Cambiar mes"+"\n"+"3.Cambiar año"+"\n"+"4.Cambiar hora"+"\n"+
                "5.Cambiar minuto"+"\n"+"6.Mostrar fecha y Hora (Formato DD/MM/AA HH:MM"+"\n"+"7. Salir.");
        while(!opc.equals("7")) {
            System.out.println("Seleccione operación (El numero asociado):");
            opc = sc.next();
            //Un pequeño failsafe
            while(!tryCode(opc)) {
                System.out.println("Opción inválida, intente nuevamente.");
                opc = sc.next();
            }
            switch(Integer.parseInt(opc)) {
                case(1):
                    System.out.println("Ingrese el dia:");
                    td.setDia(sc.nextInt());
                    break;
                case(2):
                    System.out.println("Ingrese el mes:");
                    td.setMes(sc.nextInt());
                    break;
                case(3):
                    System.out.println("Ingrese el Año:");
                    td.setAño(sc.nextInt());
                    break;
                case(4):
                    System.out.println("Ingrese la hora:");
                    td.setHora(sc.nextInt());
                    break;
                case(5):
                    System.out.println("Ingrese los minutos:");
                    td.setMinuto(sc.nextInt());
                    break;
                case(6):
                    System.out.println(td.aString(true));
                    break;
                case(7):
                    sc.close();
            }
        }
    }
}
