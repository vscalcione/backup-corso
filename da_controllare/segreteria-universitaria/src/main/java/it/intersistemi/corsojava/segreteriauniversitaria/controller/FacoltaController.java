package it.intersistemi.corsojava.segreteriauniversitaria.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.intersistemi.corsojava.segreteriauniversitaria.model.FacoltaDto;
import it.intersistemi.corsojava.segreteriauniversitaria.service.FacoltaService;
import it.intersistemi.corsojava.segreteriauniversitaria.service.StudenteService;

@Controller
@RequestMapping("/facolta")
public class FacoltaController extends CrudController<FacoltaDto, Integer, FacoltaService> {

	@Autowired
	private StudenteService studenteService;

	@Autowired
	public FacoltaController(FacoltaService service) {
		super(service);
	}

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

	@RequestMapping(value="/{id}/studenteList", method=RequestMethod.GET)
	public String showEditForm(@PathVariable("id") Integer idFacolta, Model model) {
		model.addAttribute("idFacolta", idFacolta);
		model.addAttribute("studenteList", this.studenteService.listStudenteFacolta(idFacolta));
		return "facolta/listStudenteFacolta";
	}

	@Override
	protected String getEntityListModelName() {
		return "facoltaList";
	}

	@Override
	protected String getEntityModelName() {
		return "facolta";
	}

	@Override
	protected String getListView() {
		return "facolta/facoltaList";
	}

	@Override
	protected String getDetailsView() {
		return "facolta/facoltaDetails";
	}

	@Override
	protected String getFormView() {
		return "facolta/facoltaForm";
	}

	@Override
	protected String getListUrl() {
		return "/facolta";
	}
}