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
                    <form action="recebedadosmanutencao.jsp" method="POST"> 
                        <h1 class="text-center">Manutenção</h1>   
                        <div class="codAtivo">
                            <label for="codAtivo">Código Ativo</label>
                            <input id="codAtivo" name="codAtivo" required="required" type="text" maxlength="11"/>                        
                        </div>  
                        <br>
                        <div class="codTecnico">
                            <label for="codTecnico">Código Técnico</label>
                            <input id="codTecnico" name="codTecnico" required="required" type="text" maxlength="11"/>
                        </div>   
                        <br>
                        <div class="tipoManutencao">
                            <label for="tipoManutencao">Tipo da Manutenção</label>       
                            <br>
                            <select name ="tipoManutencao" id="tipoManutencao"> 
                                <option value="C">Corretiva</option>
                                <option value="P">Preventiva</option>
                                <option value="A">Antecipativa</option>   
                            </select>
                        </div>
                        <br>
                        <div class="ordemServico">
                            <label for="ordemServico">Ordem de Serviço</label>
                            <input id="ordemServico" name="ordemServico" required="required" type="text" maxlength="1"/>
                        </div>   
                        <br>
                        <div class="descrManutencao">
                            <label for="descrManutencao">Descrição da Manutenção</label>
                            <input id="descrManutencao" name="descrManutencao" required="required" type="text" maxlength="60"/>
                        </div>
                        <br>
                        <div class="dataManutencao">
                            <label for="dataManutencao">Data da Manutenção</label>
                            <input id="dataManutencao" name="dataManutencao" required="required" type="date"/>
                        </div>
                        <br>
                        <div class="dataLiberacao">
                            <label for="dataLiberacao">Data da Liberação</label>
                            <input id="dataLiberacao" name="dataLiberacao" required="required" type="date"/>
                        </div>
                        <br>
                        <div class="statusManutencao">
                            <label for="statusManutencao">Data da Manutencao</label>
                            <input id="statusManutencao" name="statusManutencao" required="required" type="text" maxlength="1"/>
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