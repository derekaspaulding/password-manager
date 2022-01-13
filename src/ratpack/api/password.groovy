package api

import handlers.GeneratePasswordHandler
import service.PasswordGeneratorService
import service.impl.DefaultPasswordGeneratorService

import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
    bind(PasswordGeneratorService, DefaultPasswordGeneratorService)
    bind(GeneratePasswordHandler)
  }

  handlers {
    prefix("api/password") {
      get(GeneratePasswordHandler)
    }
  }
}