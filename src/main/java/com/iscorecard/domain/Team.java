package com.iscorecard.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Created by asabtharishi on 6/16/2015.
 */

@Entity
@Table(name = "TEAM")
public class Team extends Model {


    @Column(name = "PLAYER_ID")
    @OneToMany(targetEntity = Player.class, mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<Player>();
    
    @OneToOne
    @JoinColumn(name = "id")
    private Game game;

    public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Player> getPlayer() {
        return players;
    }

    public void setPlayer(List<Player> players) {
        this.players = players;
    }
}