package net.javaguides.springboot.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoderApiResponse {
	
	private LocalDateTime  timestamp;
    private String message;
    private String exception;
    @Builder.Default
    private boolean success = false;
    private int pageNo;
	private int pageSize;
	private long totalRecords;
	List<Coder> coder;
	

}
