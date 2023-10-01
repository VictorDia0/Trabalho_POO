package DAO;

import DTO.ClienteDTO;
import DTO.UsuarioDTO;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class Conexao {

    static Connection conexao;
    static PreparedStatement pst;
    static ResultSet rs;

    public static Connection conectar() {
        String driver = "jdbc:mysql://localhost:3306/dbjoias?user=root&password=2301487Vic";

        try {
            conexao = DriverManager.getConnection(driver);
            return conexao;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CONEXAO" + e.getMessage());
            return null;
        }
    }

    public static void alterarUsuario(String nome, String fone, String login, String senha, String perfil, String id) {
        String sql = "update tbusuarios set nome_usuario=?, fone=?, login=?, senha=?, perfil=? where iduser = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, fone);
            pst.setString(3, login);
            pst.setString(4, senha);
            pst.setString(5, perfil);
            pst.setString(6, id);

            if (nome.isEmpty() || login.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public static void adicionarUsuario(String id, String nome, String fone, String login, String senha, String perfil) {
        String sql = "INSERT INTO tbusuarios (iduser,nome_usuario, fone, login, senha, perfil) VALUES (?,?, ?, ?, ?,?);";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, nome);
            pst.setString(3, fone);
            pst.setString(4, login);
            pst.setString(5, senha);
            pst.setString(6, perfil);

            if ((nome.isEmpty()) || (login.isEmpty()) || (senha.isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {

                int add = pst.executeUpdate();

                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario criado com sucesso", "Sucesso!", HEIGHT);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public static UsuarioDTO consultarUsuario(String id) {
        String sql = "select * from tbusuarios where iduser = ? ; ";
        try {
            conexao = conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                return new UsuarioDTO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
            } else {
                JOptionPane.showMessageDialog(null, "Não existe nenhum usuário com esse ID");
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public static void removerUsuario(String id, String nome) {
        String sql = "delete from tbusuarios where iduser=? or nome_usuario=?";
        try {

            pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, id);
            pst.setString(2, nome);
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Usuario removido com sucesso");

            } else {
                JOptionPane.showMessageDialog(null, "Esse Usuario não existe");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public static void adicionarCliente(String nome, String endereco, String fone, String email, String cpf, String cnpj, String data_nasc, String whats) {
        String sql = "INSERT INTO tbclientes (nome, endereco_cliente, telefone, email, cpf, cnpj, whatsapp,data_nascimento) VALUES (? ,? , ? , ? , ? ,? , ? , ?);";
        try {
            conexao = conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, endereco);
            pst.setString(3, fone);
            pst.setString(4, email);
            pst.setString(5, cpf);
            pst.setString(6, cnpj);
            pst.setString(7, whats);
            pst.setString(8, data_nasc);

            if ((nome.isEmpty()) || (fone.isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {

                int add = pst.executeUpdate();

                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente criado com sucesso", "Sucesso!", HEIGHT);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public static void removerCliente(String nome) {
        String sql = "delete from tbclientes where nome=?";
        try {
            conexao = conectar();
            pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, nome);

            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Esse Cliente não existe");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public static ArrayList<ClienteDTO> pesquisarClientes(String nome) {
        String sql = "select * from tbclientes where nome like ?";
        ArrayList<ClienteDTO> listaClientes = new ArrayList<>();
        try {
            conexao = conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                ClienteDTO objClienteDTO = new ClienteDTO(
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("endereco_cliente")
                );
                listaClientes.add(objClienteDTO);
            }

            return listaClientes;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Listar clientes - Não foi possível listar clientes" + erro);
            return null;
        }

    }
    
    public static void alterarCliente(String nome, String endereco, String telefone, String email, String cpf, String cnpj, String dataNasc, String whats){
        String sql = "update tbclientes set endereco_cliente=?, telefone=?, email=?, cpf=?, cnpj=?, data_nascimento=?, whatsapp=? where nome= ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, endereco);
            pst.setString(2, telefone);
            pst.setString(3, email);
            pst.setString(4, cpf);
            pst.setString(5, cnpj);
            pst.setString(6, dataNasc);
            pst.setString(7, whats);
            pst.setString(8,nome);


            if (nome.isEmpty() ||  telefone.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}
