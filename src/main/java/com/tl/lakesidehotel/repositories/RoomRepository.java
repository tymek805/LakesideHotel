package com.tl.lakesidehotel.repositories;

import com.tl.lakesidehotel.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT DISTINCT room.roomType FROM Room room")
    List<String> findDistinctRoomTypes();
}
