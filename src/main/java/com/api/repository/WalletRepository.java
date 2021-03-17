package com.api.repository;

import com.api.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
