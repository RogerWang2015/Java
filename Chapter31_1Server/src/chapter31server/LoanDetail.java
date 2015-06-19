package chapter31server;

@SuppressWarnings("serial")
public class LoanDetail implements java.io.Serializable{
	private String AnnualIntRate;
	private String NumOfYears;
	private String LoanAmount;
	
	public LoanDetail(String AnnualIntRate, String NumOfYears, String LoanAmount){
		this.AnnualIntRate = AnnualIntRate;
		this.NumOfYears = NumOfYears;
		this.LoanAmount = LoanAmount;
	}
	
	public String getAnnualIntRate(){
		return AnnualIntRate;
	}
	
	public String getNumOfYears(){
		return NumOfYears;
	}
	
	public String getLoanAmount(){
		return LoanAmount;
	}
	
}
