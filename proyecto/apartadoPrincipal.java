package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class apartadoPrincipal {
    public static void main(String[] args) {
        // Configuración de la ventana
        JFrame ventana = new JFrame("GameStore");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1000, 700);
        ventana.setLayout(null);// Layout absoluto

        // Configurar el ícono personalizado
        Image icono = Toolkit.getDefaultToolkit().getImage("img/icono.png");
        ventana.setIconImage(icono);

        // Cargar la imagen de fondo
        ImageIcon fondoApp = new ImageIcon("img/principal.jpg"); // Ajusta la ruta según tu estructura de carpetas

        // Crear un JPanel con un fondo personalizado
        JPanel fondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics dimeciones) {
                super.paintComponent(dimeciones);
                dimeciones.drawImage(fondoApp.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Establecer el diseño del panel
        fondo.setLayout(null);

        // Crear y configurar la etiqueta
        // Crear y configurar la etiqueta principal
        JLabel label = new JLabel("GameStore", SwingConstants.CENTER);
        label.setBounds(345, 40, 300, 40);
        label.setForeground(Color.WHITE); // Texto en color blanco
        label.setFont(new Font("Arial", Font.BOLD, 40)); // Fuente adaptable

        JMenuBar menuBar = new JMenuBar();
        // Crear el menú "Salir"
        JMenu salir = new JMenu("Salir");
        JMenuItem cerrarSesion = new JMenuItem("Cerrar Tienda");
        // Se realiza una acción para cerra el sistema inmobiliario
        cerrarSesion.addActionListener(e -> System.exit(0));
        menuBar.add(salir);
        salir.add(cerrarSesion); // Añadir el elemento al menú
        // Añadir los componentes al JFrame
        ventana.setJMenuBar(menuBar);

        JMenu categorias = new JMenu("Categorias");
        JMenuItem productos1 = new JMenuItem("Ascion");
        JMenuItem productos2 = new JMenuItem("Terror");
        JMenuItem productos3 = new JMenuItem("Aventura");

        menuBar.add(categorias);
        categorias.add(productos1);
        categorias.add(productos2);
        categorias.add(productos3);

        JMenu cliente = new JMenu("Usuario");
        JMenuItem registro = new JMenuItem("Registrase");

        menuBar.add(cliente);
        cliente.add(registro);

        JMenu help = new JMenu("Ayuda");
        JMenuItem soporte = new JMenuItem("Soporte");

        menuBar.add(help);
        help.add(soporte);

        // Acción para el botón de registro
        registro.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(ventana, "Ingrese un Nombre de Uusuario:");
            if (nombre == null)
                return;
            String fechaNacimiento = JOptionPane.showInputDialog(ventana,
                    "Ingrese su Fecha de Nacimiento (DD/MM/AAAA):");
            if (fechaNacimiento == null)
                return;
            String telefono = JOptionPane.showInputDialog(ventana, "Ingrese su Teléfono:");
            if (telefono == null)
                return;
            String correo = JOptionPane.showInputDialog(ventana, "Ingrese su Correo Electrónico:");
            if (correo == null)
                return;
            // Crear un JPasswordField para capturar la contraseña
            JPasswordField contraseñaField = new JPasswordField();
            int option = JOptionPane.showConfirmDialog(
                    ventana,
                    contraseñaField,
                    "Ingrese una Contraseña:",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

            if (option == JOptionPane.OK_OPTION) {
                // Obtener la contraseña como un arreglo de caracteres
                char[] contraseña = contraseñaField.getPassword();
                if (contraseña.length == 0) {
                    JOptionPane.showMessageDialog(ventana, "Debe ingresar una contraseña.", "Error en la contraseña",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                 // Convertir el arreglo de caracteres a String
                String contraseñaPrivate = new String(contraseña);
                JOptionPane.showMessageDialog(
                        ventana,
                        "Datos Ingresados:\n" + "Nombre: " + nombre + "\n"+ "Fecha de Nacimiento: " + fechaNacimiento + "\n" + "Teléfono: " + telefono + "\n"+ "Correo Electrónico: " + correo + "\n" + "Contraseña: " + contraseñaPrivate, "Registro procesado", JOptionPane.INFORMATION_MESSAGE);
                // Actualizar la interfaz gráfica de usuario
                ventana.revalidate();
                ventana.repaint();
            }
        });

        // Agregar todos los componentes al panel de fondo
        fondo.add(label);

        // Configurar el panel como contenido de la ventana
        ventana.setContentPane(fondo);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
