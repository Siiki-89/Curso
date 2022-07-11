
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
                    <form action="recebadadosoftware.jsp" method="POST"> 
                        <h1 class="text-center">Software</h1>
                        
                        <div class="nomesoft">
                            <label for="nomesoft">Nome do software</label>
                            <input id="nomesoft" name="nomesoft" required="required" type="text" maxlength="40"/>                        
                        </div>  
                        <br>
                        <div class="versaosoft">
                            <label for="versaosoft">Versão do software</label>
                            <input id="versaosoft" name="versaosoft" required="required" type="text" maxlength="20"/>
                        </div>  
                        <br>
                        
                        <label for="datainst">Instalação Software</label>
                        <div class="datainst">
                            <input id="datainst" name="datainst" required="required" type="date" /> 
                        </div>
                        <br>
                        <div class="tipolicenca">
                            <label for="tipolicenca">Tipo de licença<br></label>
                            <br>
                            <select name ="tipolicenca" id="tipolicenca"> 
                                <option value="P">Perpétua</option>
                                <option value="G">Gratuita</option>
                                <option value="T">Temporatoria</option>   
                            </select>
                        </div>
                        <br>
                        
                        <div class="row">
                               <div class="form-group col-md-4 h-4">
                                   <input type="submit" value="Cadastrar" class="btn btn-primary " onclick="enviaForm()" />
                               </div>
                               <div class="form-group col-md-4 h-4">                                 
                                   <input type="reset"  value="Cancelar" class="btn btn-danger"/>                        
                               </div>
                        </div>
                    </form>
                </div>
            </div>                  
        </div>      
    </body>    
 </html>
