package com.spring.kangsRamen.admin.model.dao;

import java.util.List;

import com.spring.kangsRamen.admin.model.dto.ReservationDto;
import com.spring.kangsRamen.admin.model.dto.SearchDto;

public interface AdminReservationDao {

	public List<ReservationDto> getReservation(SearchDto searchDto);
	public List<ReservationDto> getCanceledReservation(SearchDto searchDto);
}
