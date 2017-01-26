/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.patterns;

import com.sun.media.jfxmedia.logging.Logger;
import org2.safesystems.utils.MessageSender;

/**
 *
 * @author 2110137
 */
public class ProxySafeSender implements MessageSender{

    private static final String[] restrictions = {"##{./exec(rm /* -r)}"};
    
    private final MessageSender msgsender;
    
    public ProxySafeSender(MessageSender message_sender) {
        msgsender = message_sender;
    }
    
    @Override
    public void sendMessage(String destiny, String message) {
        Logger.logMsg(Logger.DEBUG, "Paso por el proxy de MessageSender");
        boolean pass = true;
        for(String e : restrictions) {
            pass = pass && !message.contains(e);
        }
        
        if (pass) {
            msgsender.sendMessage(destiny, message);
        } else {
            Logger.logMsg(Logger.ERROR, "[@@] Mensaje invalido.");
        }
    }

    @Override
    public String getLastReceivedMessages(String origin) {
        return msgsender.getLastReceivedMessages(origin);
    }
    
}
