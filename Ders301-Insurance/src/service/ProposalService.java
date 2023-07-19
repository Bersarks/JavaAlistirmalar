package service;

import model.Accident;
import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ProposalService {
	VehicleService vehicleService = new VehicleService();

	//	Creates a proposal object with the given parameters.
	public Proposal createProposal(InsuranceCompany insuranceCompany, Vehicle vehicle, BigDecimal offerPrice,
								   BigDecimal discountPrice, LocalDate startDate, LocalDate endDate,
								   LocalDate expireDate) {
		Proposal proposal = new Proposal();
		proposal.setCompany(insuranceCompany);
		proposal.setVehicle(vehicle);
		proposal.setDiscountPrice(discountPrice);
		proposal.setOfferPrice(reCalculatedOfferPrice(vehicleService.calculateTotalDamagePrice(vehicle), offerPrice));
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

	public BigDecimal reCalculatedOfferPrice(BigDecimal totalDamagePrice, BigDecimal offerPrice) {

		if (totalDamagePrice.compareTo(BigDecimal.ZERO) > 0 &&
				totalDamagePrice.compareTo(new BigDecimal(4000)) <= 0) {
			return offerPrice.multiply(new BigDecimal(1.1));
		} else if (totalDamagePrice.compareTo(new BigDecimal(4000)) > 0 &&
				totalDamagePrice.compareTo(new BigDecimal(8000)) <= 0) {
			return offerPrice.multiply(new BigDecimal(1.25));
		} else if (totalDamagePrice.compareTo(new BigDecimal(8000)) > 0 &&
				totalDamagePrice.compareTo(new BigDecimal(16000)) <= 0) {
			return offerPrice.multiply(new BigDecimal(1.4));
		} else if (totalDamagePrice.compareTo(new BigDecimal(16000)) > 0) {
			return offerPrice.multiply(new BigDecimal(1.8));
		}
		return offerPrice;
	}
}
