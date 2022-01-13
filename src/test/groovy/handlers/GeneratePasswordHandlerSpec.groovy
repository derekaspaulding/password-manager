package handlers

import ratpack.groovy.test.embed.GroovyEmbeddedApp
import ratpack.test.embed.EmbeddedApp
import service.PasswordGeneratorService
import spock.lang.AutoCleanup
import spock.lang.Specification

class GeneratePasswordHandlerSpec extends Specification {
  def mockPasswordGeneratorService = Mock(PasswordGeneratorService)

  @AutoCleanup
  def app = GroovyEmbeddedApp.ratpack {
    bindings {
      bindInstance(PasswordGeneratorService, mockPasswordGeneratorService)
      bind(GeneratePasswordHandler)
    }

    handlers {
      get(GeneratePasswordHandler)
    }
  }

  def "returns generated password"() {
    when:
    def resp = app.httpClient.get("/")

    then:
    1 * mockPasswordGeneratorService.generate() >> "test-password"
    resp.body.text == "test-password"
  }
}
