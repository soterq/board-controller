package com.api.repository;

import com.api.domain.WalletNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<WalletNotice, Long> {
}
