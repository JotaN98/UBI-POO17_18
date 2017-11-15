
package projeto;

import java.text.DateFormat;

public class Pessoa {
    private String nome;
    private DateFormat nascimento;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(DateFormat nascimento) {
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public DateFormat getNascimento() {
        return nascimento;
    }
}
