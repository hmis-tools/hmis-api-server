package org.openhmis.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class IncomeSourceDTO {
	private String incomeSourceId;
	private String enrollmentId;

	// Program Specific Data Standards: Income Sources (2014, 4.2)
	private Date informationDate;
	private YesNoReason incomeFromAnySourceCode;
	private Double totalMonthlyIncome;
	private YesNo earned;
	private Double earnedAmount;
	private YesNo unemployment;
	private Double unemploymentAmount;
	private YesNo ssi;
	private Double ssiAmount;
	private YesNo ssdi;
	private Double ssdiAmount;
	private YesNo vaDisabilityService;
	private Double vaDisabilityServiceAmount;
	private YesNo vaDisabilityNonService;
	private Double vaDisabilityNonServiceAmount;
	private YesNo privateDisability;
	private Double privateDisabilityAmount;
	private YesNo workerscomp;
	private Double workersCompAmount;
	private YesNo tanf;
	private Double tanfAmount;
	private YesNo ga;
	private Double gaAmount;
	private YesNo socSecRetirement;
	private Double socSecRetirementAmount;
	private YesNo pension;
	private Double pensionAmount;
	private YesNo childSupport;
	private Double childSupportAmount;
	private YesNo alimony;
	private Double alimonyAmount;
	private YesNo otherIncomeSource;
	private Double otherIncomeAmount;
	
	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public IncomeSourceDTO() {}

	@JsonProperty
	public String getIncomeSourceId() {
		return incomeSourceId;
	}

	@JsonProperty
	public void setIncomeSourceId(String incomeSourceId) {
		this.incomeSourceId = incomeSourceId;
	}

	@JsonProperty
	public String getEnrollmentId() {
		return enrollmentId;
	}

	@JsonProperty
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	@JsonProperty
	public Date getInformationDate() {
		return informationDate;
	}

	@JsonProperty
	public void setInformationDate(Date informationDate) {
		this.informationDate = informationDate;
	}

	@JsonProperty
	public YesNoReason getIncomeFromAnySourceCode() {
		return incomeFromAnySourceCode;
	}

	@JsonProperty
	public void setIncomeFromAnySourceCode(YesNoReason incomeFromAnySourceCode) {
		this.incomeFromAnySourceCode = incomeFromAnySourceCode;
	}

	@JsonProperty
	public Double getTotalMonthlyIncome() {
		return totalMonthlyIncome;
	}

	@JsonProperty
	public void setTotalMonthlyIncome(Double totalMonthlyIncome) {
		this.totalMonthlyIncome = totalMonthlyIncome;
	}

	@JsonProperty
	public YesNo getEarned() {
		return earned;
	}

	@JsonProperty
	public void setEarned(YesNo earned) {
		this.earned = earned;
	}

	@JsonProperty
	public Double getEarnedAmount() {
		return earnedAmount;
	}

	@JsonProperty
	public void setEarnedAmount(Double earnedAmount) {
		this.earnedAmount = earnedAmount;
	}

	@JsonProperty
	public YesNo getUnemployment() {
		return unemployment;
	}

	@JsonProperty
	public void setUnemployment(YesNo unemployment) {
		this.unemployment = unemployment;
	}

	@JsonProperty
	public Double getUnemploymentAmount() {
		return unemploymentAmount;
	}

	@JsonProperty
	public void setUnemploymentAmount(Double unemploymentAmount) {
		this.unemploymentAmount = unemploymentAmount;
	}

	@JsonProperty
	public YesNo getSsi() {
		return ssi;
	}

	@JsonProperty
	public void setSsi(YesNo ssi) {
		this.ssi = ssi;
	}

	@JsonProperty
	public Double getSsiAmount() {
		return ssiAmount;
	}

	@JsonProperty
	public void setSsiAmount(Double ssiAmount) {
		this.ssiAmount = ssiAmount;
	}

	@JsonProperty
	public YesNo getSsdi() {
		return ssdi;
	}

	@JsonProperty
	public void setSsdi(YesNo ssdi) {
		this.ssdi = ssdi;
	}

	@JsonProperty
	public Double getSsdiAmount() {
		return ssdiAmount;
	}

	@JsonProperty
	public void setSsdiAmount(Double ssdiAmount) {
		this.ssdiAmount = ssdiAmount;
	}

	@JsonProperty
	public YesNo getVaDisabilityService() {
		return vaDisabilityService;
	}

	@JsonProperty
	public void setVaDisabilityService(YesNo vaDisabilityService) {
		this.vaDisabilityService = vaDisabilityService;
	}

	@JsonProperty
	public Double getVaDisabilityServiceAmount() {
		return vaDisabilityServiceAmount;
	}

	@JsonProperty
	public void setVaDisabilityServiceAmount(Double vaDisabilityServiceAmount) {
		this.vaDisabilityServiceAmount = vaDisabilityServiceAmount;
	}

	@JsonProperty
	public YesNo getVaDisabilityNonService() {
		return vaDisabilityNonService;
	}

	@JsonProperty
	public void setVaDisabilityNonService(YesNo vaDisabilityNonService) {
		this.vaDisabilityNonService = vaDisabilityNonService;
	}

	@JsonProperty
	public Double getVaDisabilityNonServiceAmount() {
		return vaDisabilityNonServiceAmount;
	}

	@JsonProperty
	public void setVaDisabilityNonServiceAmount(Double vaDisabilityNonServiceAmount) {
		this.vaDisabilityNonServiceAmount = vaDisabilityNonServiceAmount;
	}

	@JsonProperty
	public YesNo getPrivateDisability() {
		return privateDisability;
	}

	@JsonProperty
	public void setPrivateDisability(YesNo privateDisability) {
		this.privateDisability = privateDisability;
	}

	@JsonProperty
	public Double getPrivateDisabilityAmount() {
		return privateDisabilityAmount;
	}

	@JsonProperty
	public void setPrivateDisabilityAmount(Double privateDisabilityAmount) {
		this.privateDisabilityAmount = privateDisabilityAmount;
	}

	@JsonProperty
	public YesNo getWorkerscomp() {
		return workerscomp;
	}

	@JsonProperty
	public void setWorkerscomp(YesNo workerscomp) {
		this.workerscomp = workerscomp;
	}

	@JsonProperty
	public Double getWorkersCompAmount() {
		return workersCompAmount;
	}

	@JsonProperty
	public void setWorkersCompAmount(Double workersCompAmount) {
		this.workersCompAmount = workersCompAmount;
	}

	@JsonProperty
	public YesNo getTanf() {
		return tanf;
	}

	@JsonProperty
	public void setTanf(YesNo tanf) {
		this.tanf = tanf;
	}

	@JsonProperty
	public Double getTanfAmount() {
		return tanfAmount;
	}

	@JsonProperty
	public void setTanfAmount(Double tanfAmount) {
		this.tanfAmount = tanfAmount;
	}

	@JsonProperty
	public YesNo getGa() {
		return ga;
	}

	@JsonProperty
	public void setGa(YesNo ga) {
		this.ga = ga;
	}

	@JsonProperty
	public Double getGaAmount() {
		return gaAmount;
	}

	@JsonProperty
	public void setGaAmount(Double gaAmount) {
		this.gaAmount = gaAmount;
	}

	@JsonProperty
	public YesNo getSocSecRetirement() {
		return socSecRetirement;
	}

	@JsonProperty
	public void setSocSecRetirement(YesNo socSecRetirement) {
		this.socSecRetirement = socSecRetirement;
	}

	@JsonProperty
	public Double getSocSecRetirementAmount() {
		return socSecRetirementAmount;
	}

	@JsonProperty
	public void setSocSecRetirementAmount(Double socSecRetirementAmount) {
		this.socSecRetirementAmount = socSecRetirementAmount;
	}

	@JsonProperty
	public YesNo getPension() {
		return pension;
	}

	@JsonProperty
	public void setPension(YesNo pension) {
		this.pension = pension;
	}

	@JsonProperty
	public Double getPensionAmount() {
		return pensionAmount;
	}

	@JsonProperty
	public void setPensionAmount(Double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}

	@JsonProperty
	public YesNo getChildSupport() {
		return childSupport;
	}

	@JsonProperty
	public void setChildSupport(YesNo childSupport) {
		this.childSupport = childSupport;
	}

	@JsonProperty
	public Double getChildSupportAmount() {
		return childSupportAmount;
	}

	@JsonProperty
	public void setChildSupportAmount(Double childSupportAmount) {
		this.childSupportAmount = childSupportAmount;
	}

	@JsonProperty
	public YesNo getAlimony() {
		return alimony;
	}

	@JsonProperty
	public void setAlimony(YesNo alimony) {
		this.alimony = alimony;
	}

	@JsonProperty
	public Double getAlimonyAmount() {
		return alimonyAmount;
	}

	@JsonProperty
	public void setAlimonyAmount(Double alimonyAmount) {
		this.alimonyAmount = alimonyAmount;
	}

	@JsonProperty
	public YesNo getOtherIncomeSource() {
		return otherIncomeSource;
	}

	@JsonProperty
	public void setOtherIncomeSource(YesNo otherIncomeSource) {
		this.otherIncomeSource = otherIncomeSource;
	}

	@JsonProperty
	public Double getOtherIncomeAmount() {
		return otherIncomeAmount;
	}

	@JsonProperty
	public void setOtherIncomeAmount(Double otherIncomeAmount) {
		this.otherIncomeAmount = otherIncomeAmount;
	}


	@JsonProperty
	public Date getDateCreated() {
		return dateCreated;
	}

	@JsonProperty
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@JsonProperty
	public Date getDateUpdated() {
		return dateUpdated;
	}

	@JsonProperty
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
}

