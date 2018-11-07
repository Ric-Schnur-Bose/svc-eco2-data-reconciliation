package com.bose.reconcile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

    @Autowired
    @Qualifier("jdbcSource")
    public JdbcTemplate jdbcSourceTemplate;
    
    @Autowired
    @Qualifier("jdbcDestination")
    public JdbcTemplate jdbcDestinationTemplate; 
    

	public List<Account> getAccountsToReconcile() {

		// sample method
		List<Account> accounts = jdbcSourceTemplate.query("select personId, country, createdOn, emailAddress, language from Account where state = ?  and language is not null",
				new RowMapper<Account>() {
					public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
						Account account = new Account();
						account.setPersonId(rs.getString("personId"));
						account.setCountry(rs.getString("country"));
						account.setCreatedOn(rs.getString("createdOn"));
						account.setEmailAddress(rs.getString("emailAddress"));
						account.setLanguage(rs.getString("language"));

						return account;
					}
				} );

		return accounts;
	}
	
	// sample method
	public void updateAccount(Account account) {
		
		jdbcSourceTemplate.update("update Account set language = ?, country = ?, emailAddress = ?, state = 2, "
				+ "createdOn = now(), updatedOn = now(), terms = ?, privacy = ?, eula = ?, subscriber = ?, gigyaId = ?"
				+ "where personId = ?", account.getLanguage(), account.getCountry(), account.getEmailAddress(), 
				account.getTerms(), account.getPrivacy(), account.getEula(), account.getSubscriber(), 
				account.getGigyaId(), account.getPersonId());
		
	}
	
	// sample method
	private String findCustomerCountry(String personId) {
		
		String sql = "select country from Account where personId = ?";
		
		String country = (String)jdbcSourceTemplate.queryForObject(sql, new Object[] { personId }, String.class);
		return country;
	}
}


