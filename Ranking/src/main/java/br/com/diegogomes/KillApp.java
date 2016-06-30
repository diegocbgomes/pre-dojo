package br.com.diegogomes;

import br.com.diegogomes.control.Controller;
import br.com.diegogomes.control.MatchesReader;
import br.com.diegogomes.model.Ranking;

/**
 * 
 * @author diego
 *
 */
public class KillApp {

	private static String LOG_PATH = "Matches.log";

	public static void main(String args[]) {

		Controller game = new Controller();

		try {
			MatchesReader reader = new MatchesReader(LOG_PATH);

			while (reader.hasNextLogLine()) {
				game.updateRanking(reader.readNextRow());
			}
		} catch (Exception e) {
			System.err.println("Error in application");
		}

		for (Ranking r : game.getRanking()) {
			r.printRanking();
		}

	}

}
