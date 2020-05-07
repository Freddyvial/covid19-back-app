package com.poli.covid19.repositories;

import com.poli.covid19.domain.Medical;


import java.util.List;

public interface MedicalRepository {

    List<Medical> getMedical(String id);
    Medical createMedical(Medical medical);
}