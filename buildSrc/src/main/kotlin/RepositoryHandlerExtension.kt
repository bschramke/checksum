import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.MavenArtifactRepository

fun RepositoryHandler.bintrayKotlinX(): MavenArtifactRepository {
    return maven {
        with(this) {
            name = "Bintray KotlinX"
            setUrl("https://kotlin.bintray.com/kotlinx")
        }
    }
}