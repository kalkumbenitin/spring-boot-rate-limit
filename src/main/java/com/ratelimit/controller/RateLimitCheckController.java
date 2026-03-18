package com.ratelimit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class RateLimitCheckController {

	@RateLimiter(name = "apiRateLimit", fallbackMethod = "fallbackDemo")
	@GetMapping("/hi/{user}")
	public String sayHi(@PathVariable String user) {
		return "Welcome to Rate Limit Mr. " + user;
	}

	public String fallbackDemo(Exception ex) {
	    return "Rate limit exceeded, try later";
	}

}
