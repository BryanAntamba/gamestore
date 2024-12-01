package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class soporte {
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
        JLabel label = new JLabel("Soporte Tecnico", SwingConstants.CENTER);
        label.setBounds(345, 40, 350, 40);
        label.setForeground(Color.WHITE); // Texto en color blanco
        label.setFont(new Font("Arial", Font.BOLD, 40)); // Fuente adaptable
        // Agregar todos los componentes al panel de fondo
        fondo.add(label);

        JLabel label1 = new JLabel(
                "<html> Si necesitas ayuda estamos disponible para ayudarte en lo que <br> necesites, mandanos un mensaje a nuestro correo para ayudarte: </html>",
                SwingConstants.CENTER);
        label1.setBounds(30, 200, 1000, 40);
        label1.setForeground(Color.WHITE); // Texto en color blanco
        label1.setFont(new Font("Arial", Font.BOLD, 20)); // Fuente adaptable
        fondo.add(label1);

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

        JMenu regresar = new JMenu("Inicio");
        menuBar.add(regresar);
        JMenuItem irInicio = new JMenuItem("Regresar a Inicio");
        regresar.add(irInicio);

        // Acción para el botón de registro
        registro.addActionListener(e -> {
            // Mensaje de registro cancelado
            String cancelMessage = "El registro ha sido cancelado.";

            // Validación para el nombre
            String nombre = null;
            while (true) {
                nombre = JOptionPane.showInputDialog(ventana, "Ingrese un Nombre de Usuario:");
                if (nombre == null) {
                    JOptionPane.showMessageDialog(ventana, cancelMessage, "Registro cancelado",
                            JOptionPane.INFORMATION_MESSAGE);
                    return; // Salir del registro
                }
                if (nombre.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(ventana, "Debe ingresar un Nombre de Usuario.", "Error de registro",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    break;
                }
            }

            String fechaNacimiento;
            while (true) {
                fechaNacimiento = JOptionPane.showInputDialog(ventana, "Ingrese su Fecha de Nacimiento (DD/MM/AAAA):");
                if (fechaNacimiento == null) // Cancelar
                    return;
                if (fechaNacimiento.matches("\\d{8}")) // Validar 8 dígitos
                    break;
                JOptionPane.showMessageDialog(ventana, "Por favor, ingrese una fecha válida de 8 dígitos (DD/MM/AAAA).",
                        "Error de registro", JOptionPane.ERROR_MESSAGE);
            }
            String telefono = null;
            while (true) {
                telefono = JOptionPane.showInputDialog(ventana, "Ingrese su Teléfono:");
                if (telefono == null) {
                    JOptionPane.showMessageDialog(ventana, cancelMessage, "Registro cancelado",
                            JOptionPane.INFORMATION_MESSAGE);
                    return; // Salir del registro
                }
                if (!telefono.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(ventana, "Debe ingresar un número de teléfono válido de 10 dígitos.",
                            "Error de registro", JOptionPane.ERROR_MESSAGE);
                } else {
                    break;
                }
            }

            // Validación para el correo
            String correo = null;
            while (true) {
                correo = JOptionPane.showInputDialog(ventana, "Ingrese su Correo Electrónico:");
                if (correo == null) {
                    JOptionPane.showMessageDialog(ventana, cancelMessage, "Registro cancelado",
                            JOptionPane.INFORMATION_MESSAGE);
                    return; // Salir del registro
                }
                if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                    JOptionPane.showMessageDialog(ventana, "Ingrese su correo correctamente.",
                            "Error de registro", JOptionPane.ERROR_MESSAGE);
                } else {
                    break;
                }
            }
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
                    JOptionPane.showMessageDialog(ventana, "Debe ingresar una contraseña.",
                            "Error de registro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Convertir el arreglo de caracteres a String
                String contraseñaPrivate = new String(contraseña);
                JOptionPane.showMessageDialog(
                        ventana,
                        "Nombre: " + nombre + "\n" + "Fecha de Nacimiento: " + fechaNacimiento + "\n" + "Teléfono: "
                                + telefono + "\n" + "Correo Electrónico: " + correo + "\n" + "Contraseña: "
                                + contraseñaPrivate,
                        "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

                // Actualizar la interfaz gráfica de usuario
                ventana.revalidate();
                ventana.repaint();
            }
        });

        // Configurar el panel como contenido de la ventana
        ventana.setContentPane(fondo);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
