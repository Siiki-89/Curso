<%@page import="java.sql.Date"%>
<%@page import="modelos.Manutencao"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
        <%
            String codativo = request.getParameter("codativo");
            String codtecnico = request.getParameter("codtecnico");
            String tipomanutencao = request.getParameter("tipomanutencao");
            String ordemservico = request.getParameter("ordemservico");
            String descrmanutencao = request.getParameter ("descrmanutencao");
            String datamanutencao = request.getParameter ("datamanutencao");
            String dataliberacao = request.getParameter ("dataliberacao");
            String statusmanutencao = request.getParameter ("statusmanutencao");

            Manutencao manu = new Manutencao();            
            manu.setCodAtivo(Integer.valueOf(codativo));
            manu.setCodTecnico(Integer.valueOf(codtecnico));
            manu.setTipomanutencao(tipomanutencao);
            manu.setOrdemServico(Integer.valueOf(ordemservico));
            manu.setDescrManutencao(descrmanutencao);
            manu.setDataManutencao(Date.valueOf(datamanutencao));
            manu.setDataLiberacao(Date.valueOf(dataliberacao));
            manu.setStatusmanutencao(statusmanutencao);
            if (manu.incluirManutencao()) {
                response.sendRedirect("cadastraManutencao.jsp?pmensagem=Manutencao cadastrado com sucesso ");
            } else {
                response.sendRedirect("cadastraManutencao.jsp?pmensagem=Problema no cadastro do Manutencao");
            }
        %>
   