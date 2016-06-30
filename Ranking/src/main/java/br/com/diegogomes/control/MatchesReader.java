package br.com.diegogomes.control;

import br.com.diegogomes.model.KillRow;

import java.io.*;

/**
 * 
 * @author Diego Gomes
 *
 */
public class MatchesReader {

    private BufferedReader br;
    private ParseKillRow parseKillRow = new ParseKillRow();

    public MatchesReader(String file) throws Exception {
        try {
            this.br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
        	throw new Exception("Error in log", ex);
        }
    }

    public void close() throws Exception{
        try {
            if (this.br != null) {
                this.br.close();
            }
        } catch (IOException e) {
            throw new Exception("Error in log", e);
        }
    }

    public boolean hasNextLogLine() throws Exception{
        try {
            return br.ready();
        } catch (IOException e) {
        	throw new Exception("Error in log reader");
        }
    }

    public KillRow readNextRow() throws Exception{
       return parseKillRow.parseFromString(br.readLine());
    }

    @Override
    protected void finalize() throws Throwable {
        this.close();
        super.finalize();
    }
}