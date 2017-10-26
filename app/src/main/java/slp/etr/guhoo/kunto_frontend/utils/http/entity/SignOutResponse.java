package slp.etr.guhoo.kunto_frontend.utils.http.entity;

public class SignOutResponse {
    public String message;
    public int status;

    SignOutResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
