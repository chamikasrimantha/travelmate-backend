package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.BookingDto;
import com.travelmate.travelmate.entity.BookingEntity;
import com.travelmate.travelmate.entity.PropertyEntity;
import com.travelmate.travelmate.entity.UserEntity;
import com.travelmate.travelmate.repository.BookingRepository;
import com.travelmate.travelmate.repository.PropertyRepository;
import com.travelmate.travelmate.repository.UserRepository;
import com.travelmate.travelmate.service.BookingService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public BookingEntity createBooking(BookingDto bookingDto) {
        UserEntity userEntity = userRepository.findById(bookingDto.getUserId()).orElse(null);
        PropertyEntity propertyEntity = propertyRepository.findById(bookingDto.getPropertyId()).orElse(null);
        if (userEntity != null && propertyEntity != null) {
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
            bookingEntity.setAirportShuttle(bookingDto.getAirportShuttle());
            bookingEntity.setRentingCar(bookingDto.getRentingCar());
            bookingEntity.setRentingBicycle(bookingDto.getRentingBicycle());
            bookingEntity.setSpecialRequests(bookingDto.getSpecialRequests());
            bookingEntity.setArrivalTime(bookingDto.getArrivalTime());
            bookingEntity.setPaymentMethod(bookingDto.getPaymentMethod());
            bookingEntity.setUserEntity(userEntity);
            bookingEntity.setPropertyEntity(propertyEntity);
            // email
            // receipt
            // return bookingRepository.save(bookingEntity);

            BookingEntity done = bookingRepository.save(bookingEntity);
            try {
                sendBookingSuccessEmail(done);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return done;
        } else {
            return null;
        }
    }

    private void sendBookingSuccessEmail(BookingEntity bookingEntity) throws MessagingException {
        // MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        // String htmlMsg = "<div style='font-family: Arial, sans-serif; max-width:
        // 600px; margin: auto; padding: 20px; border: 1px solid #ccc;'>"
        // +
        // "<h2 style='color: #4CAF50;'>Booking success with TravelMate.lk</h2>" +
        // "<p>Dear " + bookingEntity.getFirstName() + "" + bookingEntity.getLastName()
        // + ",</p>" +
        // "<p>Your booking was successful with <strong>" +
        // bookingEntity.getPropertyEntity().getName()
        // + "</strong></p>" +
        // "<p>Here's what you can do next:</p>" +
        // "<ul>" +
        // "<li><a href='#' style='color: #4CAF50;'>View Receipt</a></li>" +
        // "<li><a href='#' style='color: #4CAF50;'>Download Receipt</a></li>" +
        // "<li><a href='#' style='color: #4CAF50;'>Contact support</a></li>" +
        // "</ul>" +
        // "<p>If you have any questions, feel free to visit our <a href='#'
        // style='color: #4CAF50;'>help center</a>.</p>"
        // +
        // "<p>Best regards,<br>TravelMate Team</p>" +
        // "<hr>" +
        // "<p style='font-size: 12px; color: #777;'>This is an automated message,
        // please do not reply.</p>" +
        // "</div>";

        // helper.setTo(bookingEntity.getEmail());
        // helper.setSubject("Booking success");
        // helper.setText(htmlMsg, true);
        // helper.setFrom("tech1234music@gmail.com");

        // javaMailSender.send(mimeMessage);
    }

    @Override
    public BookingEntity deleteBooking(Long id) {
        BookingEntity existingBooking = bookingRepository.findById(id).orElse(null);
        if (existingBooking != null) {
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
        if (propertyEntity != null) {
            return bookingRepository.findBookingsByProperty(propertyEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<BookingEntity> getBookingsByUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            return bookingRepository.findBookingsByUser(userEntity);
        } else {
            return null;
        }
    }

}
