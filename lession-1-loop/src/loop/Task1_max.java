package loop;

import java.util.Scanner;

public class Task1_max {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int max = Integer.MIN_VALUE;
            System.out.print("a = ");
            int a = sc.nextInt();
            System.out.print("b = ");
            int b = sc.nextInt();
            System.out.print("c = ");
            int c = sc.nextInt();

            int pos1 = 0, pos2 = 0, pos3 = 0;
            if(a >= max)
                max = a;
            if(b >= max)
                max = b;
            if(c >= max)
                max = c;

            System.out.println("max = " + max);

            if(a == max)
                pos1 = 1;
            if(b == max)
                pos2 = 1;
            if(c == max)
                pos3 = 1;

            if(pos1+pos2+pos3 >1){
                System.out.println("Giá trị lớn nhất bằng nhau");
            }
        }

}
