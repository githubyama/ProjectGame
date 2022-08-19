import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.sun.source.tree.WhileLoopTree;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class GameFrame {
    Instant startTime;
    Instant endTime;
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
// second round of obstacles
    Obstacle obstacle11;
    Obstacle obstacle12;
    Obstacle obstacle13;
    Obstacle obstacle14;
    Obstacle obstacle15;
    Obstacle obstacle16;
    Obstacle obstacle17;
    Obstacle obstacle18;
    Obstacle obstacle19;
    Obstacle obstacle20;


    static final char OBSTACLE = Symbols.SOLID_SQUARE;
    static final char SPACESHIP = (Symbols.TRIANGLE_UP_POINTING_BLACK);


    private Random random = new Random();



    //public static int random() {
    //    return  ThreadLocalRandom.current(().nextInt();
   // }

    public GameFrame () {
        screen.border();
        screen.putChar(20, 21, SPACESHIP, Screen.LIGHTBLUE, Screen.BLACK);

        obstacle = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle.p.x, obstacle.p.y, OBSTACLE, Screen.BLUE, Screen.BLACK);

        obstacle2 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle2.p.x, obstacle2.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle3 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle3.p.x, obstacle3.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle4 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle4.p.x, obstacle4.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle5 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle5.p.x, obstacle5.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle6 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle6.p.x, obstacle6.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle7 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle7.p.x, obstacle7.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle8 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle8.p.x, obstacle8.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle9 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle9.p.x, obstacle9.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle10 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle10.p.x, obstacle10.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

// Second group of obstacles

        obstacle11 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle11.p.x, obstacle11.p.y, OBSTACLE, Screen.BLUE, Screen.BLACK);

        obstacle12 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle12.p.x, obstacle12.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle13 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle13.p.x, obstacle13.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle14 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle14.p.x, obstacle14.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle15 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle15.p.x, obstacle15.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle16 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle16.p.x, obstacle16.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle17 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle17.p.x, obstacle17.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle18 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle18.p.x, obstacle18.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle19 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle19.p.x, obstacle19.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

        obstacle20 = new Obstacle(new Position(ThreadLocalRandom.current().nextInt(2,77), ThreadLocalRandom.current().nextInt(2,22)));
        screen.putChar(obstacle20.p.x, obstacle20.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);

    }
    private Screen screen = new Screen();

    Position spaceShipPosition = new Position(20, 21);



    void keyStroke () throws Exception {

        KeyStroke latestKeyStroke = null;

        startTime = Instant.now();

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
        screen.putChar(obstacle.p.x, obstacle.p.y, ' ', Screen.BLUE, Screen.BLACK);
        obstacle.p.y++;
        obstacle.p.x++;
        if (obstacle.p.y > 22) {
            obstacle.p.y = 2;
        }
        if (obstacle.p.x > 78) {
            obstacle.p.x = 2;
        }
        screen.putChar(obstacle.p.x, obstacle.p.y, OBSTACLE, Screen.BLUE, Screen.BLACK);

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

//OBSTACLE 10

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


//OBSTACLE 11
        screen.putChar(obstacle11.p.x, obstacle11.p.y, ' ', Screen.BLUE, Screen.BLACK);
        obstacle11.p.y++;
        obstacle11.p.x++;
        if (obstacle11.p.y > 22) {
            obstacle11.p.y = 2;
        }
        if (obstacle11.p.x > 78) {
            obstacle11.p.x = 2;
        }
        screen.putChar(obstacle11.p.x, obstacle11.p.y, OBSTACLE, Screen.BLUE, Screen.BLACK);

//OBSTACLE 12
        screen.putChar(obstacle12.p.x, obstacle12.p.y, ' ', Screen.YELLOW, Screen.BLACK);
        obstacle12.p.y++;
        obstacle12.p.x--;
        if (obstacle12.p.y > 22) {
            obstacle12.p.y = 2;
        }
        if (obstacle12.p.x < 2) {
            obstacle12.p.x = 78;
        }
        screen.putChar(obstacle12.p.x, obstacle12.p.y, OBSTACLE, Screen.YELLOW, Screen.BLACK);

//OBSTACLE 13
        screen.putChar(obstacle13.p.x, obstacle13.p.y, ' ', Screen.BLACK, Screen.BLACK);
        obstacle13.p.y++;
        if (obstacle13.p.y > 22) {
            obstacle13.p.y = 2;
        }
        screen.putChar(obstacle13.p.x, obstacle13.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);
//OBSTACLE 14

        screen.putChar(obstacle14.p.x, obstacle14.p.y, ' ', Screen.BLACK, Screen.BLACK);
        obstacle14.p.y++;
        if (obstacle14.p.y > 22) {
            obstacle14.p.y = 2;

        }
        screen.putChar(obstacle14.p.x, obstacle14.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);
//OBSTACLE 15
        screen.putChar(obstacle15.p.x, obstacle15.p.y, ' ', Screen.BLACK, Screen.BLACK);
        obstacle15.p.y++;
        if (obstacle15.p.y > 22) {
            obstacle15.p.y = 2;

        }
        screen.putChar(obstacle15.p.x, obstacle15.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);
//OBSTACLE 16
        screen.putChar(obstacle16.p.x, obstacle16.p.y, ' ', Screen.BLACK, Screen.BLACK);
        obstacle16.p.y++;
        if (obstacle16.p.y > 22) {
            obstacle16.p.y = 2;

        }
        screen.putChar(obstacle16.p.x, obstacle16.p.y, OBSTACLE, Screen.WHITE, Screen.BLACK);
//OBSTACLE 17

        screen.putChar(obstacle17.p.x, obstacle17.p.y, ' ', Screen.GREEN, Screen.BLACK);
        obstacle17.p.y++;
        obstacle17.p.x++;
        if (obstacle17.p.y > 22) {
            obstacle17.p.y = 2;
        }
        if (obstacle17.p.x > 78) {
            obstacle17.p.x = 2;
        }
        screen.putChar(obstacle17.p.x, obstacle17.p.y, OBSTACLE, Screen.GREEN, Screen.BLACK);

//OBSTACLE 18

        screen.putChar(obstacle18.p.x, obstacle18.p.y, ' ', Screen.YELLOW, Screen.BLACK);
        obstacle18.p.y++;
        obstacle18.p.x--;
        if (obstacle18.p.y > 22) {
            obstacle18.p.y = 2;
        }
        if (obstacle18.p.x < 2) {
            obstacle18.p.x = 78;
        }
        screen.putChar(obstacle18.p.x, obstacle18.p.y, OBSTACLE, Screen.YELLOW, Screen.BLACK);

//OBSTACLE 19

        screen.putChar(obstacle19.p.x, obstacle19.p.y, ' ', Screen.YELLOW, Screen.BLACK);
        obstacle19.p.y++;
        obstacle19.p.x--;
        if (obstacle19.p.y > 22) {
            obstacle19.p.y = 2;
        }
        if (obstacle19.p.x < 2) {
            obstacle19.p.x = 78;
        }
        screen.putChar(obstacle19.p.x, obstacle19.p.y, OBSTACLE, Screen.YELLOW, Screen.BLACK);

//OBSTACLE 20

        screen.putChar(obstacle20.p.x, obstacle20.p.y, ' ', Screen.GREEN, Screen.BLACK);
        obstacle20.p.y++;
        obstacle20.p.x++;
        if (obstacle20.p.y > 22) {
            obstacle20.p.y = 2;
        }
        if (obstacle20.p.x > 78) {
            obstacle20.p.x = 2;
        }
        screen.putChar(obstacle20.p.x, obstacle20.p.y, OBSTACLE, Screen.GREEN, Screen.BLACK);


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

                case Escape:
                    endTime = Instant.now();
                    System.out.println("You are quiting the game! You were able to fly for " + Duration.between(startTime, endTime).toSeconds() + " seconds.");
                    System.exit(0);

            }

            if (screen.getChar(spaceShipPosition.x, spaceShipPosition.y) == screen.BLOCK ||
                    screen.getChar(spaceShipPosition.x, spaceShipPosition.y) == OBSTACLE) {

                endTime = Instant.now();

                System.out.println("Game Over! You were able to fly for  " + Duration.between(startTime, endTime).toSeconds() + " seconds.");
                System.exit(0);

            } else {

                screen.putChar(oldPosition.x, oldPosition.y, ' ');
                screen.putChar(spaceShipPosition.x, spaceShipPosition.y, SPACESHIP, screen.LIGHTBLUE, screen.BLACK);

            }
        }




       /* terminal.setCursorPosition(oldPosition.x, oldPosition.y);
        terminal.putCharacter(' ');

        terminal.setCursorPosition(spaceShip.x, spaceShip.y);
        terminal.putCharacter(Symbols.TRIANGLE_UP_POINTING_BLACK);


        terminal.flush();*/
    }
