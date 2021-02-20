
package donutshop;

public class DonutShop {
    
    private double price;
    private String donutType;
    private int donutsOrdered;
    
    public DonutShop (String donutType, double price) {
        this.donutType = donutType;
        this.price = price;
        this.donutsOrdered = 0;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getdonutType() {
        return donutType;
    }

    public void setdonutType(String donutType) {
        this.donutType = donutType;
    }

    public int getDonutsOrdered() {
        return donutsOrdered;
    }

    public void setDonutsOrdered(int quantity) {
        this.donutsOrdered = donutsOrdered + quantity;
    }
    
    
    
}
