package com.penpick.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	public List<Reservation> getAllReservation() {
		return reservationRepository.findAll();
	}
	
	public Reservation getReservation(Integer id) {
		return reservationRepository.getById(id);
	}
	
	public void saveReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}
}
