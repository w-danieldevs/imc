package controlador;

import modelo.conexion.IMCModel;
import modelo.dao.PersonaDAO;
import modelo.dto.PersonaDTO;

public class IMCController {
	    private PersonaDAO dao = new PersonaDAO();

	    public boolean registrarPersona(String nombre, int edad, double peso, double talla) {
	        if (nombre.isEmpty() || edad <= 0 || peso <= 0 || talla <= 0) return false;

	        double imc = IMCModel.calcular(peso, talla);
	        String conclusion = IMCModel.obtenerConclusion(imc);

	        PersonaDTO persona = new PersonaDTO();
	        persona.setNombre(nombre);
	        persona.setEdad(edad);
	        persona.setPeso(peso);
	        persona.setTalla(talla);
	        persona.setImc(imc);
	        persona.setConclusion(conclusion);

	        dao.guardar(persona);
	        return true;
	    }

	    public java.util.List<PersonaDTO> obtenerHistorial() {
	        return dao.obtenerTodos();
	    }
	


}
