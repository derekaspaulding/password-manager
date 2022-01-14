import handlers.ConfigHandler
import models.ApplicationConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import ratpack.handling.RequestLogger

import java.nio.file.NoSuchFileException
import java.nio.file.Paths

import static ratpack.groovy.Groovy.ratpack

final Logger log = LoggerFactory.getLogger("ratpack.server")

ratpack {
  serverConfig {
    onError { throwable ->
      if (throwable instanceof NoSuchFileException) {
        final String file = throwable.file
        log.info "Cannot load configuration file '{}'", file
      } else {
        throw throwable
      }
    }

    yaml "application.yaml"
    yaml "application-local.yaml"
    yaml Paths.get("/config/password-manager/application.yaml")
    require("", ApplicationConfig)
  }

  bindings {
    bind(ConfigHandler)
  }

  handlers {
    all(RequestLogger.ncsa())

    get("config", ConfigHandler)
  }

  include("api/password.groovy")
}