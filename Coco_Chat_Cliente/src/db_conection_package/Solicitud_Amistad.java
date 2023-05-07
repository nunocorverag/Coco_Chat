/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db_conection_package;

/**
 *
 * @author gnuno
 */
public class Solicitud_Amistad {
    public int id_solicitud_amistad;
    public int remitente_solicitud_amistad;
    public int destinatario_solicitud_amistad;
    
    public Solicitud_Amistad()
    {
        id_solicitud_amistad = 0;
        remitente_solicitud_amistad = 0;
        destinatario_solicitud_amistad = 0;
    }
    
    public Solicitud_Amistad(int remitente_solicitud_amistad, int destinatario_solicitud_amistad)
    {
        this.id_solicitud_amistad = id_solicitud_amistad;
        this.remitente_solicitud_amistad = remitente_solicitud_amistad;
        this.destinatario_solicitud_amistad = destinatario_solicitud_amistad;
    }
}
