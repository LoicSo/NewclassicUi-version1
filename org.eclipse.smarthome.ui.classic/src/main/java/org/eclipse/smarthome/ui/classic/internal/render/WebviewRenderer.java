/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.ui.classic.internal.render;

/*camera dcs5222l 1.11
 * camera dcs932l 1.06
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.smarthome.model.sitemap.Webview;
import org.eclipse.smarthome.model.sitemap.Widget;
import org.eclipse.smarthome.ui.classic.render.RenderException;
import org.eclipse.smarthome.ui.classic.render.WidgetRenderer;
import org.eclipse.smarthome.ui.classic.rest.render.RestRenderer;
import org.eclipse.smarthome.ui.classic.rest.render.UrlBuilder;
import org.eclipse.smarthome.ui.classic.rest.render.htmlBuilder;

/**
 * This is an implementation of the {@link WidgetRenderer} interface, which
 * can produce HTML code for Webview widgets.
 *
 * @author Kai Kreuzer - Initial contribution and API
 *
 */
public class WebviewRenderer extends AbstractWidgetRenderer {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canRender(Widget w) {

        return w instanceof Webview;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EList<Widget> renderWidget(Widget w, StringBuilder sb) throws RenderException {

        Webview webview = (Webview) w;
        String snippet = getSnippet("webview");
        htmlBuilder html = new htmlBuilder(snippet);

        System.err.println("snippet de depart " + snippet);
        int height = webview.getHeight();
        if (height == 0) {
            height = 1;
        }

        try {

            ArrayList<HashMap<String, String>> list;
            list = RestRenderer.parse();

            Iterator<HashMap<String, String>> it = list.iterator();

            while (it.hasNext()) {
                HashMap<String, String> temp = it.next();
                UrlBuilder u = new UrlBuilder(temp.get("ip"), temp.get("name"));

                u.BuildUrls();
                if (u.isRegistered()) {

                    html.addCamera(temp.get("name"), u.getImageUrl(), u.getStreamUrl(), u.getPanUrl(), u.getTiltUrl());
                    System.out.println("image_URL: " + u.getImageUrl() + "\n stream_url: " + u.getStreamUrl()
                            + "\n pan_url: " + u.getPanUrl() + "\n tilt_url: " + u.getTiltUrl());
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        snippet = html.getHtml();
        sb.append(snippet);
        return null;
    }

}
