<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CdnTags.tld" prefix="cdn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <title>
            CDN Test
        </title>
    </head>
    <body>
        <p>
            <cdn:img id="product-image" src="/Y3HU2.jpg" />
        </p>

        <p>
            <cdn:modify>
                <img src="/images/OfkKz.jpg" id="second" />
            </cdn:modify>
        </p>
    </body>
</html>
