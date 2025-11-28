package com.noovoweb.project.route

import com.noovoweb.project.handler.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter
import org.springframework.web.reactive.function.server.router

@Configuration
class Index {

    @Bean
    fun indexRoutes(
        booleanHandler: BooleanHandler,
        collectionHandler: CollectionHandler,
        conditionalHandler: ConditionalHandler,
        dateTimeHandler: DateTimeHandler,
        fileHandler: FileHandler,
        networkHandler: NetworkHandler,
        numericHandler: NumericHandler,
        scenarioHandler: ScenarioHandler,
        stringHandler: StringHandler,
        structuralHandler: StructuralHandler
    ) = coRouter {
        "/webflux/api".nest {
            "/boolean".nest {
                POST("/accepted") { request -> booleanHandler.accepted(request) }
            }
            "/collection".nest {
                POST("/size") { request -> collectionHandler.size(request) }
                POST("/min-size") { request -> collectionHandler.minSize(request) }
                POST("/max-size") { request -> collectionHandler.maxSize(request) }
                POST("/not-empty") { request -> collectionHandler.notEmpty(request) }
                POST("/distinct") { request -> collectionHandler.distinct(request) }
                POST("/contains-value") { request -> collectionHandler.containsValue(request) }
                POST("/not-contains") { request -> collectionHandler.notContains(request) }
            }
            "/conditional".nest {
                POST("/same") { request -> conditionalHandler.same(request) }
                POST("/different") { request -> conditionalHandler.different(request) }
                POST("/required-if") { request -> conditionalHandler.requiredIf(request) }
                POST("/required-unless") { request -> conditionalHandler.requiredUnless(request) }
                POST("/required-with") { request -> conditionalHandler.requiredWith(request) }
                POST("/required-without") { request -> conditionalHandler.requiredWithout(request) }
            }
            "/datetime".nest {
                POST("/date-format") { request -> dateTimeHandler.dateFormat(request) }
                POST("/iso-date") { request -> dateTimeHandler.isoDate(request) }
                POST("/iso-datetime") { request -> dateTimeHandler.isoDateTime(request) }
                POST("/future") { request -> dateTimeHandler.future(request) }
                POST("/past") { request -> dateTimeHandler.past(request) }
                POST("/today") { request -> dateTimeHandler.today(request) }
            }
            "/file".nest {
                POST("/file-extension") { request -> fileHandler.fileExtension(request) }
                POST("/mime-type") { request -> fileHandler.mimeType(request) }
                POST("/max-file-size") { request -> fileHandler.maxFileSize(request) }
            }
            "/network".nest {
                POST("/ip") { request -> networkHandler.ip(request) }
                POST("/ipv4") { request -> networkHandler.ipv4(request) }
                POST("/ipv6") { request -> networkHandler.ipv6(request) }
                POST("/mac-address") { request -> networkHandler.macAddress(request) }
                POST("/port") { request -> networkHandler.port(request) }
            }
            "/numeric".nest {
                POST("/min") { request -> numericHandler.min(request) }
                POST("/max") { request -> numericHandler.max(request) }
                POST("/between") { request -> numericHandler.between(request) }
                POST("/positive") { request -> numericHandler.positive(request) }
                POST("/negative") { request -> numericHandler.negative(request) }
                POST("/zero") { request -> numericHandler.zero(request) }
                POST("/integer") { request -> numericHandler.integer(request) }
                POST("/decimal") { request -> numericHandler.decimal(request) }
                POST("/divisible-by") { request -> numericHandler.divisibleBy(request) }
                POST("/even") { request -> numericHandler.even(request) }
                POST("/odd") { request -> numericHandler.odd(request) }
                POST("/decimal-places") { request -> numericHandler.decimalPlaces(request) }
            }
            "/scenario".nest {
                POST("/register") { request -> scenarioHandler.register(request) }
                POST("/nested-2-levels") { request -> scenarioHandler.nestedTwoLevels(request) }
                POST("/products-array") { request -> scenarioHandler.productsArray(request) }
                POST("/shipping") { request -> scenarioHandler.validateShipping(request) }
                POST("/address") { request -> scenarioHandler.validateAddress(request) }
                POST("/order") { request -> scenarioHandler.validateOrder(request) }
            }
            "/string".nest {
                POST("/required") { request -> stringHandler.required(request) }
                POST("/email") { request -> stringHandler.email(request) }
                POST("/url") { request -> stringHandler.url(request) }
                POST("/uuid") { request -> stringHandler.uuid(request) }
                POST("/length") { request -> stringHandler.length(request) }
                POST("/min-length") { request -> stringHandler.minLength(request) }
                POST("/max-length") { request -> stringHandler.maxLength(request) }
                POST("/pattern") { request -> stringHandler.pattern(request) }
                POST("/alpha") { request -> stringHandler.alpha(request) }
                POST("/alphanumeric") { request -> stringHandler.alphanumeric(request) }
                POST("/ascii") { request -> stringHandler.ascii(request) }
                POST("/lowercase") { request -> stringHandler.lowercase(request) }
                POST("/uppercase") { request -> stringHandler.uppercase(request) }
                POST("/starts-with") { request -> stringHandler.startsWith(request) }
                POST("/ends-with") { request -> stringHandler.endsWith(request) }
                POST("/contains") { request -> stringHandler.contains(request) }
                POST("/one-of") { request -> stringHandler.oneOf(request) }
                POST("/not-one-of") { request -> stringHandler.notOneOf(request) }
                POST("/json") { request -> stringHandler.json(request) }
                POST("/luhn") { request -> stringHandler.luhn(request) }
            }
            "/structural".nest {
                POST("/valid") { request -> structuralHandler.valid(request) }
                POST("/fail-fast") { request -> structuralHandler.failFast(request) }
            }
        }
    }

    /**
     * Simplified API routes - demonstrates auto-discovery of validators.
     * No need to manually instantiate validators!
     */
    @Bean
    fun simplifiedRoutes(stringHandler: StringHandler) = coRouter {
        "/webflux/api/simplified".nest {
            "/string".nest {
                POST("/required", stringHandler::requiredSimplified)
                POST("/email", stringHandler::emailUltraSimplified)
            }
        }
    }

    /**
     * Reactive routes using traditional Mono-based handlers.
     * These demonstrate the validateMono() approach as an alternative to suspend functions.
     *
     * Compare:
     * - Coroutine style (above): Uses suspend fun with coRouter
     * - Reactive style (below): Uses Mono<ServerResponse> with router
     *
     * Both are fully non-blocking!
     */
    @Bean
    fun reactiveRoutes(stringHandler: StringHandler) = router {
        "/webflux/api/reactive".nest {
            "/string".nest {
                POST("/email", stringHandler::emailReactive)
                POST("/url", stringHandler::urlReactive)
                POST("/uuid", stringHandler::uuidReactive)
            }
        }
    }
}
