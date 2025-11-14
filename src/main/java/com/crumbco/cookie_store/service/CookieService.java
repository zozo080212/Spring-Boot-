package com.crumbco.cookie_store.service;

import com.crumbco.cookie_store.model.Cookies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CookieService {
    private List<Cookies> cookies = new ArrayList<>();
    private Long currentId = 1L;

    public List<Cookies> getAllCookies() {
        return cookies;
    }

    public void addCookie(Cookies cookie) {
        cookie.setId(currentId++);
        cookies.add(cookie);
    }

    public Cookies getCookieById(Long id) {
        return cookies.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public void updateCookie(Cookies updated) {
        Cookies existing = getCookieById(updated.getId());
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setIngredients(updated.getIngredients());
            existing.setQuantityOnHand(updated.getQuantityOnHand());
            existing.setCostPer(updated.getCostPer());
        }
    }

    public void removeCookie(Long id) {
        cookies.removeIf(c -> c.getId().equals(id));
    }
}
