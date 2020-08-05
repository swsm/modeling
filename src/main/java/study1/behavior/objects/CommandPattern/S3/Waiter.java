package study1.behavior.objects.CommandPattern.S3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Waiter {
    private List<Command> orders = new ArrayList<Command>();

    public void setOrder(Command command) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        if (command.toString().equals("烤鸡翅")) {
            System.out.println("服务员: 鸡翅没有了,请点别的烧烤。");
        } else {
            this.orders.add(command);
            System.out.println("日志: 增加订单: " + command.toString() + "时间: " + sdf.format(new Date()));
        }
    }

    public void myNotify() {
        for (Command c : this.orders) {
            c.excuteCommand();
        }
    }

}
