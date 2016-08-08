package com.acsp.password.reset.service;

import static com.acsp.core.rs.db.tables.HAccountPassword.H_ACCOUNT_PASSWORD;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.common.security.ACSPUser;
import com.acsp.common.util.DateTimeUtil;
import com.acsp.password.reset.dto.AccountDetailsDTO;
import com.acsp.password.reset.dto.PasswordHistoryDTO;
import com.acsp.password.reset.dto.SavePasswordDTO;
import com.acsp.password.reset.repository.PasswordHistoryRepository;
import com.acsp.password.reset.repository.PasswordResetGateway;
import com.acsp.password.reset.util.PasswordEncoder;

import org.jooq.Condition;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordResetService {

  @Autowired
  PasswordResetGateway passwordResetSave;

  @Autowired
  PasswordHistoryRepository passwordHistoryRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  public BaseResponseDTO save(SavePasswordDTO savePasswordDTO, ACSPUser acspUser) {

    savePasswordDTO.setUpdateDate(DateTimeUtil.getCurrentSqlDate());
    
    BaseResponseDTO responseDTO = new BaseResponseDTO();
    responseDTO.setResponseSuccess(true);
    
    Condition likeUsercd = DSL.trueCondition();

    likeUsercd = H_ACCOUNT_PASSWORD.USERCD.like(acspUser.getUserCd());

    List<AccountDetailsDTO> account = passwordResetSave.findByUsername(acspUser.getUserCd());
    AccountDetailsDTO accounts = account.get(0);

    // Check if current password is the correct
    if ( passwordEncoder.isMatch(savePasswordDTO.getCurrentPassword(), accounts.getPassword()) ) {

      // Check history of new password
      List<PasswordHistoryDTO> pwdHistory = passwordHistoryRepository.getPasswordHistory(likeUsercd);

      boolean hasHistory = false;
      
      if ( pwdHistory.size() > 0 ) {

        for ( PasswordHistoryDTO passwordHistoryDTO : pwdHistory ) {

          if ( passwordEncoder.isMatch(savePasswordDTO.getNewPassword(),
                                       passwordHistoryDTO.getPassword()) ) {
            hasHistory = true;
            break;
            
          }
          
        }
        
      }


      // if there it has been used save password
      if ( !hasHistory ) {
        
        passwordResetSave.save(savePasswordDTO, acspUser);
        passwordHistoryRepository.insertHistory(savePasswordDTO, acspUser);
        responseDTO.setResponseSuccess(true);
        
      } else {
        
        responseDTO.setResponseSuccess(false);
        responseDTO.addError("newPassword", "Using previous three passwords is not allowed");
        
      }

    } else {
      
      responseDTO.setResponseSuccess(false);
      responseDTO.addError("currentPassword", "Invalid Password");

    }

    return responseDTO;
  }

}
