package ru.javabegin.micro.planner.todo.feign;

import com.google.common.io.CharStreams;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

@Component
public class FeignExceptionsHandler implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 406: {
                return new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, readMessage(response));
            }
        }
        return null;
    }

    private String readMessage(Response response) {
        String message;
        Reader reader= null;
        try  {
            reader = response.body().asReader(Charset.defaultCharset());
            message = CharStreams.toString(reader);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return message;
    }
}
