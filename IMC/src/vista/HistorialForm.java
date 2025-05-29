package vista;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.IMCController;
import modelo.dto.PersonaDTO;

public class HistorialForm extends JFrame {
	    public HistorialForm(IMCController controller) {
	        setTitle("Historial de Personas");
	        setSize(500, 300);
	        setLocationRelativeTo(null);

	        List<PersonaDTO> lista = controller.obtenerHistorial();
	        String[] columnas = {"Nombre", "Edad", "Peso", "Talla", "IMC", "Conclusión"};
	        String[][] datos = new String[lista.size()][6];

	        for (int i = 0; i < lista.size(); i++) {
	            PersonaDTO p = lista.get(i);
	            datos[i][0] = p.getNombre();
	            datos[i][1] = String.valueOf(p.getEdad());
	            datos[i][2] = String.valueOf(p.getPeso());
	            datos[i][3] = String.valueOf(p.getTalla());
	            datos[i][4] = String.format("%.2f", p.getImc());
	            datos[i][5] = p.getConclusion();
	        }

	        JTable table = new JTable(datos, columnas);
	        add(new JScrollPane(table));
	    }
	


}
