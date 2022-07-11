<%@page import="modelos.Laboratorio"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/padraotelacadastro.css">
        <script src="scripts/formatacampos.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>

        <%
            int lab = Integer.parseInt(request.getParameter("idlab"));
            Laboratorio l = new Laboratorio();
            l = l.consultarLaboratorio(lab);
        %>
        <div>
            <div class="container" >
                <div class="content">      
                    <div id="cadastro">
                        <form action="recebeeditalaboratorio.jsp" method="POST"> 
                            <h1 class="text-center">Editar Laboratorio</h1>
                            <br>
                            <pre><label><h4>Tipos de Laboratório:                  Situações:</h4><br>M = Mecâcanica de moto                                    A = Aitvo<br>C = Mecâcanica de automóveis                             I = Inativo<br>R = Redes <br>I = Informática<br>D = Design</label></pre>
                            <br>
                            <div class="idlab">
                                <label>ID</label>
                                <input type="text" name="idlab" required="required" value="<%out.write("" +l.getIdLaboratorio());%>" />
                            </div>
                         
                            <div class="codbloco">
                                <label>Bloco</label>
                                <input type="text" name="codbloco" required="required" maxlength="1" value="<%out.write(l.getCodBloco());%>" />
                            </div>
                            <label for="codlab">Código laboratório:</label>
                            <div class="codlab">
                                <input id="codlab" name="codlab" required="required" type="text" maxlength="10" value="<%out.write(""+l.getCodlaboratorio());%>"/>  
                            </div>
                                    
                            <div class="tipolab">
                                <label for="tipolab">Tipo do laboratório:</label>
                                <input id="tipolab" name="tipolab" required="required" type="text" maxlength="1" value="<%out.write(l.getTipolaboratorio());%>"> 
                            </div>
                            <div class="desclab">
                                <label for="desclab">Descrição do lab:</label>
                                <input id="desclab" name="desclab" required="required" type="text" maxlength="30" value="<%out.write(l.getDescrLaboratorio());%>"> 
                            </div>
                            <div class="sitlab">
                                <label for="sitlab">Situação do Lab:</label>
                                <input id="sitlab" name="sitlab" required="required" type="text" maxlength="1" value="<%out.write(l.getSituacaoLaboratorio());%>"> 
                            </div>
                            <br>
                            <div class="row">
                                <div class="form-group col-md-3 h-10">
                                    <input type="submit" value="Alterar" class="btn btn-primary"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>                  
            </div>
        </div>                              
    </body>