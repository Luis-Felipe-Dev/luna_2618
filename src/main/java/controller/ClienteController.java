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
import model.AD_Cliente;
import model.Cliente;

/**
 *
 * @author luisf
 */
@WebServlet(name = "ClienteController", urlPatterns = {"/admin/clientes/*"})
public class ClienteController extends HttpServlet {

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
            out.println("<title>Servlet ClienteController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteController at " + request.getContextPath() + "</h1>");
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
        //localhost:8080/admin/clientes  GET : formulario de registro cliente_registro.jsp
        //localhost:8080/admin/clientes/  GET: formulario de registro cliente_registro.jsp
        
        String URL = request.getPathInfo(); //obtiene la ruta
        if (URL == null || URL.equals("/")) {
            request.getRequestDispatcher("/clientes/cliente_registro.jsp").forward(request, response);
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
        
        //localhost:8080/admin/clientes/registrar POST : formulario de registro cliente_registro.jsp        
        String URL = request.getPathInfo(); //obtiene la ruta
        
        String accion = URL.substring(1); // registrar
        
        if (accion.equals("registrar")) {
            //obtenemos los valores enviados desde el formulario de la vista (name de cada input)
            String nombres_razonsocial = request.getParameter("nombres_razonsocial");
            String tipo_documentoidentidad = request.getParameter("tipo_documentoidentidad");
            String numero_documentoidentidad = request.getParameter("numero_documentoidentidad");
            String direccion = request.getParameter("direccion");
            String pais = request.getParameter("pais");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");
            
            //creamos un objeto cliente y asignamos los valores
            Cliente cliente = new Cliente();
            cliente.setNombres_razonsocial(nombres_razonsocial);
            cliente.setTipo_documentoidentidad(tipo_documentoidentidad);
            cliente.setNumero_documentoidentidad(numero_documentoidentidad);
            cliente.setDireccion(direccion);
            cliente.setPais(pais);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            //creamos una adcceso a datos cliente para insertarlo en la base de datos
            AD_Cliente ad = new AD_Cliente();
             try {
                 boolean resultado = false;
                 resultado = ad.insertar(cliente);
                 
                 response.setContentType("text/html;charset=UTF-8");
                 PrintWriter out = response.getWriter();
                 
                 if (resultado == true) {
                     out.print("Cliente registrado con éxito.");
                 } else {
                     out.print("Error en registrar Cliente.");
                 }
             }catch (SQLException ex) {
                 Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
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