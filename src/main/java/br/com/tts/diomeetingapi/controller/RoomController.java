package br.com.tts.diomeetingapi.controller;

import br.com.tts.diomeetingapi.exception.ResourceNotFoundException;
import br.com.tts.diomeetingapi.model.Room;
import br.com.tts.diomeetingapi.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tiago Luiz Fernandes
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomRepository roomRepository;

    @GetMapping()
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Room room = verify(id);

        return ResponseEntity.ok(room);
    }

    @PostMapping()
    public ResponseEntity<Room> createRoom(@Valid @RequestBody Room room) {

        Room saved = roomRepository.save(room);

        return ResponseEntity.ok(saved);
    }

    @PutMapping("{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Room room) throws ResourceNotFoundException {

        Room ret = verify(id);

        ret.setName(room.getName());
        ret.setDate(room.getDate());
        ret.setStartHour(room.getStartHour());
        ret.setEndHour(room.getEndHour());

        roomRepository.save(ret);

        return ResponseEntity.ok(ret);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Room room = verify(id);

        roomRepository.delete(room);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", true);

        return response;

    }

    private Room verify(Long id) throws ResourceNotFoundException {
        return roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
    }

}
