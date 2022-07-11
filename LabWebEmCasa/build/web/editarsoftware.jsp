<%@page import="modelos.Software"%>
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
            int idsoftware = Integer.parseInt(request.getParameter("idsoftware"));
            Software s = new Software();
            s = s.consultarSoftware(idsoftware);
        %>
        <div>
            <div class="container" >
                <div class="content">      
                    <div id="cadastro">
                        <form action="recebaeditarsoftware.jsp" method="POST">                                                      
                            <h1 class="text-center">Editar Software</h1>
                            <pre><label><h4>Tipo de licenças:</h4><br>P = Perpétua<br>G = Gratuita<br>T = Temporatoria</label></pre>
                            <br>
                            <br>

                            <div class="idsoftware">
                                <label>Código</label>
                                <input type="text" name="idsoftware" required="required" value="<%out.write("" +s.getCodSoftware());%>" />
                            </div>
                            <div class="nomesoftware">
                                <label>Nome</label>
                                <input type="text" name="nomesoftware" required="required" type="text" maxlength="40" value="<%out.write(s.getDescSoftware());%>" />
                            </div>
                            <div class="versaosoft">
                                <label for="versaosoft">Versão do Software</label>
                                <input id="versaosoft" name="versaosoft" required="required" type="text" maxlength="20" value="<%out.write(s.getDescVersao());%>"/>  
                            </div>
                            <div class="datainst">
                                <label for="datainst">Data da instalação</label>
                                <input id="datainst" name="datainst" required="required" type="date" maxlength="8"/> 
                            </div>
                            <div class="tipolicenca">
                                <label for="tipolicenca">Licença</label>
                                <input id="tipolicenca" name="tipolicenca" required="required" type="text" maxlength="1" value="<%out.write(s.getTipoLicensa());%>"/>  
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
    </body>'
