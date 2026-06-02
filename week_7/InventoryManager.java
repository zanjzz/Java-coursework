package week_7;
import java.util.Vector;

public class InventoryManager {

	public static void main(String[] args) {
		
		Inventory manager = new Inventory();
		
		manager.addProduct(new Product("Apple", 101, 50));
		manager.addProduct(new Product("Banana", 102, 30));
		manager.addProduct(new Product("Orange", 103, 40));
		
		manager.searchProduct("Banana");
		
	}
	
}

class Inventory {
	// Our vector array containing product objects
	private Vector<Product> products = new Vector<>();
	
	void addProduct(Product p) {
		products.add(p);
	}
	
	void removeProduct(String name) {
		// Looping through the vector to find what we need to remove
		for (int i = 0; i < products.size(); ++i) {
			if (name.equals(products.get(i).productName)) {
				products.remove(i);
				System.out.println("Product: " + name + " successfully removed.");
				return;
			}
		}	
	}
	
	// For updating the product, it will only update provided values
	void updateProduct(String productName, String newName, Integer newId, Integer newQuantity) {
		for (int i = 0; i < products.size(); ++i) {
			Product p = products.get(i);
			if (productName.equals(p.productName)) {
				if (newName != null) p.productName = newName;
		        if (newId != null) p.productId = newId;
		        if (newQuantity != null) p.quantity = newQuantity;
			}
		}
		
	}
	
	void searchProduct(String name) {
		boolean isFound = false;
		// Search for a product using a loop
		for (Product p : products) {
			if (p.productName.equals(name)) {
				System.out.println(
					"Product found: " + name + " (ID: " + p.productId +
				    ", Quantity: " + p.quantity + ")"
				);
				isFound = true;
			} 
		}
		if (!isFound) {
			System.out.println("Product not found: " + name);
		}
	}
	
}

class Product {
	String productName;
	int productId, quantity;
	
	Product(String productName, int productId, int quantity) {
		this.productName = productName;
		this.productId = productId;
		this.quantity = quantity;
	}
	
}

