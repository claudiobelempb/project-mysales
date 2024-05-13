package br.com.surb.mysales.shared.models;

import org.springframework.data.domain.Page;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class PageFilterModel<T> implements Serializable {

  @Serial
  private static final long serialVersionUID = 7004354642959837182L;
  private Long totalElements;
  private Integer currentPage;
  private Integer totalPages;
  private Integer sizePage;
  private List<T> elementos;

  public PageFilterModel(){}

  public PageFilterModel(Long totalElements, Integer currentPage, Integer totalPages, Integer sizePage, List<T> elementos){
    this.totalElements = totalElements;
    this.currentPage = currentPage;
    this.totalPages = totalPages;
    this.sizePage = sizePage;
    this.elementos = elementos;
  }

  public PageFilterModel(Page<T> page){
    this.elementos = page.getContent();
    this.totalElements = page.getTotalElements();
    this.currentPage = page.getNumber();
    this.totalPages = page.getTotalPages();
    this.sizePage = page.getSize();
  }

  public Long getTotalElements() {
    return totalElements;
  }

  public Integer getCurrentPage() {
    return currentPage;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public Integer getSizePage() {
    return sizePage;
  }

  public List<T> getElementos() {
    return elementos;
  }
}
