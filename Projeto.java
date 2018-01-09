import myinput.Ler;

import java.time.ZoneId;
import java.time.ZonedDateTime;


public class Projeto {
	//Fun��o Main
    public static void main(String[] args) {
		
		Aluno.Create("Joao", "Manuel", ZonedDateTime.of(1997, 3, 5, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));
		Aluno.Create("Bruno", "Tavares", ZonedDateTime.of(1996, 3, 25, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));
		
		Professor.Create("Paula", "Prata", ZonedDateTime.of(1989, 6,4, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));
		Professor.Create("Hugo", "Proença", ZonedDateTime.of(1999, 2,14, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));
		
		Curso.Create("Ciencias", Entity.Zero);
		Curso.Create("Poo",	Professor.getProfessorFromID(2));
		
		Disciplina.Create("Java", 1);
		Disciplina.Create("Javafx", 2);
		Disciplina.getDisciplinaFromID(2).addPossibleSala("todas");
		Turma.Create("17/18", "C", 12, Curso.getCursoFromID(2), Professor.getProfessorFromID(2));
		Disciplina.getDisciplinaFromID(1).addProfessor(Professor.getProfessorFromID(1));
		Disciplina.getDisciplinaFromID(2).addProfessor(Professor.getProfessorFromID(2));
		
		Turma.getTurmaFromID(1).addAula(2, 3, Professor.getProfessorFromID(2), Disciplina.getDisciplinaFromID(2), "1");
		
		
		Curso.getCursoFromID(1).addTurma("17/18", "C", 12, Curso.getCursoFromID(1));
		Curso.getCursoFromID(1).setDiretor(Professor.getProfessorFromID(2));
		Curso.getCursoFromID(1).setNome("Logica");
		Professor.getProfessorFromID(1).setNascimento(ZonedDateTime.of(1970, 6,4, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));
		Curso.getCursoFromID(2).addDisciplina(Disciplina.getDisciplinaFromID(1));
		Curso.getCursoFromID(2).addDisciplina(Disciplina.getDisciplinaFromID(2));
	
		
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
