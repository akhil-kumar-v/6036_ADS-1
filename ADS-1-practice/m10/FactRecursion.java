import java.util.Scanner;

class FactRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int fa = sc.nextInt();
        System.out.println("Factorial of " + fa + " is " + fact(fa));

    }
    static int fact(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
