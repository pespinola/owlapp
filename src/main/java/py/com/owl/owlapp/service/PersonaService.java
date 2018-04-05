package py.com.owl.owlapp.service;

import java.util.List;

import py.com.owl.owlapp.domain.Persona;

//Qué debo hacer, no cómo.
public interface PersonaService {

	Persona insert(Persona persona);

	List<Persona> getList();

	Persona findOne(String cedula);

	Persona findOne(Long id);

	void delete(Persona persona);

}
