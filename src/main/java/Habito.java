	    import java.time.LocalDate;
		import java.util.ArrayList;
		import java.util.List;
		import java.util.Scanner;
		public class Habito {
		    private List<Habito> registroHabitos;
		
		    public Habito() {
		        registroHabitos = new ArrayList<>();
		    }
		
		    public Habito(LocalDate now, String nome, String descricao) {
				// TODO Auto-generated constructor stub
			}
		
			public void adicionarHabito(Habito habito) {
		        registroHabitos.add(habito);
		    }
		
		    public List<Habito> getHabitos() {
		        return registroHabitos;
		    }
		
		    public void mostrarHabitos() {
		        registroHabitos.forEach(System.out::println);
		    }
		}
