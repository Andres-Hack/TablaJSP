package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class ejemplo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>ejemplo de tablas</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Optional theme -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Latest compiled and minified JavaScript -->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("                var app = angular.module('myApp', []);\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body ng-app=\"myApp\">\n");
      out.write("        <div class=\"row\" ng-controller=\"myCtrolador\" ng-init=\"operacion=0\">\n");
      out.write("            <div class=\"col-md-2\"></div>\n");
      out.write("            <div class=\"col-md-10\">\n");
      out.write("                <div class=\"jumbotron\"><h1>TABLAS</h1></div>\n");
      out.write("                <form method=\"post\">\n");
      out.write("                    ingrese el id : <input type=\"text\" placeholder=\"Ingrese aqui lo que necesite\" name=\"buscar\"/><br>\n");
      out.write("                    nombre : <input type=\"text\" placeholder=\"Ingrese aqui lo que necesite\" name=\"nombre\"/><br>\n");
      out.write("                    <div class=\"radio\">\n");
      out.write("                        <label>\n");
      out.write("                          <input type=\"radio\" name=\"OptionRadio\" id=\"optionsRadios1\" value=\"option1\" checked>\n");
      out.write("                          Buscar\n");
      out.write("                        </label>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"radio\">\n");
      out.write("                        <label>\n");
      out.write("                          <input type=\"radio\" name=\"OptionRadio\" id=\"optionsRadios2\" value=\"option2\">\n");
      out.write("                          Modificar\n");
      out.write("                        </label>\n");
      out.write("                      </div>\n");
      out.write("                    <input class=\"btn btn-success\" type=\"submit\" value=\"ACEPTAR\"/>\n");
      out.write("                </form> \n");
      out.write("            </div>\n");
      out.write("        </div>          \n");
      out.write("        \n");
      out.write("        ");

            String op = request.getParameter("OptionRadio");
            String buscar = request.getParameter("buscar");
            String nombre = request.getParameter("nombre");
            String quert = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tienda", "root", "sistema123");

            Statement Estamento = conexion.createStatement();
            PreparedStatement stmt;
                
                switch(op)
                { 
                  case "option1": 
                      quert = "select id, nombre, precio from producto where id="+buscar+"";
                      ResultSet rs = Estamento.executeQuery(quert);
                        out.println("<table border=1 class=table>");
                        out.println("<tr><th>Id</th><th>Nombre</th><th>Precio</th></tr>");
                        while (rs.next()) {
                            out.println("<tr>");
                            out.println("<td>");
                            out.println(rs.getInt("id"));
                            out.println("</td><td>");
                            out.println(rs.getString("nombre"));
                            out.println("</td><td>");
                            out.println(rs.getInt("precio"));
                            out.println("</td>");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                        rs.close();
                      break;
                  case "option2": 
                      stmt = conexion.prepareStatement("update producto nombre='"+nombre+"' where id="+buscar+"");
                      stmt.executeUpdate();
                      break;
                }
                
            
            Estamento.close();
            conexion.close();
                
            
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
