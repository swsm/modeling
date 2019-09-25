package study1.constuction.SimpleFactoryPattern.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("请输入数字A:");
            String a = br.readLine();
            System.out.println("请输入运算符号(+、-、*、/):");
            char b = br.readLine().charAt(0);
            System.out.println("请输入数字A:");
            String c = br.readLine();
            String res = String.valueOf(Operation.getResult(Double.parseDouble(a), Double.parseDouble(c), b));
            System.out.println("结果是:" + res);
        } catch (Exception e) {
            System.out.println("您输入的数据有误" + e.getMessage());
        }
    }

}
