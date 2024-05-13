package br.com.surb.mysales.builder;

public class SpecificationBuilder<T> {
  Class<T> superClass;

  public SpecificationBuilder(Class<T> superClass) {
    this.superClass = superClass;
  }

}
