package konta;

import konta.model.entity.Product;
import konta.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @RequestMapping
    public String home(Model model) {
        String check1 = "Welcome to this class";
        List<Product> productList = productService.getAll();
//        productList.add(new Product(1,"Shirt",25000.0,10,new Date(),true));
//        productList.add(new Product(2,"Shirt2",25000.0,10,new Date(),true));
//        productList.add(new Product(3,"Shirt3",25000.0,10,new Date(),true));
//        productList.add(new Product(4,"Shirt4",25000.0,10,new Date(),true));

        model.addAttribute("check1", check1);
        model.addAttribute("productList", productList);
        return "check";
    }

    @GetMapping("/add")
    public String add(Model model, Product product) {
//        Product product = new Product();
        model.addAttribute("product", product);
        return "add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("category") Product product){
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/";
    }
}
