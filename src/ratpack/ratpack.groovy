import ratpack.handling.RequestLogger

import static ratpack.groovy.Groovy.ratpack

ratpack {
  handlers {
    all(RequestLogger.ncsa())
  }

  include("api/password.groovy")
}