package org.eclipse.smarthome.ui.classic.internal.render;

import org.eclipse.emf.common.util.EList;
import org.eclipse.smarthome.model.sitemap.Webview;
import org.eclipse.smarthome.model.sitemap.Widget;
import org.eclipse.smarthome.ui.classic.render.RenderException;

public class WebviewDCSRenderer extends AbstractWidgetRenderer {

    @Override
    public boolean canRender(Widget w) {
        // TODO Auto-generated method stub
        return w instanceof Webview;
    }

    @Override
    public EList<Widget> renderWidget(Widget w, StringBuilder sb) throws RenderException {
        // TODO Auto-generated method stub
        Webview webview = (Webview) w;
        String snippet = getSnippet("webviewdcs");

        int height = webview.getHeight();
        if (height == 0) {
            height = 1;
        }

        // snippet = StringUtils.replace(snippet, "%url%", webview.getUrl());
        // snippet = StringUtils.replace(snippet, "%height%", Integer.toString(height * 36));

        // sb.append(snippet);
        return null;
    }

}
