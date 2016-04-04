# NewclassicUi-version1
This is a modification of the OpenHab ClassicUI that takes in consideration our new binding upnpCamera and show the result in a webview
in order to achieve this, we overwrite the webview snippet, which normally takes an url and show the corresponded web page.

#Configurations
The only configuration needed is adding the details of your D-Link cameras to the configuration file camera.properties.
You have to follow a specific format while filing the file.

#Materials
The cameras should be D-Link cameras that support upnp protocol.
And make sure that multicast is allowed in your network because  upnp require it.

#Sitemap
in your sitemap, put the webview tag 

      Text label="Cameras Upnp" {
         Webview url="" height=10
        }

The webview tag is modified to offer a nice interface for managing the discovered cameras, but the cameras have to be saved in the inbox before.

#Saving the cameras in the inbox with PaperUI

The paperUI was introduced by openHab2 to make configurations more easier for users. 
Once our binding upnpcamera is operating, you should see the discovered cameras on the screen and add them into your inbox

#Steps to follow:

##Step 1 : Verification of camera.properties file
First, check if the name of your Upnp Camera is declared in the camera.properties :
- open the camera.properties
- if your camera is not already referenced in the file, add it following this convention :
model|video_url|image_url|pan_url|tilt_url
put null, if you don't know an information of it does not exist

##Step 2 : Add camera for the detection
Go on Openhab :
- Chose paper ui
- Click on the tab Inbox on the left
- If the camera doesn't appear in the list, click above. If not, the camera is still recorded, go at the next step

##Step 3 : Verification
- Go to configuration tab
- Go to things
- The list of all recorded camera appears. If your camera doesn't appear in the list, restart the procedure
- You can delete the camera from the inbox if you don't want it to appear on the interface.

##Step 4 : Camera visualization
- Go back on the home page of OpenHab
- Go to the classicUI
- Go to your webview and enjoy our nice interface

#ScreenShots

[![Demo ClassicUI](https://j.gifs.com/82Kj72.gif)](https://www.youtube.com/watch?v=MuBX17ZaJgY&feature=youtu.be)
