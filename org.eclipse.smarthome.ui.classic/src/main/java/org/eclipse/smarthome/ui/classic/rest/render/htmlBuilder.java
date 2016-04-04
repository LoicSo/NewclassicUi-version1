package org.eclipse.smarthome.ui.classic.rest.render;
/*this class is used to replace the values of the cameras in the
 *html. the informations to be added are
 *NomCam: name of the camera,
 *urlImage: the link to the fix image of the camera
 *urlVideo: the link to the fix video of the camera
 *pan_url: the command to the pan
 *tilt_url: the command to the tilt
 *
 *this builder support only 4 cameras for now. if there is more than 4 cameras, only the first four are displayed
 */

public class htmlBuilder {
    private String htmlPage = null;// the snippet
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

    public void addCamera(String NomCam, String urlImage, String urlVideo, String pan_url, String tilt_url) {
        numCamera++;
        if (numCamera <= 4) {
            htmlPage = htmlPage.replaceFirst("%camera" + numCamera + "Nom", NomCam);
            htmlPage = htmlPage.replaceFirst("%camera" + numCamera + "Img", urlImage);
            htmlPage = htmlPage.replaceFirst("%camera" + numCamera + "Video", urlVideo);
            htmlPage = htmlPage.replaceFirst("%camera" + numCamera + "Pan_url", pan_url);
            htmlPage = htmlPage.replaceFirst("%camera" + numCamera + "Tilt_url", tilt_url);

        }
    }

}
