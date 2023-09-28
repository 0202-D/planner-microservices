package ru.javabegin.micro.planner.utils.resttemplateandwebclient;

import org.springframework.stereotype.Component;

@Component
public interface IsExistChecker {
    boolean isUserExists(Long id);
}
