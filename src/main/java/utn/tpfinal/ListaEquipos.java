
package utn.tpfinal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




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
    
    
    public Equipo getEquipo (int idEquipo) {
        
        Equipo encontrado = null;
       
        for (Equipo eq : this.getEquipos()) {
            
            if (eq.getIdEquipo() == idEquipo) {
           
                encontrado = eq;
                
                break;
            }
        }
        
        return encontrado;
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
    
    
    public void cargarDeArchivo() {
        
        String datosEquipo;
        
        String vectorEquipo[];
        
        Equipo equipo;
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File(this.getEquiposCSV()));
            sc.useDelimiter("\n");   
                
            while (sc.hasNext()) {
                
                datosEquipo = sc.next();
                 
                fila ++;
            
                if (fila == 1)
                    continue;              
                 
                
                vectorEquipo = datosEquipo.split(",");   
                
                
                int idEquipo = Integer.parseInt(vectorEquipo[0]);
                String nombre = vectorEquipo[1];
                String descripcion = vectorEquipo[2];
               
                equipo = new Equipo(idEquipo, nombre, descripcion);
               
                this.addEquipo(equipo);
            }
            
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       

    }

}


