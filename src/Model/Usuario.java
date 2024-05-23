
package Model;



public class Usuario {
    private String nome, usuario, senha, CPF;

    public Usuario() {
    }

    public Usuario(String nome, String usuario, String senha, String CPF) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", usuario=" + usuario 
                + ", senha=" + senha + ", CPF=" + CPF + '}';
    }
    
    
    
    
    
    
}
