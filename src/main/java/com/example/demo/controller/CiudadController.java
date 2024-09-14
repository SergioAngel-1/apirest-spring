package com.example.demo.controller;

import com.example.demo.model.Ciudad;
import com.example.demo.service.CiudadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping
    public List<Ciudad> obtenerCiudades() {
        return ciudadService.obtenerTodas();
    }

    @PostMapping
    public ResponseEntity<String> agregarCiudad(@RequestBody Ciudad ciudad) {
        ciudadService.agregarCiudad(ciudad);
        return new ResponseEntity<>("Ciudad agregada", HttpStatus.CREATED);
    }

    @PutMapping("/{nombre}")
    public ResponseEntity<String> editarCiudad(@PathVariable String nombre, @RequestBody Ciudad ciudad) {
        if (ciudadService.editarCiudad(nombre, ciudad)) {
            return new ResponseEntity<>("Ciudad actualizada", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<String> eliminarCiudad(@PathVariable String nombre) {
        if (ciudadService.eliminarCiudad(nombre)) {
            return new ResponseEntity<>("Ciudad eliminada", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
