package refatorado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Biblioteca {
    private static final String DATA_EMPRESTIMO_PADRAO = "10/09/2025";

    private final List<Livro> livros = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(String titulo, String autor, int ano) {
        livros.add(new Livro(titulo, autor, ano));
    }

    public void realizarEmprestimo(Usuario usuario, String tituloLivro) {
        Optional<Livro> livroEncontrado = buscarLivroDisponivel(tituloLivro);

        if (livroEncontrado.isEmpty()) {
            System.out.println("Livro não disponível.");
            return;
        }

        Livro livro = livroEncontrado.get();
        Emprestimo emprestimo = new Emprestimo(usuario, livro, DATA_EMPRESTIMO_PADRAO);

        emprestimos.add(emprestimo);
        livro.marcarComoEmprestado();

        System.out.println("Emprestimo realizado: " + usuario.getNome()
                + " pegou " + livro.getTitulo());
    }

    private Optional<Livro> buscarLivroDisponivel(String tituloLivro) {
        return livros.stream()
                .filter(livro -> livro.possuiTitulo(tituloLivro) && livro.isDisponivel())
                .findFirst();
    }

    public void listarEmprestimos() {
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }

    public void relatorioLivros() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public List<Livro> getLivros() {
        return Collections.unmodifiableList(livros);
    }

    public List<Emprestimo> getEmprestimos() {
        return Collections.unmodifiableList(emprestimos);
    }
}