package konta.controller;

import konta.model.entity.NhanVien;
import konta.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String home(Model model) {
       List<NhanVien> employeeList = employeeService.getAll();

       model.addAttribute("employeeList", employeeList);
       return "index";
    }

    @GetMapping("/add")
    public String add(Model model, NhanVien employee) {
        model.addAttribute("employee", employee);
        return "add";
    }

    @PostMapping("/add")
    public  String add(@ModelAttribute("employee") NhanVien employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        NhanVien employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "editEmployee";
    }

    @PostMapping("/edit/{id}")
    public  String edit(@ModelAttribute("employee") NhanVien employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return "redirect:/";
    }
}
