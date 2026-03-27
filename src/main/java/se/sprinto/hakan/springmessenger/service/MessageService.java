package se.sprinto.hakan.springmessenger.service;

import org.springframework.stereotype.Service;
import se.sprinto.hakan.springmessenger.messaging.Messenger;
import se.sprinto.hakan.springmessenger.model.Message;

import java.util.Map;

@Service
public class MessageService {
    private final Map<String, Messenger> messengers;

    public MessageService(Map<String, Messenger> messengers) {
        this.messengers = messengers;
    }

    public void send(Message message) {
        for (String type : messengers.keySet()) {
            if (message.getType().equals(type)) {
                Messenger messenger = messengers.get(type);
                messenger.send(message);
                return;
            }
        }
    }
}
