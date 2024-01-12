public abstract class Product {
    private int id;
    private int price;
    private double discountRate;
    private int stock;
    private String productName;
    private String brand;
    private int memorySize;
    private double screenSize;
    private int ram;

    public Product(int id, int price, double discountRate, int stock, String productName,
                   String brand, int memorySize, double screenSize, int ram) {
        this.id = id;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.productName = productName;
        this.brand = brand;
        this.memorySize = memorySize;
        this.screenSize = screenSize;
        this.ram = ram;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}