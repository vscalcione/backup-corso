package it.intersistemi.corso.gestioneAttivita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.intersistemi.corso.gestioneAttivita.entity.Employee;
import it.intersistemi.corso.gestioneAttivita.model.ActivityDto;
import it.intersistemi.corso.gestioneAttivita.model.EmployeeDto;
import it.intersistemi.corso.gestioneAttivita.service.ActivityService;
import it.intersistemi.corso.gestioneAttivita.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController extends CrudController<EmployeeDto, Integer, EmployeeService>{

	@Autowired
	private ActivityService activityService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super(employeeService);
	}

	@RequestMapping(value="/{id}/assignActivity", method=RequestMethod.GET)
	public String showAssignActivity(@PathVariable("id") Integer idMatricola, Model model) {
		EmployeeDto employeeDto = this.service.findById(idMatricola);
		model.addAttribute(this.getEntityModelName(), employeeDto);
		model.addAttribute("idMatricola", idMatricola);
		model.addAttribute("employeeActivityList", activityService.listEmployeeActivity(idMatricola));
		Iterable<ActivityDto> listActivity = activityService.findAll();
		model.addAttribute("activityList", listActivity);
		return "employee/assignActivity";
	}

	@RequestMapping(value="/{id}/assignActivity", method=RequestMethod.POST)
	public String saveAssegnaAttivita(@PathVariable("id") Integer idMatricola,
			@RequestParam(value="idActivity", required=true) String idActivity,
			Model model) {
		this.activityService.assignEmployeeActivity(idActivity, idMatricola);
		return "redirect:/employee/"+idMatricola+"/assignActivity";
	}

	@RequestMapping(value="/{idMatricola}/removeActivity", method=RequestMethod.GET)
	public String removeActivity(@PathVariable("idMatricola") Integer idMatricola,
			@RequestParam(value="idActivity", required=true) String idActivity,
			Model model) {
		this.activityService.removeEmployeeActivity(idActivity, idMatricola);
		return "redirect:/employee/"+idMatricola+"/assignActivity";
	}

	@Override
	protected String getEntityListModelName() {
		return "employeeList";
	}

	@Override
	protected String getEntityModelName() {
		return "employee";
	}

	@Override
	protected String getListView() {
		return "employee/employeeList";
	}

	@Override
	protected String getDetailsView() {
		return "employee/employeeDetails";
	}

	@Override
	protected String getFormView() {
		return "employee/employeeForm";
	}

	@Override
	protected String getListUrl() {
		return "/employee";
	}
}