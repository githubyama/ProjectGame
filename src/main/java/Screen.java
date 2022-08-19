import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Random;

public class Screen {
    static final char BLOCK = '\u2588';
    public static final TextColor
            WHITE = new TextColor.RGB(255,255,255),
            BLACK = new TextColor.RGB(0,0,0),

            LIGHTBLUE = new TextColor.RGB (0, 255, 255),
            BLUE = new TextColor.RGB(0,0,255),
            YELLOW = new TextColor.RGB(255,255,0),
            GREEN = new TextColor.RGB(0,255,0),
            RED = new TextColor.RGB(255,0,0);



    private char [][] array =new char[80][24]; // remembers the chars in screen

    private DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
    private Terminal terminal;

    public Screen(){
        try {
            terminal = terminalFactory.createTerminal();
            terminal.setCursorVisible(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void putChar(int col, int row, char c){
            putChar(col,row,c,WHITE,BLACK);
    }
    public void putChar(int col, int row, char c,
                              TextColor foreGround, TextColor backGround) {
        try {
            terminal.setCursorPosition(col, row);
            terminal.setForegroundColor(foreGround);
            terminal.setBackgroundColor(backGround);
            terminal.putCharacter(c);
            array[col][row] =c;
            terminal.flush();

            //System.out.println("putchar"+ col + " " + row + " " + c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public KeyStroke getInput()  {
        try {
            return terminal.pollInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public char getChar(int col, int row){

        return array[col][row];

    }

    public void close() throws IOException {
       terminal.close();
    }

    public void flush()  {
        try {
            terminal.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void border() {
        for (int row = 0; row <24; row++) {
            putChar(0, row, BLOCK, RED, BLACK);
            putChar(79, row, BLOCK, RED, BLACK);
        }
        for (int col = 0; col <80; col++) {
            putChar(col, 0, BLOCK, RED, BLACK);
            putChar(col, 23, BLOCK, RED, BLACK);
        }
    }
}
