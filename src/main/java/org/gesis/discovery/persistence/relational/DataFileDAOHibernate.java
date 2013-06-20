package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.DataFile;
import org.gesis.discovery.persistence.DataFileDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Hibernate implementation for DataFile.
 * 
 * @author matthaeus
 * 
 */
public class DataFileDAOHibernate extends GenericHibernateDAO<DataFile> implements DataFileDAO
{

	public DataFileDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
