package com.example.demo.Controller;

import com.example.demo.Entity.Category;
import com.example.demo.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @PostMapping("/category")
//    public String showAllCategories(@RequestParam(value = "category") String category, Model model){
    public String showAllCategories(@RequestParam Long categoryId, Model model) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isEmpty()) {
            model.addAttribute("categories", categoryRepository.findAll());
            return "category_select";
        }
        return "redirect:/chat?categoryId=" + categoryId;
    }

    @GetMapping("/category")
    public String showAllCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "category_select";
    }

    @GetMapping("/chat")
    public String chatCategory(@RequestParam Long categoryId, Model model) {

        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isEmpty()) {
            return "redirect:/category";
        }

        model.addAttribute("selectedCategory", optionalCategory.get());
        return null;
//        return "redirect:/redirect=" + categoryId;
    }

}
