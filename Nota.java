
package projeto;


public class Nota {
    private Aluno aluno;
    private Teste teste;

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Teste getTeste() {
        return teste;
    }

    public double getValor() {
        return valor;
    }
    private double valor;
}
