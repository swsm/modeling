package study1.constuction.SimpleFactoryPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program2 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入数字A:");
        String strNumberA;
        try {
            strNumberA = br.readLine();
            System.out.println("请输入运算符号(+、-、*、/):");
            char strOperate = br.readLine().charAt(0);
            System.out.println("请输入数字A:");
            String strNumberB = br.readLine();
            String strResult = "";
            switch (strOperate) {
            case '+':
                strResult = String.valueOf(Double.parseDouble(strNumberA) + Double.parseDouble(strNumberB));
                break;
            case '-':
                strResult = String.valueOf(Double.parseDouble(strNumberA) + Double.parseDouble(strNumberB));
                break;
            case '*':
                strResult = String.valueOf(Double.parseDouble(strNumberA) + Double.parseDouble(strNumberB));
                break;
            case '/':
                if (!strNumberB.equals("0")) {
                    strResult = String.valueOf(Double.parseDouble(strNumberA) + Double.parseDouble(strNumberB));
                } else {
                    System.out.println("除数不能为0");
                    return;
                }
                break;
            }
            System.out.println("结果是：" + strResult);
        } catch (Exception e) {
            System.out.println("您输入有错:" + e.getMessage());
        }
    }

}
