package com.example;
import java.io.IOException;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


/**
 * Creates a TerminalScreen and a TextGraphics from it and writes a rectangle
 * from the character '*'
 *
 * @author Peter Borkuti
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);

        screen.startScreen();
        screen.clear();

        for (int i = 0; i < 10; ++i) {
            screen.setCharacter(10, i, new TextCharacter('*'));
            screen.newTextGraphics().putString(2, i, "cloud");
            screen.newTextGraphics().putString(20, 31, "6666/9999");
            screen.newTextGraphics().setForegroundColor(new TextColor.RGB(255, 0, 0)).putString(26, 32, "---");
            screen.newTextGraphics().setForegroundColor(new TextColor.RGB(0, 100, 255)).putString(20, 32, "------");

            screen.refresh();

            try {
                Thread.sleep(1000);
            }
            catch (Exception e)
            {}
        }

        screen.readInput();
        screen.stopScreen();
    }

}
