package com.agenda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.demo.entidades.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}

