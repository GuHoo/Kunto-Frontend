package slp.etr.guhoo.kunto_frontend.utils.http.entity;

public class SignUpResponse {
    public String token;

    SignUpResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
