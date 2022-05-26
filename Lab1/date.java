public class date{
    //[16,20] --> 5 bits --> dia
    //[12,15] --> 4 bits --> mes
    //[0,11] --> 12 bits --> año
    private int data;
    public date() {
        data = 0;
    }
    // ............/12 ..../4 ...../5 .........../ 11
    public int getAño() {
        return data >>> 20;
    }
    public int getMes() {
        return (data << 12) >>> 28;
    }
    public int getDia() {
        return (data << 16) >>> 27;
    }
    public void setAño(int año){
        data = (data & 1048575) | (año << 20);
        //System.out.println("DATA: "+Long.toBinaryString(data));
    }
    public void setMes(int mes){
        if ((mes>0) && (mes <=12)){
            data = (data & -983041)|(mes << 16);
            //System.out.println("DATA: "+Long.toBinaryString(data));
        }else {
            System.out.println("Valor ingresado no válido. (Debe ser entre 1 y 12)");
        }
    }
    public void setDia(int dia) {
        if ((dia>0) && (dia<=31) ) {
            data = (data & -63489)|(dia << 11);
            //System.out.println("DATA: "+Long.toBinaryString(data));
        }else {
            System.out.println("Valor ingresado no válido. (Debe ser entre 1 y 31");
        }
    }
    public String aString() {
        return (String.format("%02d", getDia())+"/"+String.format("%02d", getMes())+"/"+getAño());
    }

}
