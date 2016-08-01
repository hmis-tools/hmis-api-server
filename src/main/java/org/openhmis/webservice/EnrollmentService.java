package org.openhmis.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.dto.ChronicHealthConditionDTO;
import org.openhmis.dto.ClientDTO;
import org.openhmis.dto.ContactDTO;
import org.openhmis.dto.DevelopmentalDisabilityDTO;
import org.openhmis.dto.DomesticAbuseDTO;
import org.openhmis.dto.EnrollmentDTO;
import org.openhmis.dto.ExitDTO;
import org.openhmis.dto.FinancialAssistanceDTO;
import org.openhmis.dto.HealthInsuranceDTO;
import org.openhmis.dto.HivAidsStatusDTO;
import org.openhmis.dto.IncomeSourceDTO;
import org.openhmis.dto.MedicalAssistanceDTO;
import org.openhmis.dto.NonCashBenefitDTO;
import org.openhmis.dto.PhysicalDisabilityDTO;
import org.openhmis.dto.ReferralDTO;
import org.openhmis.dto.ServiceDTO;
import org.openhmis.dto.SubstanceAbuseDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.ChronicHealthConditionManager;
import org.openhmis.manager.ClientManager;
import org.openhmis.manager.ContactManager;
import org.openhmis.manager.DevelopmentalDisabilityManager;
import org.openhmis.manager.DomesticAbuseManager;
import org.openhmis.manager.EnrollmentManager;
import org.openhmis.manager.ExitManager;
import org.openhmis.manager.FinancialAssistanceManager;
import org.openhmis.manager.HealthInsuranceManager;
import org.openhmis.manager.HivAidsStatusManager;
import org.openhmis.manager.IncomeSourceManager;
import org.openhmis.manager.MedicalAssistanceManager;
import org.openhmis.manager.MentalHealthProblemManager;
import org.openhmis.manager.NonCashBenefitManager;
import org.openhmis.manager.PhysicalDisabilityManager;
import org.openhmis.manager.ReferralManager;
import org.openhmis.manager.ServiceManager;
import org.openhmis.manager.SubstanceAbuseManager;
import org.openhmis.dto.search.EnrollmentSearchDTO;
import org.openhmis.dto.search.ChronicHealthConditionSearchDTO;
import org.openhmis.dto.search.ContactSearchDTO;
import org.openhmis.dto.search.DevelopmentalDisabilitySearchDTO;
import org.openhmis.dto.search.DomesticAbuseSearchDTO;
import org.openhmis.dto.search.FinancialAssistanceSearchDTO;
import org.openhmis.dto.search.HealthInsuranceSearchDTO;
import org.openhmis.dto.search.HivAidsStatusSearchDTO;
import org.openhmis.dto.search.IncomeSourceSearchDTO;
import org.openhmis.dto.search.MedicalAssistanceSearchDTO;
import org.openhmis.dto.search.NonCashBenefitSearchDTO;
import org.openhmis.dto.search.PhysicalDisabilitySearchDTO;
import org.openhmis.dto.search.ReferralSearchDTO;
import org.openhmis.dto.search.ServiceSearchDTO;
import org.openhmis.dto.search.SubstanceAbuseSearchDTO;

import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/enrollments")
public class EnrollmentService {
	private static final ObjectMapper om = new ObjectMapper();
	private static final EnrollmentManager enrollmentManager = new EnrollmentManager();
	private static final Logger log = Logger.getLogger(ClientService.class);

	public EnrollmentService() {}


	/* Enrollment Entity Endpoints */
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<EnrollmentDTO> getEnrollments(@HeaderParam("Authorization") String authorization, @BeanParam EnrollmentSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                List<EnrollmentDTO> enrollmentDTOs = enrollmentManager.getEnrollments(searchDTO);
                log.info("GET /enrollments/ (" + enrollmentDTOs.size() + " results)");
                return enrollmentDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public EnrollmentDTO getClient(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		EnrollmentDTO enrollmentDTO = enrollmentManager.getEnrollmentById(enrollmentId);
                log.info("GET /enrollments/" + enrollmentId);
		return enrollmentDTO;
	}

	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public EnrollmentDTO createEnrollment(@HeaderParam("Authorization") String authorization, EnrollmentDTO inputVO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		EnrollmentDTO outputVO = enrollmentManager.addEnrollment(inputVO);
                log.info("POST /enrollments (new id: " + outputVO.getId() + ")");
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public EnrollmentDTO updateEnrollment(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, EnrollmentDTO inputVO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputVO.setEnrollmentId(enrollmentId);
		
		EnrollmentDTO outputVO = enrollmentManager.updateEnrollment(inputVO);
                log.info("PUT /enrollments/" + enrollmentId);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteEnrollment(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		enrollmentManager.deleteEnrollment(enrollmentId);
                log.info("PUT /enrollments/" + enrollmentId);
		return "true";
	}
	
	
	/* Exit Endpoints */
	@GET
	@Path("/{enrollmentId}/exits")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ExitDTO> getExits(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		// Exits are weird because right now only one can exist but they are still separate...
		// TODO: figure out whether or not we want exists to have history
		List<ExitDTO> exitDTOs = new ArrayList<ExitDTO>();
		exitDTOs.add(ExitManager.getExitByEnrollmentId(enrollmentId));
                log.info("GET /enrollments/" + enrollmentId + "/exits (" + exitDTOs.size() + " results)");
                return exitDTOs;
	}


	/* Chronic Health Condition Endpoints */
	@GET
	@Path("/{enrollmentId}/chronic-health-conditions")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ChronicHealthConditionDTO> getChronicHealthConditions(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam ChronicHealthConditionSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                // we add the enrollment id from the path to the BeanParam for searching
                searchDTO.setEnrollmentId(enrollmentId);
                List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = ChronicHealthConditionManager.getChronicHealthConditions(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/chronic-health-conditions (" + chronicHealthConditionDTOs.size() + " results)");
                return chronicHealthConditionDTOs;
	}
	

	/* Contact Endpoints */
	@GET
	@Path("/{enrollmentId}/contacts")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ContactDTO> getContacts(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam ContactSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setEnrollmentId(enrollmentId);
                List<ContactDTO> contactDTOs = ContactManager.getContacts(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/contacts (" + contactDTOs.size() + " results)");
                return contactDTOs;
	}


	/* Developmental Disability Endpoints */
	@GET
	@Path("/{enrollmentId}/developmental-disabilities")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<DevelopmentalDisabilityDTO> getDevelopmentalDisabilities(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam DevelopmentalDisabilitySearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                 searchDTO.setEnrollmentId(enrollmentId);
                 List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = DevelopmentalDisabilityManager.getDevelopmentalDisabilities(searchDTO);
                 log.info("GET /enrollments/" + enrollmentId + "/developmental-disabilities (" + developmentalDisabilityDTOs.size() + " results)");
                 return developmentalDisabilityDTOs;
	}


	/* Domestic Abuse Endpoints */
	@GET
	@Path("/{enrollmentId}/domestic-abuses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<DomesticAbuseDTO> getDomesticAbuses(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam DomesticAbuseSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setEnrollmentId(enrollmentId);
                List<DomesticAbuseDTO> domesticAbuseDTOs = DomesticAbuseManager.getDomesticAbuses(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/domestic-abuses (" + domesticAbuseDTOs.size() + " results)");
                return domesticAbuseDTOs;
	}


	/* Financial Assistance Endpoints */
	@GET
	@Path("/{enrollmentId}/financial-assistances")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<FinancialAssistanceDTO> getFinancialAssistances(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam FinancialAssistanceSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setEnrollmentId(enrollmentId);
                List<FinancialAssistanceDTO> financialAssistanceDTOs = FinancialAssistanceManager.getFinancialAssistances(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/financial-assistances (" + financialAssistanceDTOs.size() + " results)");
                return financialAssistanceDTOs;
	}
	

	/* Health Insurance Endpoints */
	@GET
	@Path("/{enrollmentId}/health-insurances")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<HealthInsuranceDTO> getHealthInsurances(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam HealthInsuranceSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setEnrollmentId(enrollmentId);
                List<HealthInsuranceDTO> healthInsuranceDTOs = HealthInsuranceManager.getHealthInsurances(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/health-insurances (" + healthInsuranceDTOs.size() + " results)");
                return healthInsuranceDTOs;
	}
	

	/* HIV Aids Endpoints */
	@GET
	@Path("/{enrollmentId}/hiv-aids-statuses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<HivAidsStatusDTO> getHivAidsStatuses(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam HivAidsStatusSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setEnrollmentId(enrollmentId);
                List<HivAidsStatusDTO> hivAidsStatusDTOs = HivAidsStatusManager.getHivAidsStatuses(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/hiv-aids-statuses (" + hivAidsStatusDTOs.size() + " results)");
                return hivAidsStatusDTOs;
	}
	

	/* Medical Assistance Endpoints */
	@GET
	@Path("/{enrollmentId}/medical-assistances")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<MedicalAssistanceDTO> getMedicalAssistances(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam MedicalAssistanceSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setEnrollmentId(enrollmentId);
                List<MedicalAssistanceDTO> medicalAssistanceDTOs = MedicalAssistanceManager.getMedicalAssistances(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/medical-assistances (" + medicalAssistanceDTOs.size() + " results)");
                return medicalAssistanceDTOs;
	}
	

	/* Income Source Endpoints */
	@GET
	@Path("/{enrollmentId}/income-sources")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<IncomeSourceDTO> getIncomeSources(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam IncomeSourceSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setEnrollmentId(enrollmentId);
                List<IncomeSourceDTO> incomeSourceDTOs = IncomeSourceManager.getIncomeSources(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/income-sources (" + incomeSourceDTOs.size() + " results)");
                return incomeSourceDTOs;
	}
	

	/* NonCash Benefit Endpoints */
	@GET
	@Path("/{enrollmentId}/non-cash-benefits")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<NonCashBenefitDTO> getNonCashBenefits(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam NonCashBenefitSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setEnrollmentId(enrollmentId);
                List<NonCashBenefitDTO> nonCashBenefitDTOs = NonCashBenefitManager.getNonCashBenefits(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/non-cash-benefits (" + nonCashBenefitDTOs.size() + " results)");
                return nonCashBenefitDTOs;
	}
	

	/* Physical Disability Endpoints */
	@GET
	@Path("/{enrollmentId}/physical-disabilities")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<PhysicalDisabilityDTO> getPhysicalDisabilities(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam PhysicalDisabilitySearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setEnrollmentId(enrollmentId);
                List<PhysicalDisabilityDTO> physicalDisabilityDTOs = PhysicalDisabilityManager.getPhysicalDisabilities(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/physical-disabilities (" + physicalDisabilityDTOs.size() + " results)");
                return physicalDisabilityDTOs;
	}
	

	/* Referral Endpoints */
	@GET
	@Path("/{enrollmentId}/referrals")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ReferralDTO> getReferrals(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam ReferralSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setEnrollmentId(enrollmentId);
                List<ReferralDTO> referralDTOs = ReferralManager.getReferrals(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/referrals (" + referralDTOs.size() + " results)");
                return referralDTOs;
	}
	

	/* Service Endpoints */
	@GET
	@Path("/{enrollmentId}/services")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ServiceDTO> getServices(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam ServiceSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setEnrollmentId(enrollmentId);
                List<ServiceDTO> serviceDTOs = ServiceManager.getServices(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/services (" + serviceDTOs.size() + " results)");
                return serviceDTOs;
	}
	

	/* Substance Abuse Endpoints */
	@GET
	@Path("/{enrollmentId}/substance-abuses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<SubstanceAbuseDTO> getSubstanceAbuses(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @BeanParam SubstanceAbuseSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setEnrollmentId(enrollmentId);
                List<SubstanceAbuseDTO> substanceAbuseDTOs = SubstanceAbuseManager.getSubstanceAbuses(searchDTO);
                log.info("GET /enrollments/" + enrollmentId + "/substance-abuses (" + substanceAbuseDTOs.size() + " results)");
                return substanceAbuseDTOs;
	}
}
