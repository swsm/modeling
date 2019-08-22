package study2.construction.proxy;

public class HouseProxy {
    private House house;

    public HouseProxy() {
        house = new House();
    }

    public void register(Customer customer) {
        preRegister(customer);
        house.setLikedCustomer(customer);
        afterRegister(customer);
    }

    private void afterRegister(Customer customer) {
        System.out.println(customer.getName() + "我要好好爱护它");
    }

    private void preRegister(Customer customer) {
        System.out.println(customer.getName() + "能有我很高兴");
    }

    public Customer getRegister() {
        return house.getLikedCustomer();
    }
}
