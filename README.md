A retailer offers a rewards program to its customers, awarding points based on each recorded purchase. 
 
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction.
(e.g., a $120 purchase = 2x$20 + 1x$50 = 90 points).
 
Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total.
![image](https://github.com/saiteja0731/Reward-Calculator_Web-API/assets/133249399/200e635e-f1b2-4baf-9174-4fb27884b4a1)

Reward Point

Build the project with below commad
mvn clean install

Run the code
mvn spring-boot:run

Rest API detail

1. Get Reward by Customer Id
Method : Get
http://localhost:8080/getRewards/1001

2. Get Customer By Id

Method : Get
http://localhost:8080/customers/1001

3. Get Transaction By Id
Method : Get

http://localhost:8080/rewardsPoint/customers/1001


