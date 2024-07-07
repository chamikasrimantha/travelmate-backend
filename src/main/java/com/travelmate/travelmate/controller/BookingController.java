package com.travelmate.travelmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelmate.travelmate.dto.BookingDto;
import com.travelmate.travelmate.entity.BookingEntity;
import com.travelmate.travelmate.service.BookingService;


@RestController
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookings")
    public ResponseEntity<BookingEntity> createBooking(@RequestBody BookingDto bookingDto) {
        try {
            return ResponseEntity.status(200).body(bookingService.createBooking(bookingDto));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingEntity>> getAllBookings(){
        List<BookingEntity> bookingEntities = bookingService.getAllBookings();
        if (bookingEntities!=null) {
            return ResponseEntity.status(200).body(bookingEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<BookingEntity> getBookingsById(@PathVariable Long id){
        BookingEntity bookingEntity = bookingService.getBookingsById(id);
        if (bookingEntity!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(bookingEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/users/{id}/bookings")
    public ResponseEntity<List<BookingEntity>> getBookingsByUser(@PathVariable Long id){
        return ResponseEntity.ok().body(bookingService.getBookingsByUser(id));
    }

    @GetMapping("/properties/{id}/bookings")
    public ResponseEntity<List<BookingEntity>> getBookingsByProperty(@PathVariable Long id){
        return ResponseEntity.ok().body(bookingService.getBookingsByProperty(id));
    }

    @DeleteMapping("/bookings/{id}")
    public BookingEntity deleteBooking(@PathVariable Long id){
        return bookingService.deleteBooking(id);
    }

}
