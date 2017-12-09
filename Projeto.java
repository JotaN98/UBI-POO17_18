import myinput.Ler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
				case 2:
					printMenu("Turma","Turmas");

					valorIntroduzido = 2;
					break;
				case 3:
					printMenu("Disciplina","Disciplinas");

					valorIntroduzido = 3;
					break;
				case 4:
					printMenu("Professor","Professores");
                                        
					valorIntroduzido = 4;
					break;
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
                                                    Aluno aluno;
                                                    long turmID;
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
                                                            while(pNome=="" && uNome=="" ){
                                                                System.out.println("Insira o primeiro e o ultimo nome do aluno.");
                                                                try {
                                                                    pNome = Ler.processarTecladoString();
                                                                    uNome = Ler.processarTecladoString();
                                                                } catch (IOException e) {
                                                                    System.out.println("Ocurreu um erro, insira novamente.");
                                                                }
                                                                if(pNome==""  && uNome=="" )
                                                                    System.out.println("Insira um nome correto.");
                                                            }
                                                            aluno.setPrimeiroNome(pNome);
                                                            aluno.setUltimoNome(uNome);
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
                                                                /////////////SET NASCIMENTO////////////
                                                    }
                                                }
                                            case 2:
                                                    //Eliminar um aluno
                                                    System.out.println("Insira o ID do aluno para eliminar(0 para mostrar todos, -1 para cancelar).");
                                                    long alunoID=0;
                                                    Aluno aluno = null;
                                                    Entity nAluno=Entity.Zero;
                                                    while(nAluno.getID() == 0 && Aluno.getAlunos().size()!=0){
                                                        try{
                                                            alunoID = Ler.processarTecladoLong();
                                                            if(alunoID ==0){
                                                                PrintTodosAlunos();
                                                            }else if(alunoID != -1){
                                                                aluno=Aluno.getAlunoFromID(nAluno);//extends entity ???
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
                                                                    aluno.setAno(x);
                                                                    System.out.println("Mudou o ano.");
                                                                }
                                                            }catch(IOException e){
                                                                System.out.println("Insira um valor entre 10 e 12 inclusive.");
                                                            }
                                                        case 2:
                                                            System.out.println("Insira a turma que seja alterar.");
                                                            try{          
                                                                Turma.getTurmaFromID(mudarTurma);
                                                                Aluno.getAlunoFromID(aluno).setTurma(mudarTurma);
                                                                System.out.println("Mudou a turma"); 
                                                            }catch(IOException e){
                                                                e.getMessage();
                                                                System.out.println("A turma que quer mudar nao existe.");
                                                            }
                                                        case 3:
                                                            System.out.println("Insira a turma que seja alterar.");
                                                            try{          
                                                                Curso.getCursoFromID(mudarCurso);
                                                                Aluno.getAlunoFromID(aluno).setCurso(mudarCurso);
                                                                System.out.println("Mudou o curso"); 
                                                            }catch(IOException e){
                                                                e.getMessage();
                                                                System.out.println("A turma que quer mudar nao existe.");
                                                            }
                                                        case 4:
                                                            System.out.println("Diga se quer o aluno ativo ou não(true or false)");
                                                            try{
                                                                ativo=Ler.processarTecladoBoolean();
                                                                System.out.println("Diga qual o aluno.");
                                                                alunoID=Ler.processarTecladoLong();
                                                                if(ativo==true){
                                                                    aluno.setActive(ativo);
                                                                    System.out.println("Aluno ativo");
                                                                }else if(ativo==false){
                                                                    aluno.setActive(ativo);
                                                                    System.out.println("Aluno inativo");
                                                                }
                                                            }catch(IOException e){
                                                                e.getMessage();
                                                                System.out.println("");
                                                            }
                                                        case 5:
                                                            System.out.println("Atividade:");
                                                            for (Map.Entry<ZonedDateTime, String> actividade : aluno.activity.getActivity)
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
