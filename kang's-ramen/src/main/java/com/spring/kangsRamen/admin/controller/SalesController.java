package com.spring.kangsRamen.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.kangsRamen.admin.service.SalesService;

@Controller
public class SalesController {

	@Autowired
	private SalesService salesService;

	@ResponseBody
	@RequestMapping(value = "/sales/{date}", method = RequestMethod.GET)
	public Object getSales(@PathVariable String date) {
		return salesService.getSales(date);
	}
}
