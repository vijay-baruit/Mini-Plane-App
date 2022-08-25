package in.vijay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vijay.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
