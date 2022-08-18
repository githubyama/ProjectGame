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
    Obstacle obstacle2;
    Obstacle obstacle3;
    Obstacle obstacle4;
    Obstacle obstacle5;
    Obstacle obstacle6;
    Obstacle obstacle7;
    Obstacle obstacle8;
    Obstacle obstacle9;
    Obstacle obstacle10;


    static final char OBSTACLE = Symbols.SOLID_SQUARE;
    static final char SPACESHIP = (Symbols.TRIANGLE_UP_POINTING_BLACK);
    private Random random = new Random();



    public GameFrame () {
        screen.border();
        screen.putChar(20, 21, SPACESHIP, Screen.GREEN, Screen.BLACK);

           obstacle = new Obstacle(new Position(random.nextInt(77), random.nextInt(22)));
           screen.putChar(obstacle.p.x, obstacle.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

           obstacle2 = new Obstacle(new Position(random.nextInt(77), random.nextInt(22)));
           screen.putChar(obstacle2.p.x, obstacle2.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle3 = new Obstacle(new Position(random.nextInt(77), random.nextInt(22)));
        screen.putChar(obstacle3.p.x, obstacle3.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle4 = new Obstacle(new Position(random.nextInt(77), random.nextInt(22)));
        screen.putChar(obstacle4.p.x, obstacle4.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle5 = new Obstacle(new Position(random.nextInt(77), random.nextInt(22)));
        screen.putChar(obstacle5.p.x, obstacle5.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle6 = new Obstacle(new Position(random.nextInt(77), random.nextInt(22)));
        screen.putChar(obstacle6.p.x, obstacle6.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle7 = new Obstacle(new Position(random.nextInt(77), random.nextInt(22)));
        screen.putChar(obstacle7.p.x, obstacle7.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle8 = new Obstacle(new Position(random.nextInt(77), random.nextInt(22)));
        screen.putChar(obstacle8.p.x, obstacle8.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle9 = new Obstacle(new Position(random.nextInt(77), random.nextInt(22)));
        screen.putChar(obstacle9.p.x, obstacle9.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle10 = new Obstacle(new Position(random.nextInt(77), random.nextInt(22)));
        screen.putChar(obstacle10.p.x, obstacle10.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

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
//OBSTACLE 1
        screen.putChar(obstacle.p.x, obstacle.p.y, ' ', Screen.GREEN, Screen.BLACK);
        obstacle.p.y++;
        obstacle.p.x++;
        if (obstacle.p.y > 22) {
            obstacle.p.y = 2;
        }
        if (obstacle.p.x > 78) {
            obstacle.p.x = 2;
        }
        screen.putChar(obstacle.p.x, obstacle.p.y, OBSTACLE, Screen.GREEN, Screen.BLACK);

//OBSTACLE 2
        screen.putChar(obstacle2.p.x, obstacle2.p.y, ' ', Screen.YELLOW, Screen.BLACK);
        obstacle2.p.y++;
        obstacle2.p.x--;
        if (obstacle2.p.y > 22) {
            obstacle2.p.y = 2;
        }
        if (obstacle2.p.x < 2) {
            obstacle2.p.x = 78;
        }
        screen.putChar(obstacle2.p.x, obstacle2.p.y, OBSTACLE, Screen.YELLOW, Screen.BLACK);
//OBSTACLE 3
        screen.putChar(obstacle3.p.x, obstacle3.p.y, ' ', Screen.BLACK, Screen.BLACK);
        obstacle3.p.y++;
        if (obstacle3.p.y > 22) {
            obstacle3.p.y = 2;

        }
        screen.putChar(obstacle3.p.x, obstacle3.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);
//OBSTACLE 4
        screen.putChar(obstacle4.p.x, obstacle4.p.y, ' ', Screen.BLACK, Screen.BLACK);
        obstacle4.p.y++;
        if (obstacle4.p.y > 22) {
            obstacle4.p.y = 2;

        }
        screen.putChar(obstacle4.p.x, obstacle4.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);
//OBSTACLE 5
        screen.putChar(obstacle5.p.x, obstacle5.p.y, ' ', Screen.BLACK, Screen.BLACK);
        obstacle5.p.y++;
        if (obstacle5.p.y > 22) {
            obstacle5.p.y = 2;

        }
        screen.putChar(obstacle5.p.x, obstacle5.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);
//OBSTACLE 6
        screen.putChar(obstacle6.p.x, obstacle6.p.y, ' ', Screen.BLACK, Screen.BLACK);
        obstacle6.p.y++;
        if (obstacle6.p.y > 22) {
            obstacle6.p.y = 2;

        }
        screen.putChar(obstacle6.p.x, obstacle6.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);
//OBSTACLE 7

        screen.putChar(obstacle7.p.x, obstacle7.p.y, ' ', Screen.GREEN, Screen.BLACK);
        obstacle7.p.y++;
        obstacle7.p.x++;
        if (obstacle7.p.y > 22) {
            obstacle7.p.y = 2;
        }
            if (obstacle7.p.x > 78) {
                obstacle7.p.x = 2;
            }
            screen.putChar(obstacle7.p.x, obstacle7.p.y, OBSTACLE, Screen.GREEN, Screen.BLACK);

//OBSTACLE 8

            screen.putChar(obstacle8.p.x, obstacle8.p.y, ' ', Screen.YELLOW, Screen.BLACK);
            obstacle8.p.y++;
            obstacle8.p.x--;
            if (obstacle8.p.y > 22) {
                obstacle8.p.y = 2;
            }
                if (obstacle8.p.x < 2) {
                    obstacle8.p.x = 78;
                }
                screen.putChar(obstacle8.p.x, obstacle8.p.y, OBSTACLE, Screen.YELLOW, Screen.BLACK);

//OBSTACLE 9

                screen.putChar(obstacle9.p.x, obstacle9.p.y, ' ', Screen.YELLOW, Screen.BLACK);
                obstacle9.p.y++;
                obstacle9.p.x--;
                if (obstacle9.p.y > 22) {
                    obstacle9.p.y = 2;
                }
                    if (obstacle9.p.x < 2) {
                        obstacle9.p.x = 78;
                    }
                    screen.putChar(obstacle9.p.x, obstacle9.p.y, OBSTACLE, Screen.YELLOW, Screen.BLACK);

//OBSTACLE 7

                    screen.putChar(obstacle10.p.x, obstacle10.p.y, ' ', Screen.GREEN, Screen.BLACK);
                    obstacle10.p.y++;
                    obstacle10.p.x++;
                    if (obstacle10.p.y > 22) {
                        obstacle10.p.y = 2;
                    }
                        if (obstacle10.p.x > 78) {
                            obstacle10.p.x = 2;
                        }
                        screen.putChar(obstacle10.p.x, obstacle10.p.y, OBSTACLE, Screen.GREEN, Screen.BLACK);
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
