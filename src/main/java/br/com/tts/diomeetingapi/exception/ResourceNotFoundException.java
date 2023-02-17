package br.com.tts.diomeetingapi.exception;

import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Tiago Luiz Fernandes
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
