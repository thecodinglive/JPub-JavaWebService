package info.thecodinglive.admin.controller;

import info.thecodinglive.admin.service.LocalIpChecker;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorController {
	@Autowired
	private LocalIpChecker localIpChecker;

	@PreAuthorize("@localIpChecker.isLocal()")
	@GetMapping("/admin/monitor")
	public String findList(HttpServletRequest request) {
		return "ok";
	}
}
