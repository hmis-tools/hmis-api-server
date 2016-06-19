package org.openhmis.generator;

public class FunderGenerator {

	public FunderGenerator() {
	}

	public FunderDTO generateFunderDTO(TmpProjectFunder tmpProjectFunder) {
		FunderDTO funderDTO = new FunderDTO();
		funderDTO.setFunderId(tmpProjectFunder.getFunderId().toString());
		funderDTO.setProjectId(tmpProjectFunder.getProjectId().toString());
		
		// Universal Data Standard: Funder (2014, 2.6) 
		funderDTO.setFunder(ProjectFundingSource.valueByCode(tmpProjectFunder.getFunder()));
		funderDTO.setGrantId(tmpProjectFunder.getGrantId());
		funderDTO.setStartDate(tmpProjectFunder.getStartDate());
		funderDTO.setEndDate(tmpProjectFunder.getEndDate());
		
		// Export Standard Fields
		funderDTO.setDateCreated(tmpProjectFunder.getDateCreated());
		funderDTO.setDateUpdated(tmpProjectFunder.getDateUpdated());
		
		return funderDTO;
	}

	public TmpProjectFunder generateTmpProjectFunder(FunderDTO inputDTO) {
		TmpProjectFunder tmpProjectFunder = new TmpProjectFunder();
		
		tmpProjectFunder.setFunderId(Integer.parseInt(inputDTO.getFunderId()));
		tmpProjectFunder.setProjectId(Integer.parseInt(inputDTO.getProjectId()));
		
		// Universal Data Standard: Funder (2014, 2.6) 
		tmpProjectFunder.setFunder(inputDTO.getFunder().getCode());
		tmpProjectFunder.setGrantId(inputDTO.getGrantId());
		tmpProjectFunder.setStartDate(inputDTO.getStartDate());
		tmpProjectFunder.setEndDate(inputDTO.getEndDate());

		// Export Standard Fields
		tmpProjectFunder.setDateCreated(inputDTO.getDateCreated());
		tmpProjectFunder.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpProjectFunder;

	}
}