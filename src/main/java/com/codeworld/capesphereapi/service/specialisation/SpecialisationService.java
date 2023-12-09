package com.codeworld.capesphereapi.service.specialisation;

import com.codeworld.capesphereapi.model.Specialisation;
import com.codeworld.capesphereapi.request.SpecialisationRequest;

import java.util.List;

public interface SpecialisationService {
    Specialisation createSpecialisation(SpecialisationRequest request, Long candidate_id,
                                        Long mentor_id, Long cohort_id);

    List<Specialisation> getAllSpecialisation();
}
