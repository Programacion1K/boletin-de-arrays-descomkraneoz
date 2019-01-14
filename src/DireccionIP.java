import java.util.Arrays;

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

    private static final int VALOR_MAXIMO_CLASE_A =127;
    private static final int VALOR_MAXIMO_CLASE_B =191;
    private static final int VALOR_MAXIMO_CLASE_C =223;
    private static final int VALOR_MASCARA_RED=255;



    public static String dimeClase(DireccionIP miIP) {

        if (miIP.direccionIPv4[0]<= VALOR_MAXIMO_CLASE_A){
            return CLASE+A;
        }
        else if (miIP.direccionIPv4[0]<= VALOR_MAXIMO_CLASE_B){
            return CLASE+B;
        }
        else if (miIP.direccionIPv4[0]<= VALOR_MAXIMO_CLASE_C){
            return CLASE+C;
        }
        return "IP no perteneciente a ninguna clase";
    }

    public static int[] dimeMascaraRed(DireccionIP miIP){
        int[] salida=new int[4];
        if (miIP.direccionIPv4[0]<=VALOR_MAXIMO_CLASE_A){
            salida[0]=VALOR_MASCARA_RED;
            salida[1]=0;
            salida[2]=0;
            salida[3]=0;
        }
        else if (miIP.direccionIPv4[0]<=VALOR_MAXIMO_CLASE_B){
            salida[0]=VALOR_MASCARA_RED;
            salida[1]=VALOR_MASCARA_RED;
            salida[2]=0;
            salida[3]=0;
        }
        else if (miIP.direccionIPv4[0]<=VALOR_MAXIMO_CLASE_C){
            salida[0]=VALOR_MASCARA_RED;
            salida[1]=VALOR_MASCARA_RED;
            salida[2]=VALOR_MASCARA_RED;
            salida[3]=0;
        }

        return salida;
    }

    public String getMascaraRed(DireccionIP miIP) {
        String salida="";
        if (miIP.direccionIPv4[0]<=VALOR_MAXIMO_CLASE_A){
            salida=VALOR_MASCARA_RED+"."+0+"."+0+"."+0;
        }
        else if (miIP.direccionIPv4[0]<=VALOR_MAXIMO_CLASE_B){
            salida=VALOR_MASCARA_RED+"."+VALOR_MASCARA_RED+"."+0+"."+0;
        }
        else if (miIP.direccionIPv4[0]<=VALOR_MAXIMO_CLASE_C){
            salida=VALOR_MASCARA_RED+"."+VALOR_MASCARA_RED+"."+VALOR_MASCARA_RED+"."+0;
        }
        return salida;
    }

    /*public static String dimeBroadcast(DireccionIP miIP){
        if(miIP.direccionIPv4[3]==VALOR_MASCARA_RED && miIP.direccionIPv4[2]==VALOR_MASCARA_RED && miIP.direccionIPv4[1]==VALOR_MASCARA_RED){
            return BROADCAST+A;
        }
        else if(miIP.direccionIPv4[3]==VALOR_MASCARA_RED && miIP.direccionIPv4[2]==VALOR_MASCARA_RED){
            return BROADCAST+B;
        }
        else if(miIP.direccionIPv4[3]==VALOR_MASCARA_RED){
            return BROADCAST+C;
        }

        return "Broadcast error fatal";
    }*/

    public static int [] dimeIdRed(DireccionIP miIP){
        int[] salida=new int[4];
        salida[0]=miIP.direccionIPv4[0];
        salida[1]=miIP.direccionIPv4[1];
        salida[2]=miIP.direccionIPv4[2];
        salida[3]=0;
        return salida;

    }

    public String getIdRed(DireccionIP miIP){
        String salida="";
        salida=miIP.direccionIPv4[0]+"."+miIP.direccionIPv4[1]+"."+miIP.direccionIPv4[2]+"."+0;
        return salida;

    }

    public static String direccionPrivadaOPublica(DireccionIP miIP){
        String salida="";

        if (miIP.direccionIPv4[0]<=VALOR_MAXIMO_CLASE_A){
            if (miIP.direccionIPv4[0]==10){
                if (miIP.direccionIPv4[3]==VALOR_MASCARA_RED){
                    salida="Dirección privada tipo A";
                }
            }
            salida="Dirección pública tipo A";
        }
        else if (miIP.direccionIPv4[0]<=VALOR_MAXIMO_CLASE_B){
            if (miIP.direccionIPv4[0]==172){
                if (miIP.direccionIPv4[1]>=16 && miIP.direccionIPv4[1]<=31){
                    if (miIP.direccionIPv4[3]<=VALOR_MASCARA_RED){
                        salida="Dirección privada tipo B";
                    }
                }
            }
            salida="Dirección pública tipo B";
        }
        else if (miIP.direccionIPv4[0]<=VALOR_MAXIMO_CLASE_C){
            if (miIP.direccionIPv4[0]==192){
                if (miIP.direccionIPv4[1]==168){
                    if (miIP.direccionIPv4[3]<=VALOR_MASCARA_RED){
                        salida="Dirección privada tipo C";
                    }
                }

            }

            salida="Dirección pública tipo C";

        }

        return salida;

    }

    public String infoIP(DireccionIP miIP){
        String salida="";
        salida+=toString()+"\n";
        salida+=dimeClase(miIP)+"\n";
        salida+="La Id de red es: "+getIdRed(miIP)+"\n";
        salida+="La máscara de red es: "+getMascaraRed(miIP)+"\n";
        salida+=direccionPrivadaOPublica(miIP);
        return salida;
    }




}