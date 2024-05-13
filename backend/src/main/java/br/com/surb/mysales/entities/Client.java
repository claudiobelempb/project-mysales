package br.com.surb.mysales.entities;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {

  @Serial
  private static final long serialVersionUID = 103317764888765095L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private String cpf;
  private LocalDate birth;
  private String address;
  private  String teleohone;
  private Instant createdAt;

  public Client() {
  }

  public Client(Long id, String name, String email, String cpf, LocalDate birth, String address, String teleohone, Instant createdAt) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.cpf = cpf;
    this.birth = birth;
    this.address = address;
    this.teleohone = teleohone;
    this.createdAt = createdAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public LocalDate getBirth() {
    return birth;
  }

  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTeleohone() {
    return teleohone;
  }

  public void setTeleohone(String teleohone) {
    this.teleohone = teleohone;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  @PrePersist
  public void prePersist() {
    createdAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Client client = (Client) o;
    return Objects.equals(id, client.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
