/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db_conection_package;

/**
 *
 * @author gnuno
 */
public class Grupo {
    public int id_grupo;
    public String nombre_grupo;
    
    public Grupo()
    {
        id_grupo = 0;
        nombre_grupo = "";
    }
    
    public Grupo(String nombre_grupo)
    {
        this.id_grupo = id_grupo;
        this.nombre_grupo = nombre_grupo;
    }
}

