import myinput.Ler;

import java.util.ArrayList;

public class MenuTurma {
	public static void MainMenu(){
		int valorIntroduzido = 0;

		while(valorIntroduzido != Menus.MenuExitOp){
			Menus.printMenu("Truma","Turmas");
			valorIntroduzido = Ler.processarTecladoInt();

			if(valorIntroduzido == 0)/*mostrar todos as turmas*/{
				Menus.printTodasTurmas();
			} else if(valorIntroduzido == 1)/*Criar turma*/{
				criarTurma();
			} else if(valorIntroduzido == 2)/*eliminar turma*/{
				if(Turma.size() == 0)
					System.out.println("Ainda não existe turmas.");
				else
					eliminarTurma();
			} else if(valorIntroduzido == 3)/*selecionar turma*/{
				selecionarTurma();
			} else if(valorIntroduzido == 4)/*eliminar todas as turmas*/{
				eliminarTodosTurma();
			} else if(valorIntroduzido != 5)/*nenhuma da opções*/
				System.out.println("Introduza um numero entre 1 e "+ (Menus.MainMenuExitOp-1) +".");
			// 5 = menuExitOp
		}
	}

	public static void criarTurma(){
		long cursoID = 0;
		Curso curso = Curso.getCursoFromID(Entity.Zero);
		while(curso.getID() == 0 && Curso.size() != 0){
			System.out.println("Digite o ID do curso onde quer criar uma turma(0 para mostrar todos os Cursos, -1 para cancelar): ");
			cursoID = Ler.processarTecladoLong();
			curso = Curso.getCursoFromID(cursoID);

			if(cursoID == 0)
				Menus.printTodosCursos();
			if(curso.getID() == 0)
				System.out.println("Curso \""+cursoID+"\" não existe.");
			if(cursoID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}

		}
		if(Curso.size() == 0)
			System.out.println("Ainda não existem cursos.");
		if(cursoID != -1) {
			if(!MenuCurso.criarTurma(curso))
				System.out.println("Operação cancelada.");
		}
	}
	public static void eliminarTurma(){
		long turmaID = 0;
		Turma turmaE = Turma.getTurmaFromID(Entity.Zero);
		while(turmaE.getID() == 0 && Turma.size() != 0){
			System.out.println("Digite o ID da turma a remover(0 para mostrar turmas já adicionadas, -1 para cancelar): ");
			turmaID = Ler.processarTecladoLong();
			turmaE = Turma.getTurmaFromID(turmaID);

			if(turmaID == 0)
				Menus.printTodasTurmas();
			else if(turmaID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}
			else if(turmaE.getID() == 0) {
				System.out.println("Turma \""+turmaID+"\" não existe.");
				turmaID = 0;
			}

		}
		if(Turma.size() == 0)
			System.out.println("Ainda não foram criadas turmas.");
		if(turmaID != -1){
			try {
				String turmanome = Turma.getTurmaFromID(turmaE).toString();
				Curso.getCursoFromID(Turma.getTurmaFromID(turmaE).getCurso()).removeTurma(turmaE);
				System.out.println("Turma \""+ turmanome +"\" removida.");
			} catch (IllegalArgumentException | NullPointerException e){
				System.out.println("Ocurreu um erro.");
				System.out.println(e.getMessage());
			}
		}
	}
	public static void selecionarTurma(){
		long turmaID = 0;
		Turma turma = Turma.getTurmaFromID(Entity.Zero);
		while (turma.getID() == 0 && turma.size() != 0) {
			System.out.println("Digite o ID do turma(0 para mostrar todos os Cursos, -1 para cancelar): ");
			turmaID = Ler.processarTecladoLong();
			turma = Turma.getTurmaFromID(turmaID);

			if (turmaID == 0)
				Menus.printTodasTurmas();
			if (turma.getID() == 0)
				System.out.println("Turma  \"" + turmaID + "\" não existe.");
			if (turmaID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}

		}
		if (Turma.size() == 0)
			System.out.println("Ainda não existem Turmas.");
		if (turmaID != -1) {
			int valorIntroduzido = -1;

			while (valorIntroduzido != 7) {
				System.out.println("Turma " + turma);
				System.out.println("1- Mudar Ano Letivo");
				System.out.println("2- Mudar Nome");
				System.out.println("3- Mudar Ano");
				System.out.println("4- Inserir Aluno");
				System.out.println("5- Mudar Curso");
				System.out.println("6- Mudar Diretor");
				System.out.println("7- Criar Aula");
				System.out.println("8- Eliminar Aula");
				System.out.println("9- Mostrar Horário");
				System.out.println("10- Voltar");

				valorIntroduzido = Ler.processarTecladoInt();

				if (valorIntroduzido == 1)/*Mudar ano letivo*/{
					String ano = "";
					while(ano.equalsIgnoreCase("")){
						System.out.println("Digite o novo ano letivo da turma(enter para cancelar): ");

						ano = Ler.processarTecladoString();

					}
					if(ano.equalsIgnoreCase("")){
						System.out.println("Operação cancelada.");
					} else {
						turma.setAnoLetivo(ano);
					}
				}
				else if (valorIntroduzido == 2)/*mudar nome*/{
					String nome = "";
					while(nome.equalsIgnoreCase("")){
						System.out.println("Digite o novo nome da turma(enter para cancelar): ");

						nome = Ler.processarTecladoString();

					}
					if(nome.equalsIgnoreCase("")){
						System.out.println("Operação cancelada.");
					} else {
						turma.setNome(nome);
					}

				}
				else if (valorIntroduzido == 3)/*Mudar ano*/{
					int  ano = 0;
					while(ano == 0){
						System.out.println("Digite o novo ano da turma(-1 para cancelar): ");

						ano = Ler.processarTecladoInt();

						if(ano == -1){
							System.out.println("Operaão cancelada.");
							break;
						} else if(ano < 10 || ano > 12){
							System.out.println("Ano tem que ser entre 10 e 12.");
							ano = 0;
						}

					}
					if(ano != -1){
						turma.setAno(ano);
					}
				}
				else if (valorIntroduzido == 4)/*Inserir aluno*/{
					long alunoID = 0;
					Aluno aluE = Aluno.getAlunoFromID(Entity.Zero);
					while(aluE.getID() == 0 && Aluno.size() != 0){
						System.out.println("Digite o ID da disciplina(0 para mostrar todas as disciplinas, -1 para cancelar): ");
						alunoID = Ler.processarTecladoLong();
						aluE = Aluno.getAlunoFromID(alunoID);

						if(alunoID == 0)
							Menus.printTodosAlunos();
						if(alunoID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}
						if(aluE.getID() == 0) {
							System.out.println("Aluno \""+alunoID+"\" não existe.");
						}

					}
					if(Aluno.size() == 0)
						System.out.println("Ainda não existem Alunos.");
					if(alunoID != -1){
						try {
							turma.addAluno(aluE);
							System.out.println("Aluno \""+ aluE +"\" adicionada.");
						} catch (IllegalArgumentException | NullPointerException e){
							System.out.println("Ocurreu um erro.");
							System.out.println(e.getMessage());
						}
					}
				}
				else if (valorIntroduzido == 5)/*Mudar curso*/{
					long curID = 0;
					Curso curE = Curso.getCursoFromID(Entity.Zero);
					while(curE.getID() == 0 && Curso.size() != 0){
						System.out.println("Digite o ID do Curso(0 para mostrar todas as disciplinas, -1 para cancelar): ");
						curID = Ler.processarTecladoLong();
						curE = Curso.getCursoFromID(curID);

						if(curID == 0)
							Menus.printTodosCursos();
						if(curID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}
						if(curE.getID() == 0) {
							System.out.println("Curso \""+curID+"\" não existe.");
						}

					}
					if(Curso.size() == 0)
						System.out.println("Ainda não existem Disciplinas.");
					if(curID != -1){
						try {
							turma.setCurso(curE);
							System.out.println("Curso mudado para \""+ curE +"\".");
						} catch (IllegalArgumentException | NullPointerException e){
							System.out.println("Ocurreu um erro.");
							System.out.println(e.getMessage());
						}
					}
				}
				else if (valorIntroduzido == 6)/*Mudar diretor*/{
					long profID = 0;
					Entity profE = Entity.Zero;
					while(profE.getID() == 0 && Professor.size() != 0){
						System.out.println("Digite o ID do professor(0 para mostrar todos os professores, -1 para cancelar): ");
						profID = Ler.processarTecladoLong();
						profE = Professor.getProfessorFromID(profID);

						if(profID == 0)
							Menus.printTodosProfessores();
						if(profID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}
						if(profE.getID() == 0) {
							System.out.println("Professor \""+profID+"\" não existe.");
						}

					}
					if(Professor.size() == 0)
						System.out.println("Ainda não existem professores.");
					if(profID != -1){
						try {
							turma.setDiretor(profE);
							System.out.println("Diretor definido como \""+profE);
						} catch (IllegalArgumentException | NullPointerException e){
							System.out.println("Ocurreu um erro.");
							System.out.println(e.getMessage());
						}

					}

				}
				else if (valorIntroduzido == 7)/*criar aula*/{
					if(!criarAula(turma))
						System.out.println("Operação cancelada.");
				}
				else if (valorIntroduzido == 8)/*eliminar aula*/{
					eliminarTodosAula(turma);
				}
				else if (valorIntroduzido == 9)/*mostrar horario*/{
					mostrarHorario(turma);
				}
				else if (valorIntroduzido != 10)
					System.out.println("Introduza um numero entre 1 e 10.");

			}
		}
	}
	public static void eliminarTodosTurma(){
		String remover = "";

		while(!remover.equalsIgnoreCase("n") && !remover.equalsIgnoreCase("nao") &&
				!remover.equalsIgnoreCase("s") && !remover.equalsIgnoreCase("sim")) {
			System.out.println("Tem a certeza que quer eliminar todos os cursos ?");
			System.out.print("[s/n]: ");

			remover = Ler.processarTecladoString();
		}
		if(remover.toLowerCase().equals("n") || remover.toLowerCase().equals("nao"))
			return;
		else if(remover.equalsIgnoreCase("s") || remover.equalsIgnoreCase("sim")){
			System.out.println("A limpar todas as Turmas.");

			String turname;
			for(Turma _turma : Turma.getTurmas().values()){
				if(_turma.getID() != 0){
					try {
						turname = _turma.toString();
						Turma.Remove(_turma);
						System.out.println("Turma \""+turname+"\" removida com sucesso.");
					} catch (IllegalArgumentException | NullPointerException e){
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}

	public static void mostrarHorario(Turma turma){
		ArrayList<ArrayList<Entity>> horario = turma.getHorario();

		for(String dia : Aula.ConversorDiaDaSemana){
			System.out.print("|\t" + dia + "\t");
		}
		System.out.println("|");

		Aula aula;
		for(int hora = 0; hora < Aula.ConversorHoras.size(); hora++){
			for(int diaDaSemana = 0; diaDaSemana < Aula.ConversorDiaDaSemana.size(); diaDaSemana++) {
				aula = Aula.getAulaFromID( horario.get(diaDaSemana).get(hora) );

				System.out.print("|\t");
				if(aula.getID() == 0)
					System.out.print("(vazio)");
				else
					System.out.print(aula);
				System.out.println("\t");
			}
			System.out.println("|");
		}
	}
	public static boolean criarAula(Turma turma){
		//dia da semana
		int diaDaSemana = 0;
		while (diaDaSemana == 0){
			for(int i = 0; i < Aula.ConversorDiaDaSemana.size(); i++){
				System.out.println((i+1) +"- "+Aula.ConversorDiaDaSemana.get(i));
			}
			System.out.println("Digite o dia da semana da nova aula(-1 para cancelar): ");

			diaDaSemana = Ler.processarTecladoInt();
			diaDaSemana--;

			if(diaDaSemana == -1)
				return false;
			if(diaDaSemana < 0 || diaDaSemana > Aula.ConversorDiaDaSemana.size()){
				System.out.println("Insira um dia, -1 para sair.");
				diaDaSemana = 0;
			}
		}

		//dia da semana
		int hora = 0;
		while (hora == 0){
			for(int i = 0; i < Aula.ConversorHoras.size(); i++){
				System.out.println((i+1) +"- "+Aula.ConversorHoras.get(i));
			}
			System.out.println("Digite a hora da nova aula(-1 para cancelar): ");

			hora = Ler.processarTecladoInt();
			hora--;

			if(hora == -1)
				return false;
			if(hora < 0 || hora > Aula.ConversorHoras.size()){
				System.out.println("Insira um dia, -1 para sair.");
				hora = 0;
			}
		}

		//disciplina
		long disID = 0;
		Entity disE = Entity.Zero;
		while(disE.getID() == 0 && Curso.getCursoFromID(turma.getCurso()).getDisciplinas().size() != 0){
			System.out.println("Digite o ID da disciplina (0 para mostrar todas as Disciplinas possiveis, -1 para cancelar): ");
			disID = Ler.processarTecladoLong();
			disE = Disciplina.getDisciplinaFromID(disID);

			if(disID == 0)
				for(Entity dis : Curso.getCursoFromID(turma.getCurso()).getDisciplinas()){
					System.out.println(Disciplina.getDisciplinaFromID(dis));
				}
			if(disE.getID() == 0)
				System.out.println("Professor \""+disID+"\" não existe.");
			if(disID == -1) {
				return false;
			}
			if(!Curso.getCursoFromID(turma.getCurso()).getDisciplinas().contains(disE)){
				System.out.println("Disciplina "+ Disciplina.getDisciplinaFromID(disE) +" não pode ser dada no curso " + Curso.getCursoFromID(turma.getCurso()));
				disE = Entity.Zero;
			}

		}
		if(Curso.getCursoFromID(turma.getCurso()).getDisciplinas().size() == 0) {
			System.out.println("Ainda não foram adicionadas disciplinas ao curso " + Curso.getCursoFromID(turma.getCurso()) + ".");
			return false;
		}


		//Professor
		long profID = 0;
		Entity profE = Entity.Zero;
		while(profE.getID() == 0 && Disciplina.getDisciplinaFromID(disE).getProfessores().size() != 0){
			System.out.println("Digite o ID do professor(0 para mostrar todas as disciplinas, -1 para cancelar): ");
			profID = Ler.processarTecladoLong();
			profE = Professor.getProfessorFromID(profID);

			if(profID == 0)
				for(Entity dis : Disciplina.getDisciplinaFromID(disE).getProfessores()){
					System.out.println(Disciplina.getDisciplinaFromID(dis));
				}
			if(profE.getID() == 0)
				System.out.println("Professor \""+profID+"\" não existe.");
			if(profID == -1) {
				return false;
			}
			if(!Disciplina.getDisciplinaFromID(disE).getProfessores().contains(profE)){
				System.out.println("Professor "+Professor.getProfessorFromID(profE) +" não pode dar "+ Disciplina.getDisciplinaFromID(disE) +".");
				profE = Entity.Zero;
			}
		}
		if(Disciplina.getDisciplinaFromID(disE).getProfessores().size() == 0) {
			System.out.println("Ainda não foram adicionadas professores à disciplina " + Disciplina.getDisciplinaFromID(disE) + ".");
			return false;
		}if(profID == -1){
			return false;
		}

		String sala = "";

		while(sala.equalsIgnoreCase("")) {
			System.out.println("Salas possiveis:");
			for(String salas : Disciplina.getDisciplinaFromID(disE).getPossibleSalas()) {
				System.out.println(salas);
			}
			System.out.println("Digite uma sala para a aula(enter para cancelar): ");
			sala = Ler.processarTecladoString();

			if(sala.equalsIgnoreCase(""))
				return false;
			if(!Disciplina.getDisciplinaFromID(disE).getPossibleSalas().contains(sala) && !Disciplina.getDisciplinaFromID(disE).getPossibleSalas().contains("todas")){
				System.out.println("Não pode ser essa sala.");
				sala = "";
			}
		}

		try{
			turma.addAula(hora,diaDaSemana,profE,disE,sala);
			System.out.println("Aula c");
		} catch (IllegalArgumentException | NullPointerException e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	public static void eliminarTodosAula(Turma turma){

		String remover = "";

		while(!remover.equalsIgnoreCase("n") && !remover.equalsIgnoreCase("nao") &&
				!remover.equalsIgnoreCase("s") && !remover.equalsIgnoreCase("sim")) {
			System.out.println("Tem a certeza que quer eliminar todos os cursos ?");
			System.out.print("[s/n]: ");

			remover = Ler.processarTecladoString();
		}
		if(remover.toLowerCase().equals("n") || remover.toLowerCase().equals("nao"))
			return;
		else if(remover.equalsIgnoreCase("s") || remover.equalsIgnoreCase("sim")){
			System.out.println("A limpar todas as Turmas.");

			String aulname;
			for(Entity aula : turma.getAulas()){
				if(aula.getID() != 0){
					try {
						aulname = aula.toString();
						turma.removeAula(aula);
						System.out.println("Aula \""+aulname+"\" removida com sucesso.");
					} catch (IllegalArgumentException | NullPointerException e){
						System.out.println(e.getMessage());
					}
				}
			}
		}

	}
}
