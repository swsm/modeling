package jksj.wangzeng.modeling.observer.google;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import study1.constuction.Flyweight.S4.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author swsm
 * @date 2020/12/21
 */
public class UserController {
    
    private EventBus eventBus;
    
    public UserController() {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(20));
    }
    
    public void register() {
        User user = new User("aa");
        System.out.println("我就是" + user);
        eventBus.post(user);
    }
    
    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }
    
    
    static class UserNotification {
        @Subscribe
        public void notify(User user) {
            System.out.println("收到user的信息" + user);
        }
    }

    static class UserNotificationTwo {
        @Subscribe
        public void notify(User user) {
            System.out.println("收到user的信息2" + user);
        }
    }

    public static void main(String[] args) {
        UserController userController = new UserController();
        List<Object> list = new ArrayList<>();
        list.add(new UserNotification());
        list.add(new UserNotificationTwo());
        userController.setRegObservers(list);

        userController.register();
    }
    
}
