package edu.alec.museo4ia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alessandro Cazziolato
 */
@RestController
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "Hello da museo4IA 2019-20";
	}
	@GetMapping("/ita")
	public String indexITA() {
		return "CIAO da museo4IA";
	}
}
