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
        Teams team = new Teams();
        while (sc.hasNext()) {
            String data = sc.nextLine();
            String[] str = data.split(",");
            CricTeam cric = new CricTeam(str[0], str[1],
                str[2], str[2 + 1]);
            team.addCricketTeam(cric);
        }
        team.InsertionSort();
        System.out.println(team);
    }
}
