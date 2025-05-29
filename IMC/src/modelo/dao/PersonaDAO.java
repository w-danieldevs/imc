package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import modelo.dto.PersonaDTO;

public class PersonaDAO {
	    private List<PersonaDTO> personas = new ArrayList<>();

	    public void guardar(PersonaDTO persona) {
	        personas.add(persona);
	    }

	    public List<PersonaDTO> obtenerTodos() {
	        return personas;
	    }
	


}
