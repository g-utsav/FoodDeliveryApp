# FoodDeliveryApp(Collaborative Project)

###  We have created REST API's with the help of SpringBoot. This is our Consrtuct Week project at Masai School ,Basically in masai school after every  four week we have to build project on basis of whatever learned in last four weeks.


# Class Diagram(ER)

![class Diagram](https://user-images.githubusercontent.com/101566533/185026588-e10640fb-cda2-48a9-8748-e5855261af3e.jpeg)

## Setup
###  There are various ways to use spring boot to develop a spring application: 

-  1. Installing STS software
-  2. installing the STS plugin in normal eclipse software
-  3. By using the Spring initializer website
-  4. By using Maven or Gradle application.
-  5. By using Spring Boot CLI (Command Line interface)

-  You must also be able to work with GitHub repositories.
-  Clone repository.  

        git clone https://github.com/g-utsav/FoodDeliveryApp.git
        
STS Instructions
--------------------

* **Prerequisites:**
    * Install [STS]()


* Create a new project using STS

    * Create a new as Spring Starter Project.
    * Enter Name,ArtiFact Name,GroupId
    * Choose the **Dependencies** whichever need your project( Spring web, Lombok, MySql...)
    * Write code for your project
    
* Run

    * Right-click on project
    * Run As > SpringBoot Application
   

      

## Tech Stack
- Java 
- SpringBoot
- JPA
- Spring


## Features & API's

### Register & SignIn ( Admin and User side)

-  Register/SignUp : From this API user have to register and user need to send the data in JSON format in Postman                   

           Post           : customer
-  Update         : From this API we can Update User data and we need to send the data in JSON format in Postman with the help of Unique User Id  

           Put            : customer?key=?(key)
-  LogIn         : From this API user can logIn our application after login user get  Unique User Id it is used to various perpose 

          Post           :  login
-  LogOut         : From this API user can logOut from our application with the help of Unique User Id 

         Patch           : logout



## Restaurant

-  Add Restaurant      : From this API Admin can add New Restaurant to the database                   

           Post           : RestaurantDTO
-  Update Restaurant      : From this API  Admin can update  any Restaurant to the database                   

           Put           : RestaurantDTO
-  Remove Restaurant  : From this API  Admin can Delete  any Restaurant from the database 

           Delete           : RestaurantDTO
-  View Restaurant    : From this API user can see  All Restaurants 

          Get           :  RestaurantName



## Cart 

-  Add Item to Cart       : From this API User can add item to the Cart                   

           Put           : customerId, RestaurantId,ItemId
-  Increase Number of Quantity       : From this API  User can increase quantity of products               

           Put           : itemDTOId,quantity
-  Remove Item to cart  : From this API  User can Delete  item from the cart 

           put          : CartId,ItemDtoId




## Items

-  Add Item      : From this API Admin can add any Item to the database                   

           Post           : Item
-  Update Item      : From this API  Admin can update  any Item to the database                   

           Put           : Item
-  Remove Item  : From this API  Admin can Delete  any Item from the database 

           Delete           : Item
-  View Item    : From this API user can see  Item

          Get           :  ItemId
-  View All Items    : From this API user can see all Items

          Get           :  ItemName


## Category

-  Add Category      : From this API Admin can add any  Item in Category to the database                   

           Post           : Category
-  Update Category      : From this API  Admin can update  any Item in Category to the database                   

           Put           : Category
-  Remove Category  : From this API  Admin can Delete  any Item Category from the database 

           Delete           : Category


## OrderDetails

-  Update Order      : From this API Admin can update the status of any order                   

           Put           : OrderDetailsDto
-  Add Order      : From this API user can place Order                   

           Post           : customerDTO
-  Remove Order  : From this API user can cancel the placed order  

           Delete           : OrderDetails
-  View All Pending Orders    : From this API user can see all pending orders

          Get           :   OrderDetailsDto
-  View All Orders    : From this API user can see all  orders

          Get           :   OrderDetailsDto




## Bill

-  Remove Bill  : From this API Admin can cancel the placed order  

           Delete           : BillDTO, Id

-  Generate Bill      : From this API User can Generate Bill of placed order                   

           Post           : BillDTO
-  Update Bill      : From this API user can Update the bill                  

           Put          : BillDTO

-  Get Bill     : From this API user can see All bill details

          Get           : customerId,BillDTO



## Learnings

- learnt how to make REST API's 
- How to use SpringBoot
- How to Map the Entity to form Database
- How to Maintain Relationship between Entity
- 

## Requirements to Run the API's

- PC with internet connection
- Web browser 
- Postman
  
    
## Contributors

- [Utasv Gupta](https://github.com/)
- [Avinash Ghatanure](https://github.com/Avinash7249)
- [Protyush Banerjee](https://github.com/ProtyushB)
- [Shubham Pawar](https://github.com/shubhampawar0901)
- [Vishakha Jangam](https://github.com/Vishakha-Jangam)
- [Anshuman Singh](https://github.com/asr0212)





