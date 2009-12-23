/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.louderthanreason.cdntags;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author jared
 */
public class CdnModifyTag extends BodyTagSupport {

    private String cdnBaseUrl = "http://i.imgur.com/";

    @Override
    public int doAfterBody() throws JspTagException {
        BodyContent bc = getBodyContent();
        String body = bc.getString().trim();
        bc.clearBody();



        try {
            Element img = modifySrcAttribute(body);
            getPreviousOut().print(img.toXML());
        } catch (Exception ex) {
            Logger.getLogger(CdnModifyTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SKIP_BODY;
    }

    private Element modifySrcAttribute(String body) throws ParsingException, IOException {
        Document bodyDocument = new Builder().build(body, "");
        Element img = bodyDocument.getRootElement();
        Attribute src = img.getAttribute("src");
        String cdn = cdnBaseUrl + src.getValue().replaceAll("/images/", "");
        src.setValue(cdn);
        return img;
    }
}
