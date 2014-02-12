/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listassimplementeligadas;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextArea;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.layout.LinearLayout;

import com.googlecode.lanterna.terminal.TerminalSize;

/**
 * Clase que permite mostrar un menu con las opciones para ejemplificar las listas
 * simplemente ligadas
 * @author leon
 */
public class ListasSimplementeLigadas {

    /**
     * Método estático Mail
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        final Lista<Integer> lista = new Lista<Integer>();
        final GUIScreen guiScreen = TerminalFacade.createGUIScreen();
        guiScreen.getScreen().startScreen();
        final Window window1 = new Window("Ejemplo de Listas Simplemente Ligadas");
        final Label label = new Label("Este programa demuestra el uso de listas simplemente ligadas.");
        Button insertStartButton = new Button("Inserta al Inicio", new Action() {
            @Override
            public void doAction() {
                insertaNodoEnLista(lista, guiScreen, 1);//textArea.appendLine(appendBox.getText());                
            }
        });
        Button exitButton = new Button("Salir", new Action() {

            @Override
            public void doAction() {
                window1.close();
            }
        });
        window1.addComponent(label);
        window1.addComponent(insertStartButton);
        window1.addComponent(new Button("Inserta al final", new Action() {
            @Override
            public void doAction() {
                insertaNodoEnLista(lista, guiScreen, 2);//textArea.appendLine(appendBox.getText());                
            }
        }));
        window1.addComponent(new Button("Inserta antes de un nodo determinado", new Action() {
            @Override
            public void doAction() {
                insertaNodoEnLista(lista, guiScreen, 3);//textArea.appendLine(appendBox.getText());                
            }
        }));
        window1.addComponent(new Button("Inserta despues de un nodo determinado", new Action() {
            @Override
            public void doAction() {
                insertaNodoEnLista(lista, guiScreen, 4);//textArea.appendLine(appendBox.getText());                
            }
        }));
        window1.addComponent(new Button("Borrar al inicio", new Action() {
            @Override
            public void doAction() {
                insertaNodoEnLista(lista, guiScreen, 5);
            }
        }));
        window1.addComponent(new Button("Borrar al final", new Action() {
            @Override
            public void doAction() {
                insertaNodoEnLista(lista, guiScreen, 6);
            }
        }));
        window1.addComponent(new Button("Limpiar lista", new Action() {
            @Override
            public void doAction() {
                lista.clear();
            }
        }));
        window1.addComponent(new Button("Generar una lista de ejemplo", new Action() {
            @Override
            public void doAction() {
                lista.clear();
                lista.insertaFinal(1);
                lista.insertaFinal(2);
                lista.insertaFinal(3);
                lista.insertaFinal(4);
                lista.insertaFinal(5);
            }
        }));
        window1.addComponent(exitButton);
        guiScreen.showWindow(window1, GUIScreen.Position.CENTER);
        guiScreen.getScreen().stopScreen();

        //System.out.println(lista);
        //testTerminal();
        System.out.println("Bye bye");

    }

    /**
     * Muestra una cadena en pantalla
     * @param lugar El mensaje a mostrar
     * @return 
     */
    private static String muestraLugar(Integer lugar) {
        String resultado = null;
        switch (lugar) {
            case 1:
                resultado = "Vamos a crear una lista ligada insertando cada elemento por el inicio de la lista";
                break;
            case 2:
                resultado = "Vamos a crear una lista ligada insertando cada elemento por el final de la lista";
                break;
            case 3:
                resultado = "Vamos a insertar un elemento antes de otro como referencia";
                break;
            case 4:
                resultado = "Vamos a insertar un elemento despues de otro como referencia";
                break;
            case 5:
                resultado = "Vamos a borrar el primer elemento de la lista";
                break;
            case 6:
                resultado = "Vamos a borrar el último elemento de la lista";
                break;
        }
        return resultado;
    }

    /**
     * Este metodo es el genérico para insertar elementos a la lista.
     * @param lista Una clase que implemente una lista ligada
     * @param guiScreen Liberías de uso de pantalla
     * @param lugar 1 Inicio, 2 Final, 3 Antes de 4 Despues de
     */
    public static void insertaNodoEnLista(final Lista<Integer> lista, final GUIScreen guiScreen, final Integer lugar) {

        final Window window1 = new Window("Listas simplemente ligadas");
        final TextArea textArea = new TextArea(lista.generaStringComoLista());
        final Label label = new Label(muestraLugar(lugar));
        textArea.setMaximumSize(new TerminalSize(80, 10));

        window1.addComponent(label);
        window1.addComponent(textArea);
        window1.addComponent(new EmptySpace(1, 1));
        Panel appendPanel = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
        ((LinearLayout) appendPanel.getLayoutManager()).setPadding(1);

        final TextBox appendBox = new TextBox("", 10);
        final TextBox placeBox = new TextBox("", 10);
        Button appendButton = new Button("Agregar o borrar nodo", new Action() {
            @Override
            public void doAction() {
                //textArea.appendLine(appendBox.getText());
                switch (lugar) {
                    case 1:
                        lista.insertaInicio(Integer.parseInt(appendBox.getText()));
                        break;
                    case 2:
                        lista.insertaFinal(Integer.parseInt(appendBox.getText()));
                        break;
                    case 3:
                        try {
                            lista.insertaAntesDato(Integer.parseInt(appendBox.getText()), Integer.parseInt(placeBox.getText()));
                        } catch (LinkedListException ex) {
                            MessageBox.showMessageBox(guiScreen, "Error", ex.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            lista.insertaDespuesDato(Integer.parseInt(appendBox.getText()), Integer.parseInt(placeBox.getText()));
                        } catch (LinkedListException ex) {
                            MessageBox.showMessageBox(guiScreen, "Error", ex.getMessage());
                        }
                        break;
                    case 5:
                        lista.borrarPrimerElemento();
                        break;
                    case 6:
                        lista.borrarUltimoElemento();
                        break;
                }

                textArea.clear();
                textArea.appendLine(lista.generaStringComoLista());
                System.out.println("LISTA:" + lista.generaStringComoLista());

            }
        });
        Button exitButton = new Button("Salir", new Action() {

            @Override
            public void doAction() {
                window1.close();
            }
        });
        if (lugar != 5 && lugar != 6) {
          appendPanel.addComponent(new Label("Dato"));
          appendPanel.addComponent(appendBox);
        }
        if (lugar == 3 || lugar == 4) {
            appendPanel.addComponent(new Label("Referencia"));
            appendPanel.addComponent(placeBox);
        }
        appendPanel.addComponent(appendButton);
        window1.addComponent(appendPanel);
        window1.addComponent(exitButton);

        guiScreen.showWindow(window1, GUIScreen.Position.CENTER);

    }

}
