package RESTFulWebServiceExample;

import com.example.pharma.model.Medicine;
import com.example.pharma.service.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    // GET all medicines
    @GetMapping
    public List<MedicineModel> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    // GET medicine by ID
    @GetMapping("/{id}")
    public Medicine getMedicine(@PathVariable int id) {
        return medicineService.getMedicineById(id);
    }

    // POST new medicine
    @PostMapping
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        return medicineService.addMedicine(medicine);
    }

    // PUT update medicine
    @PutMapping("/{id}")
    public Medicine updateMedicine(
            @PathVariable int id,
            @RequestBody Medicine medicine) {
        return medicineService.updateMedicine(id, medicine);
    }

    // DELETE medicine
    @DeleteMapping("/{id}")
    public String deleteMedicine(@PathVariable int id) {
        medicineService.deleteMedicine(id);
        return "Medicine deleted successfully";
    }
}
