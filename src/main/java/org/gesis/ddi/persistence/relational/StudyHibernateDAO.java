package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.Study;
import org.gesis.ddi.persistence.dataAccess.StudyDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudyHibernateDAO extends GenericHibernateDAO<Study> implements StudyDAO
{

	public StudyHibernateDAO(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<Study> getAll()
	{
		List<Study> studies = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( studies == null )
			return Collections.emptyList();

		return studies;
	}

}
