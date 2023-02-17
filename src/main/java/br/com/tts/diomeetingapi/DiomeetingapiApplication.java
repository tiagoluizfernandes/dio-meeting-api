package br.com.tts.diomeetingapi;

import br.com.tts.diomeetingapi.exception.ResourceNotFoundException;
import br.com.tts.diomeetingapi.model.Room;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiomeetingapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DiomeetingapiApplication.class, args);
	}
}
