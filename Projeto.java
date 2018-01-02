import myinput.Ler;

import java.time.ZoneId;
import java.time.ZonedDateTime;


public class Projeto {
	//Fun��o Main
    public static void main(String[] args) {
		

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
