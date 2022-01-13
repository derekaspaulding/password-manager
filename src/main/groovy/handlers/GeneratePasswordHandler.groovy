package handlers

import com.google.inject.Inject
import com.google.inject.Singleton
import ratpack.groovy.handling.GroovyContext
import ratpack.groovy.handling.GroovyHandler
import service.PasswordGeneratorService

@Singleton
class GeneratePasswordHandler extends GroovyHandler {
  private final PasswordGeneratorService passwordGenerator

 @Inject
 GeneratePasswordHandler(PasswordGeneratorService passwordGenerator) {
   this.passwordGenerator = passwordGenerator
 }

  @Override
  protected void handle(GroovyContext context) {
    context.response.send(passwordGenerator.generate())
  }
}
