import myinput.Ler;

import java.io.IOException;

public class Projeto {
	public static int exitop = 5;

	//Mostrar Menu principal	
	public static void printMenu(String singular, String plural){
		System.out.println(plural +":");
		System.out.println("0- Mostrar "+ plural);
		System.out.println("1- Criar "+ singular);
		System.out.println("2- Eliminar "+ singular);
		System.out.println("3- Selecionar "+ singular);
		System.out.println("4- Limpar todos os "+ plural);
		System.out.println("5- Voltar");
	}

	
	//Mostrar todos os cursos
	public static void printTodosCursos(){
		System.out.println("---");
		System.out.println("Todos os cursos");
		System.out.println("---");
		for(Curso curso : Curso.getCursos().values()){
			if(curso.getID() != 0){
				System.out.println(curso);
			}
		}
		System.out.println("---");
		try {
			System.in.read();
		} catch (IOException e){}
	}
	
	
	
	//Mostrar todas as turmas
	public static void printTodasTurmas(){
		System.out.println("---");
		System.out.println("Todas as Turmas");
		System.out.println("---");
		for(Turma turma : Turma.getTurmas().values()){
			if(turma.getID() != 0){
				System.out.println(turma);
			}
		}
		System.out.println("---");
		try {
			System.in.read();
		} catch (IOException e){}
	}
	
	
	
	//Mostrar todas as Disciplinas
	public static void printTodasDisciplinas(){
		System.out.println("---");
		System.out.println("Todas as Disciplinas");
		System.out.println("---");
		//Fazer isto
		for(Disciplina disciplina : Disciplina.getDisciplinas().values()){
			if(disciplina.getID() != 0){
				System.out.println(disciplina);
			}
		}
		System.out.println("---");
		try {
			System.in.read();
		} catch (IOException e){}
	}
	
	
	
	//Mostrar Menu Disciplinas->Selecionar
	public static void printMenuSelecionar(){
		System.out.println("1- Mudar Nome");
		System.out.println("2- Mudar Ano");
		System.out.println("3- Mudar Aula");
		System.out.println("4- Inserir Professor");
		System.out.println("5- Inserir possível sala");
		System.out.println("6- Voltar");
	}
	
	
	
	//Mostrar todos os professores
	public static void printTodosProfessores(){
		System.out.println("---");
		System.out.println("Todos os Professores");
		System.out.println("---");
		for(Professor prof : Professor.getProfessores().values()){
			if(prof.getID() != 0){
				System.out.println(prof);
			}
		}
		System.out.println("---");
		try {
			System.in.read();
		} catch (IOException e){}
	}


	
	//Função Main
    public static void main(String[] args) {
		int valorIntroduzido=0;

		while(valorIntroduzido != 6) {
			valorIntroduzido = 0;

			System.out.println("1- Cursos");
			System.out.println("2- Turmas");
			System.out.println("3- Disciplinas");
			System.out.println("4- Professores");
			System.out.println("5- Alunos");
			System.out.println("6- Guardar e Sair");

			try {
				valorIntroduzido = Ler.processarTecladoInt();
			} catch (IOException e) {
				System.out.println("Por favor introduza um valor entre 1 e 6.");
			}


			switch (valorIntroduzido) {
				case 1:
					valorIntroduzido = -1;
					while (valorIntroduzido != exitop) {
						// Mostrar o menu
						printMenu("Curso", "Cursos");

						// ler a opÃ§Ã£o do utilizador
						try {
							valorIntroduzido = Ler.processarTecladoInt();
						} catch (IOException e) {
							System.out.println("Por favor introduza um valor entre 1 e "+exitop+".");
						}

						// proximos menus
						Entity nCurso;
						Curso curso;
						long cursoID;
						long profID;
						Entity profEnity;
						switch (valorIntroduzido){
							case 0:
								// Mostrar tudo
								printTodosCursos();
								break;
							case 1:
								// criar Curso
								nCurso = Curso.Create();
								curso = Curso.getCursoFromID(nCurso);

								// set nome
								String nome = "";
								while (nome == "") {
									System.out.println("Insira o nome do Curso: ");
									try {
										nome = Ler.processarTecladoString();
									} catch (IOException e) {
										System.out.println("Ocurreu um erro, insira novamente.");
									}
									if(nome == "")
										System.out.println("Insira um nome correto.");
								}
								curso.setNome(nome);
								System.out.println("Nome alterado.");

								// set diretor
								profID = 0;
								profEnity = Entity.Zero;
								while(profEnity.getID() == 0 && Professor.getProfessores().size() != 0){
									System.out.println("Insira o ID do Professor (0 para mostrar todos, -1 para cancelar): ");
									try {
										profID = Ler.processarTecladoLong();

										if(profID == 0){
											printTodosProfessores();
										} else if(profID != -1){
											profEnity = Professor.getProfessorFromID(profID);
										}
									} catch (IOException e) {
										System.out.println("Ocurreu um erro, insira novamente.");
									}


									if(profEnity.getID() == 0 && profID != 0 && profID != -1) {
										System.out.println("Professor nÃ£o encontrado.");

									}else if(profEnity.getID() != 0) {
										System.out.println("Diretor definido.");
										curso.setDiretor(profEnity);

									}else if(profID == -1){
										System.out.println("Diretor nÃ£o definido.");

									}
								}
								if(Professor.getProfessores().size() == 0)
									System.out.println("NÃ£o existem professores.");


								System.out.println("Curso \""+nome+"\" criado com sucesso.");
								break;
								
								
							case 2://Eliminar um Curso
								System.out.println("Insira o ID do curso para eliminar (0 para mostrar todos, -1 para cancelar): ");

								cursoID = 0;
								nCurso = Entity.Zero;
								while(nCurso.getID() == 0 && Curso.getCursos().size() != 0) {
									try {
										cursoID = Ler.processarTecladoLong();

										if(cursoID == 0){
											printTodosCursos();
										} else if (cursoID != -1){
											curso = Curso.getCursoFromID(cursoID);
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
									}
								}

								break;
								
								
							case 3:

								break;
								
								
							case 4:

								break;
								
								
							case 5:

								break;
								
								
							default:
								System.out.println("Por favor introduza um valor entre 1 e 6.");

						}
					}
					valorIntroduzido = 1;
					break;
//-----------------------------------------------------------------------------------------------------------------------------------------------------
				case 2://Opçao Turmas
					
					valorIntroduzido = -1;
					while (valorIntroduzido != exitop) {
						// Mostrar o menu
						printMenu("Turma", "Turmas");

						// ler a opçãoo do utilizador
						try {
							valorIntroduzido = Ler.processarTecladoInt();
						} catch (IOException e) {
							System.out.println("Por favor introduza um valor entre 1 e " + exitop + ".");
						}

					
						//Variaveis que serão utilizadas no Menu abaixo
						Turma turma;
						
						Entity nTurma;
						long turmaID;
						
						
						switch (valorIntroduzido){
							case 0:// Mostrar tudo
								printTodasTurmas();
								break;
								
							case 1://criar Turma
								
								nTurma = Turma.Create();
								turma = Turma.getTurmaFromID(nTurma);

								
								
								
							case 2://Eliminar Turma
								

								break;
								
							case 3://Selecionar Turma
								
								//Perguntar qual a Turma que o utilizador pretende alterar
								
								
								//Submenu das opçoes que o utilizador tem
								 switch(valorIntroduzido){
								 
								 		case 1://----------------------------------------------xxxxxxxx------------------------------------------------------

								 		break;
									 
								 		
								 		case 2://----------------------------------------------xxxxxxxxxx------------------------------------------------------
								 		
								 		break;
								 		
								 		
								 		case 3://----------------------------------------------xxxxxxxxxxxx------------------------------------------------------
								 			
								 		break;
									 
								 		
								 		case 4://----------------------------------------------xxxxxxxxxxxx------------------------------------------------------
									 
								 		break;
									 
								 		
								 		case 5://----------------------------------------------xxxxxxxxxxxxx---------------------------------------------------
									 
								 		break;
								 		
								 		case 6://----------------------------------------------Voltar------------------------------------------------------
								 			printMenu("Turma", "Turmas");
								 		break;
								 
								 		default:
								 			System.out.println("Por favor introduza um valor entre 1 e 6.");
								 }

							break;
							
							case 4://Limpar Todas as Turmas

							break;
						
							case 5://Voltar
								
							break;
						
							default:
								System.out.println("Por favor introduza um valor entre 1 e 6.");

						}
					}
					valorIntroduzido = 1;
					break;

					
					
					
					
//-----------------------------------------------------------------------------------------------------------------------------------------------------
				case 3://Opçao Disciplinas
					valorIntroduzido = -1;
					while (valorIntroduzido != exitop) {
						// Mostrar o menu
						printMenu("Discipina", "Disciplinas");

						// ler a opçãoo do utilizador
						try {
							valorIntroduzido = Ler.processarTecladoInt();
						} catch (IOException e) {
							System.out.println("Por favor introduza um valor entre 1 e " + exitop + ".");
						}

					
						//Variaveis que serão utilizadas no Menu abaixo
						Disciplina disciplina;
						
						Entity nDisciplina;
						long disciplinaID;
						
						long profID;
						Entity profEntity;
						
						String nome;
						int ano = 0;
						
						Entity nAula;
						long aulaID;
						
						
						switch (valorIntroduzido){
							case 0:// Mostrar tudo
								printTodasDisciplinas();
								break;
								
							case 1:// criar Disciplina
								
								nDisciplina = Disciplina.Create();
								disciplina = Disciplina.getDisciplinaFromID(nDisciplina);

								//set nome da Disciplina
								nome = "";
								while (nome == "") {
									System.out.println("Insira o nome da Disciplina: ");
									try {
										nome = Ler.processarTecladoString();
									} catch (IOException e) {
										System.out.println("Ocurreu um erro, insira novamente.");
									}
									if(nome == "")
										System.out.println("Insira um nome correto.");
								}
								disciplina.setNome(nome);
								System.out.println("Nome alterado.");

								// set ano da Disciplina
								ano = 0;
								while(ano == 0){
									System.out.println("Insira o ano da Disciplina");
									try{
										ano = Ler.processarTecladoInt();
									} catch(IOException e){
										System.out.println("Ocorreu um erro, insira novamente.");
									}
									if(ano == 0)
										System.out.println("Insira um ano correto.");
								}
								disciplina.setAno(ano);
								System.out.println("Ano alterado");
							break;
								
							case 2://Eliminar Disciplina
								System.out.println("Insira o ID da Disciplina para eliminar (0 para mostrar todos, -1 para cancelar): ");

								disciplinaID = 0;
								nDisciplina = Entity.Zero;
								
								while(nDisciplina.getID() == 0 && Disciplina.getDisciplinas().size() != 0) {
									try {
										disciplinaID = Ler.processarTecladoLong();

										if(disciplinaID == 0){
											printTodasDisciplinas();
										} else if (disciplinaID != -1){
											disciplina = Disciplina.getDisciplinaFromID(disciplinaID);
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
									}
								}


								break;
								
							case 3://Selecionar Disciplina
								
								//Perguntar qual a disciplina que ele quer alterar
								System.out.println("Insira o ID da Disciplina que predente selecionar (0 para mostrar todos, -1 para cancelar): ");

								disciplinaID = 0;
								nDisciplina = Entity.Zero;
								
								while(nDisciplina.getID() == 0 && Disciplina.getDisciplinas().size() != 0) {
									try {
										disciplinaID = Ler.processarTecladoLong();

										if(disciplinaID == 0){
											printTodasDisciplinas();
										} else if (disciplinaID != -1){
											disciplina = Disciplina.getDisciplinaFromID(disciplinaID);
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
									}
								}

								System.out.println("Voce selecionou a disciplina " + disciplina.getNome());
								
								//Print do enu selecionar
								printMenuSelecionar();
								
								//Ler Valor para opçao do menu
								try {
									valorIntroduzido = Ler.processarTecladoInt();
								} catch (IOException e) {
									System.out.println("Por favor introduza um valor entre 1 e 6.");
								}
								
								
								 switch(valorIntroduzido){
								 
								 		case 1://----------------------------------------------Mudar Nome------------------------------------------------------
								 			nome = "";
											while (nome == "") {
												System.out.println("Insira o nome da Disciplina: ");
												try {
													nome = Ler.processarTecladoString();
												} catch (IOException e) {
													System.out.println("Ocurreu um erro, insira novamente.");
												}
												if(nome == "")
													System.out.println("Insira um nome correto.");
											}
											disciplina.setNome(nome);
											System.out.println("Nome alterado.");
								 		break;
									 
								 		
								 		case 2://----------------------------------------------Mudar ano------------------------------------------------------
								 			ano = 0;
											while(ano == 0){
												System.out.println("Insira o ano da Disciplina");
												try{
													ano = Ler.processarTecladoInt();
												} catch(IOException e){
													System.out.println("Ocorreu um erro, insira novamente.");
												}
												if(ano == 0)
													System.out.println("Insira um ano correto.");
											}
								 			
								 			disciplina.setAno(ano);
								 			System.out.println("Ano alterado");
								 		break;
								 		
								 		
								 		case 3://----------------------------------------------Inserir Aula------------------------------------------------------
								 			aulaID = 0;
								 			nAula = Entity.Zero;
								 			
								 			
								 		break;
									 
								 		
								 		case 4://----------------------------------------------Inserir Professor------------------------------------------------------
									 
								 		break;
									 
								 		
								 		case 5://----------------------------------------------Inserir Possivel sala---------------------------------------------------
									 
								 		break;
								 		
								 		case 6://----------------------------------------------Voltar------------------------------------------------------
								 			printMenu("Disciplina", "Disciplinas");
								 		break;
								 
								 		default:
								 			System.out.println("Por favor introduza um valor entre 1 e 6.");
								 }

							break;
							
							case 4://Limpar Todas as Disciplinas

							break;
						
							case 5://Voltar
								
							break;
						
							default:
								System.out.println("Por favor introduza um valor entre 1 e 6.");

						}
					}
					valorIntroduzido = 1;
					break;

					
					
					
//-----------------------------------------------------------------------------------------------------------------------------------------------------
				case 4://opçao professores
					
					valorIntroduzido = -1;
					while (valorIntroduzido != exitop) {
						// Mostrar o menu
						printMenu("Professor", "Professores");

						// ler a opçãoo do utilizador
						try {
							valorIntroduzido = Ler.processarTecladoInt();
						} catch (IOException e) {
							System.out.println("Por favor introduza um valor entre 1 e " + exitop + ".");
						}

					
						//Variaveis que serão utilizadas no Menu abaixo
						Professor professor;
						
						Entity nProfessores;
						long ProfessorID;
						
						
						switch (valorIntroduzido){
							case 0:// Mostrar tudo
								printTodosProfessores();
								break;
								
							case 1://criar Professor
								
								nProfessores = Professor.Create();
								professor = Professor.getProfessorFromID(nProfessores);

								
								
								
							case 2://Eliminar Professor
								

								break;
								
							case 3://Selecionar Professor
								
								//Perguntar qual o Prodfessor que o utilizador pretende alterar
								
								
								//Submenu das opçoes que o utilizador tem
								 switch(valorIntroduzido){
								 
								 		case 1://----------------------------------------------xxxxxxxx------------------------------------------------------

								 		break;
									 
								 		
								 		case 2://----------------------------------------------xxxxxxxxxx------------------------------------------------------
								 		
								 		break;
								 		
								 		
								 		case 3://----------------------------------------------xxxxxxxxxxxx------------------------------------------------------
								 			
								 		break;
									 
								 		
								 		case 4://----------------------------------------------xxxxxxxxxxxx------------------------------------------------------
									 
								 		break;
									 
								 		
								 		case 5://----------------------------------------------xxxxxxxxxxxxx---------------------------------------------------
									 
								 		break;
								 		
								 		case 6://----------------------------------------------Voltar------------------------------------------------------
								 			printMenu("Professor", "Professores");
								 		break;
								 
								 		default:
								 			System.out.println("Por favor introduza um valor entre 1 e 6.");
								 }

							break;
							
							case 4://Limpar Todas os Professores

							break;
						
							case 5://Voltar
								
							break;
						
							default:
								System.out.println("Por favor introduza um valor entre 1 e 6.");

						}
					}
					valorIntroduzido = 1;
					break;
//-----------------------------------------------------------------------------------------------------------------------------------------------------
				case 5:
					printMenu("Aluno","Alunos");

					valorIntroduzido = 5;
					break;
//-----------------------------------------------------------------------------------------------------------------------------------------------------
				case 6:
					break;

//-----------------------------------------------------------------------------------------------------------------------------------------------------
				default:
					System.out.println("Por favor introduza um valor entre 1 e 6.");
			}
		}

		System.out.println("Goodbye");

	}
    
}
