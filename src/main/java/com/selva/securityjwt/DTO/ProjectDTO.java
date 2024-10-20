package com.selva.securityjwt.DTO;

import com.selva.securityjwt.model.Client;

public class ProjectDTO {
    private Integer id;
    private String name;
    private Client client;

    public ProjectDTO(Integer id, String name, Client client) {
        this.id = id;
        this.name = name;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
