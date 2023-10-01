package DTO;

/**
 *
 * @author Victor Dias
 */
public class UsuarioDTO {

    private String iduser;
    private String nome;
    private String fone;
    private String login;
    private String senha;
    private String perfil;

    public UsuarioDTO(String id, String nome, String fone, String login, String senha, String perfil) {
        this.iduser = id;
        this.nome = nome;
        this.fone = fone;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    // Getters e setters para os atributos
    public String getIduser() {
        return iduser;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
