/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author rmjba
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (null == request.getParameter("edit")) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //capture title and comment of note 
        String title = request.getParameter("edited_title");
        String contents = request.getParameter("edited_contents");
        
        //create note object to set an attribute 
        Note mynote = new Note(title, contents);
        
        //set note as an attribute, which will be pased through to the JSP
        request.setAttribute("note", mynote);
        
        //set attributes in the request that will be passed to the front end 
        //this will make sure if the user enters something, it wont reload blank
        request.setAttribute("entered_title", title);
        request.setAttribute("entered_contents", contents);
        
         if (request.getParameter("edit") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
         
         } else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
         
        request.setAttribute("entered_title", title);
        request.setAttribute("entered_contents", contents);
        
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);

    }

}
