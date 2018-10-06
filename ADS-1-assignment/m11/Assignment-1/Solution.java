import java.util.Scanner;
import java.util.Arrays;


class Solution {
    // int bcVac;
    // int scVac;
    // int stVac;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nTotVac = sc.nextInt();
        int nUnVac = sc.nextInt();
        int bcVac = sc.nextInt();
        int scVac = sc.nextInt();
        int stVac = sc.nextInt();
        sc.nextLine();
        CreateList cl = new CreateList();
        while (n > 0) {
            n--;
            String[] line = sc.nextLine().split(",");
            String[] temp = line[1].split("-");
            int[] dobInt = new int[3];
            dobInt[0] = Integer.parseInt(temp[2]);
            dobInt[1] = Integer.parseInt(temp[2]);
            dobInt[2] = Integer.parseInt(temp[2]);
            Score s = new Score(line[0], //name
                                dobInt, //dob
                                Integer.parseInt(line[2]),//sub1
                                Integer.parseInt(line[3]),//sub2
                                Integer.parseInt(line[4]),//sub3
                                Integer.parseInt(line[5]),//total
                                line[6]); //caste
            cl.addToList(s);
            // System.out.println("qq ="+Arrays.toString(line));
        }
        // System.out.println();
        cl.selectionSort();
        System.out.println(cl);

        // for (int i = 0; i < nTotVac; i++) {
        int stCount = 0;
        int scCount = 0;
        int bcCount = 0;
        for (int j = 0; j < nUnVac; j++) {
            System.out.println(cl.scores[j].name + ","
                               + cl.scores[j].total + ","
                               + cl.scores[j].caste );
            nTotVac--;
            // if()
            if ((cl.scores[j].caste).equals("SC")) {
                scCount++;
            } else if ((cl.scores[j].caste).equals("ST")) {
                stCount++;
            } else if ((cl.scores[j].caste).equals("BC")) {
                bcCount++;
            }
        }

        for (int i = nUnVac; i < cl.size; i++) {
            // System.out.println("test");
            // System.out.println((cl.scores[i].caste));
            if ((cl.scores[i].caste).equals("BC") && bcVac > 0) {
                System.out.println(cl.scores[i].name + ","
                                   + cl.scores[i].total + ","
                                   + cl.scores[i].caste );
                bcVac--;
                nTotVac--;
            }

            if ((cl.scores[i].caste).equals("SC") && scVac > 0) {
                System.out.println(cl.scores[i].name + ","
                                   + cl.scores[i].total + ","
                                   + cl.scores[i].caste );
                scVac--;
                nTotVac--;
            }
            if ((cl.scores[i].caste).equals("ST") && stVac > 0) {
                System.out.println(cl.scores[i].name + ","
                                   + cl.scores[i].total + ","
                                   + cl.scores[i].caste );
                stVac--;
                nTotVac--;
            }
            // System.out.println("stVac =" + stVac);
            if ((cl.scores[i].caste).equals("Open") && (stVac - stCount) == 0) {
                scVac--;
                stCount++;
                nTotVac--;
                System.out.println(cl.scores[i].name + ","
                                   + cl.scores[i].total + ","
                                   + cl.scores[i].caste );
                // scVac--;
            }
            if(nTotVac==0){
                break;
            }
        }

        // if (cl.scores[i].caste.equals("BC") && bcVac > 0) {
        //     System.out.println(cl.scores[i].name + ","
        //                        + cl.scores[i].total + ","
        //                        + cl.scores[i].caste );
        //     bcVac--;
        // }
        // if (cl.scores[i].caste.equals("SC") && scVac > 0) {
        //     System.out.println(cl.scores[i].name + ","
        //                        + cl.scores[i].total + ","
        //                        + cl.scores[i].caste );
        //     scVac--;
        // }
        // if (cl.scores[i].caste.equals("ST") && stVac > 0) {
        //     System.out.println(cl.scores[i].name + ","
        //                        + cl.scores[i].total + ","
        //                        + cl.scores[i].caste );
        //     stVac--;
        // }
        // }
    }
}
