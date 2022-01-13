//package uz.narzullayev.javohir.exception;
//
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.nio.file.AccessDeniedException;
//
//
//@Component
//public class CustomAccessDeniedHandler implements AccessDeniedHandler {
//    public static final Logger LOG
//            = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
//    @Override
//    public void handle(HttpServletRequest httpServletRequest,
//                       HttpServletResponse httpServletResponse,
//                       AccessDeniedException e) throws IOException {
//        Authentication auth
//                = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            LOG.warn("User: " + auth.getAuthorities()+auth.isAuthenticated()
//                    + " attempted to access the protected URL: "
//                    + httpServletRequest.getRequestURI());
//        }
//
//        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/accessDenied");
//    }
//}
//