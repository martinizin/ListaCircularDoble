import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaGUI {
    private JTextField textField1;
    private JButton INSERTARELEMENTOButton;
    private JButton ELIMINARELEMENTOButton;
    private JButton BUSCARELEMENTOButton;
    private JTextArea textArea1;
    private JPanel pGeneral;
    private JTextArea textArea2;
    private JButton ORDENARButton;
    private JButton LIMPIARButton;
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

                    // Actualizar textArea2 para mostrar los elementos actuales de la lista
                    textArea2.setText(lista.imprimirLista());
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
                    textArea1.setText("Elemento " + dato + " eliminado.");

                    // Actualizar textArea2 para mostrar los elementos actuales de la lista
                    textArea2.setText(lista.imprimirLista());
                } catch (NumberFormatException ex) {
                    textArea1.setText("Ingrese un valor válido.");
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
        ORDENARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.ordenar();
                actualizarResultado();
            }

        });
        LIMPIARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                textArea2.setText("");

            }
        });
    }
    private void actualizarResultado() {
        textArea2.setText("Lista: " + lista.imprimirLista());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ListaGUI");
        frame.setContentPane(new ListaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
