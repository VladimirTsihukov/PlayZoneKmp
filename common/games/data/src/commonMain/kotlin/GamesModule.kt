import ktor.KtorGamesDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton
import sqlDelightGamesDataSource.SqlDelightGamesDataSource

val gamesModule = DI.Module("gamesModule") {
    bind<KtorGamesDataSource>() with provider {
        KtorGamesDataSource(instance())
    }

    bind<SqlDelightGamesDataSource>() with provider {
        SqlDelightGamesDataSource()
    }

    bind<GamesRepositoryImp>() with singleton {
        GamesRepositoryImp(instance(), instance())
    }
}