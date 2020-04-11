package it.intersistemi.corsojava.segreteriauniversitaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.intersistemi.corsojava.segreteriauniversitaria.model.FacoltaDto;
import it.intersistemi.corsojava.segreteriauniversitaria.model.StudenteDto;
import it.intersistemi.corsojava.segreteriauniversitaria.service.FacoltaService;
import it.intersistemi.corsojava.segreteriauniversitaria.service.StudenteService;

@Controller
@RequestMapping("/studente")
public class StudenteController extends CrudController<StudenteDto, Integer, StudenteService>{

	@Autowired
	private FacoltaService facoltaService;

	@Autowired
	public StudenteController(StudenteService studenteService) {
		super(studenteService);
	}

	@RequestMapping(value="/{id}/assignFacolta", method=RequestMethod.GET)
	public String showAssignActivity(@PathVariable("id") Integer matricola, Model model) {
		StudenteDto studenteDto = this.service.findById(matricola);
		model.addAttribute(this.getEntityModelName(), studenteDto);
		model.addAttribute("idMatricola", matricola);
		model.addAttribute("studenteFacoltaList", facoltaService.listStudenteFacolta(matricola));
		Iterable<FacoltaDto> listFacolta = facoltaService.findAll();
		model.addAttribute("facoltaList", listFacolta);
		return "studente/assignFacolta";
	}

	@RequestMapping(value="/{id}/assignFacolta", method=RequestMethod.POST)
	public String saveAssegnaAttivita(@PathVariable("id") Integer matricola,
			@RequestParam(value="idFacolta", required=true) Integer idFacolta,
			Model model) {
		this.facoltaService.assignStudenteFacolta(idFacolta, matricola);
		return "redirect:/studente/"+matricola+"/assignFacolta";
	}

	@RequestMapping(value="/{matricola}/removeFacolta", method=RequestMethod.GET)
	public String removeFacolta(@PathVariable("matricola") Integer matricola,
			@RequestParam(value="idFacolta", required=true) Integer idFacolta,
			Model model) {
		this.facoltaService.removeStudenteFacolta(idFacolta, matricola);
		return "redirect:/studente/"+matricola+"/assignFacolta";
	}

	@Override
	protected String getEntityListModelName() {
		return "studenteList";
	}

	@Override
	protected String getEntityModelName() {
		return "studente";
	}

	@Override
	protected String getListView() {
		return "studente/studenteList";
	}

	@Override
	protected String getDetailsView() {
		return "studente/studenteDetails";
	}

	@Override
	protected String getFormView() {
		return "studente/studenteForm";
	}

	@Override
	protected String getListUrl() {
		return "/studente";
	}
}