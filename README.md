
## Rent eSkates 

#### A full-stack web application where you can rent electric skateboards, scooters and cycles.

#### [DEMO](http://renteskates-env.isymkdspky.us-east-2.elasticbeanstalk.com/)

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

# 4. Editing User Profile
#### User can edit their profile (of course). User isn't allowed to change user name or email address however.

![profileedit](https://i.imgur.com/AryWqcH.gif)

# 5. Shop filters
#### User can search and filter in shop. Use the left navigation panel to do so.

![filters](https://i.imgur.com/SIpwOvI.gif)

# 6. Product page
#### Product page shows all the necessary details and business constraints to the user. Product page also markets other similar products to the user.

![productpage](https://i.imgur.com/SIpwOvI.gif)

# 7. Control Center
#### This application has a very powerful admin panel. The admin has tons of information presented to them whenever they access the Control Center. Control Center shows up on the navbar as soon as an admin logs in. Admins are not allowed the luxury to rent a skate.

#### As you can see as soon as you enter the page you're greeted with a monthly sales graph that updates every time an order is confirmed. Sames goes for the Financial Stats section. 

#### Order stats where you can see all orders with statuses that require attention.

![adminpanel](https://i.imgur.com/dPWfe8M.gif)

# 8. Managing Products

#### Admin can disable or enable products. Products disabled can no longer be ordered until re-enabled. However, they will still show up in User's order receipt.
![disableproduct](https://i.imgur.com/bwUbQug.gif)

#### Admin can edit product details. However there is a bug right now, after admin edits product details - the rent limit disappears. Admin has to disable and enable the product to fix that.
![editproduct](https://i.imgur.com/fSslXRq.gif)

# 8. Managing Users

#### Admin can view user profile and edit user details.
![viewedituser](https://i.imgur.com/G0bGf9M.gif)

#### Admin can add employees and users.
![addemployee](https://i.imgur.com/tvpOeL7.gif)

#### Admin can search for a specific user by any column.
![addemployee](https://i.imgur.com/yZztd8h.gif)

# 9. Managing Orders

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
![likethis](https://lh3.googleusercontent.com/32-jqC0CnpgckxHrOpZhdwt5jRM6_UVO9DKkeO7YJXeSI5tB-3nxkaKQYZ_yO-yLQV5P3UJhpu0FyePAV-nTYVmHQ-6WLfLep3NfFmf2yLuruioPAkwkiuDIKoawd1u9yKsZqDB6ZYrvfy-KNn5s5KwBY1G6IjWhYFr_GlfQhwDNPRLXPERfqVSXoHz-OE6jY6p3sAFsSJYAMkcuyirOjcckmcrHA7-UeHVrLotYkk0s_un7nkoxpo-dcwEcA2vri-7W1tsleN_8yA0pml-Mvom_zEqCWce2vSQ8Nf6N07zi57KxPELbL4atuM8GjwQPCNcp4kxHWBnnxvHBBZgTKz1s0dKCBX6oa3xYMCgneNIDgzJkb0H7OjEfXhQbvMaT2ccwkdAC5ZGvK5hhlMXIYI4k2aE_Q-NbHy3VyBVBm2H69qgAK7CbiyqKMbODxs6OKSKf8H4DiRp4b9A2c3v0cvbl5GHzquqpVmE0cjtTLuubW2yTjDE1KKJtOSnwwxKWfK66rPyUzifG-At3U4fu6ONivHRH5nhbOQjvZ9aGnpCJ2gqT-8i_fbfU4MBHUAlYtPe0aN0kr3stFzNNF2_WBBaHMpgpxPOLKlYpuX1VbJOZ_LA6X0ja2h0DpPBPE8xY=w474-h480-no)
9. Now go to the extract location and select the Idea Project folder. There will be a small black mark that will indicate that this is an Idea Project.
![idea](https://lh3.googleusercontent.com/daWeFnXID7Fr4TJMg8bTghN-wS8NUFCU_uPnN7qb5sjlRSCsDkG8stASNifx5Po4wj6y2gdjqJ217WdE7gjJFrCqK0Do-W6edj2sYh92-HetIgSqstvjEKO12G6CAVk0IDNGVMxeSFIQCqjLRCi0gNjxSjRdIKmeaMOdPyMEq4VhupZ0AWel1Llt7G_4m0a9_OtzJF8tVM1TSRPWUl23NwwGkhbEJ2i9uzaha9eD06Ky68j5X0wmCjq1Rw5RFtKfry_wcKB8G35LQJEuEkdnhwh9Ee-VDPZfzxGQZDw8f3XPxpBsr5Vz9SbBboRYmOaVmoWiSZ1xG8Z6C3RfA6uj_s-UyKJsogAvQALmTmoG50fOaeAVMRYg9enrYglE0upOjz5d4uLKl4BwCib3osFgWYTi7xnAxnDq_H-Ngkrf4CEw20eem8YYOTTLNjy0R0pvwQJ9zndgVjapyJC-bNHaBRilIduzF52kd15ebJbsaQtxcJmPhnyMe-L8KgMXQ-fgoq6IR9ZIWK11CILSQCgLc2mAARFalsXUBYwB6dN53eqOSVFB0qGaeRRp-Cho7CzVjX4vsoN5mloBu_nUjt7pLRu5X_dM1fYfwFVo83r_r0_hRIXjnt0d8qn6_y9SNV67=w426-h486-no)
10. Everything should be set. However if it isn't. You might have to configure tomcat. Click on the dropdown.
![drop](https://lh3.googleusercontent.com/tREXGTrm-IOrmNPThkgLdPsS8iYoycRCl0rsv_i33T_G4YMdAy93z_ng7aWzzJgG1h5L5QQIfZeNQ3pP8QgstMwEQ3FY8RuRxjScD1d60l3YPQkBwgslo_tIlCf-k5cZus5Vp-TyzG6J4CgsIuVxGg0vrVPipq5x6OOHrP0XF9-fEc2W-tRwxbY6CWwvkAMdglwnrAhSnKN0Giss3yDfQ-uiwvmXVKo5VsN5u5ks0ezXeIpaLKMSqGKfGXv-R1yIA8XX5qjxqfBzw2z0Tt97_z0MbG0JzDtNP9YgWiWtjPVXvsjXErv5oKvlBxUenv_g8q7DpsBExQrPXJP9eBQTX-3EyWpG_-5sV3DOFo6uzo2MmA6gZebCGAES1hFiD-VsRPt83MG4RxXD8y-v16ftn-eCiqV41uQ93pdLofgOZi5OgB42VkQ_FgfJpV9xhEcAMGbWDmkNtSkRUDRNdV4lRDt_pPNn1xA4Nr51W8m6khQ-eLcPmxqJm8147v7qLrQiDsDmSfSIhpHBBFFvbf0FA51WhJdk1Fj9oJNIAI1TeDp8rwMF20_DSPRpYImE9UiUxVMQ9ermu6LC_3n3yR_SXtPoq4VVnPjsS-knwi23-TLyjiz8_ZMrG356OdiYShFE=w1680-h365-no)
11. Click Edit Configuration
![editconfig](https://lh3.googleusercontent.com/I6xArBWwUqTYzT95d6LIW5lpFjJoW-0B3QUnSWImaU_8TVIPh49WJ_kWxnbdWDSR7l0wp3HAbhL2JJj302jCIaMPokeOVGl2LBWi39Rr7QoNH-cCgK_e7lpRxy_6x_tXYTtuKsVvxznK4_70BsbzOdO8qBmbwqoP--kh37nLcbJxcnWIph7jeycoyScodHSJHR7_nvTG5A8lAhYBJazjGx2QqdKS-MgePnJe4EVwV8VRHiNYLAuNw-m2Ib6dAgHfvqZRuzOc0hiLjEkPBI27tgd-UqakvVsCOx7b7rhDIvbOc30ESUSnLFk5dRWjtjL1m1qvnIYXoFfK8sKIIyx8vn9dDzj9i6whiktbOJB591RxXKDOd_nSyjKEGYq7BLCV554teDL7BypO9pagMuMrN6wQXVO5dYmHznld9wmuwN3MmjCVWLZ6PnPUQnAehQZGKSSgInv7T6KAe9QPzWO44-W-hQnEDdGAJ0QTdE6glDPshyqkXqhfuh47ET64dbV5T4zIxQOnc9gKP6kKLowPjzBuukjGKs6NlO0DGPkQ1EjbcaXRgNlbVnnS5p7ZR5clX7lEvcGTv3hiBPDGTIO3qB25SMRFuiBX20OSGpXxpBxxgIxxHvJCKI5wATcnWbTc=w670-h365-no)
12. Click Configure
![configure](https://lh3.googleusercontent.com/twHMjbJqO8JcLrRB_GA7JRI6iuNbsoslC2cg0PrhSxky3g2aKX2GScrsyDVNrDpkn0RzE_wNcwymEXvsaVfcukYRiNiekTlkotmHXMzaNFSB8fJxOa5BYc7Utu4p-Da_GR7Db1_aTt5nknL3EztkYYPJlaM7Nz_ze7PKsiqaarBYME1mmfsKVFGm0-DaxoY3MW1HhuSL6ZEKSCJH_Xykoa9MnVwXLihLr6TQigJ5uC3FyrukcvU3raMaigfDdO-_kVE4J8F8yqn7yXN1hn_V23yddgdfMz-Hpihak2hrVP-o8hvSwD2rjAqI0UyiG2n0BC5Ohvn4CeGIwRAe7o_ArW-1qW8_vhgNpystqzJGKD5-zs9AXoWlqruDfOnivvo4uRiU7_qYyf006gh1-p1W1jZPoguyG7JwEj3h9qjRhmDdyIAW4Q1Jom4VHvTciv8vY52eA6p-SuGaw3xmdrZ-qvbBebK8morPBQytX6Cjetx7pHp_F7hwlmFtNcEbEUwoCtmy8DGVvbzSL6fd7uqcoEjgJCg2H8cdwSdkM91iReFgjvqykIxMq4jwGhDtzMoc9YC5zTyrbYlfWbLo13B5QE6WVciH3w-u1-3RoFb3hkKZyUh2Ol5_IxH_di5xzoCd=w1078-h757-no)
13. Click on the plus icon to add tomcat.
![add](https://lh3.googleusercontent.com/CSdYTf_dYRwgeD-WRjb8QAUwimYOCUJ9j4ShrTj3D0s0YEmyt6c_f5m7e2mMpIwh2rluZgN3tgAmsPKDIbHBV5ypRpKdHbi3lj5jRBpvH3w5hgy01cb5Qfoq0Sd_qD-W9-QaEm9HCdNSUEtZrpLlXfWtgPKzmlSAzBGwG1DHBU5u4S8S9-Ag6wzLA9fbqWQR5JMH2tR8iLaK1o2ANKPgbVpM8coJGHsBCL6VPP3NYBS0SWTNuBg3mRMmHDA_-6ntzxiATErFDf2ZbAqyQtbdrLZ_maUbt5I-nSliYf_A3C67QC7phskfn74XD80LsubmNfs__aHAw8Nyc6KBYk9GiwgBr8MnjsUEQW12O2u-iDHbiQmlRugsRd0r-7WuytFkUwp2doZR4wWsDd5_8UkJkyWzwq6WBi940wYnJgHr5FaQ-eCVAMoIIpVEbq8C81YmLUoQ6_wNsuU6VNXjuKIqqAEd7dUCgODfeAutQwOy4K3bGP5gwfSa78nZnsAfI60PJ6c8d4ZWtF-NyejP2AIlyeAThnpRNsl-Meeca85r0grnHjiL-lIJilhmGB1KtA6DKeKmDBfHMq_jwlXv0svZosBLSBrzvLy2qSg4y4Lcccz1gahnQyQDy1AIu_cBJBDt=w789-h703-no)
14. Find the directory where your tomcat is installed and link it. Usually it's in C:/Program Files/Apache Software Foundation
![findtom](https://lh3.googleusercontent.com/WaSMWUz6KI76OhJSy6x6rMD2qN5tHH9a5UeQvkbMsnl8ASDpEfm6BT-VjhUixmlcHf6N47FF4pjlKL8DhBWFhnf0KlPyifUalTZn5t_lZSUFimpryz7GSYA214j2GOaaR3FiQk6xlLpakaSP19S2aUDyh7VfZDUYhBsUpniN72tJ-wobgpWYEAjiVPNCf1Bwt1l6uZm7KzFZms7YNEkezNfaZ4EvpXZHe4eZhdz0Ba9pqcitC8Fq-r1xt7QrVv-h9UgSAljRIX7dEvAAne0rUX76pkheFluzeLVydxlUD6BHKgWpL-6cBEZFZd_Gj5QW8crm6JMUiltXzVRXcpLMUBHt4llkcPlkjR2KblO-fvNpPV9XOXyRavnZtpMAvQie927EKdFP4cZQpkHI9DO3cpdqKSvctawCc6e9VGdmyo5bsOzrZOQ_na8IRAdHUNy-HUpEtUlnG36c768iE4VQoarP4LMOvTeE-D-LXowPAfzAn3YJWxHJxdvmfPynzrHOM_y8ZwaFkTvwEiFPT-C2gbdfqryWiLaprDthDcTxK1cWj-zBYOaHGCbGa7PImd2pSSWYJ6Y6ocFHiYtztollYn5FS0elsqVDr4c5n2CGFrjrzdWqpS5wPxEMCebRz-An=w418-h227-no)
15. If you are seeing no artifacts marked for deployment - Click on fix.
![art](https://i.imgur.com/m5nFGGN.png)
16. Select the exploded artifact.
![explode](https://i.imgur.com/OijvJca.png)
17. Now just Run.
![run](https://i.imgur.com/0JnyDcr.png)
18. Done! You should be welcomed to my beautiful homepage.
![beaut](https://i.imgur.com/e20QgK7.jpg)

