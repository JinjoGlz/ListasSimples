/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listassimplementeligadas;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.Component.Alignment;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Panel.Orientation;
import com.googlecode.lanterna.gui.component.Table;
import com.googlecode.lanterna.gui.component.TextArea;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.DialogButtons;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.gui.layout.VerticalLayout;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;


import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import java.util.Scanner;
import java.nio.charset.Charset;

/**
 *
 * @author leon
 */
public class ListasSimplementeLigadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
     
     
      insertaInicio();
      //System.out.println(lista);
      //testTerminal();
      System.out.println("Bye bye");
      
    }
    
     /**
     * Este metodo pregunta al usuario
     */   
    public static void insertaInicio(){
      final Lista<Integer> lista = new Lista<Integer>();
      
      final  GUIScreen guiScreen =  TerminalFacade.createGUIScreen();
      guiScreen.getScreen().startScreen();
      final Window window1 = new Window("Listas simplemente ligadas");
      final TextArea textArea = new TextArea(lista.toString());
      final Label label = new Label("Vamos a crear una lista ligada insertando cada elemento por el principio de la lista");
        textArea.setMaximumSize(new TerminalSize(80, 10));
        
        window1.addComponent(label);    
        window1.addComponent(textArea);
         window1.addComponent(new EmptySpace(1, 1));
         Panel appendPanel = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
        ((LinearLayout)appendPanel.getLayoutManager()).setPadding(1);
        final TextBox appendBox = new TextBox("", 30);
        Button appendButton = new Button("Agregar nodo", new Action() {
            @Override
            public void doAction() {
                //textArea.appendLine(appendBox.getText());
                lista.insertaInicio(Integer.parseInt(appendBox.getText()));
                textArea.clear();
                textArea.appendLine(lista.generaStringComoLista());
                System.out.println("LISTA:"+lista.generaStringComoLista());
            }
        });
        appendPanel.addComponent(appendBox);
        appendPanel.addComponent(appendButton);
        window1.addComponent(appendPanel);
        
        guiScreen.showWindow(window1, GUIScreen.Position.CENTER);
        guiScreen.getScreen().stopScreen();
        
        
        Nodo<Integer> nodo;
        Scanner scan = new Scanner(System.in);
        
    }
    
    public static void testTerminal(){
        final GUIScreen guiScreen = TerminalFacade.createGUIScreen();
        final Window window = new Window("Sample window");
        window.setWindowSizeOverride(new TerminalSize(130,50));
        window.setSoloWindow(true);
        
        Panel panelHolder = new Panel("Holder panel",Orientation.VERTICAL);
        
        Panel panel = new Panel("Panel with a right-aligned button");

        panel.setLayoutManager(new VerticalLayout());
        Button button = new Button("Button");
        button.setAlignment(Component.Alignment.RIGHT_CENTER);
        panel.addComponent(button, LinearLayout.GROWS_HORIZONTALLY);
        
        Table table = new Table(6);
        table.setColumnPaddingSize(5);
        
        Component[] row1 = new Component[6];
        row1[0] = new Label("Field-1----");
        row1[1] = new Label("Field-2");
        row1[2] = new Label("Field-3");
        row1[3] = new Label("Field-4");
        row1[4] = new Label("Field-5");
        row1[5] = new Label("Field-6");
        
        table.addRow(row1);
        panel.addComponent(table);
        
        panelHolder.addComponent(panel);

        window.addComponent(panelHolder);
        window.addComponent(new EmptySpace());
        
        final Window newWindow = new Window("This window should be of the same size as the previous one");

        Button quitButton = new Button("Show next window", new Action() {

            public void doAction() {
                
                newWindow.setWindowSizeOverride(new TerminalSize(130,50));
                newWindow.setSoloWindow(true);
                
                               
                
                Button exitBtn = new Button("Exit", new Action() {
                    
                    public void doAction() {
                        // TODO Auto-generated method stub
                        newWindow.close();
                        window.close();
                    }
                });
                
                exitBtn.setAlignment(Alignment.RIGHT_CENTER);
                
                newWindow.addComponent(exitBtn, LinearLayout.GROWS_HORIZONTALLY);
                
                guiScreen.showWindow(newWindow);
            }
        });
        quitButton.setAlignment(Component.Alignment.RIGHT_CENTER);
        window.addComponent(quitButton, LinearLayout.GROWS_HORIZONTALLY);

        guiScreen.getScreen().startScreen();
        guiScreen.showWindow(window);
        guiScreen.getScreen().stopScreen();
    }
    
    public static void testGui(){       
        final  GUIScreen guiScreen =  TerminalFacade.createGUIScreen();
        guiScreen.getScreen().startScreen();
        final Window window1 = new Window("Text window");
        //window1.addComponent(new Widget(1, 1));

        final TextArea textArea = new TextArea("TextArea");
        textArea.setMaximumSize(new TerminalSize(80, 10));
        window1.addComponent(textArea);
        
        window1.addComponent(new EmptySpace(1, 1));
        
        Panel appendPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
        ((LinearLayout)appendPanel.getLayoutManager()).setPadding(1);
        final TextBox appendBox = new TextBox("", 30);
        Button appendButton = new Button("Append", new Action() {
            @Override
            public void doAction() {
                textArea.appendLine(appendBox.getText());
            }
        });
        appendPanel.addComponent(appendBox);
        appendPanel.addComponent(appendButton);
        window1.addComponent(appendPanel);
        
        Panel removePanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
        ((LinearLayout)removePanel.getLayoutManager()).setPadding(1);
        final TextBox removeBox = new TextBox("0", 5);
        Button removeButton = new Button("Remove line", new Action() {
            @Override
            public void doAction() {
                try {
                    int lineNumber = Integer.parseInt(removeBox.getText());
                    textArea.removeLine(lineNumber);
                }
                catch(Exception e) {
                    MessageBox.showMessageBox(guiScreen, e.getClass().getSimpleName(), e.getMessage(), DialogButtons.OK);
                }
            }
        });
        Button clearButton = new Button("Clear text", new Action() {
            @Override
            public void doAction() {
                textArea.clear();
            }
        });
        removePanel.addComponent(removeBox);
        removePanel.addComponent(removeButton);
        removePanel.addComponent(clearButton);
        window1.addComponent(removePanel);
        
        window1.addComponent(new EmptySpace(1, 1));
        
        Panel lastPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
        Button exitButton = new Button("Exit", new Action() {            
            @Override
            public void doAction() {
                window1.close();
            }
        });
        lastPanel.addComponent(new EmptySpace(1, 1), LinearLayout.GROWS_HORIZONTALLY);
        lastPanel.addComponent(exitButton);
        window1.addComponent(lastPanel);
        guiScreen.showWindow(window1, GUIScreen.Position.CENTER);
        guiScreen.getScreen().stopScreen();
    }
    
}
