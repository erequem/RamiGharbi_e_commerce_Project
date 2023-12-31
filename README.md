# RamiGharbi_e_commerce_Project
E-commerce Platform Project
Introduction
This project aims to develop a comprehensive e-commerce platform with features including user authentication, product management, shopping cart functionality, order processing, inventory management, dynamic product search and filtering, and payment processing. The platform is designed to provide a seamless shopping experience for users while enabling efficient management of products and orders.

Features
1/User Authentication
I have implemented a rudimentary login/logout system(no encryption password side) in which we differentiate between admin accounts and client accounts.
It is noted that creating an account will automatically add it as a client.To add an admin you have to configure the account initializer function in the interface class.

2/Design of an abstract Product class and extension with specific categories.
the product class is the building block used throughout the project to create three subcategories of products: namely Food,Clothes and Electronics
i have also created the ItemManager class that does the job of a catalog of items as it is needed to have the id of items etc..

3/Enable management of products in a user's cart.
each user session(client)has its own cart that updates with each product added and is cleared whenever a transaction happens and an order is emitted.
This uniqueness of cart is managed by userCarts class that stores the cart with the id of the user to which it is linked(composition)


4/Development of the transition from cart to order completion.
each order is saved within the orderManager class that matches each order with the user that generated it. it is noted that only an admin account can see the history of orders and that clients are limited to their own orders.

5/Inventory Management
the inventory tracks the quantity of products within the e-commerce platform.
For the case of simplicity, the inventory updates when a user adds an item to the cart.In real world scenario we have to take into account the parallelism of purchases and different purchases can happen in the same instant.I went with this approach as to avoid conflict between two clients where one adds an item to cart then logs off.if The next user adds the last item in stock and orders,without the previous allocation we will have negative quantity.

6/Dynamic Product Search and Filtering.
a simple filter system where filters stack on each other with the option to clear the search.

7/Simulation of a basic payment transaction system.
i have added a rudimentary payment system which only asks for credit card credentials for payment.As an optional task, i decided to add a Payment manager class which lets users save their credit cards,select between them and delete them from the program.

8/Discounts
I have given the admin the possibility to add various discounts to the products in the shop.




How to run:
Start the application by running the interface file.Editing the initializing methods will result in the change of the beginning "database".
