package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.StudyGroup;
import org.gesis.ddi.persistence.dataAccess.StudyGroupDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudyGroupDAOHibernate extends GenericHibernateDAO<StudyGroup> implements StudyGroupDAO
{

	public StudyGroupDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<StudyGroup> getAll()
	{
		List<StudyGroup> studyGroups = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( studyGroups == null )
			return Collections.emptyList();

		return studyGroups;
	}

}
