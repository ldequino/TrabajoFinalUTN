
package utn.tpfinal;


    import java.util.ArrayList;
    import java.util.List;


public class Participante {
    private Integer idParticipante;
    private String nombre;
    private ListaPronosticos pronosticos;
    private Integer puntaje;
    
    public Participante(Integer idParticipante, String nombre, ListaPronosticos pronosticos, Integer puntaje) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = pronosticos;
        this.puntaje = puntaje;
    }

    public Participante(Integer idParticipante, String nombre) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = new ListaPronosticos();
        this.puntaje = puntaje;
    }

    public Participante() {
        this.idParticipante = null;
        this.nombre = null;
        this.pronosticos = new ListaPronosticos();
        this.puntaje = null;
    }

    public Integer getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPronosticos getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(ListaPronosticos pronosticos) {
        this.pronosticos = pronosticos;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
    
    public void getPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
   
        @Override
        public String toString() {
        return "Participante " + idParticipante + " nombre " + nombre + " su pronostico " + pronosticos;// + "su puntaje " + getPuntaje();
    }    
}


