
	import java.time.LocalDate;

	public class Emocao {
	    private LocalDate data;
	    private String sentimento;
	    private String descricao;

	    public Emocao(LocalDate data, String sentimento, String descricao) {
	        this.data = data;
	        this.sentimento = sentimento;
	        this.descricao = descricao;
	    }

	    public LocalDate getData() {
	        return data;
	    }

	    public String getSentimento() {
	        return sentimento;
	    }

	    public String getDescricao() {
	        return descricao;
	    }


	    public String toString() {
	        return "Data: " + data + ", Sentimento: " + sentimento + ", Descrição: " + descricao;
	    }

	}

