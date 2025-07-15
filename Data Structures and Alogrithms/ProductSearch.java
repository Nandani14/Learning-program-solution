import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ProductSearch {

    // Linear Search
    public static Product linearSearch(List<Product> products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search (Assumes list is sorted)
    public static Product binarySearch(List<Product> products, String name) {
        int low = 0, high = products.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = products.get(mid).productName.compareToIgnoreCase(name);
            if (result == 0) return products.get(mid);
            else if (result < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(201, "Shoes", "Footwear"));
        productList.add(new Product(202, "Laptop", "Electronics"));
        productList.add(new Product(203, "T-shirt", "Clothing"));
        productList.add(new Product(204, "Watch", "Accessories"));

        System.out.println("--- Linear Search ---");
        Product found1 = linearSearch(productList, "Laptop");
        System.out.println(found1 != null ? found1 : "Product not found");

        System.out.println("\n--- Binary Search (after sorting by name) ---");
        productList.sort(Comparator.comparing(p -> p.productName.toLowerCase()));
        Product found2 = binarySearch(productList, "Watch");
        System.out.println(found2 != null ? found2 : "Product not found");
    }
}

