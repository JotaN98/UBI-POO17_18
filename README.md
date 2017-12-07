# Regras de utilização
1. Nunca chamarás o construtor das classes, chamarás o Create().
3. Não criarás aulas a não ser que sejas pelas turmas.
4. Não criarás turmas a não ser que seja pelos Cursos.
3. Não defenirás a turma de um aluno, defenirás vários alunos a cada turma.
4. Nunca usem a função clone de nenhuma classe.
5. Primeiro criarás as disciplinas e só depois é que criarás os professores. (?)
6. As notas só seram criadas nos testes.


# Classes
### Por fazer:
* #11 Disciplina
* #10 Professor
* #9 Nota
* #8 Teste
* #7 Aluno
* #6 Turma
* #5 Aula
* #4 Curos

### Conteudo das Classes:
* Curso #4
    * Nome
    * Diretor
    * Disciplinas (array)
    * Turma
* Turma #6
    * Ano
    * Nome
    * Alunos (array)
    * Curso
    * Diretor
    * Horario (2D array)
    * Aulas (array)
* Aula #5
    * Hora
    * Professor
    * Disciplina
    * Turma
    * Sala
    * Testes (array)
* Teste #8
    * Data
    * Notas (array)
* Nota #9
    * Valor
    * Aluno
* Aluno #7
    * pnome, unome...
    * Turma
    * Notas (array do tipo: notas[ID de desiplinas][testes])
    * Ano
    * Curso
* Professor #10
    * pnome, unome...
    * Turmas (array)
    * Horario (2D array com ID das aulas)
    * Aulas (1D Array com as aulas, talvez não é preciso)
    * Testes (array)
* Disciplina #11
    * Nome
    * Professor
    * Aula
    * Ano
    * Sala onde pode ser dada


# Aspetos a melhorar
* Sempre que alguém remove um objeto, ele na realidade continua na base de dados mas a apontar para o objeto 0 dessa class, no entanto fica a ocupar memória desnecessariamente. Uma maneira de corrigir isto era passar por todas os objetos que não foram removidos e limpar as referencias ao objeto removido, no fim, tirava-se o objeto removido da base de dados.


---
![Classes](https://gitlab.com/EI-UBI/POO/Projeto/raw/master/Guidelines/Classes.JPG "Classes")
# Overview
![Overview](https://gitlab.com/EI-UBI/POO/Projeto/raw/master/Guidelines/Overview.JPG "Overview")