package ru.javabegin.micro.planner.utils.resttemplate;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.javabegin.micro.planner.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class UserRestBuilder {
    private static final String url = "http://localhost:8765/planner-users/user/";

    public boolean isExists(long userIdd) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Long> request = new HttpEntity<>(userIdd);
        ResponseEntity<User> response = null;
        try {
            response = restTemplate.exchange(url + "/id", HttpMethod.POST, request, User.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return true;
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

}
