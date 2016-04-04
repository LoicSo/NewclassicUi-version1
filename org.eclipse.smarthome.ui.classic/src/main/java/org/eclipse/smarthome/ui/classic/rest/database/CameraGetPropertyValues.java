package org.eclipse.smarthome.ui.classic.rest.database;

/*this class takes all the cameras in the properties file
 * and put them into an arrayList in order to use them.
 */
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

            Set<Object> keys = prop.keySet();
            Iterator<Object> i = keys.iterator();

            String str;
            String[] strArray;
            HashMap<String, String> cameraInfo;

            while (i.hasNext()) {

                str = (String) i.next();
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

            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return list;
    }

}