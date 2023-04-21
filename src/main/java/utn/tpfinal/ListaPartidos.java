
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


public class ListaPartidos {

    private List<Partido> partidos;
    private String partidosCSV;

    public ListaPartidos(List<Partido> partidos, String partidosCSV) {
        this.partidos = partidos;
        this.partidosCSV = partidosCSV;
    }

    public ListaPartidos() {
        this.partidos = new ArrayList<>();
        this.partidosCSV = "partidos.csv";
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public String getPartidosCSV() {
        return partidosCSV;
    }

    public void setPartidosCSV(String partidosCSV) {
        this.partidosCSV = partidosCSV;
    }

    public void addPartido(Partido e) {
        this.partidos.add(e);
    }

    public void removePartido(Partido e) {
        this.partidos.remove(e);
    }

    public Partido getPartido(int idPartido) {
        Partido encontrado = null;
        for (Partido eq : this.getPartidos()) {
            if (eq.getidPartido() == idPartido) {
                encontrado = eq;
                break;
            }
        }

        return encontrado;
    }

    @Override
    public String toString() {
        return "ListaPartidos{" + "partidos=" + partidos + '}';
    }

    public String listar() {
        String lista = "";
        for (Partido partido : partidos) {
            lista += "\n" + partido;
        }
        return lista;
    }
    public void cargarDeDB() {
        
      
 Connection conn = null;
        try {
           
            conn = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
            Statement stmt = conn.createStatement();
     
            String sql = "SELECT idPartido, IdEquipo1, IdEquipo2, golesEquipo1, golesEquipo2 FROM partidos";
            ResultSet rs = stmt.executeQuery(sql); 
            while (rs.next()) {
            
                System.out.println(rs.getInt("idPartido") + "\t"
                        + rs.getString("IdEquipo1") + "\t"
                        + rs.getString("IdEquipo2") + "\t"
                        + rs.getString("golesEquipo1") + "\t"
                        + rs.getString("golesEquipo2") + "\t");
                      
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

