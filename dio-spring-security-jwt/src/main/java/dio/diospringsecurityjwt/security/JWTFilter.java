package dio.diospringsecurityjwt.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JWTFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // obtém o token da request com AUTHORIZATION
        String token = request.getHeader(JWTCreator.HEADER_AUTHORIZATION);
        // implementa a integridade do token
        try {
            if (token != null && !token.isEmpty()){
                JWTObject tokenObject = JWTCreator.create(token, SecurityConfig.PREFIX, SecurityConfig.KEY);

                List<SimpleGrantedAuthority> authorities = authorities(tokenObject.getRoles());

                UsernamePasswordAuthenticationToken userToken =
                        new UsernamePasswordAuthenticationToken(
                                tokenObject.getSubject(),
                                null,
                                authorities);

                SecurityContextHolder.getContext().setAuthentication(userToken);
            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        }catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException e){
            e.printStackTrace();
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }
    }

    private List<SimpleGrantedAuthority> authorities(List<String> roles) {
        return roles.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    /*
    * Todas as requisições serão interceptadas pelo filtro,
    * a fim de pegar o token e validar, se tiver ok, monta uma
    * autenticação via token e adiciona ao contexto, que é
    * esperado pelo spring boot
    *
    * */
}
