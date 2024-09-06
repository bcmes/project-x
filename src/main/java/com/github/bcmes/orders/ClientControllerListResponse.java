package com.github.bcmes.orders;

import java.util.UUID;

public class ClientControllerListResponse {

    private final UUID id;
    private final String name;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ClientControllerListResponse(ClientDomain clientsDomain) {
        this.id = clientsDomain.getId();
        this.name = clientsDomain.getName();
    }
}
