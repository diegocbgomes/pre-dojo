package br.com.diegogomes.control;

import java.util.*;

import br.com.diegogomes.model.KillRow;
import br.com.diegogomes.model.Player;
import br.com.diegogomes.model.Ranking;

/**
 * Created by carloshager on 9/16/15.
 */
public class Controller {

    private static final String IGNORED_PLAYER = "<WORLD>";

    private Map<String, Map<String,Player>> matches = new HashMap<String, Map<String,Player>>();

    public void updateRanking(KillRow row){

        if (row == null){
            return;
        }
        
        if(!this.matches.containsKey(row.getMatch())) {
        	this.matches.put(row.getMatch(), new HashMap<String, Player>());
        }

        updateDeathPlayer(row.getMatch(), row.getDeathPlayer());

        if (!row.getKillerPlayer().contains(IGNORED_PLAYER)) {
            updateKillerPlayer(row.getMatch(), row.getKillerPlayer());
        }

    }

    private void updateDeathPlayer(String match, String name) {
        checkAndGetPlayerFromMap(match, name).addDeaths();;
    }

    private void updateKillerPlayer(String match, String name){
        checkAndGetPlayerFromMap(match, name).addKills();;
    }

    private Player checkAndGetPlayerFromMap(String match, String name){
        Player player = this.matches.get(match).get(name);
        if(player == null){
            player = new Player(name);
            this.matches.get(match).put(name,player);
        }
        return player;
    }

    public List<Ranking> getRanking(){
    	List<Ranking> rankings = new ArrayList<Ranking>();
    	
    	for(String match: this.matches.keySet()) {
    		rankings.add(new Ranking(match, new ArrayList<Player>(this.matches.get(match).values())));
    	}
    	
    	
        return rankings;
    }

}