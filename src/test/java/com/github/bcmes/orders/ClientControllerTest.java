package com.github.bcmes.orders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ClientControllerTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listAll_ShouldReturnListOfClients() {
        // Arrange
        List<ClientDomain> mockClients = List.of(new ClientDomain(), new ClientDomain());
        when(clientRepository.findAll()).thenReturn(mockClients);

        // Act
        ResponseEntity<List<ClientControllerListResponse>> response = clientController.listAll();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockClients.size(), response.getBody().size());
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    void create_ShouldSaveClientAndReturnNoContent() {
        // Arrange
        ClientControllerInputCreate clientInput = mock(ClientControllerInputCreate.class);
        ClientDomain clientDomain = new ClientDomain();
        when(clientInput.toClientDomain()).thenReturn(clientDomain);

        // Act
        ResponseEntity<Void> response = clientController.create(clientInput);

        // Assert
        assertEquals(204, response.getStatusCodeValue());
        verify(clientRepository, times(1)).save(any(ClientDomain.class));
    }
}
