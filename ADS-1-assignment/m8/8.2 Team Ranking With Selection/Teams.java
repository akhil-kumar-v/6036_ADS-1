class Teams {
	private CricTeam[] teams;
	private int size;
	Teams() {
		teams = new CricTeam[10];
		size = 0;
	}
	public void addCricketTeam(CricTeam t) {
		teams[size++] = t;
	}
	// The complexity of this recursion is O(n)
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += teams[i].name+",";
		}
		return s.substring(0, s.length() - 1);
	}
	public void exch(CricTeam[] teams, int i, int j) {
		CricTeam ct = teams[j];
		teams[j] = teams[i];
		teams[i] = ct;
	}
	// The complexity of this recursion is O(n^2)
	public void InsertionSort() {
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (less(teams, j - 1, j)) {
					exch(teams, j -1, j);
				}
			}
        }
	}
	public boolean less(CricTeam[] arr, int i, int j) {
		return  arr[i].compareTo(arr[j]) < 0;
	}
}