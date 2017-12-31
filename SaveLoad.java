import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class SaveLoad {
	private static final String SaveDir = System.getProperty("user.dir") + "\\EscolaSecundario\\";

	public static void Dump(){
		try {
			ObjectOutputStream outputTurma = new ObjectOutputStream(new FileOutputStream(SaveDir + "Turma.dat"));
			ObjectOutputStream outputCurso = new ObjectOutputStream(new FileOutputStream(SaveDir + "Curso.dat"));
			ObjectOutputStream outputAluno = new ObjectOutputStream(new FileOutputStream(SaveDir + "Aluno.dat"));
			ObjectOutputStream outputProfessor = new ObjectOutputStream(new FileOutputStream(SaveDir + "Professor.dat"));
			ObjectOutputStream outputAula = new ObjectOutputStream(new FileOutputStream(SaveDir + "Aula.dat"));
			ObjectOutputStream outputDisciplina = new ObjectOutputStream(new FileOutputStream(SaveDir + "Disciplina.dat"));
			ObjectOutputStream outputNota = new ObjectOutputStream(new FileOutputStream(SaveDir + "Nota.dat"));
			ObjectOutputStream outputTeste = new ObjectOutputStream(new FileOutputStream(SaveDir + "Teste.dat"));

			ArrayList<Teste> noNullsTeste = new ArrayList<Teste>();
			for(Map.Entry<String, Teste> entry : Teste.getTestes().entrySet()){
				if(entry.getValue().getID() != 0) {
					noNullsTeste.add(entry.getValue());
				}
			}
			outputTeste.writeObject(noNullsTeste);

			ArrayList<Nota> noNullsNota = new ArrayList<Nota>();
			for(Map.Entry<String, Nota> entry : Nota.getNotas().entrySet()){
				if(entry.getValue().getID() != 0) {
					noNullsNota.add(entry.getValue());
				}
			}
			outputNota.writeObject(noNullsNota);

			ArrayList<Disciplina> noNullsDisciplina = new ArrayList<Disciplina>();
			for(Map.Entry<String, Disciplina> entry : Disciplina.getDisciplinas().entrySet()){
				if(entry.getValue().getID() != 0) {
					noNullsDisciplina.add(entry.getValue());
				}
			}
			outputDisciplina.writeObject(noNullsDisciplina);

			ArrayList<Aula> noNullsAula = new ArrayList<Aula>();
			for(Map.Entry<String, Aula> entry : Aula.getAulas().entrySet()){
				if(entry.getValue().getID() != 0) {
					noNullsAula.add(entry.getValue());
				}
			}
			outputAula.writeObject(noNullsAula);

			ArrayList<Professor> noNullsProfessor = new ArrayList<Professor>();
			for(Map.Entry<String, Professor> entry : Professor.getProfessores().entrySet()){
				if(entry.getValue().getID() != 0) {
					noNullsProfessor.add(entry.getValue());
				}
			}
			outputProfessor.writeObject(noNullsProfessor);

			ArrayList<Aluno> noNullsAluno = new ArrayList<Aluno>();
			for(Map.Entry<String, Aluno> entry : Aluno.getAlunos().entrySet()){
				if(entry.getValue().getID() != 0) {
					noNullsAluno.add(entry.getValue());
				}
			}
			outputAluno.writeObject(noNullsAluno);

			ArrayList<Curso> noNullsCurso = new ArrayList<Curso>();
			for(Map.Entry<String, Curso> entry : Curso.getCursos().entrySet()){
				if(entry.getValue().getID() != 0) {
					noNullsCurso.add(entry.getValue());
				}
			}
			outputCurso.writeObject(noNullsCurso);

			ArrayList<Turma> noNullsTurma = new ArrayList<Turma>();
			for(Map.Entry<String, Turma> entry : Turma.getTurmas().entrySet()){
				if(entry.getValue().getID() != 0) {
					noNullsTurma.add(entry.getValue());
				}
			}
			outputTurma.writeObject(noNullsTurma);
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	public static void Load(){

		try {
			ObjectInputStream inputCurso = new ObjectInputStream(new FileInputStream(SaveDir + "Curso.dat"));
			ObjectInputStream inputTurma = new ObjectInputStream(new FileInputStream(SaveDir + "Turma.dat"));
			ObjectInputStream inputAluno = new ObjectInputStream(new FileInputStream(SaveDir + "Aluno.dat"));
			ObjectInputStream inputProfessor = new ObjectInputStream(new FileInputStream(SaveDir + "Professor.dat"));
			ObjectInputStream inputAula = new ObjectInputStream(new FileInputStream(SaveDir + "Aula.dat"));
			ObjectInputStream inputDisciplina = new ObjectInputStream(new FileInputStream(SaveDir + "Disciplina.dat"));
			ObjectInputStream inputNota = new ObjectInputStream(new FileInputStream(SaveDir + "Nota.dat"));
			ObjectInputStream inputTeste = new ObjectInputStream(new FileInputStream(SaveDir + "Teste.dat"));


			for(Curso curso : (ArrayList<Curso>) inputCurso.readObject()){
				Curso.addCurso(curso);
			}
			for(Turma turma : (ArrayList<Turma>) inputTurma.readObject()){
				Turma.addTurma(turma);
			}
			for(Aluno aluno : (ArrayList<Aluno>) inputAluno.readObject()){
				Aluno.addAluno(aluno);
			}
			for(Professor professor : (ArrayList<Professor>) inputProfessor.readObject()){
				Professor.addProfessor(professor);
			}
			for(Aula aula : (ArrayList<Aula>) inputAula.readObject()){
				Aula.addAula(aula);
			}
			for(Disciplina disciplina : (ArrayList<Disciplina>) inputDisciplina.readObject()){
				Disciplina.addDisciplina(disciplina);
			}
			for(Nota nota : (ArrayList<Nota>) inputNota.readObject()){
				Nota.addNota(nota);
			}
			for(Teste teste : (ArrayList<Teste>) inputTeste.readObject()){
				Teste.addTeste(teste);
			}


		} catch (IOException | ClassNotFoundException e){
			if (!e.getMessage().contains("The system cannot find the path specified")) {
				System.out.println("Ocorreu um erro a carregar os dados:");
				System.out.println(e.getLocalizedMessage());

			}
		}
	}

}
