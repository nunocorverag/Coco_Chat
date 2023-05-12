/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db_conection_package;

import java.io.Serializable;

/**
 *
 * @author gnuno
 */
public class Grupo implements Serializable{
    public int id_grupo;
    public String nombre_grupo;
    public int creador_grupo;
    
    public Grupo()
    {
        id_grupo = 0;
        nombre_grupo = "";
        creador_grupo = 0;
    }
    
    public Grupo(String nombre_grupo, int creador_grupo)
    {
        this.id_grupo = id_grupo;
        this.nombre_grupo = nombre_grupo;
        this.creador_grupo = creador_grupo;
    }
}