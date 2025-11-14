package com.crumbco.cookie_store.controller;

import com.crumbco.cookie_store.model.Cookies;
import com.crumbco.cookie_store.service.CookieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CookieController {
    private final CookieService cookieService;

    public CookieController(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    @GetMapping("/")
    public String viewCookies(Model model) {
        model.addAttribute("cookies", cookieService.getAllCookies());
        return "indexes";
    }
    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "dashboard";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "aboutUs";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contactUs";
    }

    @GetMapping("/cookie/add")
    public String showAddForm(Model model) {
        model.addAttribute("cookie", new Cookies());
        return "add";
    }

    @PostMapping("/cookie/add")
    public String addCookie(@ModelAttribute Cookies cookie) {
        cookieService.addCookie(cookie);
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String inventoryPage(Model model) {
        model.addAttribute("cookies", cookieService.getAllCookies());
        return "inventory";
    }
    @GetMapping("/cookie/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Cookies cookie = cookieService.getCookieById(id);
        if (cookie == null) {
            return "redirect:/inventory";
        }
        model.addAttribute("cookie", cookie);
        return "edit";
    }

    @PostMapping("/cookie/edit")
    public String editCookie(@ModelAttribute Cookies cookie) {
        cookieService.updateCookie(cookie);
        return "redirect:/inventory";
    }


    @PostMapping("/cookie/delete")
    public String deleteCookie(@RequestParam Long id) {
        cookieService.removeCookie(id);
        return "redirect:/inventory";
    }
}
