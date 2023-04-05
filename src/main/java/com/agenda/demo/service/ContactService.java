package com.agenda.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.demo.entidades.Categoria;
import com.agenda.demo.entidades.Contact;
import com.agenda.demo.repository.ContactRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;
    
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }
    
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contato não encontrado."));
    }
    
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }
    
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
    
    public List<Contact> findByCategoria(Categoria categoria) {
        return ((ContactService) contactRepository).findByCategoria(categoria);
    }
}

