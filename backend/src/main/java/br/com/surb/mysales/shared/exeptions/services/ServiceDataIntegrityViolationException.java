package br.com.surb.mysales.shared.exeptions.services;

public class ServiceDataIntegrityViolationException extends RuntimeException {
  public ServiceDataIntegrityViolationException(String msg){
    super(msg);
  }
}
