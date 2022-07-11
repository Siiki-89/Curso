<%-- 
    Document   : recebadadosoftware
    Created on : 29 de jun. de 2022, 14:20:24
    Author     : Arthur
--%>
<%@page import="java.sql.Date"%>
<%@page import="modelos.Software"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
        <%
            String nomesoftware = request.getParameter("nomesoft");
            String versaosoft = request.getParameter("versaosoft");
            String datainst = request.getParameter("datainst");
            String tipolicensa = request.getParameter("tipolicenca");

            Software soft = new Software();            
            soft.setDescSoftware(nomesoftware);
            soft.setDescVersao(versaosoft);
            soft.setDataInstalacao(Date.valueOf(datainst));
            soft.setTipoLicensa(tipolicensa);
            if (soft.incluirSoftware()) {
                response.sendRedirect("cadastrasoftware.jsp?pmensagem=Software cadastrado com sucesso ");
            } else {
                response.sendRedirect("cadastrasoftware.jsp?pmensagem=Problema no cadastro do Software");
            }
        %>
   