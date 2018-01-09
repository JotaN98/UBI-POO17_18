import myinput.Ler;

import java.time.ZoneId;
import java.time.ZonedDateTime;


public class Projeto {
	//Fun��o Main
    public static void main(String[] args) {
		
		Aluno.Create("Joao", "Manuel", ZonedDateTime.of(1997, 3, 5, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));
		Aluno.Create("Manuel", "Joao", ZonedDateTime.of(1996, 3, 25, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));

		Professor.Create("Paulo", "Jorge", ZonedDateTime.of(1985, 6,4, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));
		Professor.Create("Jose", "Augusto", ZonedDateTime.of(1982, 2,20, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));
		Professor.Create("Lucas", "Robalo", ZonedDateTime.of(1980, 3,4, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));
		Professor.Create("Maria", "Augusto", ZonedDateTime.of(1988, 3,1, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));

		Professor.getProfessorFromID(1).setNascimento(ZonedDateTime.of(1970, 6,4, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));

		Curso.Create("CT", Entity.Zero);
		Curso.Create("Economia",	Professor.getProfessorFromID(2));

		Curso.getCursoFromID(1).setDiretor(Professor.getProfessorFromID(4));

		Disciplina.Create("Economia", 10);
		Disciplina.Create("Educ. Fis.", 10);
		Disciplina.Create("Matematica A", 10);
		Disciplina.Create("Fisica", 10);
		Disciplina.getDisciplinaFromID(1).addPossibleSala("todas");
		Disciplina.getDisciplinaFromID(1).addProfessor(Professor.getProfessorFromID(2));
		Disciplina.getDisciplinaFromID(2).addPossibleSala("Ginasio 1");
		Disciplina.getDisciplinaFromID(2).addPossibleSala("Ginasio 2");
		Disciplina.getDisciplinaFromID(2).addProfessor(Professor.getProfessorFromID(1));
		Disciplina.getDisciplinaFromID(3).addPossibleSala("todas");
		Disciplina.getDisciplinaFromID(3).addProfessor(Professor.getProfessorFromID(3));
		Disciplina.getDisciplinaFromID(4).addPossibleSala("Lab 1");
		Disciplina.getDisciplinaFromID(4).addPossibleSala("Lab 2");
		Disciplina.getDisciplinaFromID(4).addProfessor(Professor.getProfessorFromID(4));

		// economia
		Curso.getCursoFromID(1).addTurma("17/18", "B", 10, Professor.getProfessorFromID(4));
		Curso.getCursoFromID(1).addDisciplina(Disciplina.getDisciplinaFromID(4));
		Curso.getCursoFromID(1).addDisciplina(Disciplina.getDisciplinaFromID(3));
		Curso.getCursoFromID(1).addDisciplina(Disciplina.getDisciplinaFromID(2));
		// ct
		Curso.getCursoFromID(2).addTurma("17/18", "A", 10, Professor.getProfessorFromID(2));
		Curso.getCursoFromID(2).addDisciplina(Disciplina.getDisciplinaFromID(1));
		Curso.getCursoFromID(2).addDisciplina(Disciplina.getDisciplinaFromID(3));
		Curso.getCursoFromID(2).addDisciplina(Disciplina.getDisciplinaFromID(2));

		//economia
		Turma.getTurmaFromID(2).addAula(2, 0, Professor.getProfessorFromID(2), Disciplina.getDisciplinaFromID(1), "1");
		//fisica
		Turma.getTurmaFromID(1).addAula(2, 0, Professor.getProfessorFromID(4), Disciplina.getDisciplinaFromID(4), "Lab 1");
		//edf
		Turma.getTurmaFromID(1).addAula(4, 1, Professor.getProfessorFromID(1), Disciplina.getDisciplinaFromID(2), "Ginasio 1");
		Turma.getTurmaFromID(2).addAula(4, 2, Professor.getProfessorFromID(1), Disciplina.getDisciplinaFromID(2), "Ginasio 2");
		//Mat A
		Turma.getTurmaFromID(1).addAula(2, 3, Professor.getProfessorFromID(3), Disciplina.getDisciplinaFromID(3), "2");
		Turma.getTurmaFromID(2).addAula(1, 3, Professor.getProfessorFromID(3), Disciplina.getDisciplinaFromID(3), "1");

		Turma.getTurmaFromID(1).addAluno(Aluno.getAlunoFromID(1));
		Turma.getTurmaFromID(2).addAluno(Aluno.getAlunoFromID(2));


	
		
		int valorIntroduzido=0;
		SaveLoad.Load();

		while(valorIntroduzido != Menus.MainMenuExitOp) {

			Menus.printMainMenu();
			valorIntroduzido = Ler.processarTecladoInt();

			if (valorIntroduzido == 1)
				MenuCurso.MainMenu();
			else if (valorIntroduzido == 2)
				MenuTurma.MainMenu();
			else if (valorIntroduzido == 3)
				MenuDisciplina.MainMenu();
			else if (valorIntroduzido == 4)
				MenuProfessor.MainMenu();
			else if (valorIntroduzido == 5)
				MenuAluno.MainMenu();
			else if (valorIntroduzido == 6){
				SaveLoad.Dump();
			}
			else  if (valorIntroduzido != Menus.MainMenuExitOp)
				System.out.println("Introduza um numero entre 1 e "+ (Menus.MainMenuExitOp-1) +".");

		}

		System.out.println("Goodbye");

	}
    
}
