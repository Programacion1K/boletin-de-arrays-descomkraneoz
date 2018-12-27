import java.util.Arrays;

public class PruebaIPs {
    public static void main(String[] args) {

        DireccionIP cadenaIP=new DireccionIP("192.168.0.50");

        System.out.println(cadenaIP.imprimeSalidaEnCadena());

        DireccionIP enterosIP=new DireccionIP(10,0,0,3);

        System.out.println(enterosIP.imprimeSalidaDeEnteros());

        DireccionIP matrizIP[]={new DireccionIP(127,25,25,30)};

        for (int i = 0; i <matrizIP.length ; i++) {
            System.out.println(Arrays.toString(matrizIP));
        }







    }
}
