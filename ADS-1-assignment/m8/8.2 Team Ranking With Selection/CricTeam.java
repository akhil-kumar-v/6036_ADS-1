class CricTeam implements Comparable<CricTeam>{
	String name;
	int wins;
	int losses;
	int draws;
	CricTeam(String name, String wins, String losses, String draws) {
		this.name = name;
		this.wins = Integer.parseInt(wins);
		this.losses = Integer.parseInt(losses);
		this.draws = Integer.parseInt(draws);
	}
	public String getName() {
		return name;
	}
	public int getWins() {
		return wins;
	}
	public int getLosses() {
		return losses;
	}
	public int getDraws() {
		return draws;
	}
	public int compareTo(CricTeam c) {
		if (this.wins > c.wins) {
			return 1;
		}
		if (this.wins < c.wins) {
			return -1;
		}
		if (this.losses < c.losses) {
			return 1;
		}
		if (this.losses > c.losses) {
			return -1;
		}
		if (this.draws > c.draws) {
			return 1;
		}
		if (this.draws < c.draws) {
			return -1;
		}
		return 0;  
	}
	public String toString() {
		return this.name;
	}
}