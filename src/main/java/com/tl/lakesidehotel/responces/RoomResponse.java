package com.tl.lakesidehotel.responces;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class RoomResponse {
    private Long id;
    private String roomType;
    private BigDecimal price;
    private Boolean isBooked;
    private String photo;
    private List<BookingResponse> bookingResponses;

    public RoomResponse(Long id, String roomType, BigDecimal price) {
        this.id = id;
        this.roomType = roomType;
        this.price = price;
    }

    public RoomResponse(Long id, String roomType, BigDecimal price, Boolean isBooked, byte[] photoBytes, List<BookingResponse> bookingResponses) {
        this.id = id;
        this.roomType = roomType;
        this.price = price;
        this.isBooked = isBooked;
        this.photo = photoBytes != null ? Base64.encodeBase64String(photoBytes) : null;
        this.bookingResponses = bookingResponses;
    }
}
