package loop;

import java.util.Scanner;

public class Task2_PhepTinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a = ");
        int a = sc.nextInt();
        System.out.print("b = ");
        int b = sc.nextInt();
        System.out.print("phép tính: ");
        char c = sc.next().charAt(0);
        if(c == '+')
            System.out.printf("%d + %d = %d", a, b, (a+b));
        else if (c == '-')
            System.out.printf("%d - %d = %d", a, b, (a-b));
        else if (c == '*')
            System.out.printf("%d * %d = %d", a, b, (a*b));
        else if (c == '/')
            if(b == 0)
                System.out.println("Không hợp lệ");
            else
                System.out.printf("%d / %d = %.2f", a, b, ((a*1.0)/b));
        else
            System.out.println("Phép tính không đúng");
    }
}
