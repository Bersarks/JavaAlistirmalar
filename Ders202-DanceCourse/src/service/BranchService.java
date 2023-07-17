package service;

import model.Branch;

import java.util.List;

public class BranchService {
	public Branch createBranch(String name) {
		Branch branch = new Branch();
		branch.setName(name);
		return branch;
	}

	public void createBranchToBranchPool(List<Branch> branchList, String name) {
		Branch branch = createBranch(name);
		for (Branch br : branchList) {
			if (br.getName().equalsIgnoreCase(name)) {
				System.err.println("Branch " + name + " already exist");
				return;
			}
		}
		branchList.add(branch);
	}
}