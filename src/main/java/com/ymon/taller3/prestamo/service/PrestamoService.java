package com.ymon.taller3.prestamo.service;

import com.ymon.taller3.prestamo.dto.PrestamoDTO;
import com.ymon.taller3.prestamo.dto.PrestamoUpdateDTO;
import com.ymon.taller3.prestamo.mapper.PrestamoMapper;
import com.ymon.taller3.prestamo.model.Prestamo;
import com.ymon.taller3.prestamo.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private PrestamoMapper prestamoMapper;

    //Crear un prestamo.
    public Prestamo createLoanFromDTO(PrestamoDTO prestamoDTO) {
        Prestamo prestamo = prestamoMapper.prestamoDTOToPrestamo(prestamoDTO);
        return prestamoRepository.save(prestamo);
    }

    //Obtener todos los prestamos.
    public List<Prestamo> getAllLoans() {
        return prestamoRepository.findAll();
    }

    //Obtener prestamo por Id.
    public Optional<Prestamo> getLoanById(Long id) {
        return prestamoRepository.findById(id);
    }

    //Actualizar un prestamo.
    public Prestamo updateLoanFromDTO(Long id, PrestamoUpdateDTO prestamoDetails) {
        Prestamo prestamo = prestamoRepository.findById(id).orElseThrow();
        prestamo.setFechaPrestamo(prestamoDetails.getFechaPrestamo());
        prestamo.setFechaDevolucion(prestamoDetails.getFechaDevolucion());
        prestamo.setPrestado(prestamoDetails.isPrestado());
        return prestamoRepository.save(prestamo);
    }

    //Eliminar un prestamo.
    public void deleteLoan(Long id) {
        prestamoRepository.deleteById(id);
    }
}
