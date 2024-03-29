import ktor.KtorAuthRemoteDataSource
import ktor.KtorLoginRequest
import model.Token

class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthRemoteDataSource,
) : AuthRepository {
    override suspend fun login(login: String, password: String): Token {
        return remoteDataSource.performLogin(KtorLoginRequest(login, password))
    }
}