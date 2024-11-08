package capitulo_3;

public class Pilha_Recursiva {

        public static void main(String[] args) {

            for(int i = 0; i < 9; i++)

                System.out.println("fatorial(" + i + ") = " + fatorial(i));

        }

        public static long fatorial(int n) {

            if( n < 2 )
                return 1;
            return n*fatorial(n-1);
        }

    }



