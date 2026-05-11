package org.example.keyguard.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Set<GrantedAuthority> authorities = new HashSet<>();

        extractRealmRoles(jwt).forEach(role ->
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role))
        );

        return authorities;
    }

    private Collection<String> extractRealmRoles(Jwt jwt) {
        Map<String, Object> realmAccess = jwt.getClaim("realm_access");

        if (realmAccess == null || realmAccess.isEmpty()) {
            return Collections.emptyList();
        }

        Object roles = realmAccess.get("roles");

        if (!(roles instanceof Collection<?> roleCollection)) {
            return Collections.emptyList();
        }

        return roleCollection.stream()
                .filter(String.class::isInstance)
                .map(String.class::cast)
                .toList();
    }
}