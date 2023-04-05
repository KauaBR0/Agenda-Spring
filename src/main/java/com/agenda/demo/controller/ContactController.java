package com.agenda.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.demo.entidades.Categoria;
import com.agenda.demo.entidades.Contact;
import com.agenda.demo.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;
    
    @GetMapping
    public List<Contact> findAll() {
        return contactService.findAll();
    }
    
    @GetMapping("/{id}")
    public Contact findById(@PathVariable Long id) {
        return contactService.findById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact create(@RequestBody Contact contact) {
        return contactService.save(contact);
    }
    
    @PutMapping("/{id}")
    public Contact update(@PathVariable Long id, @RequestBody Contact contact) {
        contact.setId(id);
        return contactService.save(contact);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        contactService.deleteById(id);
    }
    
    @GetMapping("/categoria/{categoria}")
    public List<Contact> findByCategoria(@PathVariable Categoria categoria) {
        return contactService.findByCategoria(categoria);
    }
}

