package capitulo_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ContagemRegressiva2 extends JFrame {
    private JLabel    label;
    private Timer     countdownTimer, explosionTimer;
    private int       segundos = 10;
    private boolean   visivel = true;
    private int       explosaoFrame = 1; // Frame inicial da animação de explosão
    private final int totalFramesExplosao = 6; // Número de imagens de explosão

    public ContagemRegressiva2() {
        setTitle("Contagem Regressiva");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fundo verde
        getContentPane().setBackground(Color.GREEN);

        label = new JLabel("00:10", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 48));
        add(label);

        // Iniciar contagem regressiva
        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (segundos > 0) {
                    segundos--;
                    label.setText(String.format("00:%02d", segundos));
                    visivel = !visivel; // Alternar visibilidade para piscar
                    label.setVisible(visivel);
                } else {
                    iniciarExplosao();
                    countdownTimer.stop();
                }
            }
        });
        countdownTimer.start();
        setVisible(true);
    }

    private void iniciarExplosao() {
        // Animação de explosão: mostra cada quadro da sequência
        explosionTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Carregar e definir a próxima imagem de explosão
                String caminhoImagem = "/home/eber/Imagens/explosao" + explosaoFrame + ".png";
                File arquivoImagem = new File(caminhoImagem);

                if (arquivoImagem.exists()) {
                    ImageIcon explosaoIcon = new ImageIcon(caminhoImagem);
                    label.setIcon(explosaoIcon);
                    label.setText(""); // Remove o texto para exibir a animação
                    explosaoFrame++;
                } else {
                    System.err.println("Imagem não encontrada: " + caminhoImagem);
                    explosionTimer.stop();
                    label.setIcon(null);
                    label.setText("!!! Imagem de explosão não encontrada !!!");
                    label.setForeground(Color.RED);
                    return;
                }

                // Para o timer e exibe a mensagem final após o último quadro
                if (explosaoFrame > totalFramesExplosao) {
                    explosionTimer.stop();
                    label.setIcon(null); // Limpa a imagem
                    label.setText("!!! Tempo Esgotado !!!");
                    label.setForeground(Color.RED);
                }
            }
        });
        explosionTimer.start();
    }

    public static void main(String[] args) {
        new ContagemRegressiva2();
    }
}
