package info.thecodinglive.admin.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class LocalIpChecker {
	private static final String LOCAL_IP = "127.0.0.1";
	private static final String LOCAL_IP2 = "0:0:0:0:0:0:0:1";

	public boolean isLocal() {
		HttpServletRequest req =
			((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String reqIp = req.getRemoteAddr();
		System.out.println("request ip:" + reqIp);
		return LOCAL_IP.equals(reqIp) || LOCAL_IP2.equals(reqIp);
	}
}
