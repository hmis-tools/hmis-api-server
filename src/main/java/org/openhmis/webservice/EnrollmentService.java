package org.openhmis.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	public List<EnrollmentDTO> getEnrollments(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<EnrollmentDTO> enrollmentDTOs;
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			enrollmentDTOs = enrollmentManager.getEnrollments();
		} else {
			enrollmentDTOs = enrollmentManager.getEnrollmentsByUpdateDate(DateParser.parseDate(updatedSince));
		}
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
                log.info("POST /enrollments (" + outputVO.getId() + ")");
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
                log.info("GET /" + enrollmentId + "/exits (" + exitDTOs.size() + " results)");
                return exitDTOs;
	}


	/* Chronic Health Condition Endpoints */
	@GET
	@Path("/{enrollmentId}/chronic-health-conditions")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ChronicHealthConditionDTO> getChronicHealthConditions(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                
		List<ChronicHealthConditionDTO> chronicHealthConditionDTOs;
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			chronicHealthConditionDTOs = ChronicHealthConditionManager.getChronicHealthConditionsByEnrollmentId(enrollmentId);
		} else {
			chronicHealthConditionDTOs = ChronicHealthConditionManager.getChronicHealthConditionsByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/chronic-health-conditions (" + chronicHealthConditionDTOs.size() + " results)");
                return chronicHealthConditionDTOs;
	}
	

	/* Contact Endpoints */
	@GET
	@Path("/{enrollmentId}/contacts")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ContactDTO> getContacts(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<ContactDTO> contactDTOs;
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			contactDTOs = ContactManager.getContactsByEnrollmentId(enrollmentId);
		} else {
			contactDTOs = ContactManager.getContactsByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/contacts (" + contactDTOs.size() + " results)");
                return contactDTOs;
	}


	/* Developmental Disability Endpoints */
	@GET
	@Path("/{enrollmentId}/developmental-disabilities")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<DevelopmentalDisabilityDTO> getDevelopmentalDisabilities(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs;
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			developmentalDisabilityDTOs = DevelopmentalDisabilityManager.getDevelopmentalDisabilitiesByEnrollmentId(enrollmentId);
		} else {
                        developmentalDisabilityDTOs = DevelopmentalDisabilityManager.getDevelopmentalDisabilitiesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/developmental-disabilities (" + developmentalDisabilityDTOs.size() + " results)");
                return developmentalDisabilityDTOs;
	}


	/* Domestic Abuse Endpoints */
	@GET
	@Path("/{enrollmentId}/domestic-abuses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<DomesticAbuseDTO> getDomesticAbuses(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		
                List<DomesticAbuseDTO> domesticAbuseDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			domesticAbuseDTOs = DomesticAbuseManager.getDomesticAbusesByEnrollmentId(enrollmentId);
		} else {
			domesticAbuseDTOs = DomesticAbuseManager.getDomesticAbusesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/domestic-abuses (" + domesticAbuseDTOs.size() + " results)");
                return domesticAbuseDTOs;
	}


	/* Financial Assistance Endpoints */
	@GET
	@Path("/{enrollmentId}/financial-assitances")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<FinancialAssistanceDTO> getFinancialAssistances(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<FinancialAssistanceDTO> financialAssistanceDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			financialAssistanceDTOs = FinancialAssistanceManager.getFinancialAssistancesByEnrollmentId(enrollmentId);
		} else {
			financialAssistanceDTOs = FinancialAssistanceManager.getFinancialAssistancesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/financial-assitances (" + financialAssistanceDTOs.size() + " results)");
                return financialAssistanceDTOs;
	}
	

	/* Health Insurance Endpoints */
	@GET
	@Path("/{enrollmentId}/health-insurances")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<HealthInsuranceDTO> getHealthInsurances(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<HealthInsuranceDTO> healthInsuranceDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			healthInsuranceDTOs = HealthInsuranceManager.getHealthInsurancesByEnrollmentId(enrollmentId);
		} else {
			healthInsuranceDTOs = HealthInsuranceManager.getHealthInsurancesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/health-insurances (" + healthInsuranceDTOs.size() + " results)");
                return healthInsuranceDTOs;
	}
	

	/* HIV Aids Endpoints */
	@GET
	@Path("/{enrollmentId}/hiv-aids-statuses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<HivAidsStatusDTO> getHivAidsStatuses(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<HivAidsStatusDTO> hivAidsStatusDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			hivAidsStatusDTOs = HivAidsStatusManager.getHivAidsStatusesByEnrollmentId(enrollmentId);
		} else {
			hivAidsStatusDTOs = HivAidsStatusManager.getHivAidsStatusesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/hiv-aids-statuses (" + hivAidsStatusDTOs.size() + " results)");
                return hivAidsStatusDTOs;
	}
	

	/* Medical Assistance Endpoints */
	@GET
	@Path("/{enrollmentId}/medical-assistances")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<MedicalAssistanceDTO> getMedicalAssistances(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<MedicalAssistanceDTO> medicalAssistanceDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			medicalAssistanceDTOs = MedicalAssistanceManager.getMedicalAssistancesByEnrollmentId(enrollmentId);
		} else {
			medicalAssistanceDTOs = MedicalAssistanceManager.getMedicalAssistancesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/medical-assistances (" + medicalAssistanceDTOs.size() + " results)");
                return medicalAssistanceDTOs;
	}
	

	/* Income Source Endpoints */
	@GET
	@Path("/{enrollmentId}/income-sources")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<IncomeSourceDTO> getIncomeSources(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<IncomeSourceDTO> incomeSourceDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			incomeSourceDTOs = IncomeSourceManager.getIncomeSourcesByEnrollmentId(enrollmentId);
		} else {
			incomeSourceDTOs = IncomeSourceManager.getIncomeSourcesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/income-sources (" + incomeSourceDTOs.size() + " results)");
                return incomeSourceDTOs;
	}
	

	/* NonCash Benefit Endpoints */
	@GET
	@Path("/{enrollmentId}/noncash-benefits")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<NonCashBenefitDTO> getNonCashBenefits(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<NonCashBenefitDTO> nonCashBenefitDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			nonCashBenefitDTOs = NonCashBenefitManager.getNonCashBenefitsByEnrollmentId(enrollmentId);
		} else {
			nonCashBenefitDTOs = NonCashBenefitManager.getNonCashBenefitsByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/noncash-benefits (" + nonCashBenefitDTOs.size() + " results)");
                return nonCashBenefitDTOs;
	}
	

	/* Physical Disability Endpoints */
	@GET
	@Path("/{enrollmentId}/physical-disabilities")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<PhysicalDisabilityDTO> getPhysicalDisabilities(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<PhysicalDisabilityDTO> physicalDisabilityDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			physicalDisabilityDTOs = PhysicalDisabilityManager.getPhysicalDisabilitiesByEnrollmentId(enrollmentId);
		} else {
			physicalDisabilityDTOs = PhysicalDisabilityManager.getPhysicalDisabilitiesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/physical-disabilities (" + physicalDisabilityDTOs.size() + " results)");
                return physicalDisabilityDTOs;
	}
	

	/* Referral Endpoints */
	@GET
	@Path("/{enrollmentId}/referrals")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ReferralDTO> getReferrals(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<ReferralDTO> referralDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			referralDTOs = ReferralManager.getReferralsByEnrollmentId(enrollmentId);
		} else {
			referralDTOs = ReferralManager.getReferralsByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/referrals (" + referralDTOs.size() + " results)");
                return referralDTOs;
	}
	

	/* Service Endpoints */
	@GET
	@Path("/{enrollmentId}/services")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ServiceDTO> getServices(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<ServiceDTO> serviceDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			serviceDTOs = ServiceManager.getServicesByEnrollmentId(enrollmentId);
		} else {
			serviceDTOs = ServiceManager.getServicesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/services (" + serviceDTOs.size() + " results)");
                return serviceDTOs;
	}
	

	/* Substance Abuse Endpoints */
	@GET
	@Path("/{enrollmentId}/substance-abuses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<SubstanceAbuseDTO> getSubstanceAbuses(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<SubstanceAbuseDTO> substanceAbuseDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			substanceAbuseDTOs = SubstanceAbuseManager.getSubstanceAbusesByEnrollmentId(enrollmentId);
		} else {
			substanceAbuseDTOs = SubstanceAbuseManager.getSubstanceAbusesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
		}
                log.info("GET /" + enrollmentId + "/substance-abuses (" + substanceAbuseDTOs.size() + " results)");
                return substanceAbuseDTOs;
	}
}
