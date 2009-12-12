/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.louderthanreason.cdntags;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author jared
 */
public class CdnTag implements Tag, Serializable {

    private String id;
    private String name;
    private String src;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private PageContext pc = null;
    private Tag parent = null;

    public void setPageContext(PageContext pc) {
        this.pc = pc;
    }

    public void setParent(Tag t) {
        this.parent = t;
    }

    public Tag getParent() {
        return parent;
    }

    public int doStartTag() throws JspException {
        StringBuilder image = new StringBuilder();

        image.append("<img ");

        if (StringUtils.isNotBlank(id)) {
            image.append(" id=\"" + id + "\" ");
        }

        image.append(" src=\"" + getCdnSrc(src) + "\" ");

        image.append("/>");


        try {
            pc.getOut().write(image.toString());
        } catch (IOException ex) {
            Logger.getLogger(CdnTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    public void release() {
        pc = null;
        parent = null;
        name = null;
    }

    private String getCdnSrc(String src) {
        return "http://i.imgur.com/" + src;
    }
}
