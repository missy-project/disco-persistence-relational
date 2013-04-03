package org.gesis.ddi.persistence.relational;

import java.util.List;

import org.gesis.ddi.ontology.DataFile;
import org.gesis.ddi.persistence.dataAccess.DataFileDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DataFileDAOHibernate extends GenericHibernateDAO<DataFile> implements DataFileDAO
{

	public DataFileDAOHibernate(final HibernateTemplate hibernateTemplate) {
		super( hibernateTemplate );
		// TODO Auto-generated constructor stub
	}

	@Override
	public DataFile getById( final String urn, final boolean lock )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataFile> getAll() {
		@SuppressWarnings( "unchecked" )
		List<DataFile> dataFiles = getHibernateTemplate().find( "from DataFile" );

		return dataFiles;
	}

}
