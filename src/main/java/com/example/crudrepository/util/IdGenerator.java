/**
 * 
 */
package com.example.crudrepository.util;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author Arnaud
 *
 */
public class IdGenerator implements IdentifierGenerator {

	public static final String generatorName = "bd_PrimaryKays";	
	private Params idParams = new Params();
	
	/* (non-Javadoc)
	 * @see org.hibernate.id.IdentifierGenerator#generate(org.hibernate.engine.spi.SharedSessionContractImplementor, java.lang.Object)
	 */
	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		
		Random random = new Random();
		StringBuilder builder = new StringBuilder(idParams.getIdsLength());
		
		for (int i = 0; i < idParams.getIdsLength(); i++) {
			builder.append(idParams.getIDSOURCE().charAt(random.nextInt(idParams.getIDSOURCE().length())));
		}
		
		return builder.toString();
	}
}
