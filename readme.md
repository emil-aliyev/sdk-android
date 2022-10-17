# Prerequisite:

Chrome version needs to be greater than 70 in order WebView to work properly.

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

 
	implementation 'com.github.emil-aliyev:sdk-android:$latest_version'

-----------------------------------------------------------

How to start SkyTech SDK
----------------------

First Step : Create user object and include  language, user email, user full name and user phone.

For Example:
----------------------------

Identity verification
Choose how you want to identify your users uniquely. Note that you can choose only email and phone from the default contact fields. Additionally, you can use any text and integer-based custom fields to identify your users. Make sure that you provide a value for that unique field in the contact object and also set it as a field value in identity object.

     val credentials = JSONObject()
        credentials.put("language", "en")

        val contact = JSONObject()
        val identity = JSONObject()

        contact.put("email", "user@test.com")
        contact.put("fullname", "name Surname")
        contact.put("phone", "+994XXXXXXX")

        identity.put("field", "email")

        credentials.put("contact", contact)
        credentials.put("identity", identity)
	


    SkyTech.Builder()
            .key("key")
            .appID("appID")
	        .messageId(null) // send messageId if you have one
            .firebaseToken("your_fb_token")
            .userCredentials(credentials)
            .open(this)
	    
	    
 -----------------------------------
 

	  
Second Step : Get SkyTech SDK credentials 
----------------------------------------

1.  Sign in to the  [SkyTech Web platform](https://skybot-web.kapitalbank.az)  and go to the  [**Apps -> Livechat app**](https://skybot-web.kapitalbank.az/apps/webchat)  page.
2.  Click on Install button, if you didn't installed livechat previously, if yes skip this step
3.  Next click  **Configure**  then  **SDK**.
4.  Copy the App ID and API key.  
-----------------------------------------------------------



In order to handle clicks on notifications there is `click_action` parameter in notification body. The click_action key is `OPEN_SDK_CHAT`. You can get more info on how to implement click_action on Android [here](https://firebase.google.com/docs/cloud-messaging/http-server-ref)

Sample notification body:

	     “notification”: {
             “click_action”: “OPEN_SDK_CHAT”,
             “title”: subject,
             “body”: message
            }
Use `ChatSdkManager` class in order get state of SDK (whether sdk is visible or not); specifically for handling notification on foreground

	ChatSdkManager.getSdkForegroundState()
