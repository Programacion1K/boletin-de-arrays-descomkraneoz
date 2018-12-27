public class DireccionIP {

    private int primerEnteroIP;
    private int segundoEnteroIP;
    private int tercerEnteroIP;
    private int cuartoEnteroIP;
    private int [] arrayIP;
    private String cadenaIP;

    public DireccionIP(int primerEntero, int segundoEntero, int tercerEntero, int cuartoEntero) {
        this.primerEnteroIP = primerEntero;
        this.segundoEnteroIP = segundoEntero;
        this.tercerEnteroIP = tercerEntero;
        this.cuartoEnteroIP = cuartoEntero;
    }

    public  DireccionIP(String cadena){
        this.cadenaIP=cadena;
    }

    public DireccionIP(int[] ArrayIP) {
        arrayIP[0]=primerEnteroIP;
        arrayIP[1]=segundoEnteroIP;
        arrayIP[2]=tercerEnteroIP;
        arrayIP[3]=cuartoEnteroIP;

    }

    public String imprimeSalidaEnCadena() {

        return cadenaIP;
    }

    public String imprimeSalidaDeEnteros() {

        return primerEnteroIP+"."+segundoEnteroIP+"."+tercerEnteroIP+"."+cuartoEnteroIP;
    }

    public String imprimeSalida(){
        String salida="";

        if (salida==null){
            return imprimeSalidaEnCadena();
        }else{
            return imprimeSalidaDeEnteros();
        }

    }

    @Override
    public String toString() {
        return imprimeSalida();
    }
}
