package br.com.alura.escolalura.dominio.tratamentoexception;

import org.springframework.http.HttpStatus;

import java.util.Calendar;

public class ErroApiForm {
    private HttpStatus status;
    private Calendar timestamp;
    private String message;
    private String debugMessage;

    private ErroApiForm() {
        timestamp = Calendar.getInstance();
    }

    public ErroApiForm(HttpStatus status) {
        this();
        this.status = status;
    }

    public ErroApiForm(HttpStatus status, Exception ex) {
        this();
        this.status = status;
        this.message = "Erro";
        this.debugMessage = ex.getLocalizedMessage();
    }

    public ErroApiForm(HttpStatus status, String message, Exception ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message == null)
            this.message = "Erro ao executar função";
        else
            this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }
}