
package utn.tpfinal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ListaPronosticos {
    private List<Pronostico> pronosticos;
    private String pronosticosCSV;

    public ListaPronosticos(List<Pronostico> pronosticos, String pronosticosCSV) {
        this.pronosticos = pronosticos;
        this.pronosticosCSV = pronosticosCSV;
    }

    public ListaPronosticos() {
        this.pronosticos = new ArrayList<Pronostico>();
        this.pronosticosCSV = "pronosticos.csv";
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public String getPronosticosCSV() {
        return pronosticosCSV;
    }

    public void setPronosticosCSV(String pronosticosCSV) {
        this.pronosticosCSV = pronosticosCSV;
    }

    public void addPronostico(Pronostico p) {
        this.pronosticos.add(p);
    }

    public void removePronostico(Pronostico p) {
        this.pronosticos.remove(p);
    }

    @Override
    public String toString() {
        return "ListaParticipantes{" + "pronosticos=" + pronosticos + '}';
    }

    public String listar() {
        String lista = "";
        for (Pronostico pronostico : pronosticos) {
            lista += "\n" + pronostico;
        }
        return lista;
    }

     public void cargarDeDB()
        
         
     {Connection conn = null;
        try {
           
            conn = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
            Statement stmt = conn.createStatement();
     
            String sql = "SELECT idPronostico, idParticipante, IdPartido, idEquipo, resultado FROM pronosticos WHERE idParticipante  "; //+ idParticipante;
            ResultSet rs = stmt.executeQuery(sql); 
            while (rs.next()) {
                
                System.out.println(rs.getInt("idPronostico") + "\t"
                        + rs.getString("idParticipante") + "\t"
                        + rs.getString("IdPartido") + "\t"
                        + rs.getString("idEquipo") + "\t"
                        + rs.getString("resultado") + "\t");
                
                //Partido partido = listapartidos.getPartido(rs.getInt("IdPartido"));
                //Equipo equipo = listaequipos.getEquipo(rs.getInt("IdEquipo"));  
                //Pronostico pronostico = new Pronostico(
                //rs.getInt("idPronostico"), equipo, partido, rs.getString("resultado"),charAt(1));
                //this.addPronostico(pronostico);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // conn close failed.
                System.out.println(e.getMessage());
            }
        }
        
    }

    
    
     
}

