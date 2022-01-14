package handlers

import com.google.inject.Inject
import com.google.inject.Singleton
import models.ApplicationConfig
import ratpack.groovy.handling.GroovyContext
import ratpack.groovy.handling.GroovyHandler
import ratpack.http.Status
import ratpack.server.ServerConfig

import static ratpack.jackson.Jackson.json

@Singleton
class ConfigHandler extends GroovyHandler {
  private ApplicationConfig config
  private ServerConfig serverConfig

  @Inject
  ConfigHandler(ApplicationConfig config, ServerConfig serverConfig) {
    this.config = config
    this.serverConfig = serverConfig
  }

  @Override
  protected void handle(GroovyContext context) {
    if (!serverConfig.development) {
      context.response.status(Status.NOT_FOUND).send()
      return
    }
    context.render(json(config))
  }
}
