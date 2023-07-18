package service;

import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ProposalService {
	//	Creates a proposal object with the given parameters.
	public Proposal createProposal(InsuranceCompany insuranceCompany, Vehicle vehilce, BigDecimal offerPrice,
								   BigDecimal discountPrice, LocalDate startDate, LocalDate endDate,
								   LocalDate expireDate) {
		Proposal proposal = new Proposal();
		proposal.setCompany(insuranceCompany);
		proposal.setVehicle(vehilce);
		proposal.setOfferPrice(offerPrice);
		proposal.setDiscountPrice(discountPrice);
		proposal.setStartDate(startDate);
		proposal.setEndDate(endDate);
		proposal.setExpireDate(expireDate);
		return proposal;
	}

	public BigDecimal calculateDiscountedPrice(Proposal proposal) {
		if (proposal.getDiscountPrice() != null) {
			return proposal.getOfferPrice().subtract(proposal.getDiscountPrice());
		} else {
			return proposal.getOfferPrice();
		}
	}
}
