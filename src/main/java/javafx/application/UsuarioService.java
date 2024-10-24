package javafx.application;

import java.util.ArrayList;
import java.util.List;

class UsuarioService {
    private List<Usuario> usuarios;

    public UsuarioService() {
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(String login, String senha, String telefone, String cpf) {
        Usuario usuario = new Usuario(login, senha, telefone, cpf);
        usuarios.add(usuario);
    }

    public boolean autenticarUsuario(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
