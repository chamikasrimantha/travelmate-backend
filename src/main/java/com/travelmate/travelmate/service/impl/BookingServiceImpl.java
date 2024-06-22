package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.BookingDto;
import com.travelmate.travelmate.entity.BookingEntity;
import com.travelmate.travelmate.entity.PropertyEntity;
import com.travelmate.travelmate.entity.UserEntity;
import com.travelmate.travelmate.repository.BookingRepository;
import com.travelmate.travelmate.repository.PropertyRepository;
import com.travelmate.travelmate.repository.UserRepository;
import com.travelmate.travelmate.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public BookingEntity createBooking(BookingDto bookingDto) {
        UserEntity userEntity = userRepository.findById(bookingDto.getUserId()).orElse(null);
        PropertyEntity propertyEntity = propertyRepository.findById(bookingDto.getPropertyId()).orElse(null);
        if (userEntity!=null && propertyEntity!=null) {
            BookingEntity bookingEntity = new BookingEntity();
            bookingEntity.setCheckinDate(bookingDto.getCheckinDate());
            bookingEntity.setCheckoutDate(bookingDto.getCheckoutDate());
            bookingEntity.setTotalPrice(bookingDto.getTotalPrice());
            bookingEntity.setFirstName(bookingDto.getFirstName());
            bookingEntity.setLastName(bookingDto.getLastName());
            bookingEntity.setEmail(bookingDto.getEmail());
            bookingEntity.setAddress(bookingDto.getAddress());
            bookingEntity.setPhoneNo(bookingDto.getPhoneNo());
            bookingEntity.setBookingFor(bookingDto.getBookingFor());
            bookingEntity.setRentingAdditionals(bookingDto.getRentingAdditionals());
            bookingEntity.setSpecialRequests(bookingDto.getSpecialRequests());
            bookingEntity.setArrivalTime(bookingDto.getArrivalTime());
            bookingEntity.setPaymentMethod(bookingDto.getPaymentMethod());
            bookingEntity.setUserEntity(userEntity);
            bookingEntity.setPropertyEntity(propertyEntity);
            // email
            // receipt
            return bookingRepository.save(bookingEntity);
        } else {
            return null;
        }
    }

    @Override
    public BookingEntity deleteBooking(Long id) {
        BookingEntity existingBooking = bookingRepository.findById(id).orElse(null);
        if (existingBooking!=null) {
            bookingRepository.delete(existingBooking);
            return existingBooking;
        } else {
            return null;
        }
    }

    @Override
    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingEntity getBookingsById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookingEntity> getBookingsByProperty(Long id) {
        PropertyEntity propertyEntity = propertyRepository.findById(id).orElse(null);
        if (propertyEntity!=null) {
            return bookingRepository.findBookingsByProperty(propertyEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<BookingEntity> getBookingsByUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity!=null) {
            return bookingRepository.findBookingsByUser(userEntity);
        } else {
            return null;
        }
    }

}
