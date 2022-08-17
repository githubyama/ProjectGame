import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.sun.source.tree.WhileLoopTree;

import java.io.IOException;
import java.util.Random;

public class GameFrame {

    Obstacle obstacle;
    static final char OBSTACLE = 'X';
    static final char SPACESHIP = (Symbols.TRIANGLE_UP_POINTING_BLACK);
    public GameFrame () {
        screen.border();
        screen.putChar(20,21, SPACESHIP, Screen.GREEN, Screen.BLACK);
        obstacle = new Obstacle(new Position(10, 15));
        screen.putChar(obstacle.p.x, obstacle.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);
    }

    private Screen screen = new Screen();

    Position spaceShipPosition = new Position(20, 21);



    void keyStroke () throws Exception {

        KeyStroke latestKeyStroke = null;

        boolean continueReadingInput = true;
        while (continueReadingInput) {

            int index = 0;
            KeyStroke keyStroke = null;
            do {
                index++;
                if (index % 25 == 0) {
                    if (latestKeyStroke != null) {
                        handleSpaceShip(spaceShipPosition, latestKeyStroke);
                        moveObstacles();
                    }
                }

                Thread.sleep(5); // might throw InterruptedException
                keyStroke = screen.getInput();


            } while (keyStroke == null);
            latestKeyStroke = keyStroke;
        }
    }

    private void moveObstacles() {
        screen.putChar(obstacle.p.x, obstacle.p.y, ' ', Screen.BLACK, Screen.BLACK);
        obstacle.p.y++;
        if (obstacle.p.y > 22) {
            obstacle.p.y = 2;
        }
        screen.putChar(obstacle.p.x, obstacle.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

    }

    private void handleSpaceShip(Position spaceShipPosition, KeyStroke keyStroke) {

            // Handle player
            Position oldPosition = new Position(spaceShipPosition.getX(), spaceShipPosition.getY());
            switch (keyStroke.getKeyType()) {
                case ArrowDown:
                    spaceShipPosition.y += 1;
                    break;
                case ArrowUp:
                    spaceShipPosition.y -= 1;
                    break;
                case ArrowRight:
                    spaceShipPosition.x += 1;
                    break;
                case ArrowLeft:
                    spaceShipPosition.x -= 1;
                    break;

            }
            if (screen.getChar(spaceShipPosition.x, spaceShipPosition.y) == screen.BLOCK) {
                spaceShipPosition.x = oldPosition.x;
                spaceShipPosition.y = oldPosition.y;

            } else if (screen.getChar(spaceShipPosition.x, spaceShipPosition.y) == OBSTACLE) {
                System.out.println("Game Over!");
                System.exit(0);

            } else {

                screen.putChar(oldPosition.x, oldPosition.y, ' ');
                screen.putChar(spaceShipPosition.x, spaceShipPosition.y, SPACESHIP, screen.GREEN, screen.BLACK);

            }
        }




       /* terminal.setCursorPosition(oldPosition.x, oldPosition.y);
        terminal.putCharacter(' ');

        terminal.setCursorPosition(spaceShip.x, spaceShip.y);
        terminal.putCharacter(Symbols.TRIANGLE_UP_POINTING_BLACK);


        terminal.flush();*/
    }
