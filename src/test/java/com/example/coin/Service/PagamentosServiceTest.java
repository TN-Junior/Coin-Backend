package com.example.coin.Service;

import com.example.coin.model.Pagamentos;
import com.example.coin.repository.PagamentosRepository;
import com.example.coin.service.PagamentosService;
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

class PagamentosServiceTest {

    @Mock
    private PagamentosRepository pagamentosRepository;

    @InjectMocks
    private PagamentosService pagamentosService;

    private Pagamentos mockPagamento;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockPagamento = new Pagamentos();
        mockPagamento.setId(1L);
        mockPagamento.setDescricao("Pagamento de teste");
        mockPagamento.setValor(100.0);
        mockPagamento.setTipo("Crédito");
    }

    @Test
    void getAllPagamentos() {
        List<Pagamentos> pagamentosList = new ArrayList<>();
        pagamentosList.add(mockPagamento);

        when(pagamentosRepository.findAll()).thenReturn(pagamentosList);

        List<Pagamentos> result = pagamentosService.getAllPagamentos();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(pagamentosRepository, times(1)).findAll();
    }

    @Test
    void getPagamentosByTipo() {
        List<Pagamentos> pagamentosList = new ArrayList<>();
        pagamentosList.add(mockPagamento);

        when(pagamentosRepository.findByTipo("Crédito")).thenReturn(pagamentosList);

        List<Pagamentos> result = pagamentosService.getPagamentosByTipo("Crédito");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Crédito", result.get(0).getTipo());
        verify(pagamentosRepository, times(1)).findByTipo("Crédito");
    }

    @Test
    void savePagamento() {
        when(pagamentosRepository.save(mockPagamento)).thenReturn(mockPagamento);

        Pagamentos result = pagamentosService.savePagamento(mockPagamento);

        assertNotNull(result);
        assertEquals("Crédito", result.getTipo());
        verify(pagamentosRepository, times(1)).save(mockPagamento);
    }

    @Test
    void deleteConta() {
        doNothing().when(pagamentosRepository).deleteById(1L);

        pagamentosService.deleteConta(1L);

        verify(pagamentosRepository, times(1)).deleteById(1L);
    }

    @Test
    void findById() {
        when(pagamentosRepository.findById(1L)).thenReturn(Optional.of(mockPagamento));

        Pagamentos result = pagamentosService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(pagamentosRepository, times(1)).findById(1L);
    }

    @Test
    void save() {
        when(pagamentosRepository.save(mockPagamento)).thenReturn(mockPagamento);

        Pagamentos result = pagamentosService.save(mockPagamento);

        assertNotNull(result);
        assertEquals("Crédito", result.getTipo());
        verify(pagamentosRepository, times(1)).save(mockPagamento);
    }
}
