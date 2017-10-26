package slp.etr.guhoo.kunto_frontend.utils.http;

import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Query;
import slp.etr.guhoo.kunto_frontend.utils.http.entity.SignInResponse;
import slp.etr.guhoo.kunto_frontend.utils.http.entity.SignOutResponse;
import slp.etr.guhoo.kunto_frontend.utils.http.entity.SignUpResponse;

public interface KuntoService {
    @POST("api/users/sign_up")
    Observable<SignUpResponse> signUp(@Query("email") String email, @Query("password") String password, @Query("password_confirmation") String password_confirmation);

    @POST("api/users/sign_in")
    Observable<SignInResponse> signIn(@Query("email") String email, @Query("password") String password);

    @DELETE("api/users/sign_out")
    Observable<SignOutResponse> signOut(@Query("token") String token);


}
