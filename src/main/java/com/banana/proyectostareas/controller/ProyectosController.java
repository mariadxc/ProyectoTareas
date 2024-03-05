package com.banana.proyectostareas.controller;

import com.banana.proyectostareas.model.Tarea;
import com.banana.proyectostareas.persistence.ProyectoJPARepository;
import com.banana.proyectostareas.persistence.ProyectoRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
@Validated
public class ProyectosController {

    @Autowired
    private ProyectoRepositoryData repo;



}
