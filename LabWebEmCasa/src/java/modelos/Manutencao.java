package modelos;
import java.util.*;
import java.sql.Connection;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Manutencao extends Equipamento {
    
    private int codManutencao;
    private int codAtivo;
    private int codTecnico;
    private String tipomanutencao;
    private int ordemServico;
    private String descrManutencao;
    private Date dataManutencao;
    private Date dataLiberacao;
    private String statusmanutencao;
    
       public boolean incluirManutencao() {
       String sql =" INSERT INTO tbmanuntencao (cod_ativo,cod_tecnico,tipo_manutencao,ordem_servico,descr_manutencao,data_manutencao,data_liberacao,status_manutencao) VALUES (?,?,?,?,?,?,?,?) ";
       Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manutencao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           PreparedStatement  pstm=con.prepareStatement(sql);
           pstm.setInt(1, this.codAtivo);
           pstm.setInt(2, this.codTecnico);
           pstm.setString(3, this.tipomanutencao);
           pstm.setInt(4, this.ordemServico);
           pstm.setString(5, this.descrManutencao);
           pstm.setDate(6,(java.sql.Date)this.dataManutencao);
           pstm.setDate(7,(java.sql.Date)this.dataLiberacao);
           pstm.setString(8, this.statusmanutencao);
           pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro (incluirManutencao): " + ex.getMessage());
            return false;
        }
        return true;
    }

        public boolean alterarManutencao() {
        String sql = "UPDATE tbmanutencao SET cod_ativo = ?,cod_tecnico = ? ,tipo_manutencao = ?,ordem_servico =  ?,descr_manutencao = ?, data_manutencao = ?,data_liberacao = ?, status_manutencao = ? WHERE cod_manutencao = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manutencao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement  pstm=con.prepareStatement(sql);
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, this.codAtivo);
            pstm.setInt(2, this.codTecnico);
            pstm.setString(3, this.tipomanutencao);
            pstm.setInt(4, this.ordemServico);
            pstm.setString(5, this.descrManutencao);
            pstm.setDate(5,(java.sql.Date)this.dataManutencao);
            pstm.setDate(5,(java.sql.Date)this.dataLiberacao);
            pstm.setString(8, this.statusmanutencao);
            pstm.setInt(8, this.codManutencao);
            pstm.executeUpdate();
            
        } catch (SQLException ex){
            System.out.println("Erro (alterarManutencao)" + ex.getMessage());
            return false;
        }
        return true;
    }

       public boolean excluirManutencao() {
        String sql = "DELETE FROM tbmanutencao WHERE cod_manutencao = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manutencao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, this.codManutencao);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro (excluirManutencao)" + ex.getMessage());
            return false;
        }
        return true;
    }
       
        public Manutencao consultarManutencao(int codManu) {
        Manutencao manu = null;
        String sql = "SELECT cod_manutencao, cod_ativo, cod_tecnico, tipo_manutencao,ordem_servico, descr_manutencao, data_manutencao, data_liberacao, status_manutencao FROM tbmanutencao WHERE cod_manutencao = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manutencao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, codManu );
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                manu = new Manutencao();
                manu.setCodManutencao(codManu);
                manu.setCodAtivo(rs.getInt("codAtivo"));
                manu.setCodTecnico(rs.getInt("codTecnico"));
                manu.setTipomanutencao(rs.getString("tipomanutencao"));
                manu.setOrdemServico(rs.getInt("ordemServico"));
                manu.setDescrManutencao(rs.getString("descrManutencao"));
                manu.setDataManutencao(rs.getDate("dataManutencao"));
                manu.setDataLiberacao (rs.getDate("dataLiberacao"));
                manu.setStatusmanutencao(rs.getString("statusmanutencao"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro (consultarManutencao): " + ex.getMessage());
        }
        return manu;
    }

    public List<Manutencao> consultarManutencoes(){
        List<Manutencao> dados = new ArrayList<>();
        String sql = "SELECT cod_manutencao, codAtivo, codTecnico, tipomanutencao, ordemServico, descrManutencao, dataManutencao, dataLiberacao FROM tbManutencao";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manutencao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Manutencao manu = new Manutencao();
                manu.setCodManutencao(rs.getInt("codManutencao"));
                manu.setCodAtivo(rs.getInt("codAtivo"));
                manu.setCodTecnico(rs.getInt("codTecnico"));
                manu.setTipomanutencao(rs.getString("tipomanutencao"));
                manu.setOrdemServico(rs.getInt("ordemServico"));
                manu.setDescrManutencao(rs.getString("escrManutencao"));
                manu.setDataManutencao(rs.getDate("dataManutencao"));
                manu.setDataLiberacao(rs.getDate("dataLiberacao"));
                manu.setStatusmanutencao(rs.getString("statusmanutencao"));
                dados.add(manu);
            }
        } catch (SQLException ex ) {
            System.out.println("Erro (consultarManutencoes): " + ex.getMessage());
        }
        return dados;
    }

    public int getCodManutencao() {
        return codManutencao;
    }

    public void setCodManutencao(int codManutencao) {
        this.codManutencao = codManutencao;
    }

    public int getCodAtivo() {
        return codAtivo;
    }

    public void setCodAtivo(int codAtivo) {
        this.codAtivo = codAtivo;
    }

    public int getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(int codTecnico) {
        this.codTecnico = codTecnico;
    }

    public String getTipomanutencao() {
        return tipomanutencao;
    }

    public void setTipomanutencao(String tipomanutencao) {
        this.tipomanutencao = tipomanutencao;
    }

    public String getStatusmanutencao() {
        return statusmanutencao;
    }

    public void setStatusmanutencao(String statusmanutencao) {
        this.statusmanutencao = statusmanutencao;
    }

    public int getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(int ordemServico) {
        this.ordemServico = ordemServico;
    }

    public String getDescrManutencao() {
        return descrManutencao;
    }

    public void setDescrManutencao(String descrManutencao) {
        this.descrManutencao = descrManutencao;
    }

    public Date getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(Date dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public Date getDataLiberacao() {
        return dataLiberacao;
    }

    public void setDataLiberacao(Date dataLiberacao) {
        this.dataLiberacao = dataLiberacao;
    }
}



    
    


    

