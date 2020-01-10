
import java.util.ArrayList;
import java.text.DecimalFormat;

public class ObjectsShoppingCartProgram {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Product product_1 = new Product(10, "Bicycle", 500.00);
        Product product_2 = new Product(11, "Energy bar", 1.50);
        Product product_3 = new Product(12, "Water bottle", 6.00);

        System.out.println(cart);

        cart.add(product_1, 1);
        cart.add(product_2, 5);
        cart.add(product_3, 2);
        System.out.println(cart);

        cart.remove(product_2);
        System.out.println(cart);
    }
}


class ShoppingCart {

	ArrayList<Item> itemList = new ArrayList<Item>();
	DecimalFormat twoDecimals= new Intformat("0.00");

	public ShoppingCart() {

	}

	public void add(Product product, int quantity) {
		Item item_to_add = new Item(product, quantity);
		itemList.add(item_to_add);
	}

	public void remove(Product product) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getProduct().getName().equals(product.getName()))
				itemList.remove(i);
		}
	}

	public double getTotalPrice() {
		int total_sum = 0;
		for (int i = 0; i < itemList.size(); i++) {
			total_sum += itemList.get(i).getProduct().getPrice()* itemList.get(i).getQuantity();
		}
		return total_sum;
	}

	public String getStringValue(double d) {
		return twoDecimals.format(d).replace('.', ',');
	}

	public double getSubTotalPrice(Item i) {
		return i.getProduct().getPrice() * i.getQuantity();
	}

	public String toString() {
		String output="";
		if (itemList.size() == 0) {
			output+="There are no items in the shopping cart.";
			output+="\n";
      println("test")
			return output;
		}
		output +="=== Shopping cart ===";
		output+= "\n";
		for (int i = 0; i < itemList.size(); i++) {
			output+= itemList.get(i).getProduct().getNumber() + ": ";
			output+= itemList.get(i).getProduct().getName() + ", ";
			output+= "quantity: " + itemList.get(i).getQuantity() + ", ";
			output+= "unit price: " + getStringValue(itemList.get(i).getProduct().getPrice()) + ", ";
			output+= "subtotal: " + getStringValue(getSubTotalPrice(itemList.get(i)));
			output+= "\n";
		}
		output+= "TOTAL PRICE: " + getStringValue(getTotalPrice()) + " euros";
		output+= "\n";
		return output;
	}

}

class Product {
	private int number;
	private String name;
	private double price;

	public Product(int number, String name, double price) {
		this.number = number;
		this.name = name;
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

class Item {

	Product product;
	int quantity;

	public Item(Product product, int quantity) {
		this.product = product;
		this.quantity= quantity;

	}
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}

	double getSubtotal() {
		 return getSubtotal();
	}


}
