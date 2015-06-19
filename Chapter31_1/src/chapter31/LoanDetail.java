package chapter31;

@SuppressWarnings("serial")
public class LoanDetail implements java.io.Serializable{
	private double AnnualIntRate;
	private double NumOfYears;
	private double LoanAmount;
	
	public LoanDetail(double AnnualIntRate, double NumOfYears, double LoanAmount){
		this.AnnualIntRate = AnnualIntRate;
		this.NumOfYears = NumOfYears;
		this.LoanAmount = LoanAmount;
	}
	
	public double getAnnualIntRate(){
		return AnnualIntRate;
	}
	
	public double getNumOfYears(){
		return NumOfYears;
	}
	
	public double getLoanAmount(){
		return LoanAmount;
	}
	
}
