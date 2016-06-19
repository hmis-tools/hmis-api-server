

public class ProjectValidator {

	public ProjectValidator() {
	}
	
	public boolean validateProject(ProjectDTO inputDTO) {
		
		// Universal Data Standard: Project Type (2014, 2.4)
		if(inputDTO.getContinuumProject() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.4.1 continuumProject", "continuumProject is set to an unknown code");
		if(inputDTO.getProjectType() == ProjectType.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.4.2 projectType", "projectType is set to an unknown code");
		if(inputDTO.getResidentialAffiliation() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.4.3 residentialAffiliation", "residentialAffiliation is set to an unknown code");

		if(inputDTO.getContinuumProject() != YesNo.YES
		&& inputDTO.getProjectType() == null)
			throw new InvalidParameterException("HUD 2.4.2 projectType", "projectType may only be null if continuumProject is 1");
		
		if(inputDTO.getProjectType() != ProjectType.SERVICES_ONLY
		&& inputDTO.getResidentialAffiliation() != null)
			throw new InvalidParameterException("HUD 2.4.3 residentialAffiliation", "residentialAffiliation must be null if projectType is not 6");
		
		// Universal Data Standard: Project Type (2014, 2.5)
		if(inputDTO.getTrackingMethod() == ProjectTrackingMethod.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.5.1 trackingMethod", "trackingMethod is set to an unknown code");
			
		if(inputDTO.getProjectType() != ProjectType.EMERGENCY_SHELTER
		&& inputDTO.getTrackingMethod() != null)
			throw new InvalidParameterException("HUD 2.5.1 trackingMethod", "trackingMethod must be null if projectType is not 1");

		// Universal Data Standard: Target Population (2014 2.9)
		if(inputDTO.getTargetPopulation() == ProjectTargetPopulation.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.9.1 targetPopulation", "targetPopulation is set to an unknown code");
		
		return true;
	}
}