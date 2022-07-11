package modelos;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Laboratorio extends Equipamento {

    public Laboratorio() {
    }
    public int idLaboratorio;
    
    public String codBloco;
    
    public int codlaboratorio;

    public String tipolaboratorio;

    public String descrLaboratorio;
    
    public String situacaoLaboratorio;

    public boolean incluirLaboratorio() {
        String sql = "INSERT INTO tblaboratorio (cod_bloco, cod_laboratorio, tipo_laboratorio, descr_laboratorio, situacao_laboratorio) VALUES (?,?,?,?,?)";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement  pstm=con.prepareStatement(sql);
            pstm.setString(1, this.codBloco);
            pstm.setInt(2, this.codlaboratorio);
            pstm.setString(3, this.tipolaboratorio);
            pstm.setString (4, this.descrLaboratorio);
            pstm.setString (5, this.situacaoLaboratorio);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro (incluirLaboratorio): " + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean alterarLaboratorio() {
        String sql = "UPDATE tblaboratorio"
                + " SET cod_bloco = ?, cod_laboratorio = ?, tipo_laboratorio =  ?, descr_laboratorio = ?, situacao_laboratorio = ?"
                + " WHERE id_laboratorio = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            PreparedStatement  pstm=con.prepareStatement(sql);
            pstm.setString(1, this.codBloco);
            pstm.setInt(2, this.codlaboratorio);
            pstm.setString(3, this.tipolaboratorio);
            pstm.setString (4, this.descrLaboratorio);
            pstm.setString (5, this.situacaoLaboratorio);
            pstm.setInt(6, this.idLaboratorio);
            pstm.executeUpdate();
        } catch (SQLException ex){
            System.out.println("Erro (alterarLaboratorio): " + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean excluirLaboratorio() {
        String sql = "DELETE FROM tblaboratorio WHERE id_laboratorio = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, this.idLaboratorio);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro (excluirLaboratorio): " + ex.getMessage());
            return false;
        }
        return true;
    }

    public Laboratorio consultarLaboratorio(int idlab) {
        Laboratorio lab = null;
        String sql = " SELECT id_laboratorio, cod_bloco, cod_laboratorio, tipo_laboratorio, descr_laboratorio, situacao_laboratorio "
                + " FROM tblaboratorio WHERE id_laboratorio = ? " ;
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, idlab);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                lab = new Laboratorio();
                lab.setIdLaboratorio(idlab);
                lab.setCodBloco(rs.getString("cod_bloco"));
                lab.setCodlaboratorio(rs.getInt("cod_laboratorio"));
                lab.setTipolaboratorio(rs.getString("tipo_laboratorio"));
                lab.setDescrLaboratorio(rs.getString("descr_laboratorio"));
                lab.setSituacaoLaboratorio(rs.getString("situacao_laboratorio"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro (consultarLaboratorio): " + ex.getMessage());
        }
        return lab;
    }
    public List<Laboratorio> consultarLaboratorios(){
        List<Laboratorio> dados = new ArrayList<>();
        String sql = "SELECT id_laboratorio, cod_bloco, cod_laboratorio, tipo_laboratorio, descr_laboratorio, situacao_laboratorio "
                + " FROM tblaboratorio ORDER BY id_laboratorio";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Laboratorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Laboratorio lab = new Laboratorio();
                lab.setIdLaboratorio(rs.getInt("id_laboratorio"));
                lab.setCodBloco(rs.getString("cod_bloco"));
                lab.setCodlaboratorio(rs.getInt("cod_laboratorio"));
                lab.setTipolaboratorio(rs.getString("tipo_laboratorio"));
                lab.setDescrLaboratorio(rs.getString("descr_laboratorio"));
                lab.setSituacaoLaboratorio(rs.getString("situacao_laboratorio"));
                dados.add(lab);
            }
        } catch (SQLException ex) {
             System.out.println("Erro (consultarLaboratorios): " + ex.getMessage());
        }
        return dados;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getCodBloco() {
        return codBloco;
    }

    public void setCodBloco(String codBloco) {
        this.codBloco = codBloco;
    }

    public int getCodlaboratorio() {
        return codlaboratorio;
    }

    public void setCodlaboratorio(int codlaboratorio) {
        this.codlaboratorio = codlaboratorio;
    }

    public String getTipolaboratorio() {
        return tipolaboratorio;
    }

    public void setTipolaboratorio(String tipolaboratorio) {
        this.tipolaboratorio = tipolaboratorio;
    }

    public String getDescrLaboratorio() {
        return descrLaboratorio;
    }

    public void setDescrLaboratorio(String descrLaboratorio) {
        this.descrLaboratorio = descrLaboratorio;
    }

    public String getSituacaoLaboratorio() {
        return situacaoLaboratorio;
    }

    public void setSituacaoLaboratorio(String situacaoLaboratorio) {
        this.situacaoLaboratorio = situacaoLaboratorio;
    }
    

}