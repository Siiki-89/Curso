<%@page import="modelos.Tecnico"%>
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
            int tecnico = Integer.parseInt(request.getParameter("idtecnico"));
            Tecnico t = new Tecnico();
            t = t.consultarTecnico(tecnico);
        %>
        <div>
            <div class="container" >
                <div class="content">      
                    <div id="cadastro">
                        <form action="recebeeditatecnico.jsp" method="POST"> 
                            <h1 class="text-center">Editar Técnico</h1>
                            <div class="codtecnico">
                                <label>Código</label>
                                <input type="text" name="idtecnico" required="required" value="<%out.write("" +t.getCodTecnico());%>" />
                            </div>
                         
                            <div class="nometecnico">
                                <label>Nome</label>
                                <input type="text" name="nometecnico" required="required" maxlength="40" value="<%out.write(t.getNomeTecnico());%>" />
                            </div>
                            
                            <div class="fonetecnico">
                                <label for="fonetecnico">Fone</label>
                                <input id="fonetecnico" name="fonetecnico" required="required" type="text" onfocus="javascript: retirarFormatacao(this);" onblur="javascript: formatarCampos(this);" maxlength="11" value="<%out.write(t.getFoneTecnico());%>"/>  
                            </div>
                                    
                            <div class="emailtecnico">
                                <label for="emailtecnico">Email Técnico</label>
                                <input id="emailtecnico" name="emailtecnico" required="required" type="email" maxlength="40" value="<%out.write(t.getEmailTecnico());%>"> 
                            </div>
                        
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