package projeto;

import java.text.DateFormat;

public class Teste {
    private Disciplina disciplina;
    private DateFormat data;

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setData(DateFormat data) {
        this.data = data;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public DateFormat getData() {
        return data;
    }

    public String toString() {
        return "Teste{" + "disciplina=" + disciplina + ", data=" + data + '}';
    }
    
}
