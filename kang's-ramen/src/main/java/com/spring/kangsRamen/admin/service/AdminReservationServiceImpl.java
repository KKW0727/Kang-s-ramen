package com.spring.kangsRamen.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kangsRamen.admin.model.dao.AdminReservationDao;
import com.spring.kangsRamen.admin.model.dto.ReservationDto;
import com.spring.kangsRamen.admin.model.dto.SearchDto;

@Service
public class AdminReservationServiceImpl implements AdminReservationService {

	@Autowired
	private AdminReservationDao adminReservationDao;

	@Override
	public List<ReservationDto> getReservation(SearchDto searchDto) {

		return adminReservationDao.getReservation(searchDto);
	}

	@Override
	public List<ReservationDto> getCanceledReservation(SearchDto searchDto) {
		return adminReservationDao.getCanceledReservation(searchDto);
	}

}
