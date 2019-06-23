package com.deltal.actman.repository;

import com.deltal.actman.model.Macrochallenge;
import org.springframework.data.repository.CrudRepository;

public interface MacroRepository extends CrudRepository<Macrochallenge, String> {
    Macrochallenge findByMacroid(long macroid);
}
