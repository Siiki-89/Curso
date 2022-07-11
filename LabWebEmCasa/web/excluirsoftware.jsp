<%@page import="modelos.Software"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%
    String idsoftware = request.getParameter("idsoftware");
    Software soft = new Software();
    if (idsoftware != null) {
        soft = soft.consultarSoftware(Integer.parseInt(idsoftware));
        if (soft.excluirSoftware()) {
            response.sendRedirect("consultasoftware.jsp?pmensagem=Software excluído com sucesso");
        } else {
            response.sendRedirect("consultasoftware.jsp?pmensagem=Problemas na exclusão do Software");
        }
    }
    %>