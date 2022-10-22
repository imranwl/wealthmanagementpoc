/*
 * package com.incedo.customer.service;
 * 
 * import java.time.LocalDateTime; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.incedo.customer.entity.ConfirmationToken; import
 * com.incedo.customer.repository.ConfirmationTokenRepository;
 * 
 * import lombok.AllArgsConstructor;
 * 
 * @Service
 * 
 * @AllArgsConstructor public class ConfirmationTokenService {
 * 
 * @Autowired private ConfirmationTokenRepository confirmationTokenRepository;
 * 
 * public void saveConfirmationToken(ConfirmationToken token) {
 * confirmationTokenRepository.save(token); }
 * 
 * public Optional<ConfirmationToken> getToken(String token) { return
 * confirmationTokenRepository.findByToken(token); }
 * 
 * public int setConfirmedAt(String token) { return
 * confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now()); }
 * }
 */