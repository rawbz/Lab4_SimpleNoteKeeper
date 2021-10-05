<%-- 
    Document   : editnote
    Created on : Oct 1, 2021, 8:18:50 AM
    Author     : rmjba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note Page</title>
    </head>
    <body>
        <form method="POST" action="note?edit">
            <div>
                <h1>Simple Note Keeper</h1>
                <h2>Edit Note</h2>
            </div>
            <div>
                <label>Title: </label><input type="text" name="edited_title" value="${entered_title}">
            </div>
            <div>
                <label>Contents:</label><br>
                <textarea name="edited_contents" value="${entered_contents}" rows="4" cols="30"></textarea>
            </div>
            <div>
                <input type="submit" value="Save">
            </div>
          
        </form>
        
    </body>
</html>
