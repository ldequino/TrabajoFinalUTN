
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
      
        equipos.cargarDeArchivo();
        System.out.println("Los equipos participantes son: " + equipos.listar());
        
        partidos.cargarDeArchivo(equipos);
        System.out.println("Los Resultados de los partidos son: " + partidos.listar());
       
        participantes.cargarDeArchivo();
        // Una vez cargados los participantes, para cada uno de ellos
        // cargar sus pronósticos
        for (Participante p : participantes.getParticipantes()) {
            p.cargarPronosticos(equipos, partidos);
        }
        
        System.out.println("Los participantes cargados son: " + participantes.listar());
        
        
      
        
        
        
        
       
    }    
}

