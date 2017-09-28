package slp.etr.guhoo.kunto_frontend.utils.http;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface KuntoService {
    @POST("api/users/sign_in")
    Observable<SignInResponse> repos(@Query("email") String email, @Query("password") String password);
}
