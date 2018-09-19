
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
![homepage](https://lh3.googleusercontent.com/8kRsJSg17jeClcSLR9EfR6naP0OH69urw0Q4GUC9DNpkgbTnWMRYhO7mAYSRs9lMBRTXVdHwMJwvmGc8A9Im8OQ2xVaKZRORlLH9rcVm8jmVoM7ZMDST1gE8wg-zYknCWXUnKjjinfm1ExJn4fhCncuIffOCYrVuX8xYovhjpnLfj-TJzJK5FvUI1bxwhLh6i0TC4L1ZT-0WkGJA7ZvK5eSafW96E6oRBMBpImPLguB_klIK3CJ0dms6vWiO3zOLbWWWJSIWJRiGtwjp1YcS3uJZxlXdTHeLpf6MASXTakU19kN3z8SoK9iyu0RwIrLsgx7zOELfsdQc5IzLRp6MTiQ7dnrree7oXvnfPcZr7rFY-Ng9bNTtVa719ey1Vbj15mkB10sddyHx19RxorUk7F2yan1sg2_LdL1ZM1impDaopsZvZA0ToS_l7me4aOdNDCMC89nvRpgRlGsN-w_jIj9r5t5xynWoMNgsT6qk_8QUkxhlyQCupZ3rOuQZ7XYjrKk8hlNRLalCc_kYuZWOuDZt4XhItqK8-4PzGgYj8BwazEy2TrKuir8-mgGJ0IBWHoDph26TILAytea55LoWntUPgTx9aV5YT8KeqAJFBdjN-dgUmA75hoiSpDXNRxG2=w2560-h1306-no)



# 1. Registration
#### Registration controller checks for existing email addresses in the database before letting user successfully register, validation is also present for password being handled by both JavaScript and Controller. User is automatically logged in after registration.
![registration](https://i.imgur.com/dgXqESy.gif)

# 2. Login
#### Passwords are hashed using Bcrypt. The configuration can be found in [src/main/WEB-INF/applicationContext.xml](https://github.com/th3pi/may-i-rent-e-skates/blob/master/src/main/webapp/WEB-INF/applicationContext.xml) Only hashed passwords are stored in the database.
![login](https://i.imgur.com/Mr2y3gg.gif)



# 3. The order process
#### Click on the add to cart button to rent the product. Everytime user clicks on add to cart +1 day is added to the cart. User cannot order for more days than allowed. Spring web-flow handles the entire checkout process. At this moment user can only have one billing address or shipping address at a time. They can be different from one another. Checkout information's autofilled with user profile details. Order can be cancelled as long as order status is "Order Awaiting Confirmation" Configuration available here -  [src/main/webapp/WEB-INF/flows/checkout/](https://github.com/th3pi/may-i-rent-e-skates/tree/master/src/main/webapp/WEB-INF/flows/checkout). 
![timetrials](https://i.imgur.com/5WHpcjr.gif)


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

![productpage](https://i.imgur.com/SIpwOvI.gifv)

# 7. Control Center
#### This application has a very powerful admin panel. The admin has tons of information presented to them whenever they access the Control Center. Control Center shows up on the navbar as soon as an admin logs in. Admins are not allowed the luxury to rent a skate.

#### As you can see as soon as you enter the page you're greeted with a monthly sales graph that updates every time an order is confirmed. Sames goes for the Financial Stats section. 

#### Order stats where you can see all orders with statuses that require attention.

![adminpanel](https://lh3.googleusercontent.com/5OZHiEondVznrOvqRAyXuvfzcPV6Mb4nvV7ZFsDxOmFRwKNc6ljRBzqOQcTSRj6jXQenSb29oFeRwDFZkoW3a6HsyjENjJ17Vq56JH--mMAdhecVUexH4BK08X6cxmkJZNQLhXrzktkwmcwe61M6996dFYyNwYWfRRofI2CHRUG4984HIsky6iitQhrEn3Ey-hG2qjMder7Ml1JOHHh8t1VER8VZNS7U8gOuG7UostHTEY1AE5-Z-LzVU3-uOoW7CXZyoW8YK7bPLDBwKV1PZqQggPSTvEhVW2noKDS6XtMM5MboTcWVO-bQ_kouZiWp2oWFDBcgaj8dIv8q-vmpEZtzHdEq9GekHFVVkJYeYgFkeqJ6wSSuhKYelcg4dnCDs_gPni6GSLDIqx-lB9TiphbewnrWDkXyPOochGqeJfEESQh-GMQHHDQOn91CsUGNKupxvcDIS-J3LYtY0weNgpUtAgK0kgX88qInB2excpz81kr7P7klZh7Vkk2Ty8RpypmUc2Qi2S8SnvKyG5AW8JvxeEDCfqw7ug4FzfqjGP0sP-7mRG2IDJVQmU_xu26Pf9aY9VKdIWjP_4mYNSMbSuzM2J4mrYXvkfhyHeG8kZyo8uGg44rADSG_1FXmRoPG=w1680-h858-no)

# 8. Managing Products

#### Admin can disable or enable products. Products disabled can no longer be ordered until re-enabled. However, they will still show up in User's order receipt.
![disableproduct](https://lh3.googleusercontent.com/dr75OikR8wBYxxMl6RnZOP_aCmVBOOTMhsagHpaMvrwKAtewtZHyY9I9oM2hJh7dLYZvkL-m82LZ4fEGVT0yKC5gI5I1fsCG41TSO_kjvhZms4cDlCD7Qb5Z0jF5p4BpXm6kqk1gSgDsov4T-vah8jv2vHiQpZYonk0pQLYF2Cs-Fra3l6-VjoyHuUVvwH8u6oMoXoTFcMharXOLYRnizsVZmb2v_UfAHATX7_ESk_FNDffXOePdDdogpehR1hdiF4UeC733aNmsCoQ6NbwdrjtD11eY92b5txfiukP6yGdw8JJ6vU3GfC5u0ZRpRvRNkL6a6CYBY5zHHJluFZH4vl0dYI0mtTAvmaHagUpuvZiAk921gORTKqYguF7sN36uacE73mLf5XOke5oPBMGaBQRb5-SmOdm0UoekglUFxkOSNTbS3woQruJbdAGF-31Y_Ra56d-kWjSkzCQX4HovJN9mRuCRETViIMTSIxbZUlsB2wUngVB-JoTCyUXmqk83AHP6CgGGeI37PpCuoXy6y0kep2b9a5ViIDyXw_NwLrCUcy5HLreWrkGgaEFdnV4FSsp_tFXZ44uzEiMc-C-1PSbKcCwr37Jo6QPX_h0Z-uUo9xZV9Bu7jHsIwX7Q6cMo=w1680-h858-no)

#### Admin can edit product details. However there is a bug right now, after admin edits product details - the rent limit disappears. Admin has to disable and enable the product to fix that.
![editproduct](https://lh3.googleusercontent.com/ydH-cA45bYTnHQ2KmuQ1SNVhyaFeLa8atFTAymTSIw19TuoXKw95n5RHYUaiKLgqmQ8On3yEeh9R9c-zZb26EuSujlX15rSeqFGGIwnGATjESpISV3NuFU2goeZ_cdQnlIRNvfX7ZEwEDXhwrv0uOmCQr3UpXXQRcJyCtFB2enPzjCPbhm6mZrvMSIRQBOghCjR9lDUXlEo1kogmmhKW-2fU8oqXr_5t1SiS3vgFhvewQ8ciaYLgIma7h4x1vY-IAv4TW9PiQEqzqZl3kmzpiAfFCMKJnrtCMOlaOBt-BfnnVwnPnwkxVzUf1COeHeyLY08YNi5ZkxGdXArPNnyz6dgfZN071tjwDd4C4ThOrDWQOmzRxq8k03YtqQdKrepD6f2qlxzNlFcZtqQY_EH7sFPOeAtonq4NqQM0oTmob8xGXqVK3fdQSSOG7zuh3mriJufHO3jP1WmHnoH968L5Cq43JL9Rf-wa8TzlRJcjPNueAwk54sAwN5cj5AHWrWy3A7m5LFLcImYzZdmA3VRioL9_8PWflBRk_iZVBdwBxOdjVtry3N2qDu8NRJ68O9BulrLYGks-U3HIbDrn8AZ7S-y4rffiwPapDn2Y_Z1lNM9XIqaKjUhRaOVId1kF9yu2=w1680-h858-no)

# 8. Managing Users

#### Admin can view user profile and edit user details.
![viewedituser](https://lh3.googleusercontent.com/OYBSi2tr22JqDwQfcU9U56kx6zsd-O7eAUZza-2UerOdxTYvOhbk5Y3YxPaDdA-rV3Pdy1HGBF7hfhIVjNdvoIuOo5wPU69DgNGEZTWp3QewORk6PgCjURYmFragtwON3HlsARVt2qOt8S2gD5xE0uAtT5DzQjc9AojF1aGzX2xh5z0tLyXxnFGSRdk17VuyxV173ZjKUYUgGrcKI-DYkK2Odab0z30p3hkGelnYPolUUm96TaVn3CBjAX8QmRrln4gOBCA7wbVMtlshntU4PdOyY743QgJXAzN5n9SmmWPAp8cLv22DXAkiQHtgVUINTZAzHC5lIxcJG0vyHVfADrJNB1roJYHvitZ2d59JKazpWlgJbipWvaQLlDld3gIan_cNBL5_VIlWkW8sk3OJrDcKpZsfr-E80VUbwfe1Hrhq2s2C_76WO4tIt-U-G4duLpLoDrqBAldD2wbFu8jE6PLWbmZvCQMNjIWDwcwkUX6v__vJI1m9NW4xO19WhJjRvYOWv4F9H2FClvg4AiDy_GMUWSQoSQiX7bk9QmIrFMycO1d4fjawUxYAphtH2s7r9zO3cp35MVurDYOB2t74LX2VFowLJbWznniwqF_9sY9Zk43tmEso8NZsSyXUuJdO=w1680-h858-no)

#### Admin can add employees and users.
![addemployee](https://lh3.googleusercontent.com/sY32pMrH-oXbEtn32LDe1mv3N5oZrjs4LQMs_FIUrE6ODCIPTgSrLQaZm2X2hrLsnOH8sW_-ZFT05tkEeasHidmjA3SH7dzCWYck9KTR9othvmSU9IhRa-tIFYwY0gnNL_FLKSuNS3-20NtkSJrIkEQgu2yeGQg1iq22_jH9_mquJvLLcH56VHYHw2JBrFW23REDy25X-LKe7FaDYjJaXKLOZkRuQBVKPooIzwDhq5SUUKdEyYMt1GAjFso05HD4dv6jMDTrkHdrhKPunyhV-6ccjbRjm_3VNLRP9egsVdVZxfHHk-uShEOYK8pKALLxAOsWUHp1j9pv2T34VnY0cGOstJ8ATEkp7vy_WtM6GgMPlePiZmJYNprQaKrGMQyDTorux-BJWGLEAoiEnyjMuOqGXep_Uw_43rijW2U0fx3zdb3SjG87CTmFsYiIaES0m4sTy8y9P4qkYERsGeLxGGkv9Z3k3Y8BwzTqm7Et01k8G2nDZxru4o3IDmKksOQVsx3CVD-nGm42BAUhB-fTtDUESJ0_BceRaRkeodFMUqtE3hiD_MG7A4tJZShmqZBZPQer4rSkTlPIcnTG0azhqQdSudkYVr8GfO2BzaztEtZ6imUn_JTvWSGltgBVzmEs=w1680-h858-no)

#### Admin can search for a specific user by any column.
![addemployee](https://lh3.googleusercontent.com/D2E4uT2mNxOsI_4rEZK0m768GpO8Is3YoOvLRljaMQPCSczqTjUJuAsV8F5droelFYUpZlHUYI1uq7Y2xMs8eU6RDEVd1VC7UV0SZw_-k3RQvXds2phLibMDw6Q6RWi1KULlnGl5aR0femk1WT4JaQEYJkwv00besu3ygUQwDnPEzsjJmTuEK4j9LY5EuBGnE8Wg0lVhAJQ5br1ZgS-LYx5SuobI5DS4pR4GCZICXvNkTiiwmSUbCszIbtiAaKLzc45dbDH61wbFXFp0S-tQ75IZlJ1nFWkFA1Hhx1b5PF15m0STer5UkeXtmjX_DloTn60ciWJG3SqypYY0Om-7pwFOtDXqEAzFEsATyFzJxI65dgeEqGDQQxbnQUHGgh1S_MgQUdlxEl2Kuz2g80nj4_ZsfF1c8qdoBxvxACZg5-OskKr3vQyEKWrEzFyAOMMcNXgpjjLvMPMKP8y-aSANlmc36SF3p219zgqAxyCMc4zPx0S9O7po3F8fXuT6enNRH0WFgqQNtmYzbf142U3_VatNsPnPZeQr3_nZ-dRxnnXAYEt6YPC6VScRSVW2OOU_oZohJZzO32hsXmtXOZZUNxrS-eOpEeG5VU3V-ikqwIlRdVoU-6L51yDJEtLjDe6W=w1680-h858-no)

# 9. Managing Orders

#### Admin can update order status. Even has the abilitiy to cancel orders. Admin can view order details.
![orderupdate](https://lh3.googleusercontent.com/Sef2gixkWjcHbzk_-Ho5bhbIaOyzvibPPlOpOz8GVQCvloffJisopa2yj4YT6PzBgTDEECr1HkU7hFRMGC0l6PskC2cBrQxUpSijTS0XFZkatkzMAuOmth_AL8T_E2i0HHbzAfSx3qy2k81zgNXrxmOuqcMWjQ61IjYeMDZXuP7BjqD63aNYQHzzthEfNG1Bg8hfOzVY2FTBXZPWy6XY8HRlRWLV-j7_WzfrXJeSCxT-R9AV6l34hkyBR44UJsvIKwnlikB4WhcFkAZA0jnF6uEkgiHGRkxEWHRL1-a44FiYs6OnSlFBEoor2x9p99gahiZd9MdbMQ8h6_o51HXx8BKNFA8uAgMa9lYqgQjXKv_Q_aeuRSLlWY0JyZKCz9RCjKyd3F03GOFxkgqoXnzEvjdzAfdsz5r-UF2VizY0LBeOFQJ-vcFfG4BnbksBAZN5ii8EVyCztCuhwuGyq4h8W3dRdiKus-RfKkOvGmnfunWieHTbtxByrKU_3y6hG_oYV7k_I4JDK995X4MOcrKnccMoEIEWbBNg5na8NwVrVn8Oc_lROnmq4H4Nm5jNiRfSi1awsUf7YfOlqf4Op7JDDIDswIRLF8yb6iPwEp6xPPkZ6c6w6332jcv-2VyPrJzN=w1680-h858-no)

# What happens when...

#### 1. Admin visits the shop, can admin buy anything? 
##### Ans: No. Admin has to create a separate account for rentals. Admin will not see the option to add product to cart. Only edit.
![canadminbuy](https://lh3.googleusercontent.com/dGKdsp45bTli_Xxi4TEbP8r00tPd5O_wkkY60idH-ccw8m1l_htspMdoFdUOGBDCzC06n0WFyfQLr4ZMNHiXnSyG6wUgeWTUwMlK4mw5ZWifnxO7BWrrF3LlnYmIpZ_hIDf78af-FM6_eORDoMp6YjEsUpfyJ_dH7tCSmHkGt8812M4ervTi08OZYa0CE0JBiU0Qm0wf8B6VrJbdfq1Zj1mYXMW-junnVa5qFw7J-Q3ZsmVWYKJ1sew8ufrVBS435H-E_-CEDWiBr8nnxQE-w4ioQTam-oGpLw0fNgwsk8aH1v5JaSRSy_AsLWDvY9UTPDWcJ8XhcWOLpw0OgKrCA1VWh6bxhYP5xLcXpR-2EcGnGmIHcTXFKAyDsToaa3_iuLOlAdZCbjNxWK0u9W-jO461sWKAOk7efOd7H3aVYEVbYIwXXyQ5fL9HOnd5m7XF0RFkV5jMVcKujBWzTFjaEvSp3BwaEqMN5AzyUH-iLu41vhsrsE2Psr4aDcxyAJR-X-Zi-C7U-l05hiLxzAKULYjaUBjtX_POP2CTeDsvyATI-MKoXGMu1_1EqvfgqPHzmDO7MPIEjCVmz6YFC5uzfAV3zVvWHdly6vBch1t-_zx5El3T82dhmyEcK31HhNWu=w1680-h858-no)

#### 2. An user tries visit another user's cart, profile or order?
##### Ans: It is not possible. User will see an error page.
![canuseraccess](https://lh3.googleusercontent.com/ATN4r8JW2EUsnMCaAkYazKtnFBnvyyOi980yGH513ADhgXTwia6sQopVM8Q2IJJKPfR3DrXjDJajHIu5ObZ8f663iE_jSxN0ctVtcRH1RzFa-5j8NrAFmMgiykrx6VeztaBFFUhK2k-lqQNDiMf6UsAOvBJLP1WWYHq1-8rXmso_oWZ8K_HitNrlAjcw52A4hsLNLWWXYpPcz8hSZDF82XWxHk4219jA75nkTDB8nlBuHZjfzjBk_UuQ2PufFxKkZMYnsdKUxevx8Sr4UchERy3Gk813zJrCmC7TtDeo5Ow00UhTG9S-vAwVqv0atzBagA3jlOPq8weZz3jd9ZeS7DoR4MfApHWX6-nRZjWBmJ8tIIyZYngDfskJ6ul8XOnSzzNtGwaS79IGpEZGoOqKmDJIjYKKLEhQqwzD2YYM1RJrJ6iv4jtZvs42M6JRsDxCOBL5IikTMXupUDhrTTdEkXX4K8Xp-Jsap6HZdItuHm3PNVP1aq3sbOQ9fu5n-zknTHnRsohUjV0oZWEOH1PbxoZSuvff7UBampzQFVvdVmAXwE9qiDBb1lSVChDlBSAHmJ4iNPYKjYz2rSyX-IsN5KY9EOoHuc3rbql8vj_IWv-AT1V9fb_ijhFmqNPdY5XA=w1680-h856-no)

#### 3. An user somehow accesses a disable product page, can they still order?
##### Ans: No. The button will be disabled and will say "Currently Unavailable."
![disabledproductpage](https://lh3.googleusercontent.com/MEyDG44KBbHIr5zfmscfekiemQpWb1L5ZzRjcOwIUVM4ugmT0rHFGS7M-qUJGBhc60o-f2YDfQFcw1-ZtrRMFMIx31RUOn50bAJJHAAuz_S3nP-KaVRfX3fy1mKgF_uxBkSkNhbD97aWYGWwFemb5dtBvpxsb56QXFyztQ365wq4E0fJVR_KTB7-i7HYws2TWJe8yHKC7eZOWynaAHm7QkAVETynxwxjI0ldwWYDZCqnbD5FtomvDwPHZ7TbolC0tCRfHGQuxgBPSemolpslSKhYwl9FrwfIzYizDXSn4bzxAlMNIr543pgGkct85Iu-IEoU2K4VVHhnp5CjQxuAVUuokuED64tDVMT1xXtN4pE8fd66gBVUPJwuWeNL4UbZE1URonFj7ldNyKKOF4BeY1_MdBsbU-c4tFrqdOdfHZLZTALDzvxF2Ggp775VKm7zsiuGqlDCQ5U-Si9Sd870ff1Vylp97wyX0N53hJELbLD8q2iMH3C1ChyJcwpP4iRbIC201xUNkvOTNepTr9JPjXO5kU7CsGi6NitPWOqwizVZkDRgwxa9ZLwWoY1UV2CHLQGYVjHvqqdkgsEr9SafOMA-q3B146uBTGVtvbFllFEhH8zCRBHjKhg-yZKZXHmT=w1680-h878-no)

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

