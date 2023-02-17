package br.com.tts.diomeetingapi.repository;

import br.com.tts.diomeetingapi.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tiago Luiz Fernandes
 */

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
