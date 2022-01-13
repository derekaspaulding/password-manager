package functional

import ratpack.http.Status

class PasswordApiSpec extends AbstractFunctionalSpec {
  def "GET password should generate a password" () {
    when:
    def resp = app.httpClient.get("api/password")

    then:
    resp.status == Status.OK
    resp.body.text == "password"
  }

}