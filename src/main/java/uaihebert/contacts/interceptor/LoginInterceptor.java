package uaihebert.contacts.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import uaihebert.contacts.model.User;
import uaihebert.contacts.service.UserService;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		if (user == null) {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String email = auth.getName();
			user = this.userService.findByEmail(email);
			session.setAttribute("user", user);
		}

		return super.preHandle(request, response, handler);
	}
}
