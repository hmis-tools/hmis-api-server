package org.openhmis.generator;

public class ProjectGenerator {

	public ProjectGenerator() {
	}
	
	public ProjectDTO generateProjectDTO(TmpProject tmpProject) {
		Integer projectId = tmpProject.getProjectId();

		ProjectDTO projectDTO = new ProjectDTO();
                CoCSearchDTO cocSearchDTO = new CoCSearchDTO();
                FunderSearchDTO funderSearchDTO = new FunderSearchDTO();
		projectDTO.setProjectId(tmpProject.getProjectId().toString());
                cocSearchDTO.setProjectId(tmpProject.getProjectId().toString());
                funderSearchDTO.setProjectId(tmpProject.getProjectId().toString());
                
	
		// Universal Data Standard: Project Identifiers (2014, 2.2) 
		projectDTO.setProjectName(tmpProject.getProjectName());
		
		// Universal Data Standard: Project CoC (2014, 2.3)
		projectDTO.setProjectCoCs(CoCManager.getCoCs(cocSearchDTO));

		// Universal Data Standard: Project Type (2014, 2.4)
		projectDTO.setContinuumProject(YesNo.valueByCode(tmpProject.getContinuumProject()));
		projectDTO.setProjectType(ProjectType.valueByCode(tmpProject.getProjectType()));
		projectDTO.setResidentialAffiliation(YesNo.valueByCode(tmpProject.getResidentialAffiliation()));
		projectDTO.setResProjectId(tmpProject.getResProjectId().toString());

		// Universal Data Standard: Project Type (2014, 2.5)
		projectDTO.setTrackingMethod(ProjectTrackingMethod.valueByCode(tmpProject.getTrackingMethod()));

		// Universal Data Standard: Funders (2014, 2.6)
		projectDTO.setFunders(FunderManager.getFunders(funderSearchDTO));

		// Universal Data Standard: Target Population (2014 2.9)
		projectDTO.setTargetPopulation(ProjectTargetPopulation.valueByCode(tmpProject.getTargetPopulation()));

		// Export Standard Fields
		projectDTO.setDateCreated(tmpProject.getDateCreated());
		projectDTO.setDateUpdated(tmpProject.getDateUpdated());
		
		return projectDTO;
	}
	
	public TmpProject generateTmpProject(ProjectDTO inputDTO) {
		TmpProject tmpProject = new TmpProject();
		
		tmpProject.setProjectName(inputDTO.getProjectName());

		// Universal Data Standard: Project Type (2014, 2.4)
		tmpProject.setContinuumProject(inputDTO.getContinuumProject().getCode());
		tmpProject.setProjectType(inputDTO.getProjectType().getCode());
		tmpProject.setResidentialAffiliation(inputDTO.getResidentialAffiliation().getCode());
		tmpProject.setResProjectId(Integer.parseInt(inputDTO.getResProjectId()));

		// Universal Data Standard: Project Type (2014, 2.5)
		tmpProject.setTrackingMethod(inputDTO.getTrackingMethod().getCode());

		// Universal Data Standard: Target Population (2014 2.9)
		tmpProject.setTargetPopulation(inputDTO.getTargetPopulation().getCode());

		// Export Standard Fields
		tmpProject.setDateCreated(inputDTO.getDateCreated());
		tmpProject.setDateUpdated(inputDTO.getDateUpdated());
		
		
		return tmpProject;
	}
}