package Controlador;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "CTRLOperaciones", urlPatterns = {"/CTRLOperaciones"})
public class CTRLOperaciones extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, InstantiationException {
        
                    String driver = "com.mysql.jdbc.Driver";  
                    String url = "jdbc:mysql://localhost/dbinventario";
                    String user = "root";           
                    String password = "sistema123"; 
                    String consulta = null;
                    Connection con = null;
                    String buscar = request.getParameter("gestion");
                    String partida = request.getParameter("partida");
                    String subc = request.getParameter("subc");
                    try {
                        Class.forName(driver).newInstance();
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(CTRLOperaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    con = (Connection) DriverManager.getConnection(url, user, password);
                    
                    consulta = "select * from tabla_c31 where partida = '"+partida+"'";
                    
                    ResultSet rs = null;
                    PreparedStatement pst = null;
                    pst = con.prepareStatement(consulta);
                    rs = pst.executeQuery();
                    
                    response.sendRedirect("index.jsp");

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
        try {
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CTRLOperaciones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(CTRLOperaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTRLOperaciones.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CTRLOperaciones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(CTRLOperaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTRLOperaciones.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    
    
    