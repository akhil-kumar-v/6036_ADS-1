import java.util.Scanner;


class Star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(pairStar(line));
    }
    public static String pairStar(String str) {

        if (str.length() <= 1)
            return str;

        if (str.charAt(0) == str.charAt(1))
            return str.charAt(0) + "*" + pairStar(str.substring(1));

        return str.charAt(0) + pairStar(str.substring(1));

    }
}



