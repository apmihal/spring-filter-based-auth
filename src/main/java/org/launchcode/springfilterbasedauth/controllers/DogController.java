package org.launchcode.springfilterbasedauth.controllers;

import org.launchcode.springfilterbasedauth.models.Dog;
import org.launchcode.springfilterbasedauth.models.forms.DogForm;
import org.launchcode.springfilterbasedauth.models.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class DogController extends AbstractController{


    @RequestMapping(value = "/dogs")
    public String dogForm(Model model, HttpServletRequest request) {

        User loggedInUser = getUserFromSession(request.getSession());

        model.addAttribute(new DogForm());
        model.addAttribute("title", "Add Dogs!");
        model.addAttribute("dogs", loggedInUser.getDogs());
        return "dogs";
    }

    @RequestMapping(value = "/dogs", method = RequestMethod.POST)
    public String dogs(@ModelAttribute @Valid DogForm form,
                       Errors errors,
                       HttpServletRequest request,
                       Model model) {

        User loggedInUser = getUserFromSession(request.getSession());

        if (errors.hasErrors()) {
            return "dogs";
        }

        Dog newDog = new Dog(form.getName());
        loggedInUser.addDog(newDog);
        dogDao.save(newDog);
        userDao.save(loggedInUser);

        return "redirect:/dogs";
    }


}