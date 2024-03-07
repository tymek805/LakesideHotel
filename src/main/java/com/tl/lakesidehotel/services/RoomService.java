package com.tl.lakesidehotel.services;

import com.tl.lakesidehotel.models.Room;
import com.tl.lakesidehotel.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService {
    private final RoomRepository roomRepository;

    @Override
    public Room addNewRoom(MultipartFile photo, String roomType, BigDecimal price) throws SQLException, IOException {
        Room room = new Room();
        room.setRoomType(roomType);
        room.setPrice(price);
        if (!photo.isEmpty()) {
            room.setPhoto(new SerialBlob(photo.getBytes()));
        }

        return roomRepository.save(room);
    }

    @Override
    public List<String> getAllRoomTypes() {
        return roomRepository.findDistinctRoomTypes();
    }
}
