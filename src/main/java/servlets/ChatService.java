package servlets;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class ChatService {
    private Set<ChatWebSocket> sockets;

    public ChatService(){
        sockets = new ConcurrentSkipListSet<>();
    }


}
