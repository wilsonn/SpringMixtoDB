package com.whnm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whnm.model.Persona;
import com.whnm.service.PersonaService;
import com.whnm.service.impl.PersonaServiceImpl;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		PersonaService personaService = context.getBean(PersonaServiceImpl.class);
		
		Persona persona = new Persona();
		persona.setNombres("Elvia");
		persona.setApellidos("Abad");
		personaService.create(persona);
		
		personaService.listAll().forEach(x -> {System.out.println(x.toString());});		
		
		personaService.delete(35);
		
		((ConfigurableApplicationContext)context).close();
	}
}
