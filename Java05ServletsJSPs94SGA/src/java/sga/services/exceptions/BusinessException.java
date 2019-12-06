package sga.services.exceptions;

public class BusinessException extends RuntimeException{

  //Metodos.
  public BusinessException(String mensaje, Exception e){
    super(mensaje, e);
  }


}
