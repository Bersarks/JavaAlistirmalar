package service;

import model.InsuranceRequest;
import model.Policy;
import model.Proposal;
import model.Vehicle;

import java.util.ArrayList;

public class InsuranceRequestService {
	public InsuranceRequest createInsuranceRequest(Vehicle vehicle, Policy policy) {
		return new InsuranceRequest(vehicle, policy);
	}

	public void addProposal(InsuranceRequest insuranceRequest, Proposal proposal) {
		if (insuranceRequest.getProposalList() == null) {
			insuranceRequest.setProposalList(new ArrayList<>());
		}
		insuranceRequest.getProposalList().add(proposal);
	}
}
