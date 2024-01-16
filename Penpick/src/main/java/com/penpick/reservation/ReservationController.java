package com.penpick.reservation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	private ReservationService reservationService;
	
	@GetMapping
	public String reservationList() {
		return "/reservation/list";
	}

	@GetMapping("/list")
	public ResponseEntity<List<Reservation>> getAllReservation() {
		List<Reservation> reservationList = null;
		try {
			reservationList = reservationService.getAllReservation();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(reservationList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reservation> getReservation(@PathVariable Integer id) {
		Reservation reservation = reservationService.getReservation(id);
		/*
		if (reservation == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorResponse("예약된 정보가 없습니다."));
		} */
		return ResponseEntity.ok(reservation);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Void> registerReservation(@RequestBody Reservation reservation) {
		reservationService.saveReservation(reservation);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
