
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
        <div class="container" >
            <div class="content">      
                <div id="cadastro">                   
                    <label class="cabecalho" id="msg"> 
                        <%
                            if(request.getParameter("pmensagem") != null)         
                            out.write(request.getParameter("pmensagem"));
                        %>
                    </label>                   
                    <form action="recebedadosequisoftware.jsp" method="POST"> 
                        <h1 class="text-center">equisoftware</h1>  
                        <div class="codAtivo">
                            <label for="codAtivo">Codigo do Equipamento</label>
                            <input id="codAtivo" name="codAtivo" required="required" type="text" maxlength="11"/>          
                        </div>
                        <br>
                        <div class="codSoftware">
                            <label for="codSoftware">Codigo do Software</label>
                            <input id="codSoftware" name="codSoftware" required="required" type="text" maxlength="11" /> 
                        </div>
                        <br>
                        <div class="row">
                            <div class="form-group col-md-2 h-10">
                                <input type="submit" value="Cadastrar" class="btn btn-primary " onclick="enviaForm()" />
                            </div>
                            <div class="form-group col-md-2 h-10">                                 
                                <input type="reset"  value="Cancelar" class="btn btn-danger"/>                        
                            </div>
                        </div>
                    </form>
                </div>
            </div>                  
        </div>             
    </body>    
 </html>