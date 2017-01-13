package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;

public final class pagina2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Buscador</title>\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Optional theme -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Latest compiled and minified JavaScript -->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body ng-app=\"myApp\">\n");
      out.write("        <div class=\"jumbotron\">\n");
      out.write("            <h1>Tabla de Contenido</h1>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\" ng-app=\"myCtrl\">\n");
      out.write("            <div class=\"col-xs-6 col-sm-4\"></div>\n");
      out.write("            <div class=\"col-xs-6 col-sm-4\">\n");
      out.write("                <form action=\"pagina2.jsp\" method=\"POST\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                       <label for=\"exampleInputPassword1\">GESTION</label>\n");
      out.write("                       <input type=\"text\" name=\"gestion\" class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Gestion\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\" ng-show=\"true\">\n");
      out.write("                       <label for=\"exampleInputPassword1\">PARTIDA</label>\n");
      out.write("                       <input type=\"text\" name=\"partida\" class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Gestion\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\" ng-show=\"true\">\n");
      out.write("                       <label for=\"exampleInputPassword1\">SUBC</label>\n");
      out.write("                       <input type=\"text\" name=\"subc\" class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Gestion\">\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-success\">Aceptar</button>\n");
      out.write("                </form>\n");
      out.write("                ");

                    String driver = "com.mysql.jdbc.Driver";  
                    String url = "jdbc:mysql://localhost/dbinventario";
                    String user = "root";           
                    String password = "sistema123"; 
                    String consulta = null;
                    Connection con = null;
                    String buscar = request.getParameter("gestion");
                    String partida = request.getParameter("partida");
                    String subc = request.getParameter("subc");
                    Class.forName(driver).newInstance();
                    con = DriverManager.getConnection(url, user, password);
                    consulta = "select * from tabla_c31 where gestion = '"+buscar+"'";
                    while (partida != "null") {                            
                            consulta += "and partida = '"+partida+"'";
                    }
                    while (subc != "null") {                            
                            consulta += "and subc = '"+subc+"'";
                    }
                    
                    ResultSet rs = null;
                    PreparedStatement pst = null;
                    pst = con.prepareStatement(consulta);
                    rs = pst.executeQuery();
                
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-xs-12 col-sm-12\">1</div>\n");
      out.write("                <div class=\"col-xs-12 col-sm-12\">1</div>\n");
      out.write("                <div class=\"col-xs-12 col-sm-12\">\n");
      out.write("                <table class=\"table table-striped\" Border=\"10\" CellPadding=\"5\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>GESTION</th>\n");
      out.write("                        <th>FECHA DE EMISION</th>\n");
      out.write("                        <th>FECHA DE PAGO</th>\n");
      out.write("                        <th>NUEMRO C31</th>\n");
      out.write("                        <th>SUBC</th>\n");
      out.write("                        <th>PARTIDA</th>\n");
      out.write("                        <th>BENEFICIARIO</th>\n");
      out.write("                        <th>TIPO</th>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 while(rs.next()) { 
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( rs.getString("gestion") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("fech_emision") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("fech_pago") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("nro_c31") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("nro_c31") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("partida") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("beneficiario") );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString("tipo") );
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </table>\n");
      out.write("                </div>\n");
      out.write("            <div class=\"col-xs-6 col-sm-4\"></div>\n");
      out.write("        </div>\n");
      out.write("                <script>\n");
      out.write("                    var app = angular.module('myApp', []);\n");
      out.write("                    app.controller('myCtrl', function ($scope){\n");
      out.write("                        \n");
      out.write("                    });\n");
      out.write("                </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
