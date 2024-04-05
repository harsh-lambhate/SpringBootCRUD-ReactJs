package net.javaguides.springboot.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Coder;
import net.javaguides.springboot.model.CoderApiResponse;
import net.javaguides.springboot.service.CoderService;

@Tag(name = "Coder", description = "Tech Gurus APIs")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/coder")
public class CoderController {

	@Autowired
	private CoderService coderservice;

	@Operation(summary = "Get All Coder", tags = { "Coder", "Get" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }) })
	@GetMapping
	public ResponseEntity<CoderApiResponse> getAllCoders(@PageableDefault(page = 0, size = 10) Pageable pageable) {

		Page<Coder> getAllCoders = coderservice.getResponseAllCoders(pageable);
		long totalRecords = coderservice.getTotalRecords();
		CoderApiResponse coderApiResponse = null;
		ResponseEntity<CoderApiResponse> coderResponseEntity = null;

		try {
			if (getAllCoders.hasContent()) {
				coderApiResponse = CoderApiResponse.builder()
						.timestamp(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES))
						.message("User fetch SuccessFully !!")
						.exception(null).success(true)
						.pageNo(pageable.getPageNumber())
						.pageSize(pageable.getPageSize())
						.totalRecords(totalRecords)
						.coder(getAllCoders.getContent()).build();

				coderResponseEntity = ResponseEntity.status(HttpStatus.OK).body(coderApiResponse);
			} else {
				coderApiResponse = CoderApiResponse.builder()
						.timestamp(LocalDateTime.now()
								.truncatedTo(ChronoUnit.MINUTES))
						.message("No records found !!")
						.success(false).coder(Arrays.asList(null))
						.pageNo(pageable.getPageNumber())
						.pageSize(pageable.getPageSize())
						.totalRecords(totalRecords).build();
				coderResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(coderApiResponse);
			}

		} catch (ResourceNotFoundException ex) {
			coderApiResponse = CoderApiResponse.builder()
					.timestamp(LocalDateTime.now()
					.truncatedTo(ChronoUnit.MINUTES))
					.message("User Not found")
					.exception(ex.getMessage())
					.success(false)
					.coder(null)
					.pageNo(pageable.getPageNumber())
					.pageSize(pageable.getPageSize())
					.totalRecords(totalRecords)
					.build();
			coderResponseEntity = ResponseEntity.status(HttpStatus.OK).body(coderApiResponse);

		}
		
		catch (Exception ex) {
			coderApiResponse = CoderApiResponse.builder()
					.timestamp(LocalDateTime.now()
					.truncatedTo(ChronoUnit.MINUTES))
					.message("Exception")
					.exception(ex.getMessage())
					.success(false)
					.coder(null)
					.pageNo(pageable.getPageNumber())
					.pageSize(pageable.getPageSize())
					.totalRecords(totalRecords)
					.build();
			coderResponseEntity = ResponseEntity.status(HttpStatus.OK).body(coderApiResponse);

		}
		return coderResponseEntity;

	}

	// build create employee REST API
	@Operation(summary = "Create Coder", tags = { "Coder", "Post" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }) })
	@PostMapping
	public Coder createCoder(@RequestBody Coder coder) {
		return coderservice.getResponseCreateCoder(coder);
		
		 
	}

	// build get employee by id REST API
	@Operation(summary = "Get Single Employee", tags = { "Coder", "Get" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/{coderId}")
	public Coder getCoderById(@PathVariable String coderId) {
		return coderservice.getResponseGetCoderById(coderId);
		
		
	}

	// build update employee REST API
	@Operation(summary = "Update Employee", tags = { "Coder", "Put" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }) })
	@PutMapping("/{coderId}")
	public Coder updateCoder(@PathVariable String coderId, @RequestBody Coder coderDetails) {		
		return coderservice.getResponseUpdateCoderById(coderId,coderDetails);
	}

	// build delete employee REST API
	@Operation(summary = "Delete Coder", tags = { "Coder", "Delete" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = {
					@Content(schema = @Schema(implementation = Coder.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }) })
	@DeleteMapping("/{coderId}")
	public void deleteCoder(@PathVariable String coderId) {
		 coderservice.getResponseDeleteCoderById(coderId);
	}
}
