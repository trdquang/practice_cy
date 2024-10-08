package test;

import Model.Department;

import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static void display() throws IOException{
//        throw new ArithmeticException();
    }

    public static void main(String[] args)  {
        try {
            throw new Error();
//            System.out.println(1/0);
        }catch (ArithmeticException  e){
            System.out.println(",");
        }finally {
            System.out.println("123");
        }
        System.out.println("d");
    }
}
