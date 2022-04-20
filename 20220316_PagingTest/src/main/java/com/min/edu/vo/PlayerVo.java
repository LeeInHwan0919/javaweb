package com.min.edu.vo;

public class PlayerVo {
	private String player_name;
	private String team_id    ;
	private String position   ;
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "PlayerVo [player_name=" + player_name + ", team_id=" + team_id + ", position=" + position + "]";
	}
	
}
