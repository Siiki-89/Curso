<%@page import="modelos.Tecnico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%
    String idtecnico = request.getParameter("idtecnico");
    Tecnico t = new Tecnico();
    if (idtecnico != null) {
        t = t.consultarTecnico(Integer.parseInt(idtecnico));
        if (t.excluirTecnico()) {
            response.sendRedirect("consultatecnico.jsp?pmensagem=Técnico excluído com sucesso");
        } else {
            response.sendRedirect("consultapaciente.jsp?pmensagem=Problemas na exclusão do Técnico");
        }
    }
    %>