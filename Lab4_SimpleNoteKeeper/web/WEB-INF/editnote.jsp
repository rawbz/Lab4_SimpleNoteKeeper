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
                <label>Title: </label><input type="text" name="edit_title" value="${note.title} ${newNote.title}">
            </div>
            <div>
                <label>Contents:</label><br>
                <textarea name="edit_contents" value="" rows="4" cols="30">${note.contents} ${newNote.contents}</textarea>
            </div>
            <div>
                <input type="submit" value="Save">
            </div>
          
        </form>
        
    </body>
</html>
