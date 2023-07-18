import model.*;
import service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		AccidentService accidentService = new AccidentService();
		AgencyService agencyService = new AgencyService();
		BankAccountService bankAccountService = new BankAccountService();
		CustomerService customerService = new CustomerService();
		InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();
		InsuranceService insuranceService = new InsuranceService();
		InsuranceRequestService insuranceRequestService = new InsuranceRequestService();
		PolicyService policyService = new PolicyService();
		ProposalService proposalService = new ProposalService();
		VehicleService vehicleService = new VehicleService();

		Agency agency = agencyService.createAgency("MOM Insurance");
		agencyService.addBankAccount(agency, bankAccountService.createBankAccount("Yapı Kredi Bankası", "TR99999", BigDecimal.valueOf(100000)));

		InsuranceCompany insuranceCompany = insuranceCompanyService.createInsuranceCompany("Allianz",
				"Ataşehir", "0216 000 00 00", "Kozyatağı/Ataşehir/İstanbul", BigDecimal.valueOf(0.08));
		insuranceCompanyService.addInsurance(insuranceCompany, insuranceService.createInsurance
				(InsuranceTypeEnum.COMPULSORY_TRAFFIC_INSURANCE, "Zorunlu Trafik Sigortası"));
		insuranceCompanyService.addBankAccount(insuranceCompany, bankAccountService.createBankAccount
				("Ziraat Bankası", "TR1234", BigDecimal.valueOf(5000000)));
		insuranceCompanyService.addBankAccount(insuranceCompany, bankAccountService.createBankAccount
				("Yapı Kredi Bankası", "TR4321", BigDecimal.valueOf(3000000)));

		Customer customer = customerService.createCustomer("MehmetÖz", CustomerTypeEnum.INDIVIDUAL);
		customerService.addBankAccount(customer, bankAccountService.createBankAccount("Yapı Kredi Bankası",
				"TR5678", BigDecimal.valueOf(5000)));
		customerService.addVehicle(customer, vehicleService.createVehicle("Mercedes", "C180",
				"34 ABC 34", "ASCS1236734", 2014, ColorTypeEnum.BLACK));
		agencyService.addCustomer(agency, customer);
		agencyService.addInsuranceCompany(agency, insuranceCompany);

		customerService.addInsuranceRequest(customer, insuranceRequestService.createInsuranceRequest
				(customer.getVehicleList().get(0)));

		Proposal proposal = proposalService.createProposal(insuranceCompany, customer.getVehicleList().get(0),
				BigDecimal.valueOf(5000), BigDecimal.valueOf(500), LocalDate.of(2023, 07, 18),
				LocalDate.of(2024, 07, 07), LocalDate.of(2023, 07, 25));
		insuranceRequestService.addProposal(customer.getInsuranceRequestList().get(0), proposal);

		customerService.acceptProposal(customer, proposal, agency);
		insuranceCompanyService.sendCommissionToAgency(agency, agency.getInsuranceCompanyList().get(0));

		System.out.println(customer.getBankAccountList().toString() + "\n" + customer.getPaymentMovementList().toString());
		System.out.println("\n" +agency.getName() + "\n"+ agency.getBankAccountList().toString() + "\n" + agency.getPaymentMovementList().toString());
		System.out.println("\n" + agency.getInsuranceCompanyList().toString());

	}
}