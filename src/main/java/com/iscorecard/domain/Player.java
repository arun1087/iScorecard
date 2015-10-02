package com.iscorecard.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by asabtharishi on 6/16/2015.
 */

@Entity
@Table(name = "PLAYER")
public class Player extends Model {

    @Column(name = "PLAYER_STATS_ID")
    @OneToMany(targetEntity = PlayerStatsForMatch.class ,fetch = FetchType.LAZY, mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerStatsForMatch> playerStatsForMatch = new ArrayList<PlayerStatsForMatch>();
   
    @ManyToOne
    @JoinColumn(name = "id")
    private Team team;
    
   
    public Team getTeam() {
		return team;
	}
    
	public void setTeam(Team team) {
		this.team = team;
	}

	public List<PlayerStatsForMatch> getPlayerStatsForMatch() {
        return playerStatsForMatch;
    }

    public void setPlayerStatsForMatch(List<PlayerStatsForMatch> playerStatsForMatch) {
        this.playerStatsForMatch = playerStatsForMatch;
    }
}