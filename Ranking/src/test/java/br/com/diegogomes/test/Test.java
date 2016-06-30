package br.com.diegogomes.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.diegogomes.control.Controller;
import br.com.diegogomes.control.MatchesReader;
import br.com.diegogomes.model.KillRow;
import br.com.diegogomes.model.Player;
import br.com.diegogomes.model.Ranking;

import java.util.Date;

/**
 * 
 * @author Diego Gomes
 *
 */
public class Test {


    private Controller controller;

    @Before
    public void setUp(){
        this.controller = new Controller();

    }

    @Test
    public void printCurrentRank(){
        prepareRankToTest();
        for (Ranking r : controller.getRanking()) {
			r.printRanking();
		}
    }

    @Test
    public void getWinner(){

        prepareRankToTest();
        Player winner = this.controller.getRanking().get(0).getWinner();

        Assert.assertEquals("DIEGO", winner.getName());

    }


    private void prepareRankToTest(){

        this.controller.updateRanking(new KillRow("121", "DIEGO", "PAULO", new Date()));
        this.controller.updateRanking(new KillRow("121", "<WORLD>", "PAULO", new Date()));
        this.controller.updateRanking(new KillRow("121", "CARLOS", "PAULO", new Date()));
        this.controller.updateRanking(new KillRow("121", "DIEGO", "PAULO", new Date()));
        

    }

}