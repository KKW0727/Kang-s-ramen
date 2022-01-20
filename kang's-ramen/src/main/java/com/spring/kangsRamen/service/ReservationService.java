package com.spring.kangsRamen.service;

import java.util.List;

import com.spring.kangsRamen.model.json.ReservationVo;

public interface ReservationService {

	public int InsertReservation(ReservationVo reservationVo);
	public List<ReservationVo> getAllReservation(int id);
	public int updatePayment(int id);
}
