package capitulo_3;

public class Pilha_Chamada {

        public static void main(String[] args) {
            // Chama o método sauda passando o nome como argumento
            sauda("Maria");
        }

        public static void sauda(String nome) {
            System.out.println("Olá, " + nome + "!");
            sauda2(nome);
            System.out.println("preparando para dizer tchau...");
            tchau();
        }

        public static void sauda2(String nome) {
            System.out.println("Como vai " + nome + "?");
        }

        public static void tchau() {
            System.out.println("ok, tchau!");
        }
    }


