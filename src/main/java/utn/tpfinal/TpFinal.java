
package utn.tpfinal;

public class TpFinal {

    //Trabajo Final
    public static PronosticoDeportivo PRODE;
    
   
    public static void main(String[] args) {
        System.out.println ("Sistema de simulación de pronósticos deportivos.");
        
        PRODE = new PronosticoDeportivo();

        PRODE.play();
    
    }
}
