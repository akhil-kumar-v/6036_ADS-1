class Team {
	private CricketTeam[] teams;
	private int size;
	Team() {
		teams = new CricketTeam[10];
		size = 0;
	}
	public void addCricketTeam(CricketTeam t) {
		teams[size++] = t;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += teams[i].name+",";
		}
		return s.substring(0, s.length() - 1);
	}
	public void exch(CricketTeam[] teams, int i, int j) {
		CricketTeam ct = teams[j];
		teams[j] = teams[i];
		teams[i] = ct;
	}
	public void selectionSort() {
		for (int i = 0; i < size - 1; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (less(teams, j, min)) {
					min = j;
				}
			}
			exch(teams, i, min);
        }
	}
	boolean less(CricketTeam[] arr, int i, int j) {
		return  arr[i].compareTo(arr[j]) > 0;
	}
}
