package com.invoice.api.util.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoice.api.util.dao.beans.Payout;

public interface PayoutDao extends JpaRepository<Payout, Long> {

}
