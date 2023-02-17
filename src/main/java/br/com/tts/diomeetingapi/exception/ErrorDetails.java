package br.com.tts.diomeetingapi.exception;

import lombok.AllArgsConstructor;

import java.util.Date;

/**
 * @author Tiago Luiz Fernandes
 */

@AllArgsConstructor
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}
