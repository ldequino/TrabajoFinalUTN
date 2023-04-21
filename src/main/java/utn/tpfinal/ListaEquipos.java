
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


public class ListaEquipos {
 
    private List<Equipo> equipos;
    private String equiposCSV;


    public ListaEquipos(List<Equipo> equipos, String equiposCSV) {
        this.equipos = equipos;
        this.equiposCSV = equiposCSV;
    }
    
    public ListaEquipos() {
        this.equipos = new ArrayList<Equipo>();
        this.equiposCSV = "equipos.csv";
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public String getEquiposCSV() {
        return equiposCSV;
    }

    public void setEquiposCSV(String equiposCSV) {
        this.equiposCSV = equiposCSV;
    }
    
  
    public void addEquipo(Equipo e) {
        this.equipos.add(e);
    }
    public void removeEquipo(Equipo e) {
        this.equipos.remove(e);
    }
    
    

    @Override
    public String toString() {
        return "ListaEquipos{" + "equipos=" + equipos + '}';
    }

    public String listar() {
        String lista = "";
        for (Equipo equipo: equipos) {
            lista += "\n" + equipo;
        }           
        return lista;
    }
    
    
    public void cargarDeDB() {
        
      
 Connection conn = null;
        try {
           
            conn = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
            Statement stmt = conn.createStatement();
     
            String sql = "SELECT idEquipo, Nombre, Descripcion FROM equipos";
            ResultSet rs = stmt.executeQuery(sql); 
            while (rs.next()) {
            
                System.out.println(rs.getInt("idEquipo") + "\t"
                        + rs.getString("Nombre") + "\t"
                        + rs.getString("Descripcion") + "\t");
                     
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

    Equipo getEquipo(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}



