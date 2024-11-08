package capitulo_3;

/*public class ContagemRegressiva {

    public static void regressiva(int i) {
        if (i <= 0) { // Condição de parada
            return;
        }
        System.out.println(i);
        regressiva(i - 1); // Chamada recursiva com i - 1
    }

    public static void main(String[] args) {
        int numero = 5; // Número inicial para a contagem regressiva
        regressiva(numero);
    }
}*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContagemRegressiva extends JFrame {
    private JLabel  label;
    private Timer   timer;
    private int     segundos = 10; // Defina o tempo da contagem regressiva em segundos
    private boolean visivel = true; // Para controlar a visibilidade do texto

    public ContagemRegressiva() {
        setTitle("Contagem Regressiva");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Altera a cor de fundo da janela para verde
        getContentPane().setBackground(Color.GREEN);

        label = new JLabel("00:00:05", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 48));
        add(label);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (segundos > 0) {
                    segundos--;
                    label.setText(formatarTempo(segundos));

                    // Alternar a visibilidade do JLabel para fazer o efeito de piscar
                    visivel = !visivel;
                    label.setVisible(visivel);
                } else {
                    label.setText("!!! Tempo Esgotado !!!");
                    label.setForeground(Color.RED);
                    label.setVisible(true); // Garantir que a mensagem final esteja visível
                    timer.stop();
                }
            }
        });
        timer.start();

        setVisible(true);
    }

    private String formatarTempo(int totalSegundos) {
        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    public static void main(String[] args) {
        new ContagemRegressiva();
    }
}
