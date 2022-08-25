package in.vijay.rest;

import java.util.List;
import java.util.Map;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import in.vijay.entity.Plan;
import in.vijay.service.PlanService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PlanRestController {

	@Autowired
	private PlanService planService;

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories() {
		Map<Integer, String> categories = planService.getPlanCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);

	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String responseMsg = "";
		boolean issaved = planService.savePlan(plan);
		if (issaved) {
			responseMsg = "Plan Sved";
		} else {
			responseMsg = "Plan Not Sved";
		}

		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);
	}

	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans() {
		List<Plan> allPlans = planService.getAllPlans();

		return new ResponseEntity<>(allPlans, HttpStatus.OK);

	}

	@GetMapping("/plans/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {
		Plan plan = planService.getPlanById(planId);
		return new ResponseEntity<>(plan, HttpStatus.OK);

	}

	@PutMapping("/plan")
	public ResponseEntity<String> updatedPlan(@RequestBody Plan plan) {
		boolean isUpdeted = planService.updatePlan(plan);
		String msg = "";
		if (isUpdeted) {
			msg = "Plan Updeted";
		} else {
			msg = "Plan Not Updeted";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	@DeleteMapping("/plans/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		boolean isDeleted = planService.deletePlanById(planId);
		String msg = "";
		if (isDeleted) {
			msg = "Plan Deleted";
		} else {
			msg = "Plan Not Deleted";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	@PutMapping("/status-change")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status) {
		boolean isStatusChanged = planService.planStatusChange(planId, status);
		String msg = "";
		if (isStatusChanged) {
			msg = "Plan Status Changed";
		} else {
			msg = "Plan Not Status Changed";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}
}
