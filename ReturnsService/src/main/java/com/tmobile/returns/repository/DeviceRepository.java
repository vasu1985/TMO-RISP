package com.tmobile.returns.repository;

import org.springframework.data.repository.CrudRepository;

import com.tmobile.returns.domain.Device;

public interface DeviceRepository extends CrudRepository<Device, String> {

}
