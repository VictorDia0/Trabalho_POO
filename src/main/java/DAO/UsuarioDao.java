package DAO;

import DTO.UsuarioDTO;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor Dias
 */
public class UsuarioDao {
    Connection conn;

    public ResultSet autenticacaoUsuario(UsuarioDTO objusuariodto) {
        conn = Conexao.conectar();

        try {
            String sql = "select * from tbusuarios where login = ? and senha = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getLogin());
            pstm.setString(2, objusuariodto.getSenha());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "UsusarioDAO " + e);
            
            return null;
        }
       
    }
}
