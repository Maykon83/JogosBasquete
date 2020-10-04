
public class Jogo {
	private int numJogo;
	private int placar;
	private int minTemp;
	private int maxtemp;
	private int minRecord;
	private int maxRecord;
	
	public Jogo(int placar, int numJogo) {
		this.placar = placar;
		this.numJogo = numJogo;
	}
	
	public int getNumJogo() {
		return numJogo;
	}

	public void setNumJogo(int numJogo) {
		this.numJogo = numJogo;
	}

	public int getPlacar() {
		return placar;
	}

	public void setPlacar(int placar) {
		this.placar = placar;
	}

	public int getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(int minTemp) {
		this.minTemp = minTemp;
	}

	public int getMaxtemp() {
		return maxtemp;
	}

	public void setMaxtemp(int maxtemp) {
		this.maxtemp = maxtemp;
	}

	public int getMinRecord() {
		return minRecord;
	}

	public void setMinRecord(int minRecord) {
		this.minRecord = minRecord;
	}

	public int getMaxRecord() {
		return maxRecord;
	}

	public void setMaxRecord(int maxRecord) {
		this.maxRecord = maxRecord;
	}
	
	
		
}
