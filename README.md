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


