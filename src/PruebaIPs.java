import java.util.Arrays;

public class PruebaIPs {
    public static void main(String[] args) {

        DireccionIP mia=new DireccionIP(192,168,33,1);
        System.out.println(mia);

        System.out.println(DireccionIP.dimeClase(mia));
        System.out.println(Arrays.toString(DireccionIP.dimeMascaraRed(mia)));
        System.out.println(Arrays.toString(DireccionIP.dimeIdRed(mia)));
        System.out.println(DireccionIP.direccionPrivadaOPublica(mia));


    }


}
