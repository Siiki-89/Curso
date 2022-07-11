<%@page import="modelos.Tecnico"%>
<%
    String idtecnico    = request.getParameter("idtecnico");
    String nometecnico  = request.getParameter("nometecnico");
    String fonetecnico  = request.getParameter("fonetecnico");
    String emailtecnico = request.getParameter("emailtecnico");
    
    Tecnico tec = new Tecnico();
    tec.setCodTecnico(Integer.parseInt(idtecnico));
    tec.setNomeTecnico(nometecnico);
    tec.setFoneTecnico(fonetecnico);
    tec.setEmailTecnico(emailtecnico);
    if (tec.alterarTecnico()) {
        response.sendRedirect("consultatecnico.jsp?pmensagem=Tecnico alterado com sucesso");
    } else {
        response.sendRedirect("consultatecnico.jsp?pmensagem=Problemas ao alterar o técnico.");
    }
%>