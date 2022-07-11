<%-- 
    Document   : recebaeditarsoftware
    Created on : 4 de jul. de 2022, 16:35:48
    Author     : Arthur
--%>

<%@page import="java.sql.Date"%>
<%@page import="modelos.Software"%>
<%
    String idsoftware    = request.getParameter("idsoftware");
    String nomesoftware  = request.getParameter("nomesoftware");
    String versaosoft  = request.getParameter("versaosoft");
    String datainst = request.getParameter("datainst");
    String tipolicensa = request.getParameter("tipolicenca");
    
    Software s = new Software();
    s.setCodSoftware(Integer.parseInt(idsoftware));
    s.setDescSoftware(nomesoftware);
    s.setDescVersao(versaosoft);
    s.setDataInstalacao(Date.valueOf(datainst));
    s.setTipoLicensa(tipolicensa);
    if (s.alterarSoftware()) {
        response.sendRedirect("consultasoftware.jsp?pmensagem=Software alterado com sucesso");
    } else {
        response.sendRedirect("consultasoftware.jsp?pmensagem=Problemas ao alterar o Software.");
    }
%>