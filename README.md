
## Rent eSkates 

#### A full-stack web application where you can rent electric skateboards, scooters and cycles.

# Table Of Content
- [Features](https://github.com/th3pi/may-i-rent-e-skates#features)
- [Tech Used](https://github.com/th3pi/may-i-rent-e-skates#tech-used)
- [Video Demonstrations](https://github.com/th3pi/may-i-rent-e-skates#1-registration)
- [What happens when...](https://github.com/th3pi/may-i-rent-e-skates#what-happens-when)
- [Installation](https://github.com/th3pi/may-i-rent-e-skates#installation)
- [User Stories](https://github.com/th3pi/may-i-rent-e-skates#user-stories)
- [E/R Diagram](https://github.com/th3pi/may-i-rent-e-skates#er-diagram)
- [Approach Taken](https://github.com/th3pi/may-i-rent-e-skates#er-diagram)


# Features!

  - User friendly modern UI.
  - Very powerful admin panel that let's you control EVERYTHING.
  - Daily, Monthly, Yearly sales stats.
  - Robust product and user management.
  - AWS hosted.
  - All the bells and whistles of a modern web application.

# Tech used
- AWS
- AngularJS
- Apache Tomcat 8.5
- AWS Elastic Beanstalk
- CSS
- Hibernate
- HTML
- IntelliJ
- Java 8
- JDBC
- JPA
- JavaScript
- jQuery
- JSP, JSTL
- JUnit
- Maven
- Oracle SQL
- Spring MVC
- Spring Security
- Spring Web-flow
- Trello



#### The Homepage
![homepage](https://i.imgur.com/HU3wVSf.jpg)



# 1. Registration
#### Registration controller checks for existing email addresses in the database before letting user successfully register, validation is also present for password being handled by both JavaScript and Controller. User is automatically logged in after registration.
![registration](https://i.imgur.com/dgXqESy.gif)

# 2. Login
#### Passwords are hashed using Bcrypt. The configuration can be found in [src/main/WEB-INF/applicationContext.xml](https://github.com/th3pi/may-i-rent-e-skates/blob/master/src/main/webapp/WEB-INF/applicationContext.xml) Only hashed passwords are stored in the database.
![login](https://i.imgur.com/Mr2y3gg.gif)



# 3. The order process
#### Click on the add to cart button to rent the product. Everytime user clicks on add to cart +1 day is added to the cart. User cannot order for more days than allowed. Spring web-flow handles the entire checkout process. At this moment user can only have one billing address or shipping address at a time. They can be different from one another. Checkout information's autofilled with user profile details. Order can be cancelled as long as order status is "Order Awaiting Confirmation" Configuration available here -  [src/main/webapp/WEB-INF/flows/checkout/](https://github.com/th3pi/may-i-rent-e-skates/tree/master/src/main/webapp/WEB-INF/flows/checkout). 
![timetrials](https://i.imgur.com/CbcS9Cl.gif)


# 4. Empty Cart/Profile
#### Empty Cart/Profile will not just be blank. They will try to drive sales.

![emptycart](https://i.imgur.com/M4m7JfU.gif)

# 5. Editing User Profile
#### User can edit their profile (of course). User isn't allowed to change user name or email address however.

![profileedit](https://i.imgur.com/AryWqcH.gif)

# 6. Shop filters
#### User can search and filter in shop. Use the left navigation panel to do so.

![filters](https://i.imgur.com/SIpwOvI.gif)

# 7. Product page
#### Product page shows all the necessary details and business constraints to the user. Product page also markets other similar products to the user.

![productpage](https://i.imgur.com/SIpwOvI.gif)

# 8. Control Center
#### This application has a very powerful admin panel. The admin has tons of information presented to them whenever they access the Control Center. Control Center shows up on the navbar as soon as an admin logs in. Admins are not allowed the luxury to rent a skate.

#### As you can see as soon as you enter the page you're greeted with a monthly sales graph that updates every time an order is confirmed. Sames goes for the Financial Stats section. 

#### Order stats where you can see all orders with statuses that require attention.

![adminpanel](https://i.imgur.com/dPWfe8M.gif)

# 9. Managing Products

#### Admin can disable or enable products. Products disabled can no longer be ordered until re-enabled. However, they will still show up in User's order receipt.
![disableproduct](https://i.imgur.com/bwUbQug.gif)

#### Admin can edit product details. However there is a bug right now, after admin edits product details - the rent limit disappears. Admin has to disable and enable the product to fix that.
![editproduct](https://i.imgur.com/fSslXRq.gif)

# 10. Managing Users

#### Admin can view user profile and edit user details.
![viewedituser](https://i.imgur.com/G0bGf9M.gif)

#### Admin can add employees and users.
![addemployee](https://i.imgur.com/tvpOeL7.gif)

#### Admin can search for a specific user by any column.
![addemployee](https://i.imgur.com/yZztd8h.gif)

# 11. Managing Orders

#### Admin can update order status. Even has the abilitiy to cancel orders. Admin can view order details.
![orderupdate](https://i.imgur.com/eP7lV6j.gif)

# What happens when...

#### 1. Admin visits the shop, can admin buy anything? 
##### Ans: No. Admin has to create a separate account for rentals. Admin will not see the option to add product to cart. Only edit.
![canadminbuy](https://i.imgur.com/vSAWci3.gif)

#### 2. An user tries visit another user's cart, profile or order?
##### Ans: It is not possible. User will see an error page.
![canuseraccess](https://i.imgur.com/LKVC2KV.gif)

#### 3. An user somehow accesses a disable product page, can they still order?
##### Ans: No. The button will be disabled and will say "Currently Unavailable."
![disabledproductpage](https://i.imgur.com/t7mMuDr.png)

### Installation

1. Download Intellij Idea Ultimate Free Trial from [here](https://www.jetbrains.com/idea/download/#section=windows)
2. Install IntelliJ
3. Download Apache Tomcat 8.5.34 from [here](https://tomcat.apache.org/download-80.cgi) if you don't have it already.
4. Get the Windows Service Installer
![tc](https://i.imgur.com/blKdjZQ.png)
5. Download this Intellij project zip file from [here](https://drive.google.com/open?id=1tNB0wS4jAv7Y2e8-RL9NIgfxFFw8s6fh) !!WARNING: DO NOT CLONE THIS REPO. DOWNLOAD THIS ZIP!!
6. Extrac the folder.
7. Run Intellij
8. Click on Open 
![likethis](https://i.imgur.com/NO60kha.png)
9. Now go to the extract location and select the Idea Project folder. There will be a small black mark that will indicate that this is an Idea Project.
![idea](https://i.imgur.com/3CXqXAw.png)
10. Everything should be set. However if it isn't. You might have to configure tomcat. Click on the dropdown.
![drop](https://i.imgur.com/4hcLFyH.png)
11. Click Edit Configuration
![editconfig](https://i.imgur.com/hH6J8xi.png)
12. Click Configure
![configure](https://i.imgur.com/KGRpge1.png)
13. Click on the plus icon to add tomcat.
![add](https://i.imgur.com/rLscbuk.png)
14. Find the directory where your tomcat is installed and link it. Usually it's in C:/Program Files/Apache Software Foundation
![findtom](https://i.imgur.com/SEyNBPV.png)
15. If you are seeing no artifacts marked for deployment - Click on fix.
![art](https://i.imgur.com/m5nFGGN.png)
16. Select the exploded artifact.
![explode](https://i.imgur.com/OijvJca.png)
17. Now just Run.
![run](https://i.imgur.com/0JnyDcr.png)
18. Done! You should be welcomed to my beautiful homepage.
![beaut](https://i.imgur.com/e20QgK7.jpg)

### [User stories](https://drive.google.com/file/d/1wLP_nYrwuUwp1nIyIUghWqVkJ9WoH-zT/view?usp=sharing)

### [E/R Diagram](https://drive.google.com/file/d/1KyVTXG4D7yP1iUBFVB8ckL4Jyh8gxiaO/view?usp=sharing)

### Approach Taken 
Building this application was a learn as you go process. I basically learned most of the Spring Framework technologies as I was building this web application. Followed the standard SDLC approach - Planning, Requirement Analysis, Design, Development, Testing, Implementation and Maintenance. This project was heavily dependent on TDD method. I used [Trello](https://trello.com/) for project management. It is an amazing free application. IDE used was IntelliJ (the best - let's face it). 
#### The Research Process
Working on this project was fun but challenging as I was not very familiar with the Spring framework. But hey, what's the fun without a little challenge? I started by watching videos and reading articles on the Spring Framework as a whole. Then slowly moved on to Spring MVC - the Model View Controller ideology and how it works. Once I figured that out, I still didn't jump into development until I found a better way to work with the Database than plain old thousands of lines of Result Set and Prepared Statement lines. That is when I first met Hibernate. It was love it first sight. I quickly dived into learning how hibernate works and how I can implement it. Next was the....
#### The Development Process
I started by setting up my Dependencies in [pom.xml](https://github.com/th3pi/may-i-rent-e-skates/blob/master/pom.xml), configuring [web.xml](https://github.com/th3pi/may-i-rent-e-skates/blob/master/src/main/webapp/WEB-INF/web.xml), creating and configuring [dispatcher-servlet.xml](https://github.com/th3pi/may-i-rent-e-skates/blob/master/src/main/webapp/WEB-INF/dispatcher-servlet.xml) and [applicationContext.xml](https://github.com/th3pi/may-i-rent-e-skates/blob/master/src/main/webapp/WEB-INF/applicationContext.xml). Converted all the entities from my [E/R Diagram](https://drive.google.com/file/d/1KyVTXG4D7yP1iUBFVB8ckL4Jyh8gxiaO/view?usp=sharing) to [models](https://github.com/th3pi/may-i-rent-e-skates/tree/master/src/main/java/com/mayi/model). Then it was time for controllers and views. My first three controllers were the [HomeController](https://github.com/th3pi/may-i-rent-e-skates/blob/master/src/main/java/com/mayi/controller/HomeController.java), [LoginController](https://github.com/th3pi/may-i-rent-e-skates/blob/master/src/main/java/com/mayi/controller/LoginController.java) and the [RegistrationController](https://github.com/th3pi/may-i-rent-e-skates/blob/master/src/main/java/com/mayi/controller/RegistrationController.java). The [LoginController](https://github.com/th3pi/may-i-rent-e-skates/blob/master/src/main/java/com/mayi/controller/LoginController.java) is no longer the same as it used. Eventually I implemented Spring Security to handle login. Then it was time to implement hibernate. My hibernate is configured in the [applicationContext.xml](https://github.com/th3pi/may-i-rent-e-skates/blob/master/src/main/webapp/WEB-INF/applicationContext.xml). I was able to set up everything without any issues and it ran the first time I tried. Then it was basically the same process throughout the rest of the project. I put as much focus on the project on admin-side as I did on the customer-side - both sides of the project is a polished experience. When I reached checkout, I went back into research phase, because I felt like there has to be a better way to handle checkout other than just linking submit to the next jsp page. Then I remember Spring Web-flow from when I was studying about the Spring Framework - PERFECT! I learned how to implement it and I did. When the project was done, I uploaded to AWS Elastic beanstalk.
#### The Un-mentioned
There are ton's of other technologies I used through the entire project, like AngularJS, jQuery, Semantic UI, Bootstrap, JSTL, AWS and what not. If I keep on writing about how I implemented them and my thought process - I could write a series as long as the Harry Potter.
#### Issues I faced
There were thousands. But what's important is I overcame them. One of the issues I'm still facing is, can't get that AngularJS calendar - where user could select the dates from when to when they want to rent - to play nice with Spring.
