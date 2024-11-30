package com.ymon.taller3.prestamo.controller;

import com.ymon.taller3.prestamo.dto.PrestamoDTO;
import com.ymon.taller3.prestamo.dto.PrestamoUpdateDTO;
import com.ymon.taller3.prestamo.model.Prestamo;
import com.ymon.taller3.prestamo.service.PrestamoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    //Crear un prestamo.
    @Operation(summary = "Este POST crea un nuevo prestamo.", description = "Para crear un prestamo se necesita el id del usuario que va a hacer el pristamo, el id del libro a prestar y su fecha de prestamo y devolucion..")
    @PostMapping
    public Prestamo createLoan(@RequestBody PrestamoDTO prestamo) {
        return prestamoService.createLoanFromDTO(prestamo);
    }

    //Obtener todos los prestamos.
    @Operation(summary = "Este GET muestra todos los prestamos.", description = "No se necesita ningun parametro para ver todos los prestamos registrados, este tambien traera tanto los datos del usuario que hizo el prestamo como los datos del libro prestado.")
    @GetMapping
    public List<Prestamo> getAllLoans() {
        return prestamoService.getAllLoans();
    }

    //Obtener un prestamo por Id.
    @Operation(summary = "Este GET muestra un prestamo por Id.", description = "El unico parametro requerido es el id del prestamo, este tambien traera tanto los datos del usuario que hizo el prestamo como los datos del libro prestado.")
    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getLoanById(@PathVariable Long id) {
        Optional<Prestamo> prestamo = prestamoService.getLoanById(id);
        return prestamo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Actualizar un prestamo.
    @Operation(summary = "Este PUT actualiza un prestamo mediante su Id.", description = "Como parametro solo se necesita el id del prestamo a modificar, se puede modificar las fechas del prestamo y si este esta activo o no.")
    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> updateLoanFromDTO(@PathVariable Long id, @RequestBody PrestamoUpdateDTO prestamoDetails) {
        return ResponseEntity.ok(prestamoService.updateLoanFromDTO(id, prestamoDetails));
    }

    //Eliminar un prestamo.
    @Operation(summary = "Este DELETE elimina un prestamo mediante su Id.", description = "Solo se necesita el id del libro a eliminar.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        prestamoService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
