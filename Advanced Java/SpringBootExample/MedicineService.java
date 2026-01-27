// Service class for managing medicines
package com.example.pharma.service;

import com.example.pharma.model.Medicine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineService {

    private List<MedicineModel> medicines = new ArrayList<>();

    public List<MedicineModel> getAllMedicines() {
        return medicines;
    }

    public MedicineModel getMedicineById(int id) {
        return medicines.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public MedicineModel addMedicine(MedicineModel medicine) {
        medicines.add(medicine);
        return medicine;
    }

    public MedicineModel updateMedicine(int id, MedicineModel updatedMedicine) {
        MedicineModel medicine = getMedicineById(id);
        if (medicine != null) {
            medicine.setName(updatedMedicine.getName());
            medicine.setManufacturer(updatedMedicine.getManufacturer());
            medicine.setPrice(updatedMedicine.getPrice());
        }
        return medicine;
    }

    public void deleteMedicine(int id) {
        medicines.removeIf(m -> m.getId() == id);
    }
}
