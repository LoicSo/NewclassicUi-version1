package org.eclipse.smarthome.ui.classic.rest.render;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

//import com.google.gson.*;

public class RestRenderer {

    // HTTP GET request
    public static String restResult() throws Exception {

        String url = "http://localhost:8080/rest/things/";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();

    }

    public static ArrayList<HashMap<String, String>> parse() {

        String JSONData = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        try {
            JSONData = restResult();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JSONData = "{\"items\":" + JSONData + "}";
        JsonReader Mainreader = Json.createReader(new StringReader(JSONData));
        JsonObject AllItemsObject = Mainreader.readObject();
        Mainreader.close();

        JsonArray eachItemsObject = AllItemsObject.getJsonArray("items");
        JsonReader readerItems;
        JsonObject each;
        HashMap<String, String> cameraInfo;

        for (JsonValue jsonValue : eachItemsObject) {

            readerItems = Json.createReader(new StringReader(jsonValue.toString()));
            each = readerItems.readObject();

            String UIDInfo = each.getString("UID");
            JsonObject propertiesObject = each.getJsonObject("properties");

            if (UIDInfo.contains("upnpcamera:camera")) {

                // System.out.println("properties : ");
                // for (String key : propertiesObject.keySet()) {

                // System.out.println(key + " " + propertiesObject.getString(key));

                // }
                cameraInfo = new HashMap<String, String>();
                cameraInfo.put("ip", propertiesObject.getString("ip"));
                cameraInfo.put("name", propertiesObject.getString("name"));

                if (!list.contains(cameraInfo)) {
                    list.add(cameraInfo);
                }

            }

        }

        return list;
    }

}
