package modelos;
import java.sql.Connection;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Tecnico extends Equipamento {

    public Tecnico() {
    }

    private int codTecnico;

    private String nomeTecnico;

    private String foneTecnico;

    private String emailTecnico;

    public boolean incluirTecnico() {
       String sql =" INSERT INTO TbTecnico (nome_tecnico, fone_tecnico, email_tecnico) values(?,?,?) ";
       Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           PreparedStatement  stm=con.prepareStatement(sql);
           stm.setString(1, this.nomeTecnico);
           stm.setString(2, this.foneTecnico);
           stm.setString(3, this.emailTecnico);
           stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro (incluirTecnico): " + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean alterarTecnico() {
        String sql = "UPDATE TbTecnico SET nome_tecnico = ?, fone_tecnico= ? , email_tecnico =  ? WHERE cod_tecnico = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement  pstm=con.prepareStatement(sql);
            pstm = con.prepareStatement(sql);
            pstm.setString(1, this.nomeTecnico);
            pstm.setString(2, this.foneTecnico);
            pstm.setString(3, this.emailTecnico);
            pstm.setInt(4, this.codTecnico);
            pstm.executeUpdate();
            
        } catch (SQLException ex){
            System.out.println("Erro (alterarTecnico)" + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean excluirTecnico() {
        String sql= "DELETE FROM TbTecnico WHERE cod_tecnico = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, this.codTecnico);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro (excluirTecnico): " + ex.getMessage());
            return false;
        }
        return true;
    }

    public Tecnico consultarTecnico(int codtec) {
        Tecnico tecn = null;
        String sql = "SELECT cod_tecnico, nome_tecnico, fone_tecnico, email_tecnico FROM tbtecnico WHERE cod_tecnico = ?";
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, codtec);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                tecn = new Tecnico();
                tecn.setCodTecnico(codtec);
                tecn.setNomeTecnico(rs.getString("nome_tecnico"));
                tecn.setFoneTecnico(rs.getString("fone_tecnico"));
                tecn.setEmailTecnico(rs.getString("email_tecnico"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro (consultarTecnico): " + ex.getMessage());
        }
        return tecn;
    }
    public List<Tecnico> consultarTecnicos() {
        List<Tecnico> dados = new ArrayList<>();
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        String  sql  = "SELECT cod_tecnico, nome_tecnico,fone_tecnico ,email_tecnico FROM tbtecnico ORDER BY cod_tecnico";
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Tecnico tecn = new Tecnico();
                tecn.setCodTecnico(rs.getInt("cod_tecnico"));
                tecn.setNomeTecnico(rs.getString("nome_tecnico"));
                tecn.setFoneTecnico(rs.getString("fone_tecnico"));
                tecn.setEmailTecnico(rs.getString("email_tecnico"));
                dados.add(tecn);
            }
        } catch (SQLException ex) {
            System.out.println("Erro (consultarTecnicos): " + ex.getMessage());
        }
        return dados;
    }


    public int getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(int codTecnico) {
        this.codTecnico = codTecnico;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getFoneTecnico() {
        return foneTecnico;
    }

    public void setFoneTecnico(String foneTecnico) {
        this.foneTecnico = foneTecnico;
    }

    public String getEmailTecnico() {
        return emailTecnico;
    }

    public void setEmailTecnico(String emailTecnico) {
        this.emailTecnico = emailTecnico;
    }

}