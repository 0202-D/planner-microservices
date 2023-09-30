package ru.javabegin.micro.planner.utils.resttemplateandwebclient;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.javabegin.micro.planner.entity.User;

@Component
@Primary
public class UserWebClientBuilder implements IsExistChecker {
    private static final String url = "http://localhost:8765/planner-users/user/";
    private static final String dataUrl = "http://localhost:8765/planner-todo/data/";

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
    public Flux<User> userExistsAsync(Long userId) {
        return WebClient.create(url)
                .post()
                .uri("id")
                .bodyValue(userId)
                .retrieve()
                .bodyToFlux(User.class);
    }

    public Flux<Boolean> initUserData(Long userId){
       Flux<Boolean> fluxUser = WebClient.create(dataUrl)
               .post()
               .uri("init")
               .bodyValue(userId)
               .retrieve()
               .bodyToFlux(Boolean.class);
       return  fluxUser;
    }
}
