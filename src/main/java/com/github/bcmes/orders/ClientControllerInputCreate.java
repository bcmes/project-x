package com.github.bcmes.orders;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record ClientControllerInputCreate(
        @NotBlank
        String name
) {
        public ClientDomain toClientDomain() {
                return new ClientDomain(UUID.randomUUID(), this.name);
        }
}
