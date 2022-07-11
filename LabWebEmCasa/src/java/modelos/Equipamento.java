package modelos;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Equipamento {

    public Equipamento() {
    }

    public int codAtivo;

    public String tipoEquipamento;

    public String desrEquipamento;

    public String sistemaOperacional;

    public int codSoftware;

    public int idLaboratorio;

    public String sitPatrimonio;

    public Date dataEntrAtivo;

    public Date dataBaixaAtivo;

    public boolean incluirEquipamento() {
        String sql = "INSERT INTO tbequipamento (tipo_equipamento, descr_equipamento, sistema_operacional, cod_software, id_laboratorio, sit_patrimonio, data_entrada_ativo, data_baixa_ativo)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, this.tipoEquipamento);
            pstm.setString(2, this.desrEquipamento);
            pstm.setString(3, this.sistemaOperacional);
            pstm.setInt(4, this.codSoftware);
            pstm.setInt(5, this.idLaboratorio);
            pstm.setString(6, this.sitPatrimonio);
            pstm.setDate(7, (java.sql.Date) this.dataEntrAtivo);
            pstm.setDate(8, (java.sql.Date) this.dataBaixaAtivo);
            pstm.execute();
        } catch (SQLException ex){
            System.out.println("Erro (incluirEquipamento): " + ex.getMessage());
            return false;
        }
        return true;  
    }

    public boolean alterarEquipamento() {
        String sql = "UPDATE tbequipamento SET tipo_equipamento = ?, descr_equipamento = ?, sistema_operacional = ?, cod_software = ?, id_laboratorio = ?, sit_patrimonio = ?, data_entrada_ativo = ?, data_baixa_ativo = ?"
                + "WHERE cod_ativo = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, this.tipoEquipamento);
            pstm.setString(2, this.desrEquipamento);
            pstm.setString(3, this.sistemaOperacional);
            pstm.setInt(4, this.codSoftware);
            pstm.setInt(5, this.idLaboratorio);
            pstm.setString(6, this.sitPatrimonio);
            pstm.setDate(7, (java.sql.Date) this.dataEntrAtivo);
            pstm.setDate(8, (java.sql.Date) this.dataBaixaAtivo);
            pstm.setInt(9, this.codAtivo);
            pstm.executeUpdate();
            
        } catch (SQLException ex){
            System.out.println("Erro (alterarEquipamento): " + ex.getMessage());
            return false;
        }
        return true;  
    }

    public boolean excluirEquipamento() {
        String sql = "DELETE FROM tbequipamento WHERE cod_ativo = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setInt(1, this.codAtivo);
            pstm.execute();
        } catch (SQLException ex){
            System.out.println("Erro (excluirEquipamento): " + ex.getMessage());
            return false;
        }
        return true; 
    }

    public Equipamento consultarEquipamento(int codativo) {
        Equipamento equi = null;
        String sql = "SELECT cod_ativo, tipo_equipamento, descr_equipamento, sistema_operacional, cod_software, id_laboratorio, sit_patrimonio, data_entrada_ativo, data_baixa_ativo "
                + "FROM tbequipamento WHERE cod_ativo = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, codativo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                equi = new Equipamento();
                equi.setCodAtivo(codativo);
                equi.setTipoEquipamento(rs.getString("tipo_equipamento"));
                equi.setDesrEquipamento(rs.getString("descr_equipamento"));
                equi.setSistemaOperacional(rs.getString("sistema_operacional"));
                equi.setCodSoftware(rs.getInt("cod_software"));
                equi.setIdLaboratorio(rs.getInt("id_laboratorio"));
                equi.setSitPatrimonio(rs.getString("sit_patrimonio"));
                equi.setDataEntrAtivo(rs.getDate("data_entrada_ativo"));
                equi.setDataBaixaAtivo(rs.getDate("data_baixa_ativo"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro (consultarEquipamento): " + ex.getMessage());
        }
        return equi;
    }
    
    public List<Equipamento> consultarEquipamentos() {
        List<Equipamento> dados = new ArrayList<>();
        String sql = "SELECT cod_ativo,tipo_equipamento, descr_equipamento, sistema_operacional, cod_software, id_laboratorio, sit_patrimonio, data_entrada_ativo, data_baixa_ativo "
                + "FROM tbequipamento ORDER BY cod_ativo";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Equipamento equi = new Equipamento();
                equi.setCodAtivo(rs.getInt("cod_ativo"));
                equi.setTipoEquipamento(rs.getString("tipo_equipamento"));
                equi.setDesrEquipamento(rs.getString("descr_equipamento"));
                equi.setSistemaOperacional(rs.getString("sistema_operacional"));
                equi.setCodSoftware(rs.getInt("cod_software"));
                equi.setIdLaboratorio(rs.getInt("id_laboratorio"));
                equi.setSitPatrimonio(rs.getString("sit_patrimonio"));
                equi.setDataEntrAtivo(rs.getDate("data_entrada_ativo"));
                equi.setDataBaixaAtivo(rs.getDate("data_baixa_ativo"));
                dados.add(equi);
            }
        } catch (SQLException ex) {
            System.out.println("Erro (consultarEquipamentos): " + ex.getMessage());
        }
        return dados;
    }

    public int getCodAtivo() {
        return codAtivo;
    }

    public void setCodAtivo(int codAtivo) {
        this.codAtivo = codAtivo;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getDesrEquipamento() {
        return desrEquipamento;
    }

    public void setDesrEquipamento(String desrEquipamento) {
        this.desrEquipamento = desrEquipamento;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public int getCodSoftware() {
        return codSoftware;
    }

    public void setCodSoftware(int codSoftware) {
        this.codSoftware = codSoftware;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getSitPatrimonio() {
        return sitPatrimonio;
    }

    public void setSitPatrimonio(String sitPatrimonio) {
        this.sitPatrimonio = sitPatrimonio;
    }

    public Date getDataEntrAtivo() {
        return dataEntrAtivo;
    }

    public void setDataEntrAtivo(Date dataEntrAtivo) {
        this.dataEntrAtivo = dataEntrAtivo;
    }

    public Date getDataBaixaAtivo() {
        return dataBaixaAtivo;
    }

    public void setDataBaixaAtivo(Date dataBaixaAtivo) {
        this.dataBaixaAtivo = dataBaixaAtivo;
    }
    

}