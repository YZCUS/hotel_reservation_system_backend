package com.example.hotel.scheduler;

import com.example.hotel.model.Reservation;
import com.example.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReservationScheduler {
    @Autowired
    private ReservationRepository reservationRepository;

    @Scheduled(fixedRate = 60000) // 60 seconds
    public void cancelStalePendingReservations() {
        LocalDateTime fifteenMinutesAgo = LocalDateTime.now().minusMinutes(15);
        List<Reservation> staleReservations = reservationRepository.findByStatusAndCreatedTimeBefore("pending", fifteenMinutesAgo);

        for (Reservation reservation : staleReservations) {
            reservation.setStatus("cancelled");
            reservationRepository.save(reservation);
        }
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void updateConfirmedReservations(){
        List<Reservation> reservations = reservationRepository.findConfirmedAndPastReservations();
        for (Reservation reservation : reservations) {
            reservation.setStatus("completed");
            reservationRepository.save(reservation);
        }
    }
}
