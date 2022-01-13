package service.impl

import service.PasswordGeneratorService
import spock.lang.Specification
import spock.lang.Subject

class DefaultPasswordGeneratorServiceTest extends Specification {
  @Subject
  PasswordGeneratorService generatorService = new DefaultPasswordGeneratorService()

  def "test generate"() {
    when:
    def password = generatorService.generate();

    then:
    password == "password"
  }
}
