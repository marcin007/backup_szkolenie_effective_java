package com.for_comprehension.function.E02.legacy;

import java.util.NoSuchElementException;
import java.util.Optional;

class ModernAPI {

    public static void main(String[] args) {
        ModernAPI modernAPI = new ModernAPI(new LegacyAPI());
    }

    private final LegacyAPI delegate;

    ModernAPI(LegacyAPI legacy) {
        this.delegate = legacy;
    }

    public Optional<LegacyAPI.Person> findPerson(int id) {
        try {
            return Optional.ofNullable(delegate.findPerson(id));
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }

    public Optional<String> findAddress(LegacyAPI.Person person) {
        return Optional.ofNullable(delegate.findAddress(person));
    }

    public Optional<String> findAddressById(int id) {
        return findPerson(id)
          .filter(p -> p.getHeight() > 168)
          .flatMap(p -> findAddress(p))
          .filter(a -> !a.isBlank())
          .map(String::trim);
    }
}
