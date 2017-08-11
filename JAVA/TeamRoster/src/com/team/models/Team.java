package com.team.models;
import java.util.ArrayList;

import com.team.models.Player;

public class Team {
    public String team_name;
    public ArrayList<Player> players;
    public static ArrayList<Team> list = new ArrayList<Team>();
    public Team(){
    		
    }
    
    public Team (String team_name){
        this.team_name = team_name;
        this.players = new ArrayList<Player>();
        list.add(this);
    }

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public ArrayList getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList players) {
		this.players = players;
	}
	
	public void kill() {
		list.remove(this);
	}
	
	public void killplayer(Integer thenumber) {
		players.remove(players.get(thenumber));
	}
}
