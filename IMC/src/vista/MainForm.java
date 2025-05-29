package vista;

import javax.swing.*;
import java.awt.*;
import controlador.IMCController;

public class MainForm extends JFrame {

    private JTextField txtNombre, txtEdad, txtPeso, txtTalla;
    private JLabel lblResultado;
    private IMCController controller;

    public MainForm() {
        controller = new IMCController();

        setTitle("Calculadora IMC");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 30, 200, 25);
        add(txtNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(30, 70, 100, 25);
        add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(140, 70, 200, 25);
        add(txtEdad);

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setBounds(30, 110, 100, 25);
        add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(140, 110, 200, 25);
        add(txtPeso);

        JLabel lblTalla = new JLabel("Talla (m):");
        lblTalla.setBounds(30, 150, 100, 25);
        add(lblTalla);

        txtTalla = new JTextField();
        txtTalla.setBounds(140, 150, 200, 25);
        add(txtTalla);

        JButton btnCalcular = new JButton("Calcular IMC");
        btnCalcular.setBounds(30, 200, 150, 30);
        add(btnCalcular);

        JButton btnHistorial = new JButton("Ver Historial");
        btnHistorial.setBounds(190, 200, 150, 30);
        add(btnHistorial);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(350, 200, 100, 30);
        add(btnLimpiar);

        lblResultado = new JLabel();
        lblResultado.setBounds(30, 250, 400, 30);
        add(lblResultado);

        // Acciones
        btnCalcular.addActionListener(e -> calcularIMC());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnHistorial.addActionListener(e -> new vista.HistorialForm(controller).setVisible(true));
    }

    private void calcularIMC() {
        limpiarColores();
        String nombre = txtNombre.getText().trim();
        String edadStr = txtEdad.getText().trim();
        String pesoStr = txtPeso.getText().trim();
        String tallaStr = txtTalla.getText().trim();

        boolean valido = true;
        int edad = 0;
        double peso = 0, talla = 0;

        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            txtNombre.setBackground(Color.PINK);
            valido = false;
        }

        try {
            edad = Integer.parseInt(edadStr);
            if (edad <= 0) throw new Exception();
        } catch (Exception e) {
            txtEdad.setBackground(Color.PINK);
            valido = false;
        }

        try {
            peso = Double.parseDouble(pesoStr);
            if (peso <= 0) throw new Exception();
        } catch (Exception e) {
            txtPeso.setBackground(Color.PINK);
            valido = false;
        }

        try {
            talla = Double.parseDouble(tallaStr);
            if (talla <= 0) throw new Exception();
        } catch (Exception e) {
            txtTalla.setBackground(Color.PINK);
            valido = false;
        }

        if (!valido) {
            lblResultado.setText("Corrige los campos en rojo.");
            return;
        }

        boolean registrado = controller.registrarPersona(nombre, edad, peso, talla);
        if (registrado) {
            lblResultado.setText("Persona registrada correctamente.");
        } else {
            lblResultado.setText("Error al registrar la persona.");
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEdad.setText("");
        txtPeso.setText("");
        txtTalla.setText("");
        lblResultado.setText("");
        limpiarColores();
    }

    private void limpiarColores() {
        txtNombre.setBackground(Color.WHITE);
        txtEdad.setBackground(Color.WHITE);
        txtPeso.setBackground(Color.WHITE);
        txtTalla.setBackground(Color.WHITE);
    }
}



  

