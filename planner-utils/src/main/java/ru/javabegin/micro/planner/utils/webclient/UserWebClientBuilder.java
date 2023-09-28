package ru.javabegin.micro.planner.utils.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.javabegin.micro.planner.entity.User;

@Component
public class UserWebClientBuilder {
    private static final String url = "http://localhost:8765/planner-users/user/";

    public boolean isUserExists(Long userId) {
        try {
            User user = WebClient.create(url)
                    .post()
                    .uri("id")
                    .bodyValue(userId)
                    .retrieve()
                    .bodyToFlux(User.class)
                    .blockFirst();
            if (user != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
