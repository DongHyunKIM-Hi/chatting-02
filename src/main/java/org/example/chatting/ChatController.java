package org.example.chatting;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.send")
    @SendTo("/sub/chat")
    public ChatMessage send(
        ChatMessage message,
        SimpMessageHeaderAccessor headerAccessor
    ) {
        String sessionId = headerAccessor.getSessionId();

        System.out.println("서버 수신 메시지");
        System.out.println("sessionId = " + sessionId);
        System.out.println("content   = " + message.getContent());

        return message;
    }
}

