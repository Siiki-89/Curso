<%@page import="modelos.EquipSoft"%>

<%
    String codAtivo  = request.getParameter("codAtivo");
    String codSoftware  = request.getParameter("codSoftware");
    EquipSoft equipsoft = new EquipSoft();
    equipsoft.setCodAtivo(Integer.valueOf(codAtivo));
    equipsoft.setCodSoftware(Integer.valueOf(codSoftware));
    
    if (equipsoft.incluirEquiSoftware()) {
        response.sendRedirect("cadastraequisoftware.jsp?pmensagem= equisoftware incluído com sucesso");
    } else {
        response.sendRedirect("cadastraequisoftware.jsp?pmensagem=Problemas ao incluir o equisoftware.");
    }
%>
