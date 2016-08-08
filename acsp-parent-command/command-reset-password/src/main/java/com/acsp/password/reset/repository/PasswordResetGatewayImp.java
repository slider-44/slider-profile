package com.acsp.password.reset.repository;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectConnectByStep;
import org.jooq.SelectJoinStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.common.security.ACSPUser;
import com.acsp.common.security.UserRole;
import com.acsp.core.orm.Pair;
import com.acsp.password.reset.dto.AccountDetailsDTO;
import com.acsp.password.reset.dto.SavePasswordDTO;
import com.acsp.password.reset.util.PasswordEncoder;

import static com.acsp.core.rs.db.tables.MAccountExt.M_ACCOUNT_EXT;
import static com.acsp.core.rs.db.tables.MAccountRoles.M_ACCOUNT_ROLES;

import java.util.List;
import java.util.stream.Collectors;

import static com.acsp.core.rs.db.tables.MAccount.M_ACCOUNT;;

@Component
public class PasswordResetGatewayImp implements PasswordResetGateway {

	@Autowired
	protected DSLContext jooq;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public SavePasswordDTO save(SavePasswordDTO savePasswordDTO, ACSPUser acspUser) {
		
		jooq.update(M_ACCOUNT_EXT)
		.set(M_ACCOUNT_EXT.PASSWORD,passwordEncoder.encode(savePasswordDTO.getNewPassword()))
		.set(M_ACCOUNT_EXT.UPDATEDATE, savePasswordDTO.getUpdateDate())
		.where(M_ACCOUNT_EXT.USERCD.equal(acspUser.getUserCd()))
		.execute();
		
		return savePasswordDTO;
	}
	
	

	@Override
	public List<AccountDetailsDTO> findByUsername(String username) {
		
		return findUsingCondition(M_ACCOUNT_EXT.USERCD.eq(username));
	}
	

	
	private List<AccountDetailsDTO> findUsingCondition(Condition condition) {

    	List<AccountDetailsDTO> accounts =  select(condition)
                .orderBy(M_ACCOUNT_EXT.USERCD)
                .fetch(record -> 
                    new Pair<>(new AccountDetailsDTO.Builder()
                                    .withUserCd(record.getValue(M_ACCOUNT_EXT.USERCD))
                                    .withUsername(record.getValue(M_ACCOUNT_EXT.USERCD))
                                    .withPassword(record.getValue(M_ACCOUNT_EXT.PASSWORD))
                                    .withFirstName(record.getValue(M_ACCOUNT_EXT.FIRST_NAME))
                                    .withLastName(record.getValue(M_ACCOUNT_EXT.LAST_NAME))
                                    .withEmail(record.getValue(M_ACCOUNT_EXT.EMAIL))
                                    .withStoreCd(record.getValue(M_ACCOUNT_EXT.STORECD))
                                    .build(), 
                               new UserRole.Builder()
                                    .withRole(record.getValue(M_ACCOUNT_ROLES.ROLE))
                                    .withUserCd(record.getValue(M_ACCOUNT_ROLES.USERCD))
                                    .build()))
                .stream()
                /*
                 * creates an Account and UserRole and then
                 * creates a Map<Account, Set<UserRole>> Account
                 */
                .collect(Collectors.groupingBy(Pair::getFirst, Collectors.mapping(Pair::getSecond, Collectors.toSet())))
                .entrySet()
                .stream()
                /*
                 * iterates Map<Account, Set<UserRole>> setting
                 * Set<UserRole> for each Account and then
                 * collects List<Account>
                 */
                .map(entry -> {
                    entry.getKey().setUserRoles(entry.getValue());
                    return entry.getKey();
                })
                .collect(Collectors.toList());
    	
    	return accounts;
    }
	 private SelectConnectByStep<Record> select(Condition condition) {

	        return (condition == null ? select() : select().where(condition));
	 }
	 
	 private SelectJoinStep<Record> select() {
		 
		

     return jooq.select(M_ACCOUNT_EXT.STORECD)
	                   .select(M_ACCOUNT_EXT.USERCD)
	                   .select(M_ACCOUNT_EXT.USERCD)
	                   .select(M_ACCOUNT_EXT.PASSWORD)
	                   .select(M_ACCOUNT_EXT.FIRST_NAME)
	                   .select(M_ACCOUNT_EXT.LAST_NAME)
	                   .select(M_ACCOUNT_EXT.EMAIL)
	                   .select(M_ACCOUNT_ROLES.ID)
	                   .select(M_ACCOUNT_ROLES.ROLE)
	                   .select(M_ACCOUNT_ROLES.USERCD)
	                   .from(M_ACCOUNT_EXT 
	                         .join(M_ACCOUNT_ROLES).on(M_ACCOUNT_EXT.USERCD.equal(M_ACCOUNT_ROLES.USERCD))
	                         .leftJoin(M_ACCOUNT).on(M_ACCOUNT.USERCD.equal(M_ACCOUNT_EXT.USERCD)));
		 
		
	    }

	

}
