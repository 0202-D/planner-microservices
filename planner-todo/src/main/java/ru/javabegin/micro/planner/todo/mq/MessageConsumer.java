package ru.javabegin.micro.planner.todo.mq;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import ru.javabegin.micro.planner.todo.service.TestDataService;

@Component
@EnableBinding(TodoBinding.class)
@AllArgsConstructor
public class MessageConsumer {
    private final TestDataService testDataService;
    @StreamListener(target = TodoBinding.INPUT_CHANNEL)
    public void initTestData(Long userId){
        testDataService.init(userId);
    }
}
