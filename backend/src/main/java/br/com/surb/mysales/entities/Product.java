package br.com.surb.mysales.entities;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

  @Serial
  private static final long serialVersionUID = 7494611404154924779L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String sku;
  private String name;
  @Column(precision = 16, scale = 2)
  private BigDecimal price;
  private Integer stock;
  @Column(columnDefinition = "text")
  private String description;

  /*@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")*/
  private Instant createdAt;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @ManyToOne
  @JoinColumn(name = "supplier_id")
  private Supplier supplier;

  public Product() {
  }

  public Product(Long id, String sku, String name, BigDecimal price, Integer stock, String description, Instant createdAt, Category category, Supplier supplier) {
    this.id = id;
    this.sku = sku;
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.description = description;
    this.createdAt = createdAt;
    this.category = category;
    this.supplier = supplier;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  @PrePersist
  public void prePersist() {
    sku = String.valueOf(UUID.randomUUID());
    createdAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Product product = (Product) o;

    return Objects.equals(id, product.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Product{" +
      "id=" + id +
      ", sku='" + sku + '\'' +
      ", name='" + name + '\'' +
      ", price=" + price +
      ", description='" + description + '\'' +
      ", createdAt=" + createdAt +
      '}';
  }
}
