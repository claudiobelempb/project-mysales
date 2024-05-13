package br.com.surb.mysales.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_supplier")
public class Supplier implements Serializable {

  private static final long serialVersionUID = 7927760527904858496L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany(mappedBy = "supplier")
  private final List<Product> products = new ArrayList<>();

  private Supplier(){}

  public Supplier(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Supplier supplier = (Supplier) o;
    return Objects.equals(id, supplier.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

}
