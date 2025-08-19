package com.mukho.ranksystem.Controller;

import com.mukho.ranksystem.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

	private final RecordService recordService;

	@Autowired
	public RecordController(RecordService recordService) {
		this.recordService = recordService;
	}

	@GetMapping(value = "/record")
	public ResponseEntity<List<List>> getRecord(@RequestParam(required = false) String name) throws IOException {
		return new ResponseEntity<>(recordService.getRecord(name), HttpStatus.OK);
	}

	@GetMapping("/relative")
	public ResponseEntity<List<List>> getRelativeRecord(@RequestParam(required = false) String user1,
											 @RequestParam(required = false) String user2) {
		return new ResponseEntity<>(recordService.getRelativeRecord(user1, user2), HttpStatus.OK);
	}

}