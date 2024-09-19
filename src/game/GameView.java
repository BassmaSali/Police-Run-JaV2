package game;
import Entities.Character;
import Levels.GameLevel;
import city.cs.engine.UserView;
import org.jbox2d.common.Vec2;
import java.awt.*;
import javax.swing.*;

/**
 * Represents the view of the game world.
 * This class extends the {@link UserView} class to provide a custom view
 * of the game world. It displays the background image, character status,
 * collected gems, and other game elements.
 */
public class GameView extends UserView {
    private Image background;

    private Character character;
    private Image[] gemImages;

    /**
     * Constructs a new GameView object with the specified parameters.
     * @param level     The GameLevel object representing the game world.
     * @param width     The width of the view.
     * @param height    The height of the view.
     * @param character The character object to be displayed in the view.
     */
    public GameView(GameLevel level, int width, int height, Character character) {
        super(level, width, height);
        this.character = character;


        // Adding background image
        background = new ImageIcon("data/Level1/Forest_backg.png").getImage();

        gemImages = new Image[]{
                new ImageIcon("data/Both/red_gem.gif").getImage(),
                new ImageIcon("data/Both/blue_gem.gif").getImage(),
                new ImageIcon("data/Both/green_gem.gif").getImage()
        };


    }

    /**
     * Sets the background image of the view.
     * @param imagePath The file path of the background image.
     */
    public void setBackground(String imagePath) {
        background = new ImageIcon(imagePath).getImage();
    }

    /**
     * Sets the character object to be displayed in the view.
     * @param character The character object.
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * Paints the background image of the view.
     * @param g The graphics context.
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);

    }

    // Font used for text in view
    public static final Font DefaultFont = new Font("Monospaced", Font.BOLD, 15);


    /**
     * Paints the foreground image of the view.
     * @param g The graphics context.
     */
    @Override
    protected void paintForeground(Graphics2D g) {

        // Get the position of the center of the character
        Vec2 characterPosition = character.getPosition();
        // Set the center of the view based on the position of the character
        setCentre(new Vec2(characterPosition.x, characterPosition.y + 6));
        // Adjust zoom
        setZoom(22);

        // Flashlight tracker
        ImageIcon lightIcon = new ImageIcon("data/Both/Flashlight_Off.png");
        Image lightImage = lightIcon.getImage();

        int flashlightsLeft = character.getLights();
        int barWidth = 200;
        int lightMax = 5;

        g.drawImage(lightImage, 20, 40, 30, 30, this);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(50, 45, barWidth, 13);

        // Draw the filled in bar
        int lightFilledWidth = (barWidth / lightMax) * flashlightsLeft;
        g.setColor(Color.BLUE);
        g.fillRect(50, 45, lightFilledWidth, 13);




        // Creating coins collected variables
        ImageIcon coinsIcon = new ImageIcon("data/Both/Coin.png");
        Image coinsImage = coinsIcon.getImage();

        int coinsCollected = character.getTotalCoins();
        int barWidth2 = 200;
        int coinDefault = 9;

        g.drawImage(coinsImage, 520, 25, 25, 25, this);

        // Draw the bar
        g.setColor(Color.DARK_GRAY);
        g.fillRect(550, 30, barWidth2, 13);

        // Draw the filled in bar
        int coinsFilledWidth = (barWidth2 / coinDefault) * coinsCollected;
        g.setColor(Color.YELLOW);
        g.fillRect(550, 30, coinsFilledWidth, 13);



        // Lives tracker

        ImageIcon livesIcon = new ImageIcon("data/Both/Heart.png");
        Image livesImage = livesIcon.getImage();

        int livesLeft = character.getLives();
        int livesWidth = 30;
        int livesHeight = 30;


        for (int i = 0; i < livesLeft; i++) {
            int x = 550 + (livesWidth + 5) * i;
            int y = 60;

            // Draw the heart image
            g.drawImage(livesImage, x, y, livesWidth, livesHeight, this);
        }

        // Gems tracker

        int gemWidth = 32;
        int gemHeight = 32;
        int gemsCollected = character.getTotalGems();

        for (int i = 0; i < gemsCollected; i++) {
            int x = 50 + (gemWidth + 5) * i;
            int y = 10; // Adjust as needed
            g.drawImage(gemImages[i], x, y, gemWidth, gemHeight, this);
        }
    }

}