package com.ymon.taller3.libro.controller;

import com.ymon.taller3.libro.dto.LibroDTO;
import com.ymon.taller3.libro.model.Libro;
import com.ymon.taller3.libro.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Crear un libro.
    @Operation(summary = "Este POST crea un nuevo libro.", description = "Los parametros requeridos para crear un libro son 'autor', 'isbn' y 'titulo', el id del libro se genera automaticamente.")
    @PostMapping
    public Libro createBook(@RequestBody LibroDTO libroDTO) {
        return libroService.createBookFromDTO(libroDTO);
    }

    //Obtener todos los libros.
    @Operation(summary = "Este GET muestra todos los libros.", description = "No se necesitan parametros para ver todos los usuarios.")
    @GetMapping
    public List<Libro> getAllBooks() {
        return libroService.getAllBooks();
    }

    //Obtener un libro por Id.
    @Operation(summary = "Este GET muestra un libro por Id.", description = "Solo hay que agregar el id del libro que queremos ver como parametro.")
    @GetMapping("/{id}")
    public ResponseEntity<Libro> getBookById(@PathVariable Long id) {
        Optional<Libro> libro = libroService.getBookById(id);
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Actualizar un libro.
    @Operation(summary = "Este PUT actualiza un libro mediante su Id.", description = "Se pueden modificar todos los datos del libro menos su id.")
    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateBook(@PathVariable Long id, @RequestBody LibroDTO libroDetails) {
        return ResponseEntity.ok(libroService.updateBookFromDTO(id, libroDetails));
    }

    //Eliminar un libro.
    @Operation(summary = "Este DELETE elimina un libro mediante su Id.", description = "Solo se necesita el id del libro a eliminar.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        libroService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}