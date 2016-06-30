package br.com.diegogomes.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Diego Gomes
 *
 */
public class Player implements Comparable<Player>{
	
	private final String name;
	private Integer kills;
	private Integer deaths;

	public Player(String name) throws IllegalArgumentException {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("Invalid Player Name");
		}
		this.name = name.trim();
		kills = 0;
		deaths = 0;
	}

	/**
	 * 
	 * @return player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return kills numbers
	 */
	public Integer getKills() {
		return kills;
	}

	/**
	 * 
	 * add kills
	 */
	public void addKills() {
		this.kills++;
	}

	/**
	 * 
	 * @return death numbers
	 */
	public Integer getDeaths() {
		return deaths;
	}

	/**
	 * 
	 * add deaths
	 */
	public void addDeaths() {
		this.deaths++;
	}

	/**
	 * compare kills
	 */
	public int compareTo(Player p) {
        return Comparators.KILLS.compare(this, p);
    }
	
	/**
	 * 
	 * @author Diego Gomes
	 * Classe interna para outros tipos de comparações
	 */
	public static class Comparators {

        public static Comparator<Player> KILLS = new Comparator<Player>() {
            public int compare(Player p1, Player p2) {
            	if(p1.getKills() != p2.getKills()) {
        			return p2.getKills().compareTo(p1.getKills());
        		} else {
        			return p1.getDeaths().compareTo(p2.getDeaths());
        		}
            }
        };
    }

}