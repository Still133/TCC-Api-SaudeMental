package javafx.application;

class Usuario {
    private String login;
    private String senha;
    private String telefone;
    private String cpf;

    public Usuario(String login, String senha, String telefone, String cpf) {
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }
}
