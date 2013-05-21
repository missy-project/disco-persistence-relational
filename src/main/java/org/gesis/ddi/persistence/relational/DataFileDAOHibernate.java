package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.ontology.DataFile;
import org.gesis.ddi.persistence.dataAccess.DataFileDAO;
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
