package br.edu.ifpr.persistproject.exception;

public class DatabaseIntegrityException extends RuntimeException {

    public DatabaseIntegrityException(String msg){
        super(msg);
    }

}
