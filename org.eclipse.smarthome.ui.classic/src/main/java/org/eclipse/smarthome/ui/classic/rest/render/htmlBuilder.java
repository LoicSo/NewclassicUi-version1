package org.eclipse.smarthome.ui.classic.rest.render;

public class htmlBuilder {
    private String htmlPage = null;
    private int numCamera = 0;

    public htmlBuilder(String oldSnippet) {
        this.htmlPage = oldSnippet;

    }

    public String getHtml() {
        return this.htmlPage;
    }

    public void setHtml(String s) {
        htmlPage = s;
    }

    public void addCamera(String NomCam, String urlImage, String urlVideo) {
        numCamera++;
        if (numCamera <= 4) {
            htmlPage = htmlPage.replaceFirst("%camera" + numCamera + "Nom", NomCam);
            htmlPage = htmlPage.replaceFirst("%camera" + numCamera + "Img", urlImage);
            htmlPage = htmlPage.replaceFirst("%camera" + numCamera + "Video", urlVideo);

        }
    }

}
