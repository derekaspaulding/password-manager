package functional

import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import ratpack.http.Status
import spock.lang.Specification
import spock.lang.Subject


abstract class AbstractFunctionalSpec extends Specification {
  @Subject
  def app = new GroovyRatpackMainApplicationUnderTest()
}