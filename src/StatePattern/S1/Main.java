package StatePattern.S1;

public class Main {

    public static int hour = 0;
    public static boolean workFinished = false;
    public static void writeProgram() {
        if (hour < 12) {
            System.out.println("当前时间: " + hour + "点 上午工作，精神百倍");
        } else if (hour < 13) {
            System.out.println("当前时间: " + hour + "点 饿了,午饭:犯困,午休。");
        } else if (hour < 17) {
            System.out.println("当前时间: " + hour + "点 下午状态还不错,继续努力");
        } else {
            if (workFinished) {
                System.out.println("当前时间: " + hour + "点 下班回家了");
            } else {
                if (hour < 21) {
                    System.out.println("当前时间: " + hour + "点 加班哦，疲累至极");
                } else {
                    System.out.println("当前时间: " + hour + "点 不行了, 睡着了。");
                }
            }
        }
    }
    public static void main(String[] args) {
       hour = 9;
       writeProgram();
       hour = 10;
       writeProgram();
       hour = 12;
       writeProgram();
       hour = 13;
       writeProgram();
       hour = 14;
       writeProgram();
       hour = 17;
       
       workFinished = true;
       writeProgram();
       
       hour = 19;
       writeProgram();
       hour = 22;
       writeProgram();
       
    }

}
