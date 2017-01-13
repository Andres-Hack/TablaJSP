<%@ page import="java.io.*,java.util.*,java.net.*,java.sql.*" %>
<%-- 
    Document   : buscador
    Created on : 26-feb-2013, 22:39:12
    Author     : patitozsa
--%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.DBConexion" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscador</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="  crossorigin="anonymous"></script>
        <script src="fcJS.js" type="text/javascript" charset="utf-8"></script>


    </head>
    <body ng-app="myApp">
        <div class="jumbotron">
            <h1>Tabla de Contenido</h1>
        </div>
        <div class="row" ng-controller="myCtrl">
            <div class="col-xs-6 col-sm-4"></div>
            <div class="col-xs-6 col-sm-4">
                <form action="pagina2.jsp" method="POST">
                    <div class="form-group" ng-show="true">
                       <label for="exampleInputPassword1">PARTIDA</label>
                       <input type="text" name="partida" class="form-control" id="exampleInputPassword1" placeholder="Gestion" required="">
                    </div>
                    <div class="form-group" ng-show="true">
                       <label for="exampleInputPassword1">SUBC</label>
                       <input type="text" name="subc" class="form-control" id="exampleInputPassword1" placeholder="Gestion" required="">
                    </div>
                    <button type="submit" class="btn btn-success">Aceptar</button>
                </form>
                <%

                    String consulta = null;
                    String partida = request.getParameter("partida");
                    String subc = request.getParameter("subc");

                    Connection con = DBConexion.IniciarSesion();
                    
                    consulta = "select * from tabla_c31 where subc = ? and partida = ?";
                                        
                    ResultSet rs = null;
                    PreparedStatement pst = null;
                    pst = con.prepareStatement(consulta);
                    pst.setString(1, subc);
                    pst.setString(2, partida);
                    rs = pst.executeQuery();
                %>
            </div>
            <div class="col-xs-4 col-sm-4">
                <a href=""><img src="http://rotatorsurvey.com/images/icono_imprimir.png" width="50" height="50" id="btnExport"/></a>
            </div>
                <div class="col-xs-12 col-sm-12">1</div>
                <div class="col-xs-1 col-sm-1"></div>
                <div class="col-xs-8 col-sm-8" id="dvData">
                <table class="table table-striped" Border="10" CellPadding="5" id="tabla1" data-filter="true"
                data-inputFilter="all"
                data-inputCase="true"
                data-inputClass="input-small">
                    <thead>
                        <tr>
                            <th>GESTION</th>
                            <th>FECHA DE EMISION</th>
                            <th>FECHA DE PAGO</th>
                            <th>NUEMRO C31</th>
                            <th>SUBC</th>
                            <th>PARTIDA</th>
                            <th>BENEFICIARIO</th>
                            <th>TIPO</th>
                        </tr>
                    </thead>
                    <tbody>
                    <% while(rs.next()) { %>
                        <tr>
                            <td><%= rs.getString("gestion") %></td>
                            <td><%= rs.getString("fech_emision") %></td>
                            <td><%= rs.getString("fech_pago") %></td>
                            <td><%= rs.getString("nro_c31") %></td>
                            <td><%= rs.getString("nro_c31") %></td>
                            <td><%= rs.getString("partida") %></td>
                            <td><%= rs.getString("beneficiario") %></td>
                            <td><%= rs.getString("tipo") %></td>
                        </tr>
                    <% } %>
                    </tbody>
                </table>
                </div>
            <div class="col-xs-6 col-sm-4"></div>
        </div>
                    <script>
                    $("#btnExport").click(function(e) {
                        window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData').html()));
                        e.preventDefault();
                    });
                    </script>
                <script>
                    var app = angular.module('myApp', []);
                    app.controller('myCtrl', function ($scope){
                        
                    });
                </script>
                
    </body>
</html>
