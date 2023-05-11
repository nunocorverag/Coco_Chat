/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db_conection_package;

/**
 *
 * @author gnuno
 */
public class Pertenencias_Grupo {
    public int id_pertenencia_grupo;
    public int grupo;
    public int usuario_perteneciente;
    
    public Pertenencias_Grupo()
    {
        id_pertenencia_grupo = 0;
        grupo = 0;
        usuario_perteneciente = 0;
    }
    
    public Pertenencias_Grupo(int grupo, int usuario_perteneciente)
    {
        this.id_pertenencia_grupo = id_pertenencia_grupo;
        this.grupo = grupo;
        this.usuario_perteneciente = usuario_perteneciente;
    }
}

