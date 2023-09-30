package ru.javabegin.micro.planner.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.javabegin.micro.planner.entity.Category;
import ru.javabegin.micro.planner.entity.Priority;
import ru.javabegin.micro.planner.entity.Task;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class TestDataService {
    private final TaskService taskService;
    private final CategoryService categoryService;
    private final PriorityService priorityService;

    public ResponseEntity<Boolean> init(Long userId) {
        Priority priority1 = new Priority();
        priority1.setColor("#ffff");
        priority1.setTitle("важный");
        priority1.setUserId(userId);

        Priority priority2 = new Priority();
        priority2.setColor("#ffe");
        priority2.setTitle("неважный");
        priority2.setUserId(userId);
        priorityService.add(priority1);
        priorityService.add(priority2);

        Category category1 = new Category();
        category1.setTitle("family");
        category1.setUserId(userId);
        categoryService.add(category1);

        Category category2 = new Category();
        category2.setTitle("work");
        category2.setUserId(userId);
        categoryService.add(category2);

        Task task1 = new Task();
        task1.setTitle("to love");
        task1.setCategory(category1);
        task1.setTaskDate(new Date(1212121212121L));
        task1.setPriority(priority1);
        task1.setUserId(userId);
        task1.setCompleted(true);

        Task task = new Task();
        task.setTitle("to work");
        task.setCategory(category2);
        task.setTaskDate(new Date(1212121212121L));
        task.setPriority(priority2);
        task.setUserId(userId);
        task.setCompleted(false);

        taskService.add(task);
        taskService.add(task1);

        return ResponseEntity.ok(true);


    }
}
