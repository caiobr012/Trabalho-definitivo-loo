package uniderp.loo.escola.FakeDB;

import uniderp.loo.escola.models.Aluno;
import java.util.Scanner;
import java.util.ArrayList;

public class Turma {
    
    private Scanner sc;
    private ArrayList<Aluno> aluno;
    Aluno alunos = new Aluno();

    public Turma(){

        aluno = new ArrayList<Aluno>();
        sc = new Scanner(System.in);
    }

    public void funcao(){
        int op=0;
        do{
            menu();
            System.out.print("\nEscolha uma opção: ");
            op = this.sc.nextInt();
            switch (op) { 
                case 1: 
                    opcao01();
                    break; 

                case 2: 
                    opcao02();
                    break; 

                case 9: 
                    System.out.println("Encerrando Programa..."); 
                    break; 
                default: 
                    System.out.println("\n\nOpção Inválida!\nTente Novamente!");
                    break;
            }
        }while(op != 9);
    }
    
    private void menu(){
        System.out.println("\n=========================================");
        System.out.println("MENU DE OPÇÕES");
        System.out.println("\nOpção 1 - Gerenciar Aluno");
        System.out.println("Opção 2 - Rendimento Escolar");
        System.out.println("Opção 9 - Sair");
        System.out.println("=========================================");
    }

    private void opcao01(){
        int op=0;

        do{
            System.out.println("\n=========================================");
            System.out.println("01. GERENCIAR ALUNO:");
            System.out.println("\nOpção 1 - Adicionar Aluno");
            System.out.println("Opção 2 - Alterar nome do Aluno");
            System.out.println("Opção 3 - Excluir Aluno");
            System.out.println("Opção 4 - Listar todos");
            System.out.println("Opção 5 - Selecionar um aluno da lista");
            System.out.println("Opção 9 - Voltar");
            System.out.println("=========================================");
            System.out.print("\nEscolha uma opção: ");
                    op = this.sc.nextInt();

                    switch (op) { 
                        case 1: 
                            opcao001();        
                            break;
                        case 2: 
                            opcao002();
                            break;
                        case 3: 
                            opcao003();
                            break;
                        case 4: 
                            mostrarLista();
                            break;
                        case 5:
                            int i = verificaLista(), codachado, opal =0;
                            if (i != -1){
                                codachado = procuraAluno();
                                if(codachado != -1){
                                do{
                                System.out.println("\nO aluno escolhido foi: "+ aluno.get(codachado).getNome());
                                System.out.println("\n===ESCOLHA UMA OPÇÃO===");
                                System.out.println("\n[1] - Continuar com o aluno escolhido");
                                System.out.println("[2] - Trocar o aluno");
                                System.out.println("[9] - Sair");
                                System.out.print("\nDigite sua opção: ");
                                opal = sc.nextInt();
                                switch (opal) {
                                    case 1:
                                        aluno.get(codachado).calcNotas();
                                        break;

                                    case 2:
                                        codachado = procuraAluno();
                                        break;

                                    case 9:
                                        System.out.println("\nVoltando para o menu anterior...");
                                        break;
                                    default:
                                        System.out.println("\nErro!\nOpção Inválida!");
                                        break;
                                }
                                }while(opal != 9);
                                }else{
                                        System.out.println("\nErro!\nNão há nenhum aluno cadastrado com esse código!");
                                        }
                                
                            }else{
                                System.out.println("\nNão há nenhum aluno cadastrado!\n");
                            }
                            break;
                        case 9: 
                             System.out.println("\n\nVoltando para o Menu Principal");
                            break;
                        default: 
                            System.out.println("\n\nOpção Inválida!\nTente Novamente!");
                            break;
                    }
        }while(op!=9);
    }

    private void opcao001(){

        int codigo, vet=0;
        String nome;

        System.out.print("\nDigite o código do aluno: ");
        codigo = sc.nextInt();
        int tamanho = aluno.size();
        for(int i =0; i<tamanho; i++){
            if(codigo == aluno.get(i).getCodigo()){
                vet = 1;
                i = tamanho;
            }
        }
            if(vet != 1){
                System.out.print("Digite o nome do aluno: ");
                nome = sc.next();
                sc.nextLine();
                this.aluno.add(new Aluno(codigo, nome));
            }else{
                System.out.println("\nErro!\nJá há um aluno cadastrado com esse código!");
            }
        }
        

    private void opcao002(){
        int codachado;
        String newnome;
        int i = verificaLista();
        if (i != -1){
        codachado = procuraAluno();
        if(codachado != -1){
            
            System.out.print("\nDigite o novo nome: ");
            newnome = sc.next();
            sc.nextLine();
            System.out.print("\nO aluno "+ this.aluno.get(codachado).getNome()+" passou a se chamar: ");
            this.aluno.get(codachado).setNome(newnome);
            System.out.print(""+ this.aluno.get(codachado).getNome()+"\n");
        }else{
            System.out.println("\nErro!\nAluno não encotrado!");
        }
    }else{
        System.out.println("\nNão há nenhum aluno cadastrado!\n");
    }
    }

    private void opcao003(){
        int i = verificaLista();
        if(i != -1){
            int codachado = procuraAluno();
            if(codachado != -1){
                this.aluno.remove(codachado);
            }else{
                System.out.println("\nErro!\nAluno não encotrado!");
            }
        }else{
            System.out.println("\nNão há nenhum aluno cadastrado!\n");
        }     
    }

    private int procuraAluno(){
        int cod, tamanho = aluno.size(), ret=-1;
        mostrarLista();
        System.out.print("\n\nDigite o código do aluno desejado: ");
        cod = sc.nextInt();
        for(int i=0; i<tamanho; i++){
            if(aluno.get(i).getCodigo() == cod){
                ret = i;
            }
        }
        return ret;
    }

    public void mostrarLista(){
        int v = verificaLista();
        if(v != -1){
            int cont = aluno.size();
        System.out.println("\n\nMostrando a lista...");
        System.out.println("\nCódigo --   Aluno ");
        for (int i=0; i<cont; i++) {
            System.out.println(aluno.get(i));
        }
        }else{
        System.out.println("\nNão há nenhum aluno cadastrado!\n"); 
        }
    }

    private void opcao02(){
        int op =0;
        int i = verificaLista();
        if (i != -1){
            do{
        System.out.println("\n=========================================");
        System.out.println("02. RENDIDMENTO ESCOLAR");
        System.out.println("\nOpção 1 - Exibir Rendimento de Aluno");
        System.out.println("Opção 2 - Exibir Rendimento da Turma");
        System.out.println("Opção 9 - Voltar");
        System.out.println("=========================================");

        System.out.print("\n\nEscolha uma opção: ");
                    op = this.sc.nextInt();
                    switch (op) { 
                        case 1:
                            mostrarAluno();
                            break;
                        case 2: 
                            mostrarAlunos();
                            break;
                        case 9: 
                             System.out.println("\n\nVoltando para o Menu Principal");
                            break;
                        default: 
                            System.out.println("\n\nOpção Inválida!\nTente Novamente!");
                            break;
                    }
        }while(op != 9);
        }else{
             System.out.println("\nNão há nenhum aluno cadastrado!\n");
        }
    }

    private void mostrarAluno(){
        int codachado;
        codachado = procuraAluno();
        if(codachado != -1){
            System.out.println("\n\nCódigo -- Aluno -- Nota A1 -- Nota P1 -- Nota A2 -- Nota P2 -- Media ");
            System.out.println("  "+this.aluno.get(codachado).getCodigo() + "    --  " + this.aluno.get(codachado).getNome() + "  --   " + this.aluno.get(codachado).getNotaA1() + "   --   " + this.aluno.get(codachado).getNotaP1() + "   --   " + this.aluno.get(codachado).getNotaA2() + "   --   " + this.aluno.get(codachado).getNotaP2() + "   --   " + aluno.get(codachado).calcMedia());
        }else{
            System.out.println("\nErro!\nAluno não encotrado!");
        }
}

    private void mostrarAlunos(){
         System.out.println("Mostrando a lista...");
         System.out.println("\n\nCódigo -- Aluno -- Nota A1 -- Nota P1 -- Nota A2 -- Nota P2 -- Media ");
         for (int codachado = 0; codachado < aluno.size(); codachado++) {
            System.out.println("  "+this.aluno.get(codachado).getCodigo() + "    --  " + this.aluno.get(codachado).getNome() + "  --   " + this.aluno.get(codachado).getNotaA1() + "   --   " + this.aluno.get(codachado).getNotaP1() + "   --   " + this.aluno.get(codachado).getNotaA2() + "   --   " + this.aluno.get(codachado).getNotaP2() + "   --   " + aluno.get(codachado).calcMedia());
        }
    }
    
    private int verificaLista(){
        int ver, tamanho = aluno.size();
        if(tamanho > 0){
            ver = 0;
        }else{
            ver = -1;
        }
        return ver;
    }
}
