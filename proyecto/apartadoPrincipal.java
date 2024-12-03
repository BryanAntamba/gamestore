//Clase principal del peroyecto
package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // Crear y configurar el subtítulo
        JLabel label1 = new JLabel(
                "<html>Bienvenido a GameStore donde podrás encontrar los mejores juegos<br>de acción, terror y aventura.</html>",SwingConstants.CENTER);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);

        // Añadir ambos al panel de fondo
        fondo.add(label);
        fondo.add(label1);

        // Listener para ajustar la posición dinámica al redimensionar
        ventana.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int anchoDeVentana = ventana.getWidth();
                label.setBounds((anchoDeVentana - 300) / 2, 40, 300, 40); // Centrado
                label1.setBounds((anchoDeVentana - 800) / 2, 250, 800, 60); // Justo debajo del título
            }
        });

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

        JMenu help = new JMenu("Ayuda");
        JMenuItem soporte = new JMenuItem("Soporte");

        menuBar.add(help);
        help.add(soporte);

        // Menú Usuario
        JMenu cliente = new JMenu("Usuario");
        JMenuItem registro = new JMenuItem("Registrarse");
        cliente.add(registro);
        menuBar.add(cliente);

        soporte.addActionListener(e -> {
            soporteTecnico.VentanaSoporte();
        });
        JMenu responsables = new JMenu("Creadores");
        JMenuItem creadores = new JMenuItem("Esteban");
        creadores.addActionListener(e -> {
            esteban.VentanaCreadorCuatro();
        });
        JMenuItem creadores2 = new JMenuItem("Erick");
        creadores2.addActionListener(e -> {
            erick.VentanaCreadorTres();
        });
        JMenuItem creadores3 = new JMenuItem("David");
        creadores3.addActionListener(e -> {
            david.VentanaCreadorDos();
        });
        JMenuItem creadores4 = new JMenuItem("Bryan");
        creadores4.addActionListener(e -> {
            bryan.VentanaCreadorUno();
        });

        menuBar.add(responsables);
        responsables.add(creadores);
        responsables.add(creadores2);
        responsables.add(creadores3);
        responsables.add(creadores4);
        

        JMenu tabla = new JMenu("tablas");
        JMenuItem tablas = new JMenuItem("visualizar tabla");

        menuBar.add(tabla);
        tabla.add(tablas);
        

        // Acción para "Registrarse"
        registro.addActionListener(e -> {
            System.out.println("Opción de registro seleccionada."); // Depuración
            Registro nuevoUsuario = Registro.realizarRegistro(ventana);
            if (nuevoUsuario != null) {
                JOptionPane.showMessageDialog(
                    ventana,
                    "Registro Exitoso:\n" +
                    "Nombre: " + nuevoUsuario.getNombre() + "\n" +
                    "Fecha de Nacimiento: " + nuevoUsuario.getFechaNacimiento() + "\n" +
                    "Teléfono: " + nuevoUsuario.getTelefono() + "\n" +
                    "Correo: " + nuevoUsuario.getCorreo() + "\n" +
                    "Contraseña: " + nuevoUsuario.getContraseña(), // Aquí incluimos la contraseña
                    "Registro Completado",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        

        ventana.setJMenuBar(menuBar);
        ventana.setVisible(true);
        // Agregar todos los componentes al panel de fondo
        fondo.add(label);

        // Configurar el panel como contenido de la ventana
        ventana.setContentPane(fondo);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }

    public static void apartadoPrincipal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apartadoPrincipal'");
    }
}