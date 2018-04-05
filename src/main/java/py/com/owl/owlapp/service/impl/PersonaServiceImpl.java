package py.com.owl.owlapp.service.impl;
//Cómo se va a hacer

import java.util.List;

import py.com.owl.owlapp.domain.Persona;
import py.com.owl.owlapp.service.PersonaService;

public class PersonaServiceImpl implements PersonaService {

	@Override
	public Persona insert(Persona persona) {
		BaseDeDato.personaList.add(persona);
		return persona;
	}

	@Override
	public List<Persona> getList() {
		return BaseDeDato.personaList;
	}

	@Override
	public Persona findOne(String cedula) {
		for (Persona per : BaseDeDato.personaList) {
			if (per.getCedula().compareTo(cedula) == 0) {
				return per;
			}
		}
		return null;
	}

	@Override
	public Persona findOne(Long id) {
		for (Persona per : BaseDeDato.personaList) {
			if (per.getId().compareTo(id) == 0) {
				return per;
			}
		}
		return null;
	}

	@Override
	public void delete(Persona persona) {
		BaseDeDato.personaList.remove(persona);
	}

}
