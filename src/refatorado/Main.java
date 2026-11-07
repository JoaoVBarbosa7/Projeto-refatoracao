package refatorado;
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro("O Senhor dos Anéis", "J. R. R. Tolkien", 1954);
        biblioteca.adicionarLivro("Refatoração", "Martin Fowler", 2020);

        Usuario maria = new Usuario("Maria", 21, "maria@gmail.com");

        biblioteca.realizarEmprestimo(maria, "O Senhor dos Anéis");
        biblioteca.realizarEmprestimo(maria, "Refatoração");

        biblioteca.listarEmprestimos();
    }
}