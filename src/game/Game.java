package game;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import Entities.CharacterController;
import Levels.GameLevel;
import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;
import GUI.MainMenu;

import javax.swing.JFrame;

/**
 * The main entry point for the game.
 * This class initializes and manages the game environment, including the game levels,
 * character controller, game view, and main menu. Handles starting and quitting the game
 * Also handles transitioning between levels
 */
public class Game {

    GameLevel level;
    CharacterController controller;
    public static SoundClip gameMusic;
    private JFrame frame;
    private MainMenu main;

    GameView view;

    /** Initialise a new Game. */
    public Game() {

        showMainMenu();
    }

    /**
     * Starts the game by initializing the game world, view, and controller.
     * Also starts the game music and displays the main game window.
     */
    public void startGame() {

        try {
            gameMusic = new SoundClip("data/Sound/Game_Theme.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }

        //1. make an empty game world
        level = new Level1(this);

        //2. make a view to look into the game world
        view = new GameView(level, 800, 700, level.getCharacter());

        //3. create a Java window (frame) and add the game view to it
        frame = new JFrame("City Game");
        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // Ensures key events are captured by game view
        view.requestFocus();

        // Create a controller to handle keyboard inputs
        controller = new CharacterController(level.getCharacter());
        view.addKeyListener(controller);



        // start our game world simulation!
        level.start();
    }

    /**
     * Displays the main menu of the game.
     */
    public void showMainMenu() {
        main = new MainMenu(this);
        main.setVisible(true);
    }

    /**
     * Moves to the next level.
     * This method is called when the current level is completed.
     */
    public void nextLevel() {
        if (level instanceof Level1) {
            level.stop();
            level = new Level2(this);
            view.setBackground("data/Level2/Forest_Backg2.jpg");
            view.setCharacter(level.getCharacter());
            view.setWorld(level);
            controller.updateCharacter(level.getCharacter());
            level.start();
        }
        else if (level instanceof Level2) {
            level.stop();
            level = new Level3(this);
            view.setBackground("data/Level3/Forest_Backg3.png");
            view.setCharacter(level.getCharacter());
            view.setWorld(level);
            controller.updateCharacter(level.getCharacter());
            level.start();
        } else if (level instanceof Level3) {
            System.out.println("Game done");
            System.exit(0);
        }
    }

    /**
     * Closes the current level and returns to the main menu.
     */
    public void closeLevel() {
        if (frame != null) {
            frame.dispose();
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    showMainMenu();
                }
            });
        }
    }

    /** Run the game.
      * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Create instance of game class
        new Game();
        // Create instance of give focus
        GiveFocus givefocus = new GiveFocus();
    }

}