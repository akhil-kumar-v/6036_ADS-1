import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Team team = new Team();
        while (sc.hasNext()) {
            String data = sc.nextLine();
            String[] str = data.split(",");
            CricketTeam cric = new CricketTeam(str[0], str[1],
                str[2], str[2 + 1]);
            team.addCricketTeam(cric);
        }
        team.selectionSort();
        System.out.println(team);
    }
}
