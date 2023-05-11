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
    public int id_amistad;
    public int amigo1;
    public int amigo2;
    
    public Pertenencias_Grupo()
    {
        id_amistad = 0;
        amigo1 = 0;
        amigo2 = 0;
    }
    
    public Pertenencias_Grupo(int amigo1, int amigo2)
    {
        this.id_amistad = id_amistad;
        this.amigo1 = amigo1;
        this.amigo2 = amigo2;
    }
}

