package org.openhmis.generator;

public class IncomeSourceGenerator {

	public IncomeSourceGenerator() {
	}

	public IncomeSourceDTO generateIncomeSourceDTO(TmpIncomeSource tmpIncomeSource) {
		IncomeSourceDTO incomeSourceDTO = new IncomeSourceDTO();

		incomeSourceDTO.setIncomeSourceId(tmpIncomeSource.getIncomeSourceId().toString());
		incomeSourceDTO.setEnrollmentId(tmpIncomeSource.getEnrollmentId().toString());

		// Program Specific Data Standards: Income Sources (2014, 4.2)
		incomeSourceDTO.setInformationDate(tmpIncomeSource.getInformationDate());
		incomeSourceDTO.setIncomeFromAnySourceCode(YesNoReason.valueByCode(tmpIncomeSource.getIncomeFromAnySourceCode()));
		incomeSourceDTO.setTotalMonthlyIncome(tmpIncomeSource.getTotalMonthlyIncome().doubleValue());
		incomeSourceDTO.setEarned(YesNo.valueByCode(tmpIncomeSource.getEarned()));
		incomeSourceDTO.setEarnedAmount(tmpIncomeSource.getEarnedAmount().doubleValue());
		incomeSourceDTO.setUnemployment(YesNo.valueByCode(tmpIncomeSource.getUnemployment()));
		incomeSourceDTO.setUnemploymentAmount(tmpIncomeSource.getUnemploymentAmount().doubleValue());
		incomeSourceDTO.setSsi(YesNo.valueByCode(tmpIncomeSource.getSsi()));
		incomeSourceDTO.setSsiAmount(tmpIncomeSource.getSsiAmount().doubleValue());
		incomeSourceDTO.setSsdi(YesNo.valueByCode(tmpIncomeSource.getSsdi()));
		incomeSourceDTO.setSsdiAmount(tmpIncomeSource.getSsdiAmount().doubleValue());
		incomeSourceDTO.setVaDisabilityService(YesNo.valueByCode(tmpIncomeSource.getVaDisabilityService()));
		incomeSourceDTO.setVaDisabilityServiceAmount(tmpIncomeSource.getVaDisabilityServiceAmount().doubleValue());
		incomeSourceDTO.setVaDisabilityNonService(YesNo.valueByCode(tmpIncomeSource.getVaDisabilityNonService()));
		incomeSourceDTO.setVaDisabilityNonServiceAmount(tmpIncomeSource.getVaDisabilityNonServiceAmount().doubleValue());
		incomeSourceDTO.setPrivateDisability(YesNo.valueByCode(tmpIncomeSource.getDisability()));
		incomeSourceDTO.setPrivateDisabilityAmount(tmpIncomeSource.getDisabilityAmount().doubleValue());
		incomeSourceDTO.setWorkerscomp(YesNo.valueByCode(tmpIncomeSource.getWorkerscomp()));
		incomeSourceDTO.setWorkersCompAmount(tmpIncomeSource.getWorkersCompAmount().doubleValue());
		incomeSourceDTO.setTanf(YesNo.valueByCode(tmpIncomeSource.getTanf()));
		incomeSourceDTO.setTanfAmount(tmpIncomeSource.getTanfAmount().doubleValue());
		incomeSourceDTO.setGa(YesNo.valueByCode(tmpIncomeSource.getGa()));
		incomeSourceDTO.setGaAmount(tmpIncomeSource.getGaAmount().doubleValue());
		incomeSourceDTO.setSocSecRetirement(YesNo.valueByCode(tmpIncomeSource.getSocSecRetirement()));
		incomeSourceDTO.setSocSecRetirementAmount(tmpIncomeSource.getSocSecRetirementAmount().doubleValue());
		incomeSourceDTO.setPension(YesNo.valueByCode(tmpIncomeSource.getPension()));
		incomeSourceDTO.setPensionAmount(tmpIncomeSource.getPensionAmount().doubleValue());
		incomeSourceDTO.setChildSupport(YesNo.valueByCode(tmpIncomeSource.getChildSupport()));
		incomeSourceDTO.setChildSupportAmount(tmpIncomeSource.getChildSupportAmount().doubleValue());
		incomeSourceDTO.setAlimony(YesNo.valueByCode(tmpIncomeSource.getAlimony()));
		incomeSourceDTO.setAlimonyAmount(tmpIncomeSource.getAlimonyAmount().doubleValue());
		incomeSourceDTO.setOtherIncomeSource(YesNo.valueByCode(tmpIncomeSource.getOtherIncomeSource()));
		incomeSourceDTO.setOtherIncomeAmount(tmpIncomeSource.getOtherIncomeAmount().doubleValue());

		// Export Standard Fields
		incomeSourceDTO.setDateCreated(tmpIncomeSource.getDateCreated());
		incomeSourceDTO.setDateUpdated(tmpIncomeSource.getDateUpdated());
		
		return incomeSourceDTO;
	}
	
	public TmpIncomeSource generateTmpIncomeSource(IncomeSourceDTO inputDTO) {
		TmpIncomeSource tmpIncomeSource = new TmpIncomeSource();
		
		tmpIncomeSource.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));
		// Program Specific Data Standards: Income Sources (2014, 4.2)
		tmpIncomeSource.setInformationDate(inputDTO.getInformationDate());
		tmpIncomeSource.setIncomeFromAnySourceCode(inputDTO.getIncomeFromAnySourceCode().getCode());
		tmpIncomeSource.setTotalMonthlyIncome(inputDTO.getTotalMonthlyIncome().intValue());
		tmpIncomeSource.setEarned(inputDTO.getEarned().getCode());
		tmpIncomeSource.setEarnedAmount(inputDTO.getEarnedAmount().intValue());
		tmpIncomeSource.setUnemployment(inputDTO.getUnemployment().getCode());
		tmpIncomeSource.setUnemploymentAmount(inputDTO.getUnemploymentAmount().intValue());
		tmpIncomeSource.setSsi(inputDTO.getSsi().getCode());
		tmpIncomeSource.setSsiAmount(inputDTO.getSsiAmount().intValue());
		tmpIncomeSource.setSsdi(inputDTO.getSsdi().getCode());
		tmpIncomeSource.setSsdiAmount(inputDTO.getSsdiAmount().intValue());
		tmpIncomeSource.setVaDisabilityService(inputDTO.getVaDisabilityService().getCode());
		tmpIncomeSource.setVaDisabilityServiceAmount(inputDTO.getVaDisabilityServiceAmount().intValue());
		tmpIncomeSource.setVaDisabilityNonService(inputDTO.getVaDisabilityNonService().getCode());
		tmpIncomeSource.setVaDisabilityNonServiceAmount(inputDTO.getVaDisabilityNonServiceAmount().intValue());
		tmpIncomeSource.setDisability(inputDTO.getPrivateDisability().getCode());
		tmpIncomeSource.setDisabilityAmount(inputDTO.getPrivateDisabilityAmount().intValue());
		tmpIncomeSource.setWorkerscomp(inputDTO.getWorkerscomp().getCode());
		tmpIncomeSource.setWorkersCompAmount(inputDTO.getWorkersCompAmount().intValue());
		tmpIncomeSource.setTanf(inputDTO.getTanf().getCode());
		tmpIncomeSource.setTanfAmount(inputDTO.getTanfAmount().intValue());
		tmpIncomeSource.setGa(inputDTO.getGa().getCode());
		tmpIncomeSource.setGaAmount(inputDTO.getGaAmount().intValue());
		tmpIncomeSource.setSocSecRetirement(inputDTO.getSocSecRetirement().getCode());
		tmpIncomeSource.setSocSecRetirementAmount(inputDTO.getSocSecRetirementAmount().intValue());
		tmpIncomeSource.setPension(inputDTO.getPension().getCode());
		tmpIncomeSource.setPensionAmount(inputDTO.getPensionAmount().intValue());
		tmpIncomeSource.setChildSupport(inputDTO.getChildSupport().getCode());
		tmpIncomeSource.setChildSupportAmount(inputDTO.getChildSupportAmount().intValue());
		tmpIncomeSource.setAlimony(inputDTO.getAlimony().getCode());
		tmpIncomeSource.setAlimonyAmount(inputDTO.getAlimonyAmount().intValue());
		tmpIncomeSource.setOtherIncomeSource(inputDTO.getOtherIncomeSource().getCode());
		tmpIncomeSource.setOtherIncomeAmount(inputDTO.getOtherIncomeAmount().intValue());

		// Export Standard Fields
		tmpIncomeSource.setDateCreated(inputDTO.getDateCreated());
		tmpIncomeSource.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpIncomeSource;
	}
}