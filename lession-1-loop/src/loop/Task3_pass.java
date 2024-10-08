package loop;

import java.util.Scanner;

public class Task3_pass {
    public static void main(String[] args) {
        char pass = 'z';
        Scanner sc = new Scanner(System.in);

        int cnt = 1;

        while(cnt <= 3) {
            System.out.print("your pass = ");
            char c = sc.next().charAt(0);
            if(c == pass){
                System.out.println("access");
                break;
            }else
                System.out.println("denide");
            cnt++;
        }
    }
}
