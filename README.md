# Kotlin Validator — Spring WebFlux Example

A runnable REST API that demonstrates [**kotlin-validator**](https://github.com/noovoweb/kotlin-validator) with **Spring Boot WebFlux** (reactive + coroutines).

> 📚 **Full library documentation:** https://github.com/noovoweb/kotlin-validator

## Prerequisites

| | |
|---|---|
| JDK | 21+ |
| Gradle | bundled wrapper |
| GitHub PAT | with `read:packages` scope (see below) |

## Setup

The library is hosted on **GitHub Packages**, which always requires authentication.

Add your credentials to `~/.gradle/gradle.properties`:

```properties
gpr.user=your-github-username
gpr.token=ghp_your_personal_access_token
```

Create a token at https://github.com/settings/tokens with the `read:packages` scope.

> 💡 If you have the library installed locally via `./gradlew publishToMavenLocal` in the `kotlin-validator/` repo, you can skip the credentials — `mavenLocal()` is checked first.

## Run

```bash
./gradlew bootRun
```

Application starts at **http://localhost:8081** — base path `/webflux/api/*`.

## Try it

```bash
# Valid email
curl -X POST http://localhost:8081/webflux/api/string/email \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com"}'

# Validation failure (in French)
curl -X POST http://localhost:8081/webflux/api/string/email \
  -H "Content-Type: application/json" \
  -H "Accept-Language: fr" \
  -d '{"email":"invalid"}'
```

A Postman collection is included: `Kotlin Validator Spring Webflux API.postman_collection.json`.

## What's demonstrated

| Feature | Notes |
|---|---|
| **Built-in validators** | String, numeric, date/time, collection, file, network, conditional |
| **Custom validators** | Strong password, address geocoding |
| **Nested validation** | `@Valid` on nested data classes |
| **i18n** | English / French via `Accept-Language` header |
| **Reactive + coroutines** | Both `suspend` handlers and `Mono`-returning handlers |
| **422 error handling** | Structured `ValidationException` → JSON response |

## Idiomatic usage

```kotlin
@Validated
data class RegisterRequest(
    @Required @Email val email: String?,
    @Required @StrongPassword val password: String?,
)

@Component
class UserHandler(private val ctx: ValidationContextProvider) {

    suspend fun register(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<RegisterRequest>()
        payload.validate(request, ctx.getBase())   // throws ValidationException
        return ServerResponse.ok().bodyValueAndAwait(payload)
    }
}
```

**Error response (422):**
```json
{
  "status": 422,
  "message": "Validation Failed",
  "errors": {
    "email": ["Please enter a valid email address"],
    "password": ["Password must be at least 12 characters"]
  }
}
```

## Dependencies

```kotlin
val kotlinValidatorVersion = "0.1.0-beta.3"

implementation("com.noovoweb:kotlin-validator-annotations:$kotlinValidatorVersion")
implementation("com.noovoweb:kotlin-validator-runtime:$kotlinValidatorVersion")
implementation("com.noovoweb:kotlin-validator-spring-webflux:$kotlinValidatorVersion")
ksp("com.noovoweb:kotlin-validator-processor:$kotlinValidatorVersion")
```

See `build.gradle.kts` for the full setup including the GitHub Packages repository block.

## License

Provided as-is for demonstration purposes.
