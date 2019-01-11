public class DireccionIP {
    int[] direccionIPv4;

        //https://es.wikipedia.org/wiki/Direcci%C3%B3n_IP

    DireccionIP mascaraRed;

    DireccionIP idRed;

    private static final String CLASE="Clase";
    private static final String MASCARA_RED="Máscara de Red";
    private static final String BROADCAST="Id. Broadcast de clase";
    private static final String A=" A";
    private static final String B=" B";
    private static final String C=" C";



    DireccionIP(int octeto1,int octeto2,int octeto3,int octeto4){
        this.direccionIPv4=new int[4];
        this.direccionIPv4[0]=octeto1;
        this.direccionIPv4[1]=octeto2;
        this.direccionIPv4[2]=octeto3;
        this.direccionIPv4[3]=octeto4;
        //this.mascaraRed=new DireccionIP(255,255,255,0); //No es asi
        //this.idRed=new DireccionIP(this.direccionIPv4[0],this.direccionIPv4[1],this.direccionIPv4[2],this.direccionIPv4[3]);
    }

    @Override
    public String toString() {
        return this.direccionIPv4[0]+"."+this.direccionIPv4[1]+"."+this.direccionIPv4[2]+"."+this.direccionIPv4[3];
    }

    private static final int VALOR_CLASE_A=127;
    private static final int VALOR_CLASE_B=191;
    private static final int VALOR_CLASE_C=223;
    private static final int VALOR_MASCARA_RED=255;



    public static String dimeClase(DireccionIP miIP) {

        if (miIP.direccionIPv4[0]<=VALOR_CLASE_A){
            return CLASE+A;
        }
        else if (miIP.direccionIPv4[0]<=VALOR_CLASE_B){
            return CLASE+B;
        }
        else if (miIP.direccionIPv4[0]<=VALOR_CLASE_C){
            return CLASE+C;
        }
        return "IP no perteneciente a ninguna clase";
    }

    public static String dimeMascaraRed(DireccionIP miIP){
        if(miIP.direccionIPv4[0]==VALOR_MASCARA_RED && miIP.direccionIPv4[1]==0 && miIP.direccionIPv4[2]==0 && miIP.direccionIPv4[3]==0){
            return MASCARA_RED+A;
        }
        else if(miIP.direccionIPv4[0]==VALOR_MASCARA_RED && miIP.direccionIPv4[1]==VALOR_MASCARA_RED && miIP.direccionIPv4[2]==0 && miIP.direccionIPv4[3]==0){
            return MASCARA_RED+B;
        }
        else if(miIP.direccionIPv4[0]==VALOR_MASCARA_RED && miIP.direccionIPv4[1]==VALOR_MASCARA_RED && miIP.direccionIPv4[2]==VALOR_MASCARA_RED && miIP.direccionIPv4[3]==0){
            return MASCARA_RED+C;
        }
        else if(miIP.direccionIPv4[3]==VALOR_MASCARA_RED && miIP.direccionIPv4[2]==VALOR_MASCARA_RED && miIP.direccionIPv4[1]==VALOR_MASCARA_RED){
            return BROADCAST+A;
        }
        else if(miIP.direccionIPv4[3]==VALOR_MASCARA_RED && miIP.direccionIPv4[2]==VALOR_MASCARA_RED){
            return BROADCAST+B;
        }
        else if(miIP.direccionIPv4[3]==VALOR_MASCARA_RED){
            return BROADCAST+C;
        }
        return "Máscara de red no perteneciente a ninguna clase";
    }




}