package com.spring.kangsRamen.admin.model.dto;

public class GameInfoDto {

	private String my_team;
	private String opponent_team;
	private int my_team_score;
	private int opponent_team_score;
	private String game_info_dtl_url;

	public String getMy_team() {
		return my_team;
	}

	public void setMy_team(String my_team) {
		this.my_team = my_team;
	}

	public String getOpponent_team() {
		return opponent_team;
	}

	public void setOpponent_team(String opponent_team) {
		this.opponent_team = opponent_team;
	}

	public int getMy_team_score() {
		return my_team_score;
	}

	public void setMy_team_score(int my_team_score) {
		this.my_team_score = my_team_score;
	}

	public int getOpponent_team_score() {
		return opponent_team_score;
	}

	public void setOpponent_team_score(int opponent_team_score) {
		this.opponent_team_score = opponent_team_score;
	}

	public String getGame_info_dtl_url() {
		return game_info_dtl_url;
	}

	public void setGame_info_dtl_url(String game_info_dtl_url) {
		this.game_info_dtl_url = game_info_dtl_url;
	}

	@Override
	public String toString() {
		return "GameInfoDto [my_team=" + my_team + ", opponent_team=" + opponent_team + ", my_team_score="
				+ my_team_score + ", opponent_team_score=" + opponent_team_score + ", game_info_dtl_url="
				+ game_info_dtl_url + "]";
	}

}
