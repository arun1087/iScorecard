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
import javax.validation.constraints.NotNull;

/**
 * Created by asabtharishi on 6/16/2015.
 */

@Entity
@Table(name = "PLAYER_STATS")
public class PlayerStatsForMatch extends Model {

    @OneToMany(targetEntity = BowlingStatsForMatch.class, fetch = FetchType.LAZY, mappedBy = "playerStatsForMatch", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "BOWLING_STATS_ID")
    private List<BowlingStatsForMatch> bowlingStatsForMatch = new ArrayList<BowlingStatsForMatch>();

    @NotNull
    @OneToMany(targetEntity = BattingStatsForMatch.class, fetch = FetchType.LAZY, mappedBy = "playerStatsForMatch", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "BOWLING_STATS_ID")
    private List<BattingStatsForMatch> battingStatsForMatch = new ArrayList<BattingStatsForMatch>();
    
    @ManyToOne
    @JoinColumn(name = "id")
    private Player player;

    public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<BowlingStatsForMatch> getBowlingStatsForMatch() {
        return bowlingStatsForMatch;
    }

    public void setBowlingStatsForMatch(List<BowlingStatsForMatch> bowlingStatsForMatch) {
        this.bowlingStatsForMatch = bowlingStatsForMatch;
    }

    public List<BattingStatsForMatch> getBattingStatsForMatch() {
        return battingStatsForMatch;
    }

    public void setBattingStatsForMatch(List<BattingStatsForMatch> battingStatsForMatch) {
        this.battingStatsForMatch = battingStatsForMatch;
    }
}