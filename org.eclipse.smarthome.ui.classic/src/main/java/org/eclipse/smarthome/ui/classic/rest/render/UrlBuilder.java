package org.eclipse.smarthome.ui.classic.rest.render;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.openhab.binding.upnpcamera.database.CameraGetPropertyValues;

public class UrlBuilder {

    String StreamUrl;
    String ImageUrl;
    String PanUrl;
    String TiltUrl;
    String ZoomUrl;
    String ipaddress;
    String modelcam;
    private boolean registered;

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public UrlBuilder(String ipaddress, String model) {

        this.ipaddress = ipaddress;
        this.modelcam = model;
        this.registered = false;
    }

    public void BuildUrls() throws IOException

    {

        CameraGetPropertyValues properties = new CameraGetPropertyValues();
        ArrayList<HashMap<String, String>> list = properties.getPropValues();
        Iterator<HashMap<String, String>> it = list.iterator();
        while (it.hasNext()) {

            HashMap<String, String> temp = it.next();

            if (temp.get("model").equals(modelcam)) {
                StreamUrl = temp.get("video_url").replaceFirst("IPADDRESS", this.ipaddress);
                ImageUrl = temp.get("image_url").replaceFirst("IPADDRESS", this.ipaddress);
                PanUrl = temp.get("pan_url").replaceFirst("IPADDRESS", this.ipaddress);
                TiltUrl = temp.get("tilt_url").replaceFirst("IPADDRESS", this.ipaddress);
                registered = true;

            } else if (!isRegistered()) {
                System.err.println("The camera model " + modelcam + " is not listed in the properties file"
                        + "\n please add the camera configurations in the camera.properties file \n");

            }

        }

    }

    public String getStreamUrl() {
        return StreamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        StreamUrl = streamUrl;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getPanUrl() {
        return PanUrl;
    }

    public void setPanUrl(String panUrl) {
        PanUrl = panUrl;
    }

    public String getTiltUrl() {
        return TiltUrl;
    }

    public void setTiltUrl(String tiltUrl) {
        TiltUrl = tiltUrl;
    }
}
