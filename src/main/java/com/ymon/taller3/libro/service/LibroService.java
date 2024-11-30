package com.ymon.taller3.libro.service;

import com.ymon.taller3.libro.dto.LibroDTO;
import com.ymon.taller3.libro.model.Libro;
import com.ymon.taller3.libro.mapper.LibroMapper;
import com.ymon.taller3.libro.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private LibroMapper libroMapper;

    // Crear un libro desde el DTO sin ID.
    public Libro createBookFromDTO(LibroDTO libroDTO) {
        Libro libro = libroMapper.libroDTOToLibro(libroDTO);
        return libroRepository.save(libro);
    }

    //Obtener todos los libros.
    public List<Libro> getAllBooks() {
        return libroRepository.findAll();
    }

    //Obtener libro por Id.
    public Optional<Libro> getBookById(Long id) {
        return libroRepository.findById(id);
    }

    //Actualizar un libro.
    public Libro updateBookFromDTO(Long id, LibroDTO libroDetails) {
        Libro libro = libroRepository.findById(id).orElseThrow();
        libro.setAutor(libroDetails.getAutor());
        libro.setTitulo(libroDetails.getTitulo());
        libro.setIsbn(libroDetails.getIsbn());
        return libroRepository.save(libro);
    }

    //Eliminar un libro.
    public void deleteBook(Long id) {
        libroRepository.deleteById(id);
    }

}