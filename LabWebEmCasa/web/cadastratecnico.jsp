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
                    <form action="recebedadostecnico.jsp" method="POST"> 
                        <h1 class="text-center">Técnico</h1>  
                        <div class="nometecnico">
                            <label for="nometecnico">Nome</label>
                            <input id="nometecnico" name="nometecnico" required="required" type="text" maxlength="40"/>                        
                        </div>  
                        <br>
                        <div class="fonetecnico">
                            <label for="fonetecnico">Contato</label>
                            <input id="fonetecnico" name="fonetecnico" required="required" type="text" onfocus="javascript: retirarFormatacao(this);" onblur="javascript: formatarCampos(this);" maxlength="11"/>
                        </div>   
                        <br>
                        <div class="emailtecnico">
                            <label for="emailtecnico">Email</label>
                            <input id="emailtecnico" name="emailtecnico" required="required" type="email" maxlength="60"/> 
                        </div>
                        <br>
                        <div class="row">
                               <div class="form-group col-md-3 h-10">
                                   <input type="submit" value="Cadastrar" class="btn btn-primary " onclick="enviaForm()" />
                               </div>
                               <div class="form-group col-md-3 h-10">                                 
                                   <input type="reset"  value="Cancelar" class="btn btn-danger"/>                        
                               </div>
                        </div>
                    </form>
                </div>
            </div>                  
        </div>      
    </body>    
 </html>