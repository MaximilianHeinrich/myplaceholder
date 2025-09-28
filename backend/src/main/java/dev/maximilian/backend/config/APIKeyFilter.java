package dev.maximilian.backend.config;

import dev.maximilian.backend.repository.administration.ClientRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class APIKeyFilter extends OncePerRequestFilter {

    private final ClientRepository clientRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        String apiKey = request.getHeader("X-API-KEY");

        if (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/api/v1/administration/client/register")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (apiKey != null) {
            clientRepository.findByApiKey(apiKey).ifPresent(client -> {
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(client.getUsername(), null, null);
                SecurityContextHolder.getContext().setAuthentication(auth);
            });
        }

        filterChain.doFilter(request, response);

    }

}
