package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.DataFile;
import org.gesis.discovery.persistence.DataFileDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Hibernate implementation for DataFile.
 * 
 * @author matthaeus
 * 
 */
public class DataFileDAOHibernate extends GenericResourceHibernateDAO<DataFile> implements DataFileDAO
{

	public DataFileDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
