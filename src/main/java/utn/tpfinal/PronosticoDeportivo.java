

package utn.tpfinal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
      
        System.out.println("Los equipos participantes son: " + equipos.listar());
        equipos.cargarDeDB();
        
        System.out.println("");
        
        System.out.println("Los Resultados de los partidos son: " + partidos.listar());
        System.out.println("Iden." + " Equi 1 " + " Equi 2 " + " Gol E1 " + " Gol E2 ");
        partidos.cargarDeDB();
        
        System.out.println("");
        System.out.println("Los Participantes son: " + participantes.listar());
        System.out.println("Iden.   " + "    Nombre ");
        participantes.cargarDeDB();
        // Una vez cargados los participantes, para cada uno de ellos
        // cargar sus pronósticos
        for (Participante p : participantes.getParticipantes()) {
            p.cargarPronosticos(equipos, partidos);
        }
        
        System.out.println("Los^Pronosticos de los participantes son: " + pronosticos.listar());
        
    }
}