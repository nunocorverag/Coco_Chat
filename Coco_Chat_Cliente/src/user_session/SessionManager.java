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

    public static void createSession(String username) {
        sessionData = new SessionData(username);
    }
    
    public static void closeSession()
    {
        if(sessionData != null)
        {
            invalidateSession();
        }
    }

    public static SessionData getSession() {
        return sessionData;
    }

    public static void invalidateSession() {
        sessionData = null;
    }
    
}


