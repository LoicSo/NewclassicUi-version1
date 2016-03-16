package org.openhab.binding.upnpcamera.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class CameraGetPropertyValues {

    String result = "";
    InputStream inputStream;

    public ArrayList<HashMap<String, String>> getPropValues() throws IOException {

        // Multimap<String, String> myMultimap = ArrayListMultimap.create();
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        try {
            Properties prop = new Properties();

            String propFileName = "camera.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property values

            Set<Object> keys = prop.keySet();

            Iterator<Object> i = keys.iterator();

            String camera_name;
            String str;
            String temp = "camera_";
            String[] strArray;
            HashMap<String, String> cameraInfo;

            while (i.hasNext()) {

                str = (String) i.next();
                // System.out.println(str);

                // strArray = str.split("/");
                // System.out.println(strArray.length);
                cameraInfo = new HashMap<String, String>();

                strArray = (prop.getProperty(str).split("\\|"));
                cameraInfo.put("model", strArray[0]);
                cameraInfo.put("video_url", strArray[1]);
                cameraInfo.put("image_url", strArray[2]);
                cameraInfo.put("pan_url", strArray[3]);
                cameraInfo.put("tilt_url", strArray[4]);

                if (!list.contains(cameraInfo)) {
                    list.add(cameraInfo);
                    
                }
                // camera_name = temp.concat(strArray[1]);

            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return list;
    }

}