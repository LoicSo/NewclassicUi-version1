package org.eclipse.smarthome.ui.classic.rest.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ReadCameraProperties {

    public static void main(String[] args) throws IOException {

        CameraGetPropertyValues properties = new CameraGetPropertyValues();
        ArrayList<HashMap<String, String>> list = properties.getPropValues();

        Iterator it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

    }

}
