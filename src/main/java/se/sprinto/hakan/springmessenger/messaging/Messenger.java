package se.sprinto.hakan.springmessenger.messaging;

import se.sprinto.hakan.springmessenger.model.Message;

public interface Messenger {
    void send(Message message);
}
