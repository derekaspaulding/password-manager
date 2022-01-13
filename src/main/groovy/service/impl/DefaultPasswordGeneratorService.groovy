package service.impl

import service.PasswordGeneratorService

class DefaultPasswordGeneratorService implements PasswordGeneratorService {
  @Override
  String generate() {
    return "password"
  }
}
