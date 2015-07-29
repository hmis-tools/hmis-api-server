package org.openhmis.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.manager.ClientManager;
import org.openhmis.manager.EnrollmentManager;
import org.openhmis.vo.EnrollmentVO;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/enrollments")
public class EnrollmentService {
	private static final Logger log = Logger.getLogger(EnrollmentService.class);
	private static final ObjectMapper om = new ObjectMapper();
	private static final EnrollmentManager enrollmentManager = new EnrollmentManager();

	public EnrollmentService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public String getEnrollments() throws JsonProcessingException {
		List<EnrollmentVO> enrollmentVos = enrollmentManager.getEnrollments();
		return om.writeValueAsString(enrollmentVos);
	}

	@POST
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public String createEnrollment(String data) throws JsonParseException, JsonMappingException, IOException {
		// This endpoint takes in a raw json STRING as input.
		// TODO: support the serialization of individual POST parameters
		EnrollmentVO inputVO = om.readValue(data, EnrollmentVO.class);
		EnrollmentVO outputVO = enrollmentManager.addEnrollment(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@GET
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getClient(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		EnrollmentVO enrollmentVO = enrollmentManager.getEnrollmentById(enrollmentId);
		return om.writeValueAsString(enrollmentVO);
	}
	
	@PUT
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateClient(@PathParam("enrollmentId") String enrollmentId, String data) throws JsonParseException, JsonMappingException, IOException {
		EnrollmentVO inputVO = om.readValue(data, EnrollmentVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		
		EnrollmentVO outputVO = enrollmentManager.updateEnrollment(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateClient(@PathParam("enrollmentId") String enrollmentId) throws JsonParseException, JsonMappingException, IOException {
		enrollmentManager.deleteEnrollment(enrollmentId);
		return "true";
	}
}
