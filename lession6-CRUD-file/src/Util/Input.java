package Util;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);

    public static int inputOneNum(String message){
        int num = 0;
        while (true){
            try {
                System.out.print(message);
                num = Integer.parseInt(sc.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Hãy nhập số nguyên");
            }
        }

        return num;
    }
}
