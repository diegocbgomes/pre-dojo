package br.com.diegogomes.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.diegogomes.model.KillRow;

/**
 * 
 * @author Diego Gomes
 *
 */
public class ParseKillRow {

	private String matchNumber;

	public KillRow parseFromString(String row) throws Exception {

		if (row == null || row.trim().length() == 0) {
			return null;
		}

		if (row.contains("has started") || row.contains("has ended")) {
			this.matchNumber = parseMatch(row);
			return null;
		}

		return new KillRow(this.matchNumber, this.parseKillerPlayer(row), this.parseDeathPlayer(row),
				this.parseDate(row));
	}

	/**
	 * 
	 * @return Date
	 */
	private Date parseDate(String row) throws Exception {

		String dateStr = row.substring(0, 19);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		try {
			sdf.parse(dateStr);
		} catch (ParseException e) {
			throw new Exception("Error in parse log", e);
		}
		return null;
	}

	/**
	 * Carrega nome do player que matou
	 * 
	 * @param row
	 * @return name
	 */
	private String parseKillerPlayer(String row) throws Exception {
		try {
			return row.substring(22, row.indexOf("killed")).trim();
		} catch (Exception e) {
			throw new Exception("Error in parse log", e);
		}
	}

	/**
	 * Carrega nome do player que foi morto
	 *
	 * @param row
	 * @return name
	 */
	private String parseDeathPlayer(String row) throws Exception {
		String indexEndKey = row.contains(" by ") ? " by " : " using ";
		try {
			return row.substring(row.indexOf(" killed ") + 8, row.lastIndexOf(indexEndKey)).trim();
		} catch (Exception e) {
			throw new Exception("Error in parse log", e);
		}
	}

	private String parseMatch(String row) throws Exception {
		try {
			return row.substring(row.indexOf(" match ") + 7, row.indexOf(" has ")).trim();
		} catch (Exception e) {
			throw new Exception("Error in parse log", e);
		}
	}

}