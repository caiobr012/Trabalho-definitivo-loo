package uniderp.loo.escola.dominio;

import java.util.Scanner;

public class Aluno {

    private Scanner sc;

    private int codigo;
    private String nome;
    private double notaA1;
    private double notaP1;
    private double notaA2;
    private double notaP2;
    private double media;
    
    public Scanner getSc() {
        return sc;
    }
    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getNotaA1() {
        return notaA1;
    }
    public void setNotaA1(double notaA1) {
        this.notaA1 = notaA1;
    }
    public double getNotaP1() {
        return notaP1;
    }
    public void setNotaP1(double notaP1) {
        this.notaP1 = notaP1;
    }
    public double getNotaA2() {
        return notaA2;
    }
    public void setNotaA2(double notaA2) {
        this.notaA2 = notaA2;
    }
    public double getNotaP2() {
        return notaP2;
    }
    public void setNotaP2(double notaP2) {
        this.notaP2 = notaP2;
    }
    public double getMedia() {
        return media;
    }
    public void setMedia(double media) {
        this.media = media;
    }
    public Aluno( int codigo, String nome) {
        this.sc = new Scanner(System.in);
        this.codigo = codigo;
        this.nome = nome;
    }

    public Aluno() {
        sc = new Scanner(System.in);
    }


    public void calcNotas(){
        int op=0;

        do{
            opcao005();
        System.out.print("Escolha uma opção: ");
        op = this.sc.nextInt();
        switch (op) {
            case 1:
                System.out.print("Digite a nota A1: ");
                setNotaA1(this.sc.nextDouble());
                op = 9;
                break;
            case 2:
                System.out.print("Digite a nota P1: ");
                setNotaP1(this.sc.nextDouble());
                op = 9;
                break;
                
            case 3:
                System.out.print("Digite a nota A2: ");
                setNotaA2(this.sc.nextDouble());
                op = 9;
                break;
            case 4:
                System.out.print("Digite a nota P2: ");
                setNotaP2(this.sc.nextDouble());
                op = 9;
                break;
            case 5:
                System.out.println("Fazendo calculo da média: ");
                this.media = calcMedia();
                System.out.print("Media do aluno é: " + this.media);
                if(this.media >= 6){
                    System.out.println("\nO aluno foi aprovado");
                }else{
                    System.out.println("\nO aluno foi reprovado");   
                }
                op = 9;
                break;
            case 9:
                System.out.println("\n\nVoltando para Menu de Gerenciamento Alunos...");
                break;
            default:
                System.out.println("\n\nOpção Inválida!\nTente Novamente!");
                op = 9;
                break;
        }
        }while(op != 9);
        
    }

    public void opcao005(){
            System.out.println("\n=========================================");
            System.out.println("05. SELECIONAR UM ALUNO PARA:");
            System.out.println("\nOpção 1 - Adicionar a nota A1 do aluno selecionado;");
            System.out.println("Opção 2 - Adicionar a nota P1 do aluno selecionado;");
            System.out.println("Opção 3 - Adicionar a nota A2 do aluno selecionado;");
            System.out.println("Opção 4 - Adicionar a nota P2 do aluno selecionado;");
            System.out.println("Opção 5 - Calcular a Média do Aluno");
            System.out.println("Opção 9 - Voltar");
            System.out.println("=========================================\n"); 
    }

    public double calcMedia(){
        double media = ((((notaA1 + notaP1)/2)+((notaA2 + notaP2)/2))/2);;
        return media;
    }

    @Override
    public String toString() {
        String ret = "   " + codigo + "   --  " + nome;
        return ret;
    }
    
}