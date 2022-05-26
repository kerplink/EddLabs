public class TimeDate {

    //[16,20] --> 5 bits --> dia
    //[12,15] --> 4 bits --> mes
    //[0,11] --> 12 bits --> año
    private int data;
    private int mask;
    public TimeDate() {
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
    public int getHora(){
        return (data<<21) >>> 27;
    }
    public int getMinuto(){
        return (data<<26) >>> 26;
    }
    public void setAño(int año){
        mask = 1048575;
        data = (data & mask) | (año << 20);
        //System.out.println("DATA: "+Long.toBinaryString(data));
    }
    public void setMes(int mes){
        if ((mes>0) && (mes <=12)){
            mask = -983041;
            data = (data & mask)|(mes << 16);
            //System.out.println("DATA: "+Long.toBinaryString(data));
        }else {
            System.out.println("Valor ingresado no válido. (Debe ser entre 1 y 12)");
        }
    }
    public void setHora(int hora){
        if((hora>=0)&&(hora<=23)){
            mask = -1985;
            data = (data & mask)|(hora<<6);
        }else{
            System.out.println("Valor ingresado no válido (Debe ser formato 24H)");
        }
    }
    public void setMinuto(int min){
        if ((min>=0)&&(min<=59) ){
            mask = -64;
            data = (data & mask)|min;
        }else{
            System.out.println("Valor ingresado no válido(Debe ser del minuto 0 al 59)");
        }
    }
    public void setDia(int dia) {
        if ((dia>0) && (dia<=31) ) {
            mask = -63489;
            data = (data & mask)|(dia << 11);
            //System.out.println("DATA: "+Long.toBinaryString(data));
        }else {
            System.out.println("Valor ingresado no válido. (Debe ser entre 1 y 31");
        }
    }
    public boolean sameDate(TimeDate t){
        return t.aString(false).equals(aString(false));
    }
    public  boolean isBefore(TimeDate t){
        if (sameDate(t)) {
            return false;
        }else if(t.getAño()>getAño()){
            return  false;
        }else if(t.getMes()>getMes()){
            return  false;
        }else return t.getDia() < getDia();
    }
    public boolean isAfter(TimeDate t){
        return !(isBefore(t) || sameDate(t));
    }
    public String aString(boolean h) {
        //return ((data<<16)>>>27)+"/"+((data<<12)>>>28)+"/"+((data>>>20));
        if(h){
            return (String.format("%02d", getDia())+"/"+String.format("%02d", getMes())+"/"+getAño())+" "+String.format("%02d", getHora())+":"+String.format("%02d", getMinuto());
        }
        return (String.format("%02d", getDia())+"/"+String.format("%02d", getMes())+"/"+getAño());
    }
}
