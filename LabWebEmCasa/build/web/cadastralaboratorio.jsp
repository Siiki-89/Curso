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
                    <form action="recebedadoslaboratorio.jsp" method="POST"> 
                        <h1 class="text-center">Laboratorio</h1> 
                        <label for="codbloco">Código bloco:</label>
                        <div class="codbloco">
                            <input id="codbloco" name="codbloco" required="required" type="text" maxlength="1"/>
                        </div>
                        <br>
                        <label for="codlab">Código laboratório:</label>
                        <div class="codlab">                  
                            <input id="codlab" name="codlab" required="required" type="text" maxlength="11"/>
                        </div>
                        <br>
                        <div class="tipolab">
                            <label for="tipolab">Tipo de laboratório:</label><br>
                                <select name ="tipolab" id="tipolab"> 
                                <option value="M">Mecâcanica de moto</option>
                                <option value="C">Mecânica de automóveis</option>
                                <option value="R">Redes</option>   
                                <option value="I">Informática</option>   
                                <option value="D">Design</option>   
                            </select>
                        </div>
                        <br>
                        <div class="desclab">
                            <label for="desclab">Descrição do lab:</label>
                            <input id="desclab" name="desclab" required="required" type="text" maxlength="30"/>
                        </div>
                        <br>
                        <div class="sitlab">
                            <label for="sitlab">Situação:</label><br>
                            <select name ="sitlab" id="sitlab"> 
                                <option value="A">Ativo</option>
                                <option value="I">Inativo</option>   
                            </select>
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