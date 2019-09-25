package study2.construction.proxy;

public class House {

    private Customer likedCustomer;

    public Customer getLikedCustomer() {
        return this.likedCustomer;
    }

    public void setLikedCustomer(Customer customer) {
        this.likedCustomer = customer;

    }
}
