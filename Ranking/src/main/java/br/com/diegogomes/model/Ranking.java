package br.com.diegogomes.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Diego Gomes
 *
 */
public class Ranking {

	private String match;
	
    private List<Player> players;

    public Ranking(String match, List<Player> players) {
    	this.match = match;
        this.players = players;
    }

    /**
     * Mostra ranking por kills
     */
    public void printRanking() {

    	Collections.sort(players); 
    	System.out.println("Match: " + match);
    	for(Player p: players) {
    		System.out.println("Name: " + p.getName() + " | Kills: " + p.getKills() + " | Deaths: " + p.getDeaths());
    	}

    }

    /**
     * 
     * @return Ranking
     */
    public List<Player> getRanking() {
    	Collections.sort(players);
        return players;
    }

    /**
     * 
     * @return Winner
     */
    public Player getWinner() {
    	Collections.sort(players);
        return players.get(0);
    }

}
