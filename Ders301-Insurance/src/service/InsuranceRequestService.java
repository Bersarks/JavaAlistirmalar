package service;

import model.InsuranceRequest;
import model.Policy;
import model.Proposal;
import model.Vehicle;

import java.util.ArrayList;

public class InsuranceRequestService {
	//	Creates a new insurance request with the given parameters.
	public InsuranceRequest createInsuranceRequest(Vehicle vehicle) {
		return new InsuranceRequest(vehicle);
	}

	// Adds a proposal to the given insurance request.
	public void addProposal(InsuranceRequest insuranceRequest, Proposal proposal) {
		if (insuranceRequest.getProposalList() == null) {
			insuranceRequest.setProposalList(new ArrayList<>());
		}
		insuranceRequest.getProposalList().add(proposal);
	}

	public void addPolicy(InsuranceRequest insuranceRequest, Policy policy) {
		insuranceRequest.setPolicy(policy);
	}
}
