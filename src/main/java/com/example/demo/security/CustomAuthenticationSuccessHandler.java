package com.example.demo.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);
        System.out.println("Target URL: " + targetUrl);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        List<String> roles = authentication.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .collect(Collectors.toList());
        System.out.println("User roles: " + roles);

        if (roles.contains("ROLE_INFORC")) {
            return "/InforC.html";
        } else if (roles.contains("ROLE_FACC")) {
            return "/FACC.html";
        } else if (roles.contains("ROLE_HUMANC")) {
            return "/HumanC.html";
        } else if (roles.contains("ROLE_GENERALC")) {
            return "/GeneralC.html";
        } else if (roles.contains("ROLE_CONCIERGE")) {
            return "/DA.html";
        }
        else {
            throw new IllegalStateException("Role not supported");
        }
    }
}
