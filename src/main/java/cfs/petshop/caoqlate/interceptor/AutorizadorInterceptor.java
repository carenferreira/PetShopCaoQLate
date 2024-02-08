package cfs.petshop.caoqlate.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AutorizadorInterceptor implements HandlerInterceptor{
	
	public boolean preHandle(HttpServletRequest request,
	HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		if (uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") || 
			uri.endsWith("cadastroCliente") || uri.endsWith("adicionaCliente") || 
			uri.endsWith("adicionaUsuario") || uri.endsWith("emailConfirmacao")
			|| uri.contains("resources")){
			return true;
		}
		if (request.getSession().getAttribute("usuarioLogado") != null){
			return true;
		}
		response.sendRedirect("loginForm");
		return false;
	}
}
