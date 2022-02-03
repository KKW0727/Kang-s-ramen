package com.spring.kangsRamen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.kangsRamen.service.GameInfoService;

@Controller
public class IndexController {

	@Autowired
	private GameInfoService gameInfoService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		System.out.println(123);
		return "index/index";
	}

	@ResponseBody
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public Object getGameInfo() {
		return gameInfoService.getGameInfo();
	}
}
