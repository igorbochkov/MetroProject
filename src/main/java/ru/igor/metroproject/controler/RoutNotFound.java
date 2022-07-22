package ru.igor.metroproject.controler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.igor.metroproject.exception.NotFoundEntity;

@ControllerAdvice
public class RoutNotFound {

    @ResponseBody
    @ExceptionHandler(NotFoundEntity.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String RoutNotFoundHandler(NotFoundEntity notFoundEntity) {
        return notFoundEntity.getMessage();
    }

}
