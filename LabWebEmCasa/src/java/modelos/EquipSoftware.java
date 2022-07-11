
package modelos;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EquipSoftware extends Equipamento {
    public int codAtivo;
    public int cod_Software;
    public Boolean incluirEquiSoftware() {
        String sql = " INSERT INTO tbequisoftware(cod_ativo, cod_software) VALUES (?,?) ";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement  pstm=con.prepareStatement(sql);
            pstm.setInt(1, this.codAtivo);
            pstm.setInt(2, this.cod_Software);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro (incluirEquiSoftware): " + ex.getMessage());
            return false;
        }
        return true;
    } 

   public boolean excluirEquiSoftware() {
        String sql = "DELETE FROM tbequisoftware WHERE cod_ativo, cod_software = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, this.codAtivo);
            pstm.setInt(2, this.cod_Software);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro (excluirEquiSoftware): " + ex.getMessage());
            return false;
        }
        return true;
    }

      public EquipSoftware consultarEquiSoftware(int codSoftware) {
        EquipSoftware equisoft = null;
        String sql = "SELECT cod_ativo, cod_software FROM tbequisoftware WHERE cod_ativo = ?, cod_software";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, codSoftware);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
               equisoft = new EquipSoftware();
               equisoft.setCodAtivo(codAtivo);
               equisoft.setCodSoftware(rs.getInt("cod_software"));
              
            }
        } catch (SQLException ex) {
            System.out.println("Erro (consultarEquiSoftware): " + ex.getMessage());
        }
        return equisoft;
    }

    public List<EquipSoftware> consultarEquiSoftwares(){
        List<EquipSoftware> dados = new ArrayList<>();
        String sql = "SELECT cod_ativo, cod_software,  FROM tbequisoftware";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                EquipSoftware equisoft = new EquipSoftware();
                equisoft.setCodSoftware(codAtivo);
                equisoft.setCodSoftware(codSoftware);    
            }
        } catch (SQLException ex ) {
            System.out.println("Erro (consultarEquiSoftwares): " + ex.getMessage());
        }
        return dados;
    } 

}
    

