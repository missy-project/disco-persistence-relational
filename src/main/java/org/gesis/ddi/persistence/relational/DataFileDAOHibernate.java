package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.DataFile;
import org.gesis.ddi.persistence.dataAccess.DataFileDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional
	public List<DataFile> getAll()
	{
		List<DataFile> dataFiles = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( dataFiles == null )
			return Collections.emptyList();

		return dataFiles;
	}

}
