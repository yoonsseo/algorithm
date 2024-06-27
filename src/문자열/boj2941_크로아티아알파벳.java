package 문자열;

import java.util.Scanner;

public class boj2941_크로아티아알파벳 {
    //contains()와 replace() 이용

    static String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();

        for (int i = 0; i < croatia.length; i++) {
            if (string.contains(croatia[i])) {
                string = string.replace(croatia[i], "@");
            }
        }

        System.out.println(string.length());
    }
}
