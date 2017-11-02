package com.test.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping(value = "/addLink")

    public ModelAndView addLink (
            @RequestParam("Name") String Name,
            @RequestParam("Description") String Description,
            @RequestParam("Date") String Date,
            @RequestParam("URL") String URL,
            @RequestParam("Category") String Category
    ) {
        boolean result = DAO.addLink(Name, Description, Date, URL, Category);
        ArrayList<bottomAdded> recentList = DAO.getBottomAdded();
        ArrayList<categories> categoryList = DAO.getAllCategories();

        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("bdata", recentList);
        mv.addObject("categories", categoryList);

        return mv;
    }

    @RequestMapping("/")

    public ModelAndView recentlyAdded () {

        ArrayList<bottomAdded> recentList = DAO.getBottomAdded();
        ArrayList<categories> categoryList = DAO.getAllCategories();

        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("bdata", recentList);
        mv.addObject("categories", categoryList);

        return mv;

    }

    @RequestMapping("/retrieveLinks")
            public ModelAndView retrieveLinks(
                    @RequestParam("Category") String Category
    ) {
        ArrayList<Information> informationList = DAO.getInformation(Category);
        ArrayList<bottomAdded> recentList = DAO.getBottomAdded();

        ModelAndView mv = new ModelAndView("links");
        mv.addObject("idata", informationList);
        mv.addObject("bdata", recentList);

        return mv;
    }
}