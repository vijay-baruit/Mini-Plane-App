package in.vijay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vijay.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
