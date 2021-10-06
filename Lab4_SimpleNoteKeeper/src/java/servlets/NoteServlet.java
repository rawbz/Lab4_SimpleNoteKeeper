
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
            
            Note myNote = new Note();

            myNote.setTitle(title);
            myNote.setContents(contents);

            request.setAttribute("note", myNote);

        if (request.getParameter("edit") == null) {
            
             getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            
            return;
            
        } else { 
            
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);  

            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        if(request.getParameter("edit") != null) {
            String updatedTitle = request.getParameter("edit_title");
            String updatedContents = request.getParameter("edit_contents");

            Note newNote = new Note();
            
            newNote.setTitle(updatedTitle);
            newNote.setContents(updatedContents);
            
            request.setAttribute("note", newNote);

            String path = getServletContext().getRealPath("/WEB-INF/note.txt");

            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

            pw.println(updatedTitle);
            pw.println(updatedContents);
            
            pw.close();
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response); 
        
            return;
        }
    }

}
