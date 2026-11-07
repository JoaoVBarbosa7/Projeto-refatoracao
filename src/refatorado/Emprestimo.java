package refatorado;
public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private String data;

    public Emprestimo(Usuario usuario, Livro livro, String data) {
        this.usuario = usuario;
        this.livro = livro;
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Usuário: " + usuario.getNome()
                + " - Livro: " + livro.getTitulo()
                + " - Data: " + data;
    }
}