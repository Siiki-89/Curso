<%@page import="modelos.Tecnico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            String nometecnico = request.getParameter("nometecnico");
            String fonetecnico = request.getParameter("fonetecnico");
            String emailtecnico = request.getParameter("emailtecnico");

            Tecnico tec = new Tecnico();            
            tec.setNomeTecnico(nometecnico);
            tec.setFoneTecnico(fonetecnico);
            tec.setEmailTecnico(emailtecnico);
            if (tec.incluirTecnico()) {
                response.sendRedirect("cadastratecnico.jsp?pmensagem=Tecnico cadastrado com sucesso ");
            } else {
                response.sendRedirect("cadastratecnico.jsp?pmensagem=Problema no cadastro do tecnico");
            }

        %>
   