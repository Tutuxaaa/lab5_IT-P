import java.util.HashMap;
import java.util.Map;


public class Sales {
    private Map<String, Integer> salesMap;
    private int totalSales;

    public Sales() {
        salesMap = new HashMap<>();
        totalSales = 0;
    }

    public void addSale(String product, int quantity, int price) {
        salesMap.put(product, salesMap.getOrDefault(product, 0) + quantity);
        totalSales += quantity * price;
    }

    public void displaySales() {
        System.out.println("Список проданных товаров:");
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " продано");
        }
    }

    public int getTotalSales() {
        return totalSales;
    }

    public String getMostPopularProduct() {
        String mostPopular = null;
        int maxSales = 0;

        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        return "Наиболее популярный товар: " + mostPopular;
    }

    public static void main(String[] args) {
        Sales tracker = new Sales();
        tracker.addSale("milk", 10, 100);
        tracker.addSale("banana", 40, 50);
        tracker.addSale("cookies", 100, 100);
        System.out.println(tracker.getMostPopularProduct());
        tracker.displaySales();
        System.out.println(tracker.getTotalSales());

    }
}