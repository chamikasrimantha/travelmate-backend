package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.BookingDto;
import com.travelmate.travelmate.entity.BookingEntity;

@Service
public interface BookingService {
    BookingEntity createBooking(BookingDto bookingDto);
    List<BookingEntity> getAllBookings();
    BookingEntity getBookingsById(Long id);
    List<BookingEntity> getBookingsByUser(Long id);
    List<BookingEntity> getBookingsByProperty(Long id);
    BookingEntity deleteBooking(Long id);
}
