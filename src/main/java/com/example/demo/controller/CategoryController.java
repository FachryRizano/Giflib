package com.example.demo.controller;

import com.example.demo.data.CategoryRepository;
import com.example.demo.data.GifRepository;
import com.example.demo.model.Category;
import com.example.demo.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String category(ModelMap modelMap){
        List<Category> categories = categoryRepository.getAllCategories();
        modelMap.put("categories",categories);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String findById(@PathVariable int id, ModelMap modelMap){
        Category category = categoryRepository.findById(id);
        modelMap.put("category",category);

        List<Gif> gifs = gifRepository.findByCategoryId(id);
        return "category";
    }
}
