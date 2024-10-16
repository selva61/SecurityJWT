package com.selva.securityjwt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clients_id_gen")
    @SequenceGenerator(name = "clients_id_gen", sequenceName = "clients_client_id_seq", allocationSize = 1)
    @Column(name = "client_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "client_name", nullable = false, length = 100)
    private String clientName;

    @Size(max = 100)
    @NotNull
    @Column(name = "contact_email", nullable = false, length = 100)
    private String contactEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

}