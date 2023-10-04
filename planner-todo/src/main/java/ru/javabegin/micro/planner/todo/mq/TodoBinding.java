package ru.javabegin.micro.planner.todo.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface TodoBinding {
    String INPUT_CHANNEL = "todoInputPutChannel";
    @Input(INPUT_CHANNEL)
    MessageChannel todoInputChannel();
}
