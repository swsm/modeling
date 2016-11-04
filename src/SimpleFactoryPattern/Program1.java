package SimpleFactoryPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入数字A:");
        String a = br.readLine();
        System.out.println("请输入运算符号(+、-、*、/):");
        String b = br.readLine();
        System.out.println("请输入数字A:");
        String c = br.readLine();
        String d = "";
        if (b.equals("+")) {
            d = String.valueOf(Double.parseDouble(a) + Double.parseDouble(c));
        }
        if (b.equals("-")) {
            d = String.valueOf(Double.parseDouble(a) + Double.parseDouble(c));
        }
        if (b.equals("*")) {
            d = String.valueOf(Double.parseDouble(a) + Double.parseDouble(c));
        }
        if (b.equals("/")) {
            d = String.valueOf(Double.parseDouble(a) + Double.parseDouble(c));
        }
        System.out.println("结果是:" + d);
        
    }

}
