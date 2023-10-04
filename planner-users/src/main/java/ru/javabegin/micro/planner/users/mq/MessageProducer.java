package ru.javabegin.micro.planner.users.mq;

import lombok.RequiredArgsConstructor;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(TodoBinding.class)
@RequiredArgsConstructor
public class MessageProducer {
    private final TodoBinding todoBinding;

    public void initUserData(Long userId){
        Message message = MessageBuilder.withPayload(userId).build();
        todoBinding.todoOutputChannel().send(message);
    }
}
