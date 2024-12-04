package com.example.coin.Service;

import com.example.coin.model.Empresa;
import com.example.coin.repository.EmpresaRepository;
import com.example.coin.service.EmpresaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmpresaServiceTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private EmpresaService empresaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmpresas() {
        // Arrange
        Empresa empresa1 = new Empresa(1L, "12345678000101", "Empresa 1", "Ativa");
        Empresa empresa2 = new Empresa(2L, "98765432000199", "Empresa 2", "Inativa");
        when(empresaRepository.findAll()).thenReturn(Arrays.asList(empresa1, empresa2));

        // Act
        List<Empresa> empresas = empresaService.getAllEmpresas();

        // Assert
        assertNotNull(empresas);
        assertEquals(2, empresas.size());
        verify(empresaRepository, times(1)).findAll();
    }

    @Test
    void testGetEmpresaById() {
        // Arrange
        Empresa empresa = new Empresa(1L, "12345678000101", "Empresa 1", "Ativa");
        when(empresaRepository.findById(1L)).thenReturn(Optional.of(empresa));

        // Act
        Optional<Empresa> result = empresaService.getEmpresaById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Empresa 1", result.get().getNome());
        verify(empresaRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveEmpresa() {
        // Arrange
        Empresa empresa = new Empresa(null, "12345678000101", "Empresa Nova", "Ativa");
        Empresa savedEmpresa = new Empresa(1L, "12345678000101", "Empresa Nova", "Ativa");
        when(empresaRepository.save(empresa)).thenReturn(savedEmpresa);

        // Act
        Empresa result = empresaService.saveEmpresa(empresa);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Empresa Nova", result.getNome());
        verify(empresaRepository, times(1)).save(empresa);
    }

    @Test
    void testDeleteEmpresa() {
        // Arrange
        Long empresaId = 1L;
        doNothing().when(empresaRepository).deleteById(empresaId);

        // Act
        empresaService.deleteEmpresa(empresaId);

        // Assert
        verify(empresaRepository, times(1)).deleteById(empresaId);
    }
}
