package com.palta.BuildRig.data;


import com.palta.BuildRig.Models.Memory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface MemoryDao extends CrudRepository<Memory, Integer> {
}
