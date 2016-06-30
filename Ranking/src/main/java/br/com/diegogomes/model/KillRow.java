package br.com.diegogomes.model;

import java.util.Date;

/**
 * 
 * @author Diego Gomes
 *
 */
public class KillRow {

	private String match;
    private Date date;
    private String deathPlayer;
    private String killerPlayer;

    public KillRow(String match, String killerPlayer, String deathPlayer, Date date) {
    	this.match = match;
        this.killerPlayer = killerPlayer;
        this.deathPlayer = deathPlayer;
        this.date = date;
    }

    /**
     * 
     * @return date
     */
	public Date getDate() {
		return date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 
	 * @return deathPlayer
	 */
	public String getDeathPlayer() {
		return deathPlayer;
	}

	/**
	 * 
	 * @param deathPlayer
	 */
	public void setDeathPlayer(String deathPlayer) {
		this.deathPlayer = deathPlayer;
	}

	/**
	 * 
	 * @return killerPlayer
	 */
	public String getKillerPlayer() {
		return killerPlayer;
	}

	/**
	 * 
	 * @param killerPlayer
	 */
	public void setKillerPlayer(String killerPlayer) {
		this.killerPlayer = killerPlayer;
	}

	/**
	 * 
	 * @return match
	 */
	public String getMatch() {
		return match;
	}

	/**
	 * 
	 * @param match
	 */
	public void setMatch(String match) {
		this.match = match;
	}

}
