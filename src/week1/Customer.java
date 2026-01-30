package week1;

import java.util.List;

public class Customer {

    private String name;

    public Customer() {}

    public Customer(String name) {
        this.name = name;
    }

    public Menu order(Barista barista, String coffeeName, List<Menu> menuList) {
        return barista.makeMenu(coffeeName, menuList);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
