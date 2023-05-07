/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user_session;
/**
 *
 * @author PABLOPC
 */
public class SessionManager {
    private static SessionData sessionData;

    public static void createSession(int idUsuario) {
        sessionData = new SessionData(idUsuario);
    }

    public static SessionData getSession() {
        return sessionData;
    }

    public static void invalidateSession() {
        sessionData = null;
    }
}


