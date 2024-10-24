import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DiarioEmocional {
    private List<Emocao> registroEmocoes;
    private List<Habito> registroHabitos;
    private List<String> lembretes;

    public DiarioEmocional() {
        registroEmocoes = new ArrayList<>();
        registroHabitos = new ArrayList<>();
        lembretes = new ArrayList<>();
    }

    public void adicionarEmocao(Emocao emocao) {
        registroEmocoes.add(emocao);
    }

    public void mostrarEmocoes() {
        System.out.println("Emoções registradas:");
        if (registroEmocoes.isEmpty()) {
            System.out.println("Nenhuma emoção registrada.");
        } else {
            registroEmocoes.forEach(System.out::println);
        }
    }

    public void adicionarHabito(Habito habito) {
        registroHabitos.add(habito);
    }

    public void mostrarHabitos() {
        System.out.println("Hábitos registrados:");
        if (registroHabitos.isEmpty()) {
            System.out.println("Nenhum hábito registrado.");
        } else {
            registroHabitos.forEach(System.out::println);
        }
    }

    public void adicionarLembrete(String lembrete) {
        lembretes.add(lembrete);
    }

    public void mostrarLembretes() {
        System.out.println("Lembretes:");
        if (lembretes.isEmpty()) {
            System.out.println("Nenhum lembrete registrado.");
        } else {
            lembretes.forEach(System.out::println);
        }
    }
}

class Emocao {
    private LocalDate data;
    private String sentimento;
    private String descricao;
    private List<String> tags;

    public Emocao(LocalDate data, String sentimento, String descricao, List<String> tags) {
        this.data = data;
        this.sentimento = sentimento;
        this.descricao = descricao;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Sentimento: " + sentimento + ", Descrição: " + descricao + ", Tags: " + tags;
    }
}

class Habito {
    private LocalDate data;
    private String nome;
    private String descricao;
    private String frequencia;

    public Habito(LocalDate data, String nome, String descricao, String frequencia) {
        this.data = data;
        this.nome = nome;
        this.descricao = descricao;
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Hábito: " + nome + ", Descrição: " + descricao + ", Frequência: " + frequencia;
    }
}

class Usuario {
    private String nome;
    private String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}

public class AppSaudeMental {
    private DiarioEmocional diario;
    private List<Usuario> usuarios;

    public AppSaudeMental() {
        diario = new DiarioEmocional();
        usuarios = new ArrayList<>();
        // Adicionando um usuário padrão
        usuarios.add(new Usuario("usuario", "senha123"));
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        if (!login(scanner)) {
            System.out.println("Login falhou. Saindo do aplicativo.");
            return;
        }

        String opcao;
        do {
            exibirMenu();
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    adicionarEmocao(scanner);
                    break;
                case "2":
                    adicionarHabito(scanner);
                    break;
                case "3":
                    adicionarLembrete(scanner);
                    break;
                case "4":
                    // Implementar escolher tipo de gráfico
                    System.out.println("Escolha um tipo de gráfico (pizza, barra, linha):");
                    break;
                case "5":
                    gerarRelatorioEmocoes();
                    break;
                case "6":
                    diario.mostrarLembretes();
                    break;
                case "7":
                    diario.mostrarHabitos();
                    break;
                case "8":
                    priorizarLembretes(scanner);
                    break;
                case "9":
                    enviarFeedback(scanner);
                    break;
                case "10":
                    dicasDeBemEstar();
                    break;
                case "11":
                    monitorarQualidadeSono(scanner);
                    break;
                case "12":
                    aprimoramentoCognitivo(scanner);
                    break;
                case "13":
                    empoderamentoPessoal(scanner);
                    break;
                case "14":
                    System.out.println("Saindo do Aplicativo");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!opcao.equals("14"));

        scanner.close();
    }

    private boolean login(Scanner scanner) {
        System.out.print("Digite seu nome de usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido!");
                return true;
            }
        }
        return false;
    }

    private void exibirMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Adicionar Emoção com Tags");
        System.out.println("2. Adicionar Hábitos com Frequência");
        System.out.println("3. Adicionar Lembrete");
        System.out.println("4. Escolher Tipo de Gráfico");
        System.out.println("5. Gerar Relatório de Emoções");
        System.out.println("6. Mostrar Lembretes");
        System.out.println("7. Mostrar Hábitos");
        System.out.println("8. Priorizar Lembretes");
        System.out.println("9. Enviar Feedback");
        System.out.println("10. Dicas de Bem-Estar");
        System.out.println("11. Monitorar Qualidade do Sono");
        System.out.println("12. Aprimoramento Cognitivo");
        System.out.println("13. Empoderamento Pessoal");
        System.out.println("14. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void adicionarEmocao(Scanner scanner) {
        System.out.print("Digite o sentimento: ");
        String sentimento = scanner.nextLine();
        System.out.print("Digite uma descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite as tags (separadas por vírgula): ");
        String tagsInput = scanner.nextLine();
        List<String> tags = List.of(tagsInput.split(","));
        Emocao emocao = new Emocao(LocalDate.now(), sentimento, descricao, tags);
        diario.adicionarEmocao(emocao);
        System.out.println("Emoção adicionada com sucesso!");
    }

    private void adicionarHabito(Scanner scanner) {
        System.out.print("Digite o nome do hábito: ");
        String nome = scanner.nextLine();
        System.out.print("Digite uma descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a frequência (diário, semanal, mensal): ");
        String frequencia = scanner.nextLine();
        Habito habito = new Habito(LocalDate.now(), nome, descricao, frequencia);
        diario.adicionarHabito(habito);
        System.out.println("Hábito adicionado com sucesso!");
    }

    private void adicionarLembrete(Scanner scanner) {
        System.out.print("Digite o lembrete: ");
        String lembrete = scanner.nextLine();
        diario.adicionarLembrete(lembrete);
        System.out.println("Lembrete adicionado com sucesso!");
    }

    private void gerarRelatorioEmocoes() {
        System.out.println("Relatório de Emoções não implementado ainda.");
    }

    private void priorizarLembretes(Scanner scanner) {
        System.out.print("Digite o lembrete que você deseja priorizar: ");
        String lembrete = scanner.nextLine();
        System.out.println("Lembrete priorizado: " + lembrete);
    }


    private void dicasDeBemEstar() {
        System.out.println("Dicas de Bem-Estar: Beba água, faça exercícios, medite. Pratique a Gratidão: Reserve um momento do dia para refletir sobre as coisas pelas quais você é grato. Isso pode ajudar a melhorar seu humor e perspectiva.");
    }

    private void monitorarQualidadeSono(Scanner scanner) {
        System.out.print("Quantas horas você dormiu na última noite? ");
        String horasDormidas = scanner.nextLine();
        System.out.println("Você dormiu " + horasDormidas + " horas.");
    }

    private void aprimoramentoCognitivo(Scanner scanner) {
        System.out.println("Aprimoramento Cognitivo: Tente aprender algo novo todos os dias!");
        return; 
    }

    private void empoderamentoPessoal(Scanner scanner) {
        System.out.println("Empoderamento Pessoal: Acredite em si mesmo e busque seus objetivos, Você é mais forte do que imagina. Confie na sua capacidade. Não importa o quão devagar você vá, contanto que você não pare. O poder está dentro de você. Desperte-o");
        return;
    }

    public static void main(String[] args) {
        AppSaudeMental app = new AppSaudeMental();
        app.iniciar();
    }
}
