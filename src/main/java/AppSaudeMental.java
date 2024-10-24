import javax.swing.*;
import javax.swing.event.HyperlinkEvent;

import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.time.LocalDate;
	import java.util.ArrayList;
	import java.util.List;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	
	

	public class DatabaseConnection {
	    private static final String URL = "jdbc:sqlserver://<hostname>:<port>;databaseName=<database>";
	    private static final String USER = "<username>";
	    private static final String PASSWORD = "<password>";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	}

	class DiarioEmocional {
		private List<Emocao> emocaoList;
		private List<Habito> habitoList;
		private List<String> lembretes;
		private List<Medicamento> medicamentoList;
		private List<String> dicasQualidadeSono;
		private List<String> dicasAprimoramentoCognitivo;
		private List<String> dicasEmpoderamentoPessoal;
	
		public DiarioEmocional() {
			emocaoList = new ArrayList<>();
			habitoList = new ArrayList<>();
			lembretes = new ArrayList<>();
			medicamentoList = new ArrayList<>();
			dicasQualidadeSono = new ArrayList<>();
			dicasAprimoramentoCognitivo = new ArrayList<>();
			dicasEmpoderamentoPessoal = new ArrayList<>();
		}
	
		public void adicionarEmocao(Emocao emocao) {
			emocaoList.add(emocao);
		}
	
		public void adicionarHabito(Habito habito) {
			habitoList.add(habito);
		}
	
		public void adicionarLembrete(String lembrete) {
			lembretes.add(lembrete);
		}
	
		public void adicionarMedicamento(Medicamento medicamento) {
			medicamentoList.add(medicamento);
		}
	
		public void adicionarDicaQualidadeSono(String dica) {
			dicasQualidadeSono.add(dica);
		}
	
		public void adicionarDicaAprimoramentoCognitivo(String dica) {
			dicasAprimoramentoCognitivo.add(dica);
		}
	
		public void adicionarDicaEmpoderamentoPessoal(String dica) {
			dicasEmpoderamentoPessoal.add(dica);
		}
	
		public List<Emocao> getEmocoes() {
			return emocaoList;
		}
	
		public List<Habito> getHabitos() {
			return habitoList;
		}
	
		public List<String> getLembretes() {
			return lembretes;
		}
	
		public List<Medicamento> getMedicamentos() {
			return medicamentoList;
		}
	
		public List<String> getDicasQualidadeSono() {
			return dicasQualidadeSono;
		}
	
		public List<String> getDicasAprimoramentoCognitivo() {
			return dicasAprimoramentoCognitivo;
		}
	
		public List<String> getDicasEmpoderamentoPessoal() {
			return dicasEmpoderamentoPessoal;
		}
	}
	
	class Emocao {
		private LocalDate data;
		private String sentimento;
		private String descricao;
	
		public Emocao(LocalDate data, String sentimento, String descricao) {
			this.data = data;
			this.sentimento = sentimento;
			this.descricao = descricao;
		}
	
		@Override
		public String toString() {
			return "Data: " + data + ", Sentimento: " + sentimento + ", Descrição: " + descricao;
		}
	}
	
	class Habito {
		private LocalDate data;
		private String nome;
		private String descricao;
	
		public Habito(LocalDate data, String nome, String descricao) {
			this.data = data;
			this.nome = nome;
			this.descricao = descricao;
		}
	
		@Override
		public String toString() {
			return "Hábito: " + nome + " | Data: " + data + " | Descrição: " + descricao;
		}
	}
	
	class Medicamento {
		private String nome;
		private String dosagem;
		private LocalDate dataInicio;
	
		public Medicamento(String nome, String dosagem, LocalDate dataInicio) {
			this.nome = nome;
			this.dosagem = dosagem;
			this.dataInicio = dataInicio;
		}
	
		@Override
		public String toString() {
			return "Medicamento: " + nome + ", Dosagem: " + dosagem + ", Data de Início: " + dataInicio;
		}
	}
	
	public class AppSaudeMental {
		private DiarioEmocional diario;
		private JFrame frame;
	
		public AppSaudeMental() {
			diario = new DiarioEmocional();
			criarInterface();
		}
	
		private void criarInterface() {
			frame = new JFrame("Diário Emocional");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600, 800);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(Color.WHITE);
	
			JPanel panel = new JPanel();
			panel.setLayout(new GridBagLayout());
			panel.setBackground(Color.WHITE);
			panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			gbc.insets = new Insets(10, 0, 10, 0);
	
			// Botões com design moderno e imagens
			JButton btnAdicionarEmocao = new JButton(carregarImagem("/images/emoji_brain.png"));
			btnAdicionarEmocao.setText("Adicionar Emoção");
			btnAdicionarEmocao.setHorizontalTextPosition(SwingConstants.RIGHT); // Para o texto à direita da imagem

			JButton btnAdicionarHabito = new JButton(carregarImagem("/images/emoji_check.png"));
			btnAdicionarHabito.setText("Adicionar Hábito");
			btnAdicionarHabito.setHorizontalTextPosition(SwingConstants.RIGHT);

			JButton btnAdicionarLembrete = new JButton(carregarImagem("/images/emoji_note.png"));
			btnAdicionarLembrete.setText("Adicionar Lembrete");
			btnAdicionarLembrete.setHorizontalTextPosition(SwingConstants.RIGHT);

			JButton btnAdicionarMedicamento = new JButton(carregarImagem("/images/emoji_pill.png"));
			btnAdicionarMedicamento.setText("Adicionar Medicamento");
			btnAdicionarMedicamento.setHorizontalTextPosition(SwingConstants.RIGHT);

			JButton btnMostrarEmocoes = new JButton(carregarImagem("/images/emoji_chart.png"));
			btnMostrarEmocoes.setText("Mostrar Emoções");
			btnMostrarEmocoes.setHorizontalTextPosition(SwingConstants.RIGHT);

			JButton btnMostrarHabitos = new JButton(carregarImagem("/images/emoji_list.png"));
			btnMostrarHabitos.setText("Mostrar Hábitos");
			btnMostrarHabitos.setHorizontalTextPosition(SwingConstants.RIGHT);

			JButton btnMostrarMedicamentos = new JButton(carregarImagem("/images/emoji_pill.png"));
			btnMostrarMedicamentos.setText("Mostrar Medicamentos");
			btnMostrarMedicamentos.setHorizontalTextPosition(SwingConstants.RIGHT);

			JButton btnMostrarLembretes = new JButton(carregarImagem("/images/emoji_bell.png"));
			btnMostrarLembretes.setText("Mostrar Lembretes");
			btnMostrarLembretes.setHorizontalTextPosition(SwingConstants.RIGHT);

			JButton btnModoCrise = new JButton(carregarImagem("/images/emoji_alert.png"));
			btnModoCrise.setText("Modo de Crise");
			btnModoCrise.setHorizontalTextPosition(SwingConstants.RIGHT);
			btnModoCrise.setBackground(Color.RED);

			JButton btnDicasBemEstar = new JButton(carregarImagem("/images/emoji_plant.png"));
			btnDicasBemEstar.setText("Dicas de Bem-Estar");
			btnDicasBemEstar.setHorizontalTextPosition(SwingConstants.RIGHT);

			// Botões para qualidade do sono, aprimoramento cognitivo e empoderamento pessoal
			JButton btnQualidadeSono = new JButton(carregarImagem("/images/emoji_sleep.png"));
			btnQualidadeSono.setText("Qualidade do Sono");
			btnQualidadeSono.setHorizontalTextPosition(SwingConstants.RIGHT);

			JButton btnAprimoramentoCognitivo = new JButton(carregarImagem("/images/emoji_puzzle.png"));
			btnAprimoramentoCognitivo.setText("Aprimoramento Cognitivo");
			btnAprimoramentoCognitivo.setHorizontalTextPosition(SwingConstants.RIGHT);

			JButton btnEmpoderamentoPessoal = new JButton(carregarImagem("/images/emoji_strength.png"));
			btnEmpoderamentoPessoal.setText("Empoderamento Pessoal");
			btnEmpoderamentoPessoal.setHorizontalTextPosition(SwingConstants.RIGHT);

			// Adicionando botões ao painel
			gbc.gridx = 0;
			gbc.gridy = 0;
			panel.add(btnAdicionarEmocao, gbc);
			gbc.gridy = 1;
			panel.add(btnAdicionarHabito, gbc);
			gbc.gridy = 2;
			panel.add(btnAdicionarLembrete, gbc);
			gbc.gridy = 3;
			panel.add(btnAdicionarMedicamento, gbc);
			gbc.gridy = 4;
			panel.add(btnMostrarEmocoes, gbc);
			gbc.gridy = 5;
			panel.add(btnMostrarHabitos, gbc);
			gbc.gridy = 6;
			panel.add(btnMostrarMedicamentos, gbc);
			gbc.gridy = 7;
			panel.add(btnMostrarLembretes, gbc);
			gbc.gridy = 8;
			panel.add(btnModoCrise, gbc);
			gbc.gridy = 9;
			panel.add(btnDicasBemEstar, gbc);
			gbc.gridy = 10;
			panel.add(btnQualidadeSono, gbc);
			gbc.gridy = 11;
			panel.add(btnAprimoramentoCognitivo, gbc);
			gbc.gridy = 12;
			panel.add(btnEmpoderamentoPessoal, gbc);
	
			frame.add(panel, BorderLayout.CENTER);
			frame.setVisible(true);
	
			// Ações dos botões
			btnAdicionarEmocao.addActionListener(e -> adicionarEmocao());
			btnAdicionarHabito.addActionListener(e -> adicionarHabito());
			btnAdicionarLembrete.addActionListener(e -> adicionarLembrete());
			btnAdicionarMedicamento.addActionListener(e -> adicionarMedicamento());
			btnMostrarEmocoes.addActionListener(e -> mostrarEmocoes());
			btnMostrarHabitos.addActionListener(e -> mostrarHabitos());
			btnMostrarMedicamentos.addActionListener(e -> mostrarMedicamentos());
			btnMostrarLembretes.addActionListener(e -> mostrarLembretes());
			btnModoCrise.addActionListener(e -> modoCrise());
			btnDicasBemEstar.addActionListener(e -> mostrarDicasBemEstar());
			btnQualidadeSono.addActionListener(e -> adicionarDicaQualidadeSono());
			btnAprimoramentoCognitivo.addActionListener(e -> adicionarDicaAprimoramentoCognitivo());
			btnEmpoderamentoPessoal.addActionListener(e -> adicionarDicaEmpoderamentoPessoal());
		}
	
		private Icon carregarImagem(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		private JButton criarBotao(String texto) {
			return criarBotao(texto, new Color(70, 130, 180));
		}
	
		private JButton criarBotao(String texto, Color cor) {
			JButton botao = new JButton(texto);
			botao.setFont(new Font("Segoe UI", Font.BOLD, 18));
			botao.setFocusPainted(false);
			botao.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			botao.setBackground(cor);
			botao.setForeground(Color.WHITE);
			botao.setPreferredSize(new Dimension(300, 50));
			botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
			// Efeitos de hover
			botao.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					botao.setBackground(botao.getBackground().darker());
				}
	
				public void mouseExited(java.awt.event.MouseEvent evt) {
					botao.setBackground(cor);
				}
			});
	
			return botao;
		}
	
		// Métodos para adicionar emoções, hábitos, lembretes e medicamentos
		private void adicionarEmocao() {
			String sentimento = JOptionPane.showInputDialog(frame, "Digite o sentimento:", "Adicionar Emoção",
					JOptionPane.QUESTION_MESSAGE);
			String descricao = JOptionPane.showInputDialog(frame, "Digite uma descrição:", "Adicionar Emoção",
					JOptionPane.QUESTION_MESSAGE);
			if (sentimento != null && descricao != null && !sentimento.trim().isEmpty() && !descricao.trim().isEmpty()) {
				Emocao emocao = new Emocao(LocalDate.now(), sentimento, descricao);
				diario.adicionarEmocao(emocao);
				JOptionPane.showMessageDialog(frame, "Emoção adicionada com sucesso!", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(frame, "Sentimento e descrição não podem ser vazios!", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	
		private void adicionarHabito() {
			String nome = JOptionPane.showInputDialog(frame, "Digite o hábito:", "Adicionar Hábito",
					JOptionPane.QUESTION_MESSAGE);
			String descricao = JOptionPane.showInputDialog(frame, "Digite uma descrição:", "Adicionar Hábito",
					JOptionPane.QUESTION_MESSAGE);
			if (nome != null && descricao != null && !nome.trim().isEmpty() && !descricao.trim().isEmpty()) {
				Habito habito = new Habito(LocalDate.now(), nome, descricao);
				diario.adicionarHabito(habito);
				JOptionPane.showMessageDialog(frame, "Hábito adicionado com sucesso!", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(frame, "Nome e descrição do hábito não podem ser vazios!", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	
		private void adicionarLembrete() {
			String lembrete = JOptionPane.showInputDialog(frame, "Digite um lembrete:", "Adicionar Lembrete",
					JOptionPane.QUESTION_MESSAGE);
			if (lembrete != null && !lembrete.trim().isEmpty()) {
				diario.adicionarLembrete(lembrete);
				JOptionPane.showMessageDialog(frame, "Lembrete adicionado com sucesso!", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(frame, "O lembrete não pode ser vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	
		private void adicionarMedicamento() {
			String nome = JOptionPane.showInputDialog(frame, "Digite o nome do medicamento:", "Adicionar Medicamento",
					JOptionPane.QUESTION_MESSAGE);
			String dosagem = JOptionPane.showInputDialog(frame, "Digite a dosagem:", "Adicionar Medicamento",
					JOptionPane.QUESTION_MESSAGE);
			if (nome != null && dosagem != null && !nome.trim().isEmpty() && !dosagem.trim().isEmpty()) {
				Medicamento medicamento = new Medicamento(nome, dosagem, LocalDate.now());
				diario.adicionarMedicamento(medicamento);
				JOptionPane.showMessageDialog(frame, "Medicamento adicionado com sucesso!", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(frame, "Nome e dosagem do medicamento não podem ser vazios!", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	
		private void mostrarEmocoes() {
			List<Emocao> emocoes = diario.getEmocoes();
			StringBuilder mensagem = new StringBuilder("Emoções registradas:\n");
			if (emocoes.isEmpty()) {
				mensagem.append("Nenhuma emoção registrada.");
			} else {
				for (Emocao emocao : emocoes) {
					mensagem.append(emocao).append("\n");
				}
			}
			JOptionPane.showMessageDialog(frame, mensagem.toString(), "Emoções", JOptionPane.INFORMATION_MESSAGE);
		}
	
		private void mostrarHabitos() {
			List<Habito> habitos = diario.getHabitos();
			StringBuilder mensagem = new StringBuilder("Hábitos registrados:\n");
			if (habitos.isEmpty()) {
				mensagem.append("Nenhum hábito registrado.");
			} else {
				for (Habito habito : habitos) {
					mensagem.append(habito).append("\n");
				}
			}
			JOptionPane.showMessageDialog(frame, mensagem.toString(), "Hábitos", JOptionPane.INFORMATION_MESSAGE);
		}
	
		private void mostrarLembretes() {
			List<String> lembretes = diario.getLembretes();
			StringBuilder mensagem = new StringBuilder("Lembretes registrados:\n");
			if (lembretes.isEmpty()) {
				mensagem.append("Nenhum lembrete registrado.");
			} else {
				for (String lembrete : lembretes) {
					mensagem.append(lembrete).append("\n");
				}
			}
			JOptionPane.showMessageDialog(frame, mensagem.toString(), "Lembretes", JOptionPane.INFORMATION_MESSAGE);
		}
	
		private void mostrarMedicamentos() {
			List<Medicamento> medicamentos = diario.getMedicamentos();
			StringBuilder mensagem = new StringBuilder("Medicamentos registrados:\n");
			if (medicamentos.isEmpty()) {
				mensagem.append("Nenhum medicamento registrado.");
			} else {
				for (Medicamento medicamento : medicamentos) {
					mensagem.append(medicamento).append("\n");
				}
			}
			JOptionPane.showMessageDialog(frame, mensagem.toString(), "Medicamentos", JOptionPane.INFORMATION_MESSAGE);
		}
	
		private void modoCrise() {
		    String mensagem = "Modo de Crise Ativado!\nAqui estão algumas ações que você pode tomar:\n"
		            + "- Entre em contato com um amigo ou familiar.\n"
		            + "- Ligue para um serviço de emergência ou linha direta de apoio.\n"
		            + "- Respire fundo e tente se acalmar.\n"
		            + "- Contatos de Emergência:\n"
		            + "- Centro de Valorização da Vida: 188 (apoio emocional)\n"
		            + "- SAMU: 192 (serviço de emergência médica)\n"
		            + "- Disque Saúde: 136 (informações sobre saúde)\n"
		            + "- CAPS: (número caps:(11) 2558-6491) (atendimento em saúde mental)";
		    
		    JOptionPane.showMessageDialog(frame, mensagem, "Modo de Crise", JOptionPane.WARNING_MESSAGE);
		}

		
	
		private void mostrarDicasBemEstar() {
		    String mensagem = "<html>" +
		            "<head>" +
		            "<style>" +
		            "body { font-family: Arial, sans-serif; color: #333; }" +
		            "h2 { color: #4CAF50; }" +
		            "ul { list-style-type: disc; margin-left: 20px; }" +
		            "a { color: #1E90FF; text-decoration: none; }" +
		            "a:hover { text-decoration: underline; }" +
		            "</style>" +
		            "</head>" +
		            "<body>" +
		            "<h2>Dicas de Bem-Estar:</h2>" +
		            "<ul>" +
		            "<li>Alimente-se bem.</li>" +
		            "<li>Durma pelo menos 8 horas por noite.</li>" +
		            "<li>Tome seus medicamentos.</li>" +
		            "<li>Não use drogas.</li>" +
		            "<li>Faça exercícios com frequência.</li>" +
		            "<li>Em caso de crise, busque ajuda profissional.</li>" +
		            "<li>Pratique Meditação Guiada: sessões relaxantes para reduzir o estresse.</li>" +
		            "</ul>" +
		            "<p>Assista a vídeos de meditação guiada:</p>" +
		            "<ul>" +
		            "<li><a href='https://www.youtube.com/watch?v=9laAtD91JUQ'>Vídeo 1</a></li>" +
		            "<li><a href='https://www.youtube.com/watch?v=oR_YBAjeP1A'>Vídeo 2</a></li>" +
		            "<li><a href='https://www.youtube.com/watch?v=U7GqtGgEjDM'>Vídeo 3</a></li>" +
		            "</ul>" +
		            "</body>" +
		            "</html>";

		    JEditorPane editorPane = new JEditorPane("text/html", mensagem);
		    editorPane.setEditable(false);
		    editorPane.setCaretPosition(0);
		    editorPane.addHyperlinkListener(e -> {
		        if (HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType())) {
		            try {
		                Desktop.getDesktop().browse(e.getURL().toURI());
		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
		        }
		    });

		    JOptionPane.showMessageDialog(frame, new JScrollPane(editorPane), "Dicas de Bem-Estar", JOptionPane.INFORMATION_MESSAGE);
		}


		private void adicionarDicaQualidadeSono() {
		    // Directly set the tip for demonstration
		    String dica = "Ler um livro antes de dormir ajuda a relaxar.";
		    
		    // Prompt for ideal amount of sleep
		    String quantidadeSono = JOptionPane.showInputDialog(frame, "Digite sua quantidade ideal de sono (em horas):",
		            "Quantidade Ideal de Sono", JOptionPane.QUESTION_MESSAGE);
		    
		    // Check if the ideal amount of sleep is valid
		    if (quantidadeSono != null && !quantidadeSono.trim().isEmpty()) {
		        int horasSono;
		        try {
		            horasSono = Integer.parseInt(quantidadeSono);
		        } catch (NumberFormatException e) {
		            JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Determine if the sleep duration is good or bad
		        String qualidadeSono;
		        if (horasSono >= 7 && horasSono <= 9) {
		            qualidadeSono = "Sua quantidade de sono está dentro da faixa recomendada! Bom trabalho!";
		        } else if (horasSono < 7) {
		            qualidadeSono = "Sua quantidade de sono está abaixo da faixa recomendada. Tente dormir mais.";
		        } else {
		            qualidadeSono = "Sua quantidade de sono está acima da faixa recomendada. Tente ajustar.";
		        }

		        diario.adicionarDicaQualidadeSono(dica);
		        String mensagem = "Dica adicionada com sucesso!\n\nAqui estão algumas sugestões para melhorar a qualidade do sono:\n\n";
		        
		        // Add user’s ideal sleep duration and quality
		        mensagem += "👉 Sua Quantidade Ideal de Sono: " + quantidadeSono + " horas.\n";
		        mensagem += "👉 Avaliação: " + qualidadeSono + "\n\n";
		        
		        // Recommended sleep duration
		        mensagem += "👉 Duração do Sono: \n";
		        mensagem += "- Para a maioria dos adultos, recomenda-se de 7 a 9 horas de sono por noite.\n\n";
		        
		        // Categorizing tips
		        mensagem += "👉 Hábito Regular:\n";
		        mensagem += "- Mantenha um horário regular de sono, indo para a cama e acordando no mesmo horário todos os dias.\n";
		        mensagem += "- Evite cochilos longos durante o dia, especialmente no final da tarde.\n\n";
		        
		        mensagem += "👉 Ambiente de Sono:\n";
		        mensagem += "- Crie um ambiente tranquilo e escuro; considere usar cortinas blackout.\n";
		        mensagem += "- Mantenha a temperatura do quarto fresca, entre 18°C e 22°C.\n";
		        mensagem += "- Use uma cama confortável e troque de travesseiros e colchão conforme necessário.\n\n";
		        
		        mensagem += "👉 Rotina de Relaxamento:\n";
		        mensagem += "- Estabeleça uma rotina relaxante antes de dormir, como ler, tomar um banho morno ou praticar meditação.\n";
		        mensagem += "- Evite atividades estimulantes, como assistir a filmes de ação ou usar dispositivos eletrônicos antes de dormir.\n\n";
		        
		        mensagem += "👉 Alimentação e Estilo de Vida:\n";
		        mensagem += "- Evite grandes refeições e cafeína perto da hora de dormir.\n";
		        mensagem += "- Limite o consumo de álcool, que pode interferir no sono.\n";
		        mensagem += "- Exercite-se regularmente, mas evite atividades intensas nas horas que antecedem o sono.\n";

		        mensagem += "👉 Considere Profissionais:\n";
		        mensagem += "- Se você tem dificuldades persistentes para dormir, consulte um médico ou especialista em sono para orientação.\n";
		        
		        JOptionPane.showMessageDialog(frame, mensagem, "Sugestões para Qualidade do Sono", JOptionPane.INFORMATION_MESSAGE);
		    } else {
		        JOptionPane.showMessageDialog(frame, "A quantidade de sono não pode ser vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
		    }
		}

	
		private void adicionarDicaAprimoramentoCognitivo() {
		    String mensagem = "Aqui estão algumas sugestões para aprimoramento cognitivo:\n\n";
		    
		    // Categorizing tips
		    mensagem += "👉 Atividades Mentais:\n";
		    mensagem += "- Pratique quebra-cabeças e jogos de raciocínio, como sudoku ou xadrez, para desafiar sua mente.\n";
		    mensagem += "- Experimente aprender uma nova língua ou tocar um instrumento musical; isso estimula diferentes áreas do cérebro.\n";
		    mensagem += "- Considere aplicativos de treino cerebral, como Lumosity ou Peak.\n\n";
		    
		    mensagem += "👉 Aprendizado Contínuo:\n";
		    mensagem += "- Mantenha-se curioso e busque aprender algo novo todos os dias, seja através de livros, documentários ou cursos online.\n";
		    mensagem += "- Participe de discussões em grupo ou clubes de leitura para trocar ideias e aprender com os outros.\n";
		    mensagem += "- Assista a palestras TED para insights sobre diversos tópicos.\n\n";
		    
		    mensagem += "👉 Organização e Anotações:\n";
		    mensagem += "- Faça anotações sobre o que aprendeu; isso ajuda a fixar o conhecimento.\n";
		    mensagem += "- Use técnicas de mnemônica para memorizar informações importantes.\n";
		    mensagem += "- Experimente métodos de organização como mapas mentais para visualizar conexões entre ideias.\n\n";
		    
		    mensagem += "👉 Estilo de Vida Saudável:\n";
		    mensagem += "- Mantenha uma dieta equilibrada, rica em antioxidantes e ômega-3, que ajudam na saúde cerebral.\n";
		    mensagem += "- Durma o suficiente, pois o sono é crucial para a consolidação da memória; estabeleça uma rotina de sono regular.\n";
		    mensagem += "- Beba bastante água, pois a desidratação pode afetar a função cognitiva.\n\n";
		    
		    mensagem += "👉 Exercícios Físicos:\n";
		    mensagem += "- Exercícios regulares não apenas melhoram a saúde física, mas também têm um impacto positivo na função cognitiva.\n";
		    mensagem += "- Experimente atividades como dança, que combinam movimento e aprendizado de novas sequências.\n";
		    
		    // Show the message in a dialog
		    JOptionPane.showMessageDialog(frame, mensagem, "Sugestões para Aprimoramento Cognitivo", JOptionPane.INFORMATION_MESSAGE);
		}


		
		private void adicionarDicaEmpoderamentoPessoal() {
		    String mensagem = "Aqui estão algumas dicas para empoderamento pessoal:\n\n";
		    
		    // Categorizing tips
		    mensagem += "👉 Definição de Metas:\n";
		    mensagem += "- Defina metas alcançáveis e trabalhe nelas de forma consistente.\n";
		    mensagem += "- Divida suas metas em etapas menores para facilitar o progresso.\n";
		    mensagem += "- Use um caderno ou aplicativo para acompanhar seu progresso.\n\n";
		    
		    mensagem += "👉 Autocompaixão e Autocuidado:\n";
		    mensagem += "- Pratique a autocompaixão; trate-se com a mesma gentileza que trataria um amigo.\n";
		    mensagem += "- Reserve tempo para o autocuidado, seja através de hobbies, exercícios ou relaxamento.\n";
		    mensagem += "- Considere incluir práticas como ioga ou meditação na sua rotina.\n\n";
		    
		    mensagem += "👉 Mentalidade Positiva:\n";
		    mensagem += "- Acredite em si mesmo e busque seus objetivos com confiança.\n";
		    mensagem += "- Lembre-se: o poder está dentro de você. Desperte-o e use-o a seu favor.\n";
		    mensagem += "- Confie na sua capacidade de superar desafios e aprender com as experiências.\n";
		    mensagem += "- Mantenha um diário de gratidão para focar nas coisas positivas da vida.\n\n";
		    
		    mensagem += "👉 Resiliência:\n";
		    mensagem += "- Você é mais forte do que imagina; reconheça suas conquistas e aprendizados.\n";
		    mensagem += "- Enfrente adversidades como oportunidades de crescimento e desenvolvimento.\n";
		    mensagem += "- Lembre-se de que pedir ajuda é um sinal de força, não de fraqueza.\n\n";
		    
		    // Show the message in a dialog
		    JOptionPane.showMessageDialog(frame, mensagem, "Sugestões para Empoderamento Pessoal", JOptionPane.INFORMATION_MESSAGE);
		}



	
		public static void main(String[] args) {
			SwingUtilities.invokeLater(AppSaudeMental::new);
		}
	}