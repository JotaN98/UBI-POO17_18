import myinput.Ler;

public class MenuCurso {
	public static void MainMenu(){
		int valorIntroduzido = 0;

		while(valorIntroduzido != Menus.MenuExitOp){
			Menus.printMenu("Curso","Cursos");
			valorIntroduzido = Ler.processarTecladoInt();

			if(valorIntroduzido == 0)/*mostrar todos os cursos*/{
				Menus.printTodosCursos();
			} else if(valorIntroduzido == 1)/*Criar curso*/{
				criarCurso();
			} else if(valorIntroduzido == 2)/*eliminar curso*/{
				if(Curso.size() == 0)
					System.out.println("Ainda não existe cursos.");
				else
					eliminarCurso();
			} else if(valorIntroduzido == 3)/*selecionar curso*/{
				selecionarCurso();
			} else if(valorIntroduzido == 4)/*eliminar todos os cursos*/{
				eliminarTodosCurso();
			} else if(valorIntroduzido != 5)/*nenhuma da opções*/
				System.out.println("Introduza um numero entre 1 e "+ (Menus.MainMenuExitOp-1) +".");
			// 5 = menuExitOp
		}
	}

	public static void criarCurso(){
		Curso nCurso = Curso.getCursoFromID(Curso.Create());

		System.out.println("A criar curso "+ (Entity)nCurso + ".");

		String nome = "";
		while(nome.equals("")){
			System.out.println("Digite o nome do curso: ");
			nome = Ler.processarTecladoString();
		}
		nCurso.setNome(nome);

		long profID = 0;
		Entity profE = Entity.Zero;
		while(profE.getID() == 0 && Professor.size() != 0){
			System.out.println("Digite o ID do diretor(0 para mostrar todos os professores, -1 para cancelar): ");
			profID = Ler.processarTecladoLong();
			profE = Professor.getProfessorFromID(profID);

			if(profID == 0)
				Menus.printTodosProfessores();
			if(profE.getID() == 0)
				System.out.println("Professor \""+profID+"\" não existe.");
			if(profID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}

		}
		if(Professor.size() == 0)
			System.out.println("Ainda não existem professores.");
		else {
			if (profID != -1) {
				System.out.println("Diretor definido como \"" + profE + "\".");
				nCurso.setDiretor(profE);
			}
		}

		System.out.println("Curso \""+nCurso+"\" criado com sucesso.");
	}
	public static void eliminarCurso(){
		long cursoID = 0;
		Entity cursoE = Entity.Zero;
		while(cursoE.getID() == 0 && Curso.size() != 0){
			System.out.println("Digite o ID do curso que quer eliminar(0 para mostrar todos os Cursos, -1 para cancelar): ");
			cursoID = Ler.processarTecladoLong();
			cursoE = Curso.getCursoFromID(cursoID);

			if(cursoID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}
			if(cursoID == 0) {
				Menus.printTodosCursos();
			}
			if(cursoE.getID() == 0) {
				System.out.println("Curso \""+cursoID+"\" não existe.");
			}

		}
		if(Curso.size() == 0)
			System.out.println("Ainda não existem cursos.");
		if(cursoID != -1){
			try {
				Curso.Remove(cursoE);
				System.out.println("Curso \""+cursoID+" removido com sucesso.");
			} catch (IllegalArgumentException | NullPointerException e){
				System.out.println("Erro ao remover o curso: ");
				System.out.println(e.getMessage());
			}
		}
	}
	public static void selecionarCurso(){
		long cursoID = 0;
		Curso curso = Curso.getCursoFromID(Entity.Zero);
		while(curso.getID() == 0 && Curso.size() != 0){
			System.out.println("Digite o ID do curso que quer eliminar(0 para mostrar todos os Cursos, -1 para cancelar): ");
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
		if(cursoID != -1){
			int valorIntroduzido = -1;

			while (valorIntroduzido != 8){
				System.out.println("Curso "+ curso);
				System.out.println("1- Mudar Nome");
				System.out.println("2- Mudar Diretor");
				System.out.println("3- Inserir Disciplina");
				System.out.println("4- Remover uma Disciplina");
				System.out.println("5- Criar Turma");
				System.out.println("6- Eliminar Turma");
				System.out.println("7- Mudar para " + (curso.getAtivo() ? "in" : "") + "activo");
				System.out.println("8- Voltar");

				valorIntroduzido = Ler.processarTecladoInt();

				if(valorIntroduzido == 1)/*Mudar nome*/{
					System.out.println("Nome atual: "+ curso.getNome());

					System.out.println("Digite o novo nome do curso:");

					String nome = Ler.processarTecladoString();

					if(nome.equals(""))
						System.out.println("Operação cancelada.");
					else {
						System.out.println("Nome do curos mudado.");
						curso.setNome(nome);
					}

				}
				else if(valorIntroduzido == 2)/*Mudar diretor*/{
					long profID = 0;
					Entity profE = Entity.Zero;
					while(profE.getID() == 0 && Professor.size() != 0){
						System.out.println("Digite o ID do diretor(0 para mostrar todos os professores, -1 para cancelar): ");
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
					else {
						if(profID != -1){
							try {
								curso.setDiretor(profE);
								System.out.println("Diretor definido como \""+profE);
							} catch (IllegalArgumentException | NullPointerException e){
								System.out.println("Ocurreu um erro.");
								System.out.println(e.getMessage());
							}

						}
					}
				}
				else if(valorIntroduzido == 3)/*Inserir disciplina*/{
					long discID = 0;
					Disciplina discE = Disciplina.getDisciplinaFromID(Entity.Zero);
					while(discE.getID() == 0 && Disciplina.size() != 0){
						System.out.println("Digite o ID da disciplina(0 para mostrar todas as disciplinas, -1 para cancelar): ");
						discID = Ler.processarTecladoLong();
						discE = Disciplina.getDisciplinaFromID(discID);

						if(discID == 0)
							Menus.printTodasDisciplinas();
						if(discID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}
						if(discE.getID() == 0) {
							System.out.println("Disciplina \""+discID+"\" não existe.");
						}

					}
					if(Disciplina.size() == 0)
						System.out.println("Ainda não existem Disciplinas.");
					else {
						if(discID != -1){
							try {
								curso.addDisciplina(discE);
								System.out.println("Disciplina \""+ discE +"\" adicionada.");
							} catch (IllegalArgumentException | NullPointerException e){
								System.out.println("Ocurreu um erro.");
								System.out.println(e.getMessage());
							}
						}
					}
				}
				else if(valorIntroduzido == 4)/*Remover disciplina*/{
					long discID = 0;
					Disciplina discE = Disciplina.getDisciplinaFromID(Entity.Zero);
					while(discE.getID() == 0 && curso.getDisciplinas().size() != 0){
						System.out.println("Digite o ID da disciplina a remover(0 para mostrar disciplinas já adicionadas, -1 para cancelar): ");
						discID = Ler.processarTecladoLong();
						discE = Disciplina.getDisciplinaFromID(discID);

						if(discID == 0)
							for(Entity dis : curso.getDisciplinas()){
								if(dis.getID() != 0){
									System.out.println(Disciplina.getDisciplinaFromID(dis));
								}
							}
						else if(discID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}
						else if(discE.getID() == 0 || !curso.getDisciplinas().contains(discE)) {
							System.out.println("Disciplina \""+discID+"\" não existe.");
							discID = 0;
						}

					}
					if(curso.getDisciplinas().size() == 0)
						System.out.println("Ainda não foram adicionadas Disciplinas.");
					else {
						if(discID != -1){
							try {
								String disnome = Disciplina.getDisciplinaFromID(discE).toString();
								curso.removeDisciplina(discE);
								System.out.println("Disciplina \""+ disnome +"\" removida.");
							} catch (IllegalArgumentException | NullPointerException e){
								System.out.println("Ocurreu um erro.");
								System.out.println(e.getMessage());
							}
						}
					}
				}
				else if(valorIntroduzido == 5)/*Criar Turma*/{
					if(!criarTurma(curso))
						System.out.println("Operação cancelada.");
				}
				else if(valorIntroduzido == 6)/*eliminar turma*/{
					long turmaID = 0;
					Turma turmaE = Turma.getTurmaFromID(Entity.Zero);
					while(turmaE.getID() == 0 && curso.getTurmas().size() != 0){
						System.out.println("Digite o ID da turma a remover(0 para mostrar turmas já adicionadas, -1 para cancelar): ");
						turmaID = Ler.processarTecladoLong();
						turmaE = Turma.getTurmaFromID(turmaID);

						if(turmaID == 0)
							for(Entity turma : curso.getTurmas()){
								if(turma.getID() != 0){
									System.out.println(Turma.getTurmaFromID(turma));
								}
							}
						else if(turmaID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}
						else if(turmaE.getID() == 0 || !curso.getTurmas().contains(turmaE)) {
							System.out.println("Turma \""+turmaID+"\" não existe.");
							turmaID = 0;
						}

					}
					if(curso.getTurmas().size() == 0)
						System.out.println("Ainda não foram criadas turmas.");
					else {
						if(turmaID != -1){
							try {
								String turmanome = Turma.getTurmaFromID(turmaE).toString();
								curso.removeTurma(turmaE);
								System.out.println("Turma \""+ turmanome +"\" removida.");
							} catch (IllegalArgumentException | NullPointerException e){
								System.out.println("Ocurreu um erro.");
								System.out.println(e.getMessage());
							}
						}
					}
				}
				else if(valorIntroduzido == 7)/*Mudar atividade*/{
					curso.setAtivo(!curso.getAtivo());
				}
				else if(valorIntroduzido != 8)
					System.out.println("Introduza um numero entre 1 e 7.");
			}
		}
	}
	public static void eliminarTodosCurso(){
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
			System.out.println("A limpar todos os cursos.");

			String curnome;
			for(Curso _curso : Curso.getCursos().values()){
				if(_curso.getID() != 0){
					try {
						curnome = _curso.toString();
						Curso.Remove(_curso);
						System.out.println("Curso \""+curnome+"\" removido com sucesso.");
					} catch (IllegalArgumentException | NullPointerException e){
						System.out.println(e.getMessage());
					}
				}
			}
		}



	}

	public static boolean criarTurma(Curso curso){
		//ano
		int ano = 0;
		while (ano == 0){
			System.out.println("Digite o ano da turma(-1 para cancelar): ");

			ano = Ler.processarTecladoInt();

			if(ano == -1)
				return false;
			if(ano < 10 || ano > 12){
				System.out.println("Insira um ano entre 10 e 12, -1 para sair.");
				ano = 0;
			}
		}

		//ano letivo
		String anoLetivo = "";
		while(anoLetivo.equalsIgnoreCase("")){
			System.out.println("Insira o ano letivo(enter para cancelar): ");

			anoLetivo = Ler.processarTecladoString();

			if(anoLetivo.equalsIgnoreCase("")){
				return false;
			}
		}

		//nome
		String nome = "";
		while (nome.equalsIgnoreCase("")){
			System.out.println("Digite o nome da nova turma(enter para cancelar): ");
			nome = Ler.processarTecladoString();

			if(nome.equalsIgnoreCase("")){
				return false;
			}
		}

		//diretor
		long profID = 0;
		Entity profE = Entity.Zero;
		while(profE.getID() == 0 && Professor.size() != 0){
			System.out.println("Digite o ID do diretor(0 para mostrar todos os professores, -1 para cancelar): ");
			profID = Ler.processarTecladoLong();
			profE = Professor.getProfessorFromID(profID);

			if(profID == 0)
				Menus.printTodosProfessores();
			if(profE.getID() == 0)
				System.out.println("Professor \""+profID+"\" não existe.");
			if(profID == -1) {
				return false;
			}

		}
		if(Professor.size() == 0)
			System.out.println("Ainda não existem professores.");
		if(profID != -1){
			try {
				System.out.println("Turma "+Turma.getTurmaFromID(curso.addTurma(anoLetivo,nome,ano,profE))+" criada com sucesso");
			} catch (IllegalArgumentException | NullPointerException e){
				System.out.println("Ocurreu um erro.");
				System.out.println(e.getMessage());
				return false;
			}

			return true;

		}
		return false;
	}
}
