/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
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
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        String title = br.readLine();
        String contents = br.readLine();
            
        Note myNote = new Note(title, contents);
        
        request.setAttribute("note", myNote);

        if (request.getParameter("edit") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            
            System.out.println("i need to add something here i think");
            return;
            
        } else {
            title = br.readLine();
            contents = br.readLine();
            System.out.print("new assignment");
            
            Note newNote = new Note(title, contents);
        
            request.setAttribute("newnote", newNote);
            
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);  
            System.out.println("we went into the else clause");
         
            
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
            String updatedTitle = request.getParameter("edit_title");
            String updatedContents = request.getParameter("edit_contents");

            Note updatedNote = new Note(updatedTitle, updatedContents);

            request.setAttribute("newNote", updatedNote);

        if(request.getParameter("edit") != null) {
            
            System.out.println("we pushed save");

            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            // to write to a file
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));

            pw.println(updatedTitle);
            pw.println(updatedContents);
            
            pw.flush();
            pw.close();
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response); 
        
            return;
        }
    }

}
