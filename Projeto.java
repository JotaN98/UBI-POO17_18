import myinput.Ler;

import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Projeto {
	public static int exitop = 5;

	public static void printMenu(String singular, String plural){
		System.out.println(plural +":");
		System.out.println("0- Mostrar "+ plural);
		System.out.println("1- Criar "+ singular);
		System.out.println("2- Eliminar "+ singular);
		System.out.println("3- Selecionar "+ singular);
		System.out.println("4- Limpar todos os "+ plural);
		System.out.println("5- Voltar");
	}

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
	public static void printSelecionarDisciplina(){
		System.out.println("1- Mudar Nome");
		System.out.println("2- Mudar Ano");
		System.out.println("3- Mudar Aula");
		System.out.println("4- Inserir Professor");
		System.out.println("5- Inserir poss�vel sala");
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
        public static void PrintTodosAlunos(){
          System.out.println("---");
		System.out.println("Todos os Alunos");
		System.out.println("---");
		for(Aluno alu : Aluno.getAlunos().values()){
			if(alu.getID() != 0){
				System.out.println(alu);
			}
		}
		System.out.println("---");
		try {
			System.in.read();
		} catch (IOException e){}
	}  
        
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

						// ler a opção do utilizador
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
										System.out.println("Professor não encontrado.");

									}else if(profEnity.getID() != 0) {
										System.out.println("Diretor definido.");
										curso.setDiretor(profEnity);

									}else if(profID == -1){
										System.out.println("Diretor não definido.");

									}
								}
								if(Professor.getProfessores().size() == 0)
									System.out.println("Não existem professores.");


								System.out.println("Curso \""+nome+"\" criado com sucesso.");
								break;
							case 2:
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
				
				case 2://Opção Turmas
					
					valorIntroduzido = -1;
					while (valorIntroduzido != exitop) {
						// Mostrar o menu
						printMenu("Turma", "Turmas");
                                                
                                                try{
                                                    valorIntroduzido = Ler.processarTecladoInt();
                                                }catch(IOException e){
                                                    System.out.println("Por favor introduza um valor entre 1 e " + exitop + ".");
                                                }
                                                
                                                
                                                
                                                Turma turma;
                                                Entity nTurma;
                                                long turmaID;
                                                String nome;
                                                int ano=0;
                                                String anoLetivo;
                                                
                                                
                                                
                                                switch(valorIntroduzido){
                                                    case 0:
                                                        printTodasTurmas();
                                                        break;
                                                    //criar turma
                                                    case 1:
                                                        nTurma = Turma.Create();
                                                        turma=Turma.getTurmaFromID(nTurma);
                                                        
                                                        //set nome turma
                                                        nome="";
                                                        while(nome==""){
                                                            System.out.println("Insira o nome da turma:");
                                                            try{
                                                                nome=Ler.processarTecladoString();
                                                            }
                                                            catch(IOException e){
                                                                System.out.println("Ocorreu um erro, insira novamente.");
                                                            }if(nome=="")
                                                                System.out.println("Insira um nome correto.");
                                                        }
                                                        turma.setNome(nome);
                                                        System.out.println("Nome alterado");
                                                        
                                                        //set ano da turma
                                                        ano=0;
                                                        while(ano==0){
                                                            System.out.println("Insira o ano da turma");
                                                            try{
                                                                ano=Ler.processarTecladoInt();
                                                            }catch(IOException e){
                                                                System.out.println("Ocorreu um erro, insira novamente.");
                                                            }
                                                            if(ano==0)
                                                                System.out.println("Insira um ano correto");
                                                        }
                                                        turma.setAno(ano);
                                                        System.out.println("Ano alterado");
                                                        
                                                        //set Ano letivo da turma
                                                        anoLetivo="";
                                                        while(anoLetivo==""){
                                                            System.out.println("Insira o ano letivo: ");
									try {
										anoLetivo = Ler.processarTecladoString();
									} catch (IOException e) {
										System.out.println("Ocurreu um erro, insira novamente.");
									}
									if(anoLetivo == "")
										System.out.println("Insira um nome correto.");
								}
								turma.setAnoLetivo(anoLetivo);
								System.out.println("Ano letivo alterado.");
                                                        break;
                                                    //eliminar turma    
                                                    case 2:
                                                        System.out.println("Insira o ID da Disciplina para eliminar (0 para mostrar todos, -1 para cancelar): ");
                                                        turmaID=0;
                                                        nTurma=Entity.Zero;
                                                        while(nTurma.getID()==0 && Turma.getTurmas().size() !=0){
                                                            try{
                                                                turmaID = Ler.processarTecladoLong();
                                                                
                                                                if(turmaID == 0){
                                                                    printTodasTurmas();
                                                                }else if(turmaID != -1){
                                                                    turma = Turma.getTurmaFromID(turmaID);
                                                                }
                                                                }catch(IOException e){
                                                                        System.out.println("Ocorreu um erro, tentar novamente");
                                                                }
                                                            }
                                                        Turma.Remove(nTurma);
                                                        break;
                                                        }
                                                
                                                
                                                        }
                                                }
                                                
                                                
                                                
                                                
					valorIntroduzido = 2;
					break;
				case 3:
					printMenu("Disciplina","Disciplinas");

					
					
					
					
//-----------------------------------------------------------------------------------------------------------------------------------------------------
				case 3://Opçao Disciplinas
					valorIntroduzido = -1;
					while (valorIntroduzido != exitop) {
						// Mostrar o menu
						printMenu("Disciplina", "Disciplinas");

						// ler a opção do utilizador
						try {
							valorIntroduzido = Ler.processarTecladoInt();
						} catch (IOException e) {
							System.out.println("Por favor introduza um valor entre 1 e " + exitop + ".");
						}

					
						//Variaveis que serão utilizadas no Menu abaixo
						
						Disciplina disciplina;
						Entity nDisciplina;
						long disciplinaID;
						
						Professor professor;
						long profID;
						Entity nProf;
						
						String nome;
						int ano = 0;
						
						Aula aula;
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
											printTodosCursos();
										} else if (disciplinaID != -1){
											disciplina = Disciplina.getDisciplinaFromID(disciplinaID);
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
									}
								}
								
								Disciplina.Remove(disciplina);
								break;
								
							case 3://Selecionar Disciplina
								
								//Perguntar qual a disciplina que ele quer alterar
								System.out.println("Insira o ID da Disciplina que predente selecionar (0 para mostrar todos, -1 para cancelar): ");

								disciplinaID = 0;
								nDisciplina = Entity.Zero;
								
								
								//Procurar a Disciplina pretendida
								while(nDisciplina.getID() == 0 && Disciplina.getDisciplinas().size() != 0) {
									try {
										disciplinaID = Ler.processarTecladoLong();

										if(disciplinaID == 0){
											printTodasDisciplinas();
										} else if (disciplinaID != -1){
											disciplina = Disciplina.getDisciplinaFromID(disciplinaID);
											System.out.println("Voce selecionou a disciplina " + disciplina.getNome() + ".");
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
									}
								}

								
							
								
								valorIntroduzido = -1;
								while(valorIntroduzido != exitop){
									//Print Menu Disciplina->Selecionar
									printSelecionarDisciplina();
									
									//Ler Valor para op�ao do menu
									try {
										valorIntroduzido = Ler.processarTecladoInt();
									} catch (IOException e) {
										System.out.println("Por favor introduza um valor entre 0 e" + exitop + ".");
									}
									
									switch(valorIntroduzido){
								 
								 		case 0://----------------------------------------------Mudar Nome------------------------------------------------------
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
									 
								 		
								 		case 1://----------------------------------------------Mudar ano------------------------------------------------------
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
								 		
								 		
								 		case 2://----------------------------------------------Inserir Aula------------------------------------------------------
								 			/*Falta aqui esta*/
								 			nAula = Entity.Zero;
								 			aulaID=0;
                                             //Create(hora, DiaDaSemana, prof, nDisciplina, turma, sala);
								 			nAula = Aula.Create();
								 			aula = Aula.getAulaFromID(nAula);
								 			
								 			
								 			
								 			disciplina.addAula(nAula);
								 			
								 			
								 		break;
									 
								 		
								 		case 3://----------------------------------------------Inserir Professor------------------------------------------------------
								 			//criar professor
                                            nProf = Professor.Create();
                                            professor = Professor.getProfessorFromID(nProf);
                                            
                                            // set primeiro e ultimo nome
                                            String pNome="", uNome = "" ;
                                            
                                            while(pNome=="" || uNome=="" ){
                                                System.out.println("Insira o primeiro e o ultimo nome do professor.");
                                                try {
                                                    pNome = Ler.processarTecladoString();
                                                    uNome = Ler.processarTecladoString();
                                                } catch (IOException e) {
                                                    System.out.println("Ocurreu um erro, insira novamente.");
                                                }
                                                if(pNome==""  || uNome=="" )
                                                    System.out.println("Insira um nome correto.");
                                            }
                                            
                                            professor.setPrimeiroNome(pNome);
                                            professor.setUltimoNome(uNome);
                                            
                                            System.out.println("Nome alterado.");
                                            
                                            //set nascimento
                                            ZoneId zoneid = ZoneId.systemDefault();
                                            ZonedDateTime nascimento = ZonedDateTime.now();
                                            
                                            //Enquanto o ano do nascimento for diferente do ano atual
                                            while(nascimento.getYear() == ZonedDateTime.now().getYear()){
                                                System.out.println("Insira a data de nascimento no seguinte formato ano->mes->dia.");
                                                
                                                try{
                                                    nascimento = ZonedDateTime.of(Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), 0, 0, 0, 0, zoneid);
                                                } catch (IOException e){
                                                    System.out.println("Introduza uma data correta.");
                                                }
                                            }
                                            
                                            professor.setNascimento(nascimento);
                                            System.out.println("Data de nascimento alterada.");
                                            
                                            disciplina.addProfessor(professor);
                                            System.out.println("Professor adicionado com sucesso.");
								 			
								 		break;
				
								 		case 4://----------------------------------------------Inserir Possivel sala---------------------------------------------------
								 			String nomeSala;
								 			
								 			while(nomeSala == ""){
                                                System.out.println("Insira a Sala desejada:");
                                                try {
                                                	nomeSala = Ler.processarTecladoString();
                                                } catch (IOException e) {
                                                    System.out.println("Ocurreu um erro, insira novamente.");
                                                }
                                                if(nomeSala == "")
                                                    System.out.println("Insira uma Sala correta:");
                                            }
								 			
								 			disciplina.addPossibleSala(nomeSala);
								 			System.out.println("Sala " + nomeSala + "adicionada com sucesso!");
								 		
								 		break;
								 		
								 		case 5://----------------------------------------------Voltar------------------------------------------------------
								 			printMenu("Disciplina", "Disciplinas");
								 		break;
								 
								 		default:
								 			System.out.println("Por favor introduza um valor entre 1 e 6.");
										}

									break;
								}
							case 4://Limpar Todas as Disciplinas
								/*Falta aqui esta*/
							break;
						
							case 5://Voltar
								
							break;
						
							default:
								System.out.println("Por favor introduza um valor entre 1 e 6.");

						}
					}
					valorIntroduzido = 1;
					break;
				case 4:
					printMenu("Professor","Professores");
                                        
                                        //ler a opção do utilizador
                                        try{
                                            valorIntroduzido = Ler.processarTecladoInt();
                                        } catch (IOException e){
                                            System.out.println("Por favor introduza um valor entre 1 e "+exitop+".");
                                        }
                                        
                                        //proximos menus
                                        Entity nProfessor;
                                        Professor professor;
                                        long profID;
                                        
                                        switch(valorIntroduzido){
                                            case 0:
                                                //Mostrar tudo
                                                printTodosProfessores();
                                                break;
                                            case 1:
                                                //criar professor
                                                nProfessor=Professor.Create();
                                                professor = Professor.getProfessorFromID(nProfessor);
                                                
                                                // set primeiro e último nome
						String pNome="", uNome = "" ;
						while(pNome=="" || uNome=="" ){
                                                    System.out.println("Insira o primeiro e o ultimo nome do professor.");
                                                    try {
                                                        pNome = Ler.processarTecladoString();
                                                        uNome = Ler.processarTecladoString();
                                                    } catch (IOException e) {
                                                        System.out.println("Ocurreu um erro, insira novamente.");
                                                    }
                                                    if(pNome==""  || uNome=="" )
                                                        System.out.println("Insira um nome correto.");
                                                }
                                                professor.setPrimeiroNome(pNome);
                                                professor.setUltimoNome(uNome);
                                                System.out.println("Nome alterado.");
                                                
                                                //set nascimento
                                                ZoneId zoneid = ZoneId.systemDefault();
                                                ZonedDateTime nascimento = ZonedDateTime.now();
                                                //Enquanto o ano do nascimento for diferente do ano atual
                                                while(nascimento.getYear() == ZonedDateTime.now().getYear()){
                                                    System.out.println("Insira a data de nascimento no seguinte formato ano->mês->dia.");
                                                    try{
                                                        nascimento = ZonedDateTime.of(Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), 0, 0, 0, 0, zoneid);
                                                    } catch (IOException e){
                                                        System.out.println("Introduza uma data correta.");
                                                    }
                                                }
                                                professor.setNascimento(nascimento);
                                                System.out.println("Data de nascimento alterada.");
                                                System.out.println("Professor: " +pNome+" "+uNome+" criado com sucesso.");
                                                break;
                                            
                                                
                                            case 2://Eliminar um Professor
                                                    System.out.println("Insira o ID do Professor para eliminar (0 para mostrar todos, -1 para cancelar): ");
                                                    
                                                    profID=0;
                                                    nProfessor=Entity.Zero;
                                                    while(nProfessor.getID() == 0 && Professor.getProfessores().size() != 0){
                                                        try{
                                                            profID = Ler.processarTecladoLong();
                                                            
                                                            if(profID == 0){
                                                                printTodosProfessores();
                                                            }
                                                            else if (profID != -1){
                                                                professor = Professor.getProfessorFromID(profID);
                                                                Professor.Remove(professor);
                                                            }
                                                        } catch (IOException e){
                                                            System.out.println("Ocorreu um erro, insira novamente.");
                                                        }    
                                                    }
                                                    break;
                                                    
                                            case 3://Selecionar Professor
                                                System.out.println("Insira o ID do Professor (0 para mostrar todos, -1 para cancelar): ");
                                                    
                                                profID=0;
                                                nProfessor=Entity.Zero;
                                                while(nProfessor.getID()==0 && Professor.getProfessores().size()!=0){
                                                     try{
                                                         profID = Ler.processarTecladoLong();
                                                    
                                                         if(profID == 0){
                                                            printTodosProfessores();
                                                        }
                                                        else if(profID!=-1){
                                                           professor = Professor.getProfessorFromID(profID);
                                                           
                                                           System.out.println("Selecionou o professor "+professor.getNome()+".");
                                                        }
                                                    } catch (IOException e){
                                                         System.out.println("Ocorreu um erro, insira novamente.");
                                                    } 
                                                   
                                                   valorIntroduzido=-1;
                                                   while(valorIntroduzido != exitop){
                                                        //Print do Menu Selecionar
                                                        printSelecionarProfessor();   
                                                        //ler valor do utilizador
                                                        try{
                                                            valorIntroduzido = Ler.processarTecladoInt();
                                                        } catch(IOException e){
                                                            System.out.println("Por favor introduza um valor entre 1 e"+exitop+".");
                                                        }
                                                        //proximos menus
                                                        Entity aulaEntity;
                                                        Aula aula;
                                                        long aulaID;
                                                        Entity nTeste;
                                                        Teste teste;
                                                        long testeID;
                                                        
                                                        switch(valorIntroduzido){
                                                            case 1://adicionar aula
                                                                aulaID=0;
                                                                aulaEntity = Entity.Zero;
                                                                while(aulaEntity.getID()==0){
                                                                    System.out.println("Insira o ID da aula (0 para mostrar todos, -1 para cancelar): ");
                                                                    try{
                                                                        aulaID = Ler.processarTecladoLong();
                                                                        
                                                                        if(aulaID == 0){
                                                                            PrintTodasAulas();
                                                                        } else if(aulaID != -1){
                                                                            aulaEntity = Aula.getAulaFromID(aulaID);
                                                                            Professor.getProfessorFromID(profID).addAula(aulaEntity);
                                                                        }
                                                                    } catch(IOException e){
                                                                        System.out.println("Ocorreu um erro, insira novamente.");
                                                                    }
                                                                }
                                                                break;
                                                            case 2://mostrar horario
                                                                String wtf; //FALTA FAZER HORARIOOO
                                                                ArrayList<ArrayList<Entity>> horario = Professor.getProfessorFromID(profID).getHorario();
                                                                for(int i=0;i<5;i++){
                                                                    System.out.println("\n"+horario.get(i).toString());
                                                                    for(int j=0;j<5;j++){
                                                                        System.out.print(horario.get(i).get(j));
                                                                    }
                                                                }
                                                                break;
                                                            case 3://Criar teste
                                                                nTeste = Teste.Create();
                                                                teste = Teste.getTesteFromID(nTeste);
                                                                
                                                                //set aula
                                                                aulaID=0;
                                                                aulaEntity = Entity.Zero;
                                                                while(aulaEntity.getID()==0 && Aula.getAulas().size() != 0){
                                                                    System.out.println("Insira o ID da aula (0 para mostrar todas, -1 para cancelar): ");
                                                                    try{
                                                                        aulaID = Ler.processarTecladoLong();
                                                                        
                                                                        if(aulaID == 0){
                                                                            PrintTodasAulas();
                                                                        } else if( aulaID != -1){
                                                                            aulaEntity = Aula.getAulaFromID(aulaID);
                                                                        }
                                                                    } catch (IOException e){
                                                                        System.out.println("Ocorreu um erro, introduza novamente.");
                                                                    }
                                                                }
                                                                teste.setAula(aulaEntity);
                                                                System.out.println("Aula introduzida.");
                                                                
                                                                //set data
                                                                zoneid = ZoneId.systemDefault();
                                                                ZonedDateTime data = ZonedDateTime.now();
                                                                //Enquanto o dia do ano for diferente do dia do ano atual
                                                                while(data.getDayOfYear()== ZonedDateTime.now().getDayOfYear()){
                                                                    System.out.println("Insira a data no seguinte formato ano->mês->dia->hora->minuto.");
                                                                    try{
                                                                        data = ZonedDateTime.of(Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), 0, 0, zoneid);
                                                                    } catch (IOException e){
                                                                        System.out.println("Introduza uma data correta.");
                                                                    }
                                                                }
                                                                teste.setData(data);
                                                                System.out.println("Data introduzida.");
                                                                Professor.getProfessorFromID(profID).addTeste(teste);
                                                                break;
                                                            case 4://Selecionar teste
                                                                System.out.println("Insira o ID do teste (0 para mostrar todos, -1 para cancelar): ");
                                                                
                                                                testeID=0;
                                                                nTeste=Entity.Zero;
                                                                while(nTeste.getID()==0 && Teste.getTestes().size() !=0){
                                                                    try{
                                                                        testeID = Ler.processarTecladoLong();
                                                                        
                                                                        if(testeID == 0){
                                                                            PrintTodosTestes();
                                                                        } else if(testeID != -1){
                                                                            teste = Teste.getTesteFromID(testeID);
                                                                        }
                                                                    } catch (IOException e){
                                                                        System.out.println("Ocorreu um erro, insira novamente.");
                                                                    }
                                                                    
                                                                    valorIntroduzido=-1;
                                                                    while(valorIntroduzido != exitop){
                                                                        //print do menu selecionar 
                                                                        printSelecionarTeste();
                                                                        //ler valor do utilizador
                                                                        try{
                                                                            valorIntroduzido = Ler.processarTecladoInt();
                                                                        } catch (IOException e){
                                                                            System.out.println("Por favor introduza um valor entre 1 e"+exitop+".");
                                                                        }
                                                                        //proximos menus 
                                                                        Entity alunoEntity;
                                                                        Aluno aluno;
                                                                        long alunoID;
                                                                        Entity nNota;
                                                                        Nota nota;
                                                                        long notaID;
                                                                        
                                                                        switch(valorIntroduzido){
                                                                            case 1://Alterar Nota
                                                                                nNota = Nota.Create();
                                                                                nota = Nota.getNotaFromID(nNota);
                                                                                
                                                                                //set aluno
                                                                                alunoID=0;
                                                                                alunoEntity=Entity.Zero;
                                                                                while(alunoEntity.getID()==0){
                                                                                        System.out.println("Insira o ID do aluno (0 para mostrar todos, -1 para cancelar): ");
                                                                                    try{
                                                                                        alunoID = Ler.processarTecladoLong();
                                                                        
                                                                                        if(alunoID == 0){
                                                                                            PrintTodosAlunos();
                                                                                        } else if(alunoID != -1 && Aluno.getAlunoFromID(alunoID).getID()!=0){
                                                                                            alunoEntity = Aluno.getAlunoFromID(alunoID);
                                                                                        }
                                                                                    } catch(IOException e){
                                                                                        System.out.println("Ocorreu um erro, insira um aluno existente.");
                                                                                    }
                                                                                }
                                                                                nota.setAluno(alunoEntity);
                                                                                System.out.println("Aluno encontrado.");
                                                                                
                                                                                //set valor
                                                                                double valor = -1;
                                                                                while(valor<0 || valor>20){
                                                                                    System.out.println("Insira o valor da nova nota do aluno.");
                                                                                    try{
                                                                                        valor = Ler.processarTecladoDouble();
                                                                                    } catch (IOException e){
                                                                                        System.out.println("Introduza um valor entre 0 e 20.");
                                                                                    }
                                                                                }
                                                                                nota.setValor(valor);
                                                                                
                                                                                Teste.getTesteFromID(testeID).getNotas().replace(alunoEntity,nota);
                                                                            break;
                                                                            
                                                                            case 2://Eliminar Nota
                                                                                System.out.println("Insira o ID do Teste para eliminar (0 para mostrar todos, -1 para cancelar): ");
                                                                                
                                                                                notaID=0;
                                                                                nNota=Entity.Zero;
                                                                                while(nNota.getID()==0 && Nota.getNotas().size()!=0){
                                                                                    try{
                                                                                        notaID = Ler.processarTecladoLong();
                                                                                        if(notaID ==0){
                                                                                           PrintTodasAulas();
                                                                                        } else if(notaID != -1){
                                                                                            nota = Nota.getNotaFromID(notaID);
                                                                                            Nota.Remove(nota);
                                                                                        }
                                                                                    } catch (IOException e){
                                                                                        System.out.println("Ocorreu um erro, insira novamente.");
                                                        }                           }
                                                                            break;
                                                                               
                                                                            case 3://Criar nota
                                                                                nNota = Nota.Create();
                                                                                nota = Nota.getNotaFromID(nNota);
                                                                                
                                                                                //set aluno
                                                                                alunoID=0;
                                                                                alunoEntity=Entity.Zero;
                                                                                while(alunoEntity.getID()==0){
                                                                                        System.out.println("Insira o ID do aluno (0 para mostrar todos, -1 para cancelar): ");
                                                                                    try{
                                                                                        alunoID = Ler.processarTecladoLong();
                                                                        
                                                                                        if(alunoID == 0){
                                                                                            PrintTodosAlunos();
                                                                                        } else if(alunoID != -1){
                                                                                            alunoEntity = Aluno.getAlunoFromID(alunoID);
                                                                                        }
                                                                                    } catch(IOException e){
                                                                                        System.out.println("Ocorreu um erro, insira novamente.");
                                                                                    }
                                                                                }
                                                                                nota.setAluno(alunoEntity);
                                                                                System.out.println("Aluno introduzido.");
                                                                                
                                                                                //set valor
                                                                                valor = -1;
                                                                                while(valor<0 || valor>20){
                                                                                    System.out.println("Insira o valor da nota do aluno.");
                                                                                    try{
                                                                                        valor = Ler.processarTecladoDouble();
                                                                                    } catch (IOException e){
                                                                                        System.out.println("Introduza um valor entre 0 e 20.");
                                                                                    }
                                                                                }
                                                                                nota.setValor(valor);
                                                                                nota.setTeste(Teste.getTesteFromID(testeID));
                                                                            break;
                                                                            
                                                                            case 4://Mudar data
                                                                                zoneid = ZoneId.systemDefault();
                                                                                data = ZonedDateTime.now();
                                                                                //Enquanto o dia do ano for diferente do dia do ano atual
                                                                                while(data.getDayOfYear()== ZonedDateTime.now().getDayOfYear()){
                                                                                    System.out.println("Insira a data no seguinte formato ano->mês->dia->hora->minuto.");
                                                                                    try{
                                                                                        data = ZonedDateTime.of(Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), 0, 0, zoneid);
                                                                                    } catch (IOException e){
                                                                                        System.out.println("Introduza uma data correta.");
                                                                                     }               
                                                                                }
                                                                                Teste.getTesteFromID(testeID).setData(data);
                                                                            break;
                                                                            
                                                                            case 5://Voltar
                                                                                break;
                                                                        
                                                                            default:    System.out.println("Por favor introduza um valor entre 1 e "+exitop+".");

                                                                        }
                                                                        
                                                                    }
                                                                }
                                                                
                                                                break;
                                                            case 5://Voltar
                                                                break;
                                                                
                                                            default:
								System.out.println("Por favor introduza um valor entre 1 e "+exitop+".");

                                                        }
                                                   }
                                                    
                                                
                                        }   
                                    }
					break;
					
//-----------------------------------------------------------------------------------------------------------------------------------------------------
				case 5:
                                        switch (valorIntroduzido) {
                                            case 1:
                                                valorIntroduzido=-1;
                                                while(valorIntroduzido!=exitop){
                                                    printMenu("Aluno","Alunos");
                                                    
                                                    try{
                                                        valorIntroduzido=Ler.processarTecladoInt();
                                                    }catch(IOException e){
                                                        System.out.println("Por favor introduza um valor entre 1 e "+exitop+".");
                                                    }
                                                    
                                                    Entity nAluno;
                                                    int ano=0,mes=0,dia=0;
                                                    Aluno aluno;
                                                    long turmID;
                                                    ZonedDateTime nascimento=null;
                                                    String pNome="",uNome="";
                                                    switch(valorIntroduzido){
                                                        case 0:
                                                            PrintTodosAlunos();
                                                            break;
                                                        case 1:
                                                            //criar alunos
                                                            nAluno = Aluno.Create();
                                                            aluno = Aluno.getAlunoFromID(nAluno);
                                                            
                                                            //set nomes
                                                            while(pNome=="" && uNome==""  ){
                                                                System.out.println("Insira o primeiro e o ultimo nome do aluno.");
                                                                try {
                                                                    pNome = Ler.processarTecladoString();
                                                                    uNome = Ler.processarTecladoString();
                                                                    System.out.println("Insira o dia.");
                                                                    dia=Ler.processarTecladoInt();
                                                                    System.out.println("Insira o mês.");
                                                                    mes=Ler.processarTecladoInt();
                                                                    System.out.println("Insira o ano.");
                                                                    ano=Ler.processarTecladoInt();
                                                                } catch (IOException e) {
                                                                    System.out.println("Ocurreu um erro, insira novamente.");
                                                                }
                                                                if(pNome==""  || uNome=="" || (dia<=0 && dia >=31) || (mes<0 && mes >12) || (ano<=0 && ano>Integer.MAX_VALUE) )
                                                                    System.out.println("Insira um nome correto.");
                                                            }
                                                            aluno.setPrimeiroNome(pNome);
                                                            aluno.setUltimoNome(uNome);
                                                            aluno.setNascimento(nascimento);//dia???
                                                            aluno.setNascimento(nascimento.withDayOfMonth(mes));
                                                            aluno.setNascimento(nascimento.withDayOfYear(ano));
                                                            System.out.println("Nome alterado.");
                                                        case 2:   
                                                            //set turma
                                                            Entity turma=Entity.Zero;
                                                            long turmaID=0;
                                                            while(turma.getID()==0){
                                                                System.out.println("Insira o ID da turma(0 para mostrar todos, -1 para cancelar).");
                                                                try {
                                                                    turmaID = Ler.processarTecladoLong();
                                                                    
                                                                    if(turmaID==0){
                                                                        PrintTodosAlunos();
                                                                    }else if(turmaID!=-1){
                                                                        turma = Turma.getTurmaFromID(turma);
                                                                    }
                                                                } catch (IOException e) {
                                                                    System.out.println("Ocurreu um erro, insira novamente.");
                                                                }
                                                            }
                                                                if(Turma.getTurmas().size() == 0)
                                                                    System.out.println("Não existem turmas.");
                                                                System.out.println("Aluno \""+pNome+uNome+"\" criado com sucesso.");
								break;
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
                                                        case 3:
                                                            //set nascimento/??????????????NAO SEI COMO FAZER ISTO
                                                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd(ano/mes/dia)");
                                                            while(ZonedDateTime.now()!=null){
                                                                try{
                                                                    System.out.println("Insira o dia que quer alterar");
                                                                    dia=Ler.processarTecladoInt();
                                                                    System.out.println("Insira o mês que quer alterar");
                                                                    mes=Ler.processarTecladoInt();
                                                                    System.out.println("Insira o ano que quer alterar");
                                                                    ano=Ler.processarTecladoInt();
                                                                    if((dia<=0 && dia >=31) && (mes<0 && mes >12) && (ano<=0 && ano>Integer.MAX_VALUE))
                                                                        System.out.println("Nao é possivel inserir esses valores(dia esta compreendido entre 0 e 31, mês entre 0 e 12 e ano entre 0 e Integer.MAX_VALUE )");
                                                                    else
                                                                        System.out.println("Data mudada.");
                                                                }catch(IOException | NullPointerException e){
                                                                    e.getMessage();
                                                                    System.out.println("Insira novamente os valores");
                                                                }
                                                            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
                                                    }
                                                }
                                            case 2:
                                                    //Eliminar um aluno
                                                    System.out.println("Insira o ID do aluno para eliminar(0 para mostrar todos, -1 para cancelar).");
                                                    long alunoID=0;
                                                    Aluno aluno=null ;
                                                    Entity nAluno=Entity.Zero;
                                                    while(nAluno.getID() == 0 && Aluno.getAlunos().size()!=0){
                                                        try{
                                                            alunoID = Ler.processarTecladoLong();
                                                            if(alunoID ==0){
                                                                PrintTodosAlunos();
                                                            }else if(alunoID != -1){
                                                                aluno=Aluno.getAlunoFromID(nAluno);
                                                            }
                                                        }catch (IOException e) {
                                                        	System.out.println("Occureu um erro, inisra novamente.");
                                                        }
                                                       }
                                            case 3:
                                                    valorIntroduzido = -1;
                                                while (valorIntroduzido != exitop) {
                                                    // Mostrar o menu
                                                    printMenu("Curso", "Cursos");

                                                    // ler a opção do utilizador
                                                    try {
                                                    	valorIntroduzido = Ler.processarTecladoInt();
                                                    } catch (IOException e) {
							System.out.println("Por favor introduza um valor entre 1 e "+exitop+".");
                                                    }
                                                    int x;
                                                    int turmaID;
                                                    Entity mudarTurma=Entity.Zero;
                                                    Entity mudarCurso=Entity.Zero;
                                                    boolean ativo;
                                                    Aluno alu=null;
                                                    switch (valorIntroduzido){
							case 0:
								// Mostrar tudo
								printTodosCursos();
								break;
                                                        case 1:
                                                            System.out.println("Insira o ano que deseja alterar.");
                                                            try{          
                                                                x=Ler.processarTecladoInt();
                                                                if(x<=10 || x>=12){
                                                                    alu.setAno(x);
                                                                    System.out.println("Mudou o ano.");
                                                                }
                                                            }catch(IOException e){
                                                                System.out.println("Insira um valor entre 10 e 12 inclusive.");
                                                            }
                                                        case 2:
                                                            System.out.println("Insira a turma que seja alterar.");
                                                            try{          
                                                                Turma.getTurmaFromID(mudarTurma);
                                                                Aluno.getAlunoFromID(alu).setTurma(mudarTurma);
                                                                System.out.println("Mudou a turma"); 
                                                            }catch(NullPointerException e){
                                                                e.getMessage();
                                                                System.out.println("A turma que quer mudar nao existe.");
                                                            }
                                                        case 3:
                                                            System.out.println("Insira o curso que seja alterar.");
                                                            try{          
                                                                Curso.getCursoFromID(mudarCurso);
                                                                Aluno.getAlunoFromID(alu).setCurso(mudarCurso);
                                                                System.out.println("Mudou o curso"); 
                                                            }catch(NullPointerException e){
                                                                e.getMessage();
                                                                System.out.println("O curso que quer mudar nao existe.");
                                                            }
                                                        case 4:
                                                            System.out.println("Diga se quer o aluno ativo ou não(true or false)");
                                                            try{
                                                                ativo=Ler.processarTecladoBoolean();
                                                                System.out.println("Diga qual o aluno.");
                                                                alunoID=Ler.processarTecladoLong();
                                                                if(ativo==true){
                                                                    alu.setActive(ativo);
                                                                    System.out.println("Aluno ativo");
                                                                }else if(ativo==false){
                                                                    alu.setActive(ativo);
                                                                    System.out.println("Aluno inativo");
                                                                }
                                                            }catch(IOException e){
                                                                e.getMessage();
                                                                System.out.println("");
                                                            }
                                                        case 5:
                                                            System.out.println("Atividade:");
                                                            for (Map.Entry<ZonedDateTime, String> actividade : alu.getNascimento())
                                                                System.out.println(actividade.getKey() +": "+ actividade.getValue());
                        
					valorIntroduzido = 5;
					break;

				case 6:
					break;


				default:
					System.out.println("Por favor introduza um valor entre 1 e 6.");
			}
		}

		System.out.println("Goodbye");

	}
    
}
