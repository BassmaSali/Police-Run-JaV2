package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.Game;

/**
 * The MainMenu class is the main menu GUI of the game.
 * It provides options for starting a new game, loading a saved game, and quitting the game.
 * Also includes instructions on how to play the game.
 */
public class MainMenu extends JFrame {

    private Game game;
    private JButton newGame;
    private JButton loadGame;
    private JButton quitGame;

    /**
     * Constructs a MainMenu object.
     * @param game The Game object associated with the main menu.
     */
    public MainMenu(Game game) {
        this.game = game;
        setTitle("Game Menu");
        setSize(900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel menu = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel title = new JLabel("POLICE RUN");
        title.setFont(new Font("Helvetica", Font.BOLD, 35));
        menu.add(title, gbc);

        gbc.gridy++;
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGame();
                dispose();
            }
        });
        menu.add(newGame, gbc);

        gbc.gridy++;
        JButton quitGame = new JButton("Quit Game");
        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(quitGame, gbc);

        gbc.gridy++;
        JButton instr = new JButton("How to Play\n");
        instr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainMenu.this,
                        "- Use the -> and <- arrow keys to move left and right\n- Press 'Space' to jump\n- Press 'x' to shoot\n");
            }
        });
        menu.add(instr, gbc);

        setContentPane(menu);
        setVisible(true);
    }
}
