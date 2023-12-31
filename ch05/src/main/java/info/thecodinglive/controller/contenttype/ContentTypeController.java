package info.thecodinglive.controller.contenttype;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ContentTypeController {
	@Operation(summary = "json 타입 지정")
	@GetMapping(value = "/api/v1/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> findJsonData() {
		String jsonData = "{\"jsonKey\": \"hello\"}";
		return ResponseEntity.ok(jsonData);
	}

	@Operation(summary = "json 타입 미지정")
	@GetMapping(value = "/api/v1/nojson")
	public ResponseEntity<String> findJsonDataNoType() {
		String jsonData = "{\"jsonKey\": \"hello\"}";
		return ResponseEntity.ok(jsonData);
	}
}
