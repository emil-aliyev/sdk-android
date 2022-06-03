# To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  and
  
  Step 2. Add the dependency

 
# implementation 'com.github.emil-aliyev:sdk-android:1.0.3'

-----------------------------------------------------------

How to start SkyTech SDK
----------------------

First Step : Create user object and include  language, user email, user full name and user phone.

For Example:
----------------------------
      val userCredentials =
            UserCredentials(
                "en", Contact(
                    "user@test.com", "Name Surname",
                    "+994XXXXXXXXX"
                )
            )
 -----------------------------------
 
   SkyTech.Builder()
            .key("key")
            .appID("appID")
            .userCredentials(userCredentials)
            .open(this)
	    
 -----------------------------------

Second Step : Get SkyTech SDK credentials 
----------------------------------------

1.  Sign in to the  [SkyTech Web platform](https://pre-web.kapitalbank.az)  and go to the  [**Apps -> Livechat app**](https://pre-web.kapitalbank.az/apps/webchat)  page.
2.  Click on Install button, if you didn't installed livechat previously, if yes skip this step
3.  Next click  **Configure**  then  **SDK**.
4.  Copy the App ID and API key.  
----------------------------------------

Third Step : Start SkyTech SDK with this example.
-----------------------------------------------

 SkyTech.Builder()
                .key("key value")
                .appID("app id")
                .userCredentials(userCredentials)
                .open(this)
