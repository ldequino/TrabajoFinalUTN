
package utn.tpfinal;


public class Partido {

    private int idPartido;
    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(int idPartido, String equipo1, String equipo2, int golesEquipo1, int golesEquipo2) {
        this.idPartido = idPartido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public Partido() {
        this.idPartido = 0;
        this.equipo1 = null;
        this.equipo2 = null;
        this.golesEquipo1 = 0;
        this.golesEquipo2 = 0;
    }

    public int getidPartido() {
        return idPartido;
    }

    public void setidPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }
    public Partido getPartido(int idPartido){
        Partido partido = new Partido(getidPartido(),getEquipo1(),getEquipo2(),getGolesEquipo1(),getGolesEquipo2());
        return partido;
    }

    @Override
    public String toString() {
        return "Partido Numero " + idPartido + ", Equipo " + equipo1 + " Consiguio " + golesEquipo1 + " Goles" + "   " + "Equipo " +  equipo2  + 
                 " Consiguio " + golesEquipo2 + " Goles";
    } 

    public char getResultado(Equipo equipo) {
        char resultado = 'X';
        
        if (equipo.getNombre().equals(equipo1.getNombre())) {
            if (this.golesEquipo1 > this.golesEquipo2){
                resultado = 'G';
             }else if (this.golesEquipo1 < this.golesEquipo2){
                        resultado = 'P';
              }else {
                 resultado = 'E';
                }
             }else if (equipo.getNombre().equals(equipo2.getNombre())) {
            if (this.golesEquipo2 > this.golesEquipo1){
                resultado = 'G';
             }else if (this.golesEquipo2 < this.golesEquipo1){
                        resultado = 'P';
              }else {
                 resultado = 'E';
              }
              }
            return resultado;
      }
  
  }
