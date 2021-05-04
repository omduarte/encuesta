package com.sic.gov.co.app.controllers;

import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sic.gov.co.app.models.entity.Encuesta;
import com.sic.gov.co.app.models.service.IEncuestaService;
import com.sic.gov.co.app.models.service.IMarcaPcService;

@Controller(value = "/encuesta")
@SessionAttributes("encuesta")
public class EncuestaController {

	@Autowired
	private IEncuestaService encuestaService;
	
	@Autowired
	private IMarcaPcService marcaPcService;

	@GetMapping(value = "/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de encuestas");
		model.addAttribute("encuestas", encuestaService.findAll());
		return "listar";
	}

	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		Encuesta encuesta = new Encuesta();
		model.put("encuesta", encuesta);
		model.put("titulo", "Formulario de encuesta");
		model.put("marcasPc", marcaPcService.findAll());
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Encuesta encuesta, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de encuesta");
			return "form";
		}

		encuesta.setFechaRespuesta(new Date());
		encuestaService.save(encuesta);
		status.setComplete();
		return "redirect:listar";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		Encuesta encuesta = null;
		  
		
		if (id > 0) {
			encuesta = encuestaService.findOne(id);
		} else {
			return "redirect:/listar";
		}

		
		model.put("encuesta", encuesta);
		model.put("titulo", "Editar encuesta");
		model.put("marcasPc", marcaPcService.findAll());
		
		return "form";

	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {

		if (id > 0) {
			encuestaService.delete(id);
		}

		return "redirect:/listar";
	}

}
