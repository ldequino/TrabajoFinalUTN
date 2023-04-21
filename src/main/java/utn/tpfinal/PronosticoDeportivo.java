

package utn.tpfinal;



public class PronosticoDeportivo {
    private final ListaEquipos equipos;
    private final ListaPartidos partidos;
    private final ListaParticipantes participantes;
    private final ListaPronosticos pronosticos;

    public PronosticoDeportivo() {
        equipos = new ListaEquipos();
        partidos = new ListaPartidos();
        participantes = new ListaParticipantes();
        pronosticos = new ListaPronosticos();
    }
    
    public void play(){
      
        System.out.println("Los equipos participantes son: " );
        equipos.cargarDeDB();
        
        System.out.println("");
        
        System.out.println("Los Resultados de los partidos son: " );
        System.out.println("Iden." + " Equi 1 " + " Equi 2 " + " Gol E1 " + " Gol E2 ");
        partidos.cargarDeDB();
        
        System.out.println("");
        System.out.println("Los Participantes son: " );
        System.out.println("Iden.   " + "    Nombre ");
        participantes.cargarDeDB();
       
        System.out.println("");
        System.out.println("Los^Pronosticos de los participantes son: " );
        System.out.println("Iden." + " Partic. " + "Partido " + "Equipo " + "Result ");
        pronosticos.cargarDeDB();
    }
}