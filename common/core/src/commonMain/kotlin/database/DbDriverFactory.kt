package database

import com.squareup.sqldelight.db.SqlDriver
import platform.PlatformConfiguration

expect class DatabaseDriverFactory(platformConfiguration: PlatformConfiguration) {
    fun createDriver(scheme: SqlDriver.Schema, name: String ): SqlDriver
}