package com.malikov.productmanager.controller;

import com.malikov.productmanager.model.Product;
import com.malikov.productmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    @Qualifier(value = "productService")
    private ProductService productService;

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.getAll());
        return "products";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        if (product.getId() == null) {
            productService.add(product);
        } else {
            productService.update(product);
        }
        return "redirect:/products";
    }

    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @RequestMapping("edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.get(id));
        model.addAttribute("listProducts", productService.getAll());
        return "products";
    }

    @RequestMapping("productdata/{id}")
    public String productdata(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.get(id));
        return "productdata";
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}

