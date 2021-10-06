<%-- 
    Document   : viewnote
    Created on : Oct 1, 2021, 8:18:39 AM
    Author     : rmjba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
        <body>
            <div>
                <h1>Simple Note Keeper</h1>
                <h2>View Note</h2>
            </div>
            <div>
                <p><strong>Title:</strong> ${note.title}</p>
                <p><strong>Contents:</strong> ${note.contents}</p>
                <a href="note?edit">Edit</a>   
            </div>
        
    </body>
</html>
