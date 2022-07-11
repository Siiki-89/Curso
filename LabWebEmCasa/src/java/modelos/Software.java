package modelos;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Software {

    public Software() {
    }

    public int codSoftware;

    public String descSoftware;

    public String descVersao;

    public Date dataInstalacao;
    
    public String tipoLicensa;

    public boolean incluirSoftware() {
        String sql = " INSERT INTO TbSoftware (descr_software, desc_versao, data_instalacao, tipo_licenca) VALUES (?,?,?,?) ;";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Software.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement  pstm=con.prepareStatement(sql);
            pstm.setString(1, this.descSoftware);
            pstm.setString(2, this.descVersao);
            pstm.setDate(3, (java.sql.Date) this.dataInstalacao);
            pstm.setString (4, this.tipoLicensa);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro (incluirSoftware): " + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean alterarSoftware() {
        String sql = "UPDATE tbsoftware SET descr_software = ?, desc_versao= ?, data_instalacao =  ?, tipo_licenca = ? WHERE cod_software = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Software.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            PreparedStatement  pstm=con.prepareStatement(sql);
            pstm = con.prepareStatement(sql);
            pstm.setString(1, this.descSoftware);
            pstm.setString(2, this.descVersao);
            pstm.setDate(3, (java.sql.Date) this.dataInstalacao);
            pstm.setString (4, this.tipoLicensa);
            pstm.setInt (5, this.codSoftware);
            pstm.executeUpdate();
        } catch (SQLException ex){
            System.out.println("Erro (alterarSoftware)" + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean excluirSoftware() {
        String sql = "DELETE FROM TbSoftware WHERE cod_software = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Software.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, this.codSoftware);
            pstm.execute();
        } catch (SQLException erro) {
            System.out.println(erro + " Excluir tecnico");
            return false;
        }
        return true;
    }

    public Software consultarSoftware(int codSoftware) {
        Software soft = null;
        String sql = "SELECT cod_software, descr_software, desc_versao, data_instalacao, tipo_licenca "
                + "FROM TbSoftware WHERE cod_software = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Software.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, codSoftware);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                soft = new Software();
                soft.setCodSoftware(codSoftware);
                soft.setDescSoftware(rs.getString("descr_software"));
                soft.setDescVersao(rs.getString("desc_versao"));
                soft.setDataInstalacao(rs.getDate("data_instalacao"));
                soft.setTipoLicensa(rs.getString("tipo_licenca"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro (consultarSoftware): " + ex.getMessage());
        }
        return soft;
    }

    public List<Software> consultarSoftwares(){
        List<Software> dados = new ArrayList<>();
        String sql = "SELECT cod_software, descr_software, desc_versao, data_instalacao, tipo_licenca FROM TbSoftware";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Software.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Software soft = new Software();
                soft.setCodSoftware(rs.getInt("cod_software"));
                soft.setDescSoftware(rs.getString("descr_software"));
                soft.setDescVersao(rs.getString("desc_versao"));
                soft.setDataInstalacao(rs.getDate("data_instalacao"));
                soft.setTipoLicensa(rs.getString("tipo_licenca"));
                dados.add(soft);
            }
        } catch (SQLException ex ) {
            System.out.println("Erro (consultarSoftwares): " + ex.getMessage());
        }
        return dados;
    }

    public int getCodSoftware() {
        return codSoftware;
    }

    public void setCodSoftware(int codSoftware) {
        this.codSoftware = codSoftware;
    }

    public String getDescSoftware() {
        return descSoftware;
    }

    public void setDescSoftware(String descSoftware) {
        this.descSoftware = descSoftware;
    }

    public String getDescVersao() {
        return descVersao;
    }

    public void setDescVersao(String descVersao) {
        this.descVersao = descVersao;
    }

    public Date getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(Date dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }


    public String getTipoLicensa() {
        return tipoLicensa;
    }

    public void setTipoLicensa(String tipoLicensa) {
        this.tipoLicensa = tipoLicensa;
    }
    
    

}