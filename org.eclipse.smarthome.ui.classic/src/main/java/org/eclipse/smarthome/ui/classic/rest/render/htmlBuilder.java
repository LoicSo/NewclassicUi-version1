package org.eclipse.smarthome.ui.classic.rest.render;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class htmlBuilder {
    private String htmlPage = null;
    private String Url;

    public htmlBuilder(String url) {
        this.Url = url;
        try {
            buildHtml();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void buildHtml() throws IOException {
        String url = Url;

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
        htmlPage = response.toString();
    }

    public String getHtml() {
        return this.htmlPage;
    }

    public void setHtml(String s) {
        htmlPage = s;
    }

    public void replaceInHtml(String old, String newString) {
        if (htmlPage != null) {
            htmlPage.replace(old, newString);
        }
    }
}
