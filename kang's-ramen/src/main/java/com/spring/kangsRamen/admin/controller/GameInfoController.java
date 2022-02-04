package com.spring.kangsRamen.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.kangsRamen.admin.model.dto.GameInfoDto;
import com.spring.kangsRamen.admin.service.GameInfoService;

@Controller
public class GameInfoController {

	@Autowired
	private GameInfoService gameInfoService;

	@ResponseBody
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public Object getGameInfo() {
		return gameInfoService.getGameInfo();
	}

	@RequestMapping(value = "game/edit", method = RequestMethod.POST)
	public String updateGameInfo(GameInfoDto gameInfoDto) {
		if (gameInfoService.updateGameInfo(gameInfoDto) == 1) {
			return "redirect:/index";
		}
		return "redirect:/error";
	}

}
