package com.tl.lakesidehotel.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomType;
    private BigDecimal price;
    private Boolean isBooked = false;

    @Lob
    private Blob photo;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Room() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        if (bookings == null)
            bookings = new ArrayList<>();

        bookings.add(booking);
        booking.setRoom(this);
        isBooked = true;
        booking.setBookingConfirmationCode(RandomStringUtils.randomNumeric(10));
    }
}
