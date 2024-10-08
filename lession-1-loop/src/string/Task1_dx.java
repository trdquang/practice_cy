package string;

import java.util.Scanner;

public class Task1_dx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("s = ");
        String s = sc.nextLine();

        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                System.out.println("Không đối xứng");
                return;
            }
            l++;
            r--;
        }
        System.out.println("Đối xứng");
    }
}
