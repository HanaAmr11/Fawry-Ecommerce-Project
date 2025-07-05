# Fawry Rise Journey – E-commerce System 

This project is a solution to the **Full Stack Development Internship Challenge** from the Fawry Rise Journey program. It is a simple **Java-based e-commerce system** that supports product management, cart functionality, checkout processing, and shipping integration.

---

## Features

- Define products with name, price, and quantity.
- Handle **expirable products** 
- Handle **shippable products**  with weight.
- Prevent checkout if:
  - Cart is empty
  - Customer's balance is insufficient
  - Product is out of stock or expired
- Calculate:
  - Subtotal (sum of all items)
  - Shipping fees based on total weight
  - Total amount (subtotal + shipping)
- Print detailed **checkout receipt** and **shipment notice**.
- Integrate with `ShippingService` using interface `Shippable`.

---

## Project Structure

```
FawryEcommerceProject/
├── Cart.java
├── CartItem.java
├── Customer.java
├── ExpirableProduct.java
├── ExpirableShippableProduct.java
├── Main.java
├── Product.java
├── ShippingService.java
├── Shippable.java
└── ShippableProduct.java
```



---




## 🚀 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/YOUR_USERNAME/FawryEcommerceProject.git
   cd FawryEcommerceProject/src
   ```

2. Compile the project:
   ```bash
   javac *.java
   ```

3. Run the app:
   ```bash
   java Main
   ```



