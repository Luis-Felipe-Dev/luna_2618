/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AD_Alumno;
import model.Alumno;

/**
 *
 * @author Luis-Felipe-Dev
 */
@WebServlet(name = "AlumnoController", urlPatterns = {"/alumno/*"})
public class AlumnoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AlumnoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlumnoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //localhost:8080/alumno  GET : formulario de registro alumno_registro.jsp
        //localhost:8080/alumno/  GET: formulario de registro alumno_registro.jsp
        
        String URL = request.getPathInfo(); //obtiene la ruta
        if (URL == null || URL.equals("/")) {
            request.getRequestDispatcher("/alumno_registro.jsp").forward(request, response);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        
        //localhost:8080/alumno/registrar POST : formulario de registro alumno_registro.jsp        
        String URL = request.getPathInfo(); //obtiene la ruta
        
        String accion = URL.substring(1); // registrar
        
        if (accion.equals("registrar")) {
            //obtenemos los valores enviados desde el formulario de la vista (name de cada input)
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String dni = request.getParameter("dni");
            String carrera = request.getParameter("carrera");
            String periodo = request.getParameter("periodo");
            
            //creamos un objeto alumno y asignamos los valores
            Alumno alumno = new Alumno();
            alumno.setNombres(nombre);
            alumno.setApellidos(apellidos);
            alumno.setDni(dni);
            alumno.setCarrera(carrera);
            alumno.setPeriodo(periodo);
            
            //creamos una adcceso a datos alumno para insertarlo en la base de datos
            AD_Alumno ad = new AD_Alumno();
             try {
                 boolean resultado = false;
                 resultado = ad.insertar(alumno);
                 
                 response.setContentType("text/html;charset=UTF-8");
                 PrintWriter out = response.getWriter();
                 
                 if (resultado == true) {
                     out.print("Alumno registrado con éxito.");
                 } else {
                     out.print("Error en registrar Alumno.");
                 }
             }catch (SQLException ex) {
                 Logger.getLogger(AlumnoController.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
