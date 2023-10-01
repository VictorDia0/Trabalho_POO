package DTO;

/**
 *
 * @author Victor Dias
 */
public class ClienteDTO {
    private int idCliente;
    private String nome;
    private String enderecoCliente;
    private String telefone;
    private String email;
    private String cpf;
    private String cnpj;
    private String dataNascimento;
    private String whatsapp;

    public ClienteDTO(String nome, String enderecoCliente, String telefone, String email, String cpf, String cnpj, String dataNascimento, String whatsapp) {
        this.nome = nome;
        this.enderecoCliente = enderecoCliente;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.dataNascimento = dataNascimento;
        this.whatsapp = whatsapp;
    }
    
    public ClienteDTO(String nome, String telefone, String enderecoCliente){
        this.nome = nome;
        this.telefone = telefone;
        this.enderecoCliente = enderecoCliente;
    }

    // Getters e Setters para todos os campos
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }
}

