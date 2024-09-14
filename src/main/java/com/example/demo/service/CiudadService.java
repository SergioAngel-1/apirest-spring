package com.example.demo.service;

import com.example.demo.model.Ciudad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {

    private final List<Ciudad> ciudades = new ArrayList<>();

    // Inicialización con datos predeterminados
    public CiudadService() {
        ciudades.add(new Ciudad("Ciudad de México", "México"));
        ciudades.add(new Ciudad("Buenos Aires", "Argentina"));
        ciudades.add(new Ciudad("Santiago", "Chile"));
    }

    public List<Ciudad> obtenerTodas() {
        return ciudades;
    }

    public void agregarCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
    }

    public boolean editarCiudad(String nombre, Ciudad ciudadActualizada) {
        Optional<Ciudad> ciudadOptional = ciudades.stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst();

        if (ciudadOptional.isPresent()) {
            Ciudad ciudad = ciudadOptional.get();
            ciudad.setNombre(ciudadActualizada.getNombre());
            ciudad.setPais(ciudadActualizada.getPais());
            return true;
        }
        return false;
    }

    public boolean eliminarCiudad(String nombre) {
        return ciudades.removeIf(ciudad -> ciudad.getNombre().equals(nombre));
    }
}
