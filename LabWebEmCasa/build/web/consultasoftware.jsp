<%@page import="java.util.List"%>
<%@page import="modelos.Software"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/padraotelagrid.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet"/>        
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>    </head>
    <style>

    .msg-popup2 {
        z-index: 10;
        width: 30%;
        height: 20vh;
        margin-left:  500px;
        margin-right: 400px;
        top: 250px;
        background-color: rgb(9, 117, 167);
        display: none;
        position: absolute;
        border: 2px solid #b2b2b2;
        -webkit-border-radius: 15px;
        border-radius: 15px;
        -webkit-box-shadow: 0px 1px 4px 0px rgba(43, 40, 40, 0.6) inset;
        box-shadow: 0px 1px 4px 0px rgba(43, 40, 40, 0.6) inset;
        -webkit-transition: all 0.2s linear;
        transition: all 0.2s linear;       
        }
    </style>    
    <body>
      <%
        Software soft = new Software();
        List<Software> Software = soft.consultarSoftwares();
      %>
        
      <%-- label para lan�ar mensagem de feedback da atualiza��o --%>
        <label class="cabecalho" id="msg"> 
            <%
                if(request.getParameter("pmensagem") != null)         
                out.write(request.getParameter("pmensagem"));
            %>
        </label>
        <h1 class="text-center"> Rela��o de Software </h1>
            <table class="table">
                <thead>
                    <tr>        
                        <th scope="col">C�digo</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Vers�o</th>
                        <th scope="col">Data da instala��o</th>
                        <th scope="col">Tipo da licenca</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Excluir</th>
                    </tr>                        
                </thead>                    

                <tbody>
                    <% for (Software s : Software) {%>
                    <tr>
                        <%
                           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                           String datainst      = sdf.format(s.getDataInstalacao());
                        %>
                        <td><% out.write("  " + s.getCodSoftware());%></td>
                        <td><% out.write(s.getDescSoftware()); %></td>                       
                        <td><% out.write(s.getDescVersao()); %></td>
                        <td><% out.write(datainst); %></td>
                        <td><% out.write(s.getTipoLicensa()); %></td>
                        <td><%out.write("<a href=editarsoftware.jsp?idsoftware="  + ""+s.getCodSoftware()+ ">" + "<i class='far fa-edit' style='color:blue'></i>" + "</a>");%></td>
                        <td>
                            <button type="button" id="botaoexcluir" 
                                    onclick="mostrarExclusao(<%out.write("" + s.getCodSoftware());%>)">
                                <i class='far fa-trash-alt' style='color:red'></i> 
                            </button>
                        </td>
                    </tr> 
                    <%}%>
                </tbody>
            </table>
 <!-- POPUP DE CONFIRMA��O DE EXCLUS�O -->                
        
            <div class="msg-popup2">
                <h5 class="text-center" style="color: #ffffff; font-family: arial-bold ">EXCLUS�O</h5>
                <h5 class="text-center" style="color: #ffffff;">Confirma a <b>exclus�o</b> do registro ?</h5>
                <div class="text-center">                
                    <a href=""><button class="btn btn-dark" click="cancela()"> N�o </button></a>
                    <a id="exclui" href="#"><button class="btn btn-danger" id="excluir"> Sim </button></a>                    
                </div>
            </div>                
                
            <script>
                function cancela() {
                    document.getElementsByClassName("msg-popup2")[0].style.display = "none";
                }

                function mostrarExclusao(software) {
                    document.getElementsByClassName("msg-popup2")[0].style.display = "block";
                    var link = document.getElementById("exclui");
                    link.href = "excluirsoftware.jsp?idsoftware=" + software;
                }
            </script>                               
    </body>
</html>
