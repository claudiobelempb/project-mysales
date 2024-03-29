package br.com.surb.mysales.shared.exeptions.resources;


public class ResourceNotFondExecption extends RuntimeException {
  public ResourceNotFondExecption(String msg) {
    super(msg);
  }
}
