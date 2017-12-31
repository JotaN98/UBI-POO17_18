import myinput.Ler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

public class Projeto {
	//Fun��o Main
    public static void main(String[] args) {
		int valorIntroduzido=0;
		SaveLoad.Load();
//		Curso.Create("Economia",Entity.Zero);
//		Curso.Create("CT",Entity.Zero);
//		Curso.Create("Humanidades",Entity.Zero);
//
//
//		Curso.getCursoFromID(1).addTurma("17/18","A",10,Entity.Zero);
//		Curso.getCursoFromID(2).addTurma("17/18","A",10,Entity.Zero);
//		Curso.getCursoFromID(3).addTurma("17/18","A",10,Entity.Zero);
//
//		Professor.Create("Manuel","Costa", ZonedDateTime.of(1984, 3, 2, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));
//
//		Disciplina.getDisciplinaFromID(Disciplina.Create("Economia",10)).addProfessor(Professor.getProfessorFromID(1));
//		Disciplina.getDisciplinaFromID(1).addPossibleSala("todas");
//
//		Disciplina.getDisciplinaFromID(Disciplina.Create("Matematica A",10)).addProfessor(Professor.getProfessorFromID(1));
//		Disciplina.getDisciplinaFromID(2).addPossibleSala("todas");
//
//		Curso.getCursoFromID(1).addDisciplina(Disciplina.getDisciplinaFromID(1));


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
				Entity teste = Curso.getCursoFromID(1).getDisciplinas().get(0);
				System.out.println(teste.getClass());
				System.out.println(Disciplina.getDisciplinaFromID(1).getClass());
				SaveLoad.Dump();
			}
			else  if (valorIntroduzido != Menus.MainMenuExitOp)
				System.out.println("Introduza um numero entre 1 e "+ (Menus.MainMenuExitOp-1) +".");

		}

		System.out.println("Goodbye");

	}
    
}
