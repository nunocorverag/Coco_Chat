package returned_models;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gnuno
 */
public class SolicitarMensajesUsuario  implements Serializable {
    public String usuarioLoggeado;
    public String usuarioSeleccionado;

    public SolicitarMensajesUsuario(String usuarioLoggeado, String usuarioSeleccionado)
    {
        this.usuarioLoggeado = usuarioLoggeado;
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

}
