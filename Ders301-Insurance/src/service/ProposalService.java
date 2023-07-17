package service;

import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
import java.util.Date;

public class ProposalService {
	public Proposal createProposal(InsuranceCompany insuranceCompany, Vehicle vehilce, BigDecimal offerPrice,
								   BigDecimal discountPrice, boolean isApproved, Date startDate, Date endDate, Date expireDate) {
		Proposal proposal = new Proposal();
		proposal.setCompany(insuranceCompany);
		proposal.setVehicle(vehilce);
		proposal.setOfferPrice(offerPrice);
		proposal.setDiscountPrice(discountPrice);
		proposal.setApproved(isApproved);
		proposal.setStartDate(startDate);
		proposal.setEndDate(endDate);
		proposal.setExpireDate(expireDate);
		return proposal;
	}
}
