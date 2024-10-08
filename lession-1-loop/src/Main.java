import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cd, cr;

        //nhap du lieu
        System.out.print("cd = ");
        cd = sc.nextDouble();
        System.out.print("cr = ");
        cr = sc.nextDouble();

        //tinh toan va ep kieu
        double cv = (int)((cd+cr)*2);
        double dt = (int)(cd*cr);

        //in ra ...
        System.out.printf("cv = %.3f\t dt = %.3f", cv, dt);
    }
}