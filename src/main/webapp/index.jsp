<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CdnTags.tld" prefix="cdn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <p>
            <cdn:img id="product-image" src="/Y3HU2.jpg" />
        </p>

        <p>
            <cdn:modify>
                <img src="OfkKz.jpg" id="second" />
            </cdn:modify>
        </p>
    </body>
</html>
