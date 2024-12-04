package com.example.coin.Service;

import com.example.coin.model.PlanoConta;
import com.example.coin.repository.PlanoContaRepository;
import com.example.coin.service.PlanoContaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlanoContaServiceTest {

    @Mock
    private PlanoContaRepository repository;

    @InjectMocks
    private PlanoContaService service;

    private PlanoConta mockPlanoConta;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockPlanoConta = new PlanoConta();
        mockPlanoConta.setId(1L);
        mockPlanoConta.setConta("Conta Teste");
        mockPlanoConta.setStatus("Ativo");
        mockPlanoConta.setCategoria("Despesa");
        mockPlanoConta.setValor("100.00");
        mockPlanoConta.setVencimento("2024-12-31");
    }

    @Test
    void findAll() {
        List<PlanoConta> planoContaList = new ArrayList<>();
        planoContaList.add(mockPlanoConta);

        when(repository.findAll()).thenReturn(planoContaList);

        List<PlanoConta> result = service.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Conta Teste", result.get(0).getConta());
        verify(repository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(repository.findById(1L)).thenReturn(Optional.of(mockPlanoConta));

        Optional<PlanoConta> result = service.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Conta Teste", result.get().getConta());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void save() {
        when(repository.save(mockPlanoConta)).thenReturn(mockPlanoConta);

        PlanoConta result = service.save(mockPlanoConta);

        assertNotNull(result);
        assertEquals("Conta Teste", result.getConta());
        verify(repository, times(1)).save(mockPlanoConta);
    }

    @Test
    void deleteById() {
        doNothing().when(repository).deleteById(1L);

        service.deleteById(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
