<%@page import="modelos.Laboratorio"%>
<%@page import="java.sql.Date"%>
<%@page import="modelos.Tecnico"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            String codlab = request.getParameter("codlab");
            String codbloco = request.getParameter("codbloco");
            String tipolab= request.getParameter("tipolab");
            String desclab= request.getParameter("desclab");
            String sitlab= request.getParameter("sitlab");
            Laboratorio lab = new Laboratorio();
            int number = Integer.parseInt(codlab);
            lab.setCodlaboratorio(number);
            lab.setCodBloco(codbloco);
            lab.setTipolaboratorio(tipolab);
            lab.setDescrLaboratorio(desclab);
            lab.setSituacaoLaboratorio(sitlab);
            if(lab.incluirLaboratorio()){
                response.sendRedirect("cadastralaboratorio.jsp?pmensagem= Laboratorio incluido com sucesso");
            } else {
                response.sendRedirect("cadastralaboratorio.jsp?pmensagem= Problemas ao incluir");
            }
        %>
    </body>
</html>
