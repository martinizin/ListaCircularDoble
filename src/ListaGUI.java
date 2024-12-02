import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaGUI {
    private JTextField textField1;
    private JButton INSERTARELEMENTOButton;
    private JButton ELIMINARELEMENTOButton;
    private JButton BUSCARELEMENTOButton;
    private JButton ORDENARYMOSTRARButton;
    private JTextArea textArea1;
    private JPanel pGeneral;
    private listaCircularDoble lista;


    public ListaGUI() {
        lista = new listaCircularDoble();
        INSERTARELEMENTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField1.getText();
                try {
                    int dato = Integer.parseInt(texto);
                    lista.insertar(dato);
                    textArea1.setText("Elemento " + dato + " insertado.");
                    textField1.setText("");  // Limpiar el campo de texto
                } catch (NumberFormatException ex) {
                    textArea1.setText("Por favor ingrese un número válido.");
                }

            }
        });

        ELIMINARELEMENTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField1.getText();
                try {
                    int dato = Integer.parseInt(texto);
                    lista.eliminar(dato);
                    textField1.setText("");  // Limpiar el campo de texto
                } catch (NumberFormatException ex) {
                    textArea1.setText("Ingrese un valor válido:");
                }
            }
        });

        BUSCARELEMENTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField1.getText();
                try {
                    int dato = Integer.parseInt(texto);
                    boolean encontrado = lista.buscar(dato);
                    if (encontrado) {
                        textArea1.setText("Elemento " + dato + " encontrado.");
                    } else {
                        textArea1.setText("Elemento " + dato + " no encontrado.");
                    }
                    textField1.setText("");  // Limpiar el campo de texto
                } catch (NumberFormatException ex) {
                    textArea1.setText("Ingrese un valor válido.");
                }
            }
        });

        ORDENARYMOSTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField1.getText();
                if (texto.equalsIgnoreCase("ascendente")) {
                    lista.ordenar(true);  // Orden ascendente
                    textArea1.setText("Lista ordenada ascendentemente.");
                } else if (texto.equalsIgnoreCase("descendente")) {
                    lista.ordenar(false);  // Orden descendente
                    textArea1.setText("Lista ordenada descendentemente.");
                } else {
                    textArea1.setText("Por favor ingrese 'ascendente' o 'descendente' en el campo de texto.");
                }
                textField1.setText("");  // Limpiar el campo de texto
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ListaGUI");
        frame.setContentPane(new ListaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
